import com.dylan.CalendarService.Calendar;
import com.dylan.CalendarService.CalendarServiceGrpc;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeTokenRequest;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.Events;
import com.google.protobuf.Empty;
import com.google.protobuf.Timestamp;
import io.grpc.stub.StreamObserver;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.sql.Time;
import java.util.List;

public class CalendarService extends CalendarServiceGrpc.CalendarServiceImplBase {

    private static final String APPLICATION_NAME = "Google Calendar API Java Quickstart";
    private static final String CREDENTIALS_FILE_PATH = "/credentials.json";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private GoogleClientSecrets clientSecrets;
    public CalendarService() {
        super();
        try {
            InputStream in = CalendarService.class.getResourceAsStream(CREDENTIALS_FILE_PATH);
            if (in == null) {
                throw new FileNotFoundException("Resource not found: " + CREDENTIALS_FILE_PATH);
            }
            clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));
        } catch (Exception e) {
            System.out.println("Service Constructor Failed");
        }
    }

    @Override
    public void retrieveEvents(Calendar.EventsRequest request, StreamObserver<Calendar.Events> responseObserver) {
        //super.retrieveEvents(request, responseObserver);
        try {
            final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
            String authCode = request.getAuthCode();
            GoogleTokenResponse tokenResponse =
                    new GoogleAuthorizationCodeTokenRequest(
                            HTTP_TRANSPORT,
                            JSON_FACTORY,
                            "https://oauth2.googleapis.com/token",
                            clientSecrets.getDetails().getClientId(),
                            clientSecrets.getDetails().getClientSecret(),
                            authCode,
                            "https://resrem.firebaseapp.com/__/auth/handler")
                            .execute();
            String accessToken = tokenResponse.getAccessToken();
            GoogleCredential googleCredential = new GoogleCredential().setAccessToken(accessToken);
            com.google.api.services.calendar.Calendar service = new com.google.api.services.calendar.Calendar.Builder(HTTP_TRANSPORT, JSON_FACTORY, googleCredential).setApplicationName(APPLICATION_NAME).build();
            DateTime now = new DateTime(System.currentTimeMillis());
            Events events = service.events().list("primary")
                    .setMaxResults(10)
                    .setTimeMin(now)
                    .setOrderBy("startTime")
                    .setSingleEvents(true)
                    .execute();
            List<Event> items = events.getItems();
            Calendar.EventsResponse.Builder response = Calendar.EventsResponse.newBuilder();
            Calendar.Events.Builder response_events = Calendar.Events.newBuilder();
            if (!items.isEmpty()) {
                for (Event event : items) {
                    DateTime date = event.getEnd().getDateTime();
                    System.out.println(date);
                    Timestamp response_date = Timestamp.newBuilder().setSeconds(date.getValue()).build();
                    Calendar.Event response_event = Calendar.Event.newBuilder()
                            .setName(event.getSummary())
                            .setLocation(event.getLocation())
                            .setDate(response_date)
                            .build();
                    System.out.println(event);
                    response_events.addEvents(response_event);
                }
            }
            responseObserver.onNext(response_events.build());
            responseObserver.onCompleted();

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @Override
    public void markEvent(Calendar.MarkEventRequest request, StreamObserver<Empty> responseObserver) {
        //super.markEvent(request, responseObserver);
    }
}
