import com.dylanlin.AccountService.AccountService;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.*;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.DateTime;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.CalendarScopes;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.Events;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class main {
    private static final String APPLICATION_NAME = "Google Calendar API Java Quickstart";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static final String TOKENS_DIRECTORY_PATH = "tokens";

    /**
     * Global instance of the scopes required by this quickstart.
     * If modifying these scopes, delete your previously saved tokens/ folder.
     */
    private static final List<String> SCOPES = Collections.singletonList(CalendarScopes.CALENDAR_READONLY);
    private static final String CREDENTIALS_FILE_PATH = "/credentials.json";

    /**
     * Creates an authorized Credential object.
     * @param HTTP_TRANSPORT The network HTTP Transport.
     * @return An authorized Credential object.
     * @throws IOException If the credentials.json file cannot be found.
     */

    public static void main(String... args) throws IOException, GeneralSecurityException {
        /*final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();

        GoogleIdTokenVerifier verifier =
                new GoogleIdTokenVerifier.Builder(HTTP_TRANSPORT, JSON_FACTORY)
                        .build();

        InputStream in = main.class.getResourceAsStream(CREDENTIALS_FILE_PATH);
        if (in == null) {
            throw new FileNotFoundException("Resource not found: " + CREDENTIALS_FILE_PATH);
        }
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));
        String authCode = "4/0AX4XfWgK_BaRTJw32czvoEaN4ckgGRKy3Mg0uQIHVvKC2gVKMpwr2KF_BdDMOcYyK4BkLQ";
        try {
            GoogleTokenResponse tokenResponse =
                    new GoogleAuthorizationCodeTokenRequest(
                            HTTP_TRANSPORT,
                            JSON_FACTORY,
                            "https://oauth2.googleapis.com/token",
                            "946460541416-sc523ondrpu36v8sh2i1f263u1sh3m98.apps.googleusercontent.com",
                            "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",
                            authCode,
                            "https://resrem.firebaseapp.com/__/auth/handler")
                            .execute();
            String accessToken = tokenResponse.getAccessToken();
            GoogleCredential googleCredential = new GoogleCredential().setAccessToken(accessToken);
            Calendar service = new Calendar.Builder(HTTP_TRANSPORT, JSON_FACTORY, googleCredential)
                    .setApplicationName(APPLICATION_NAME)
                    .build();

            // List the next 10 events from the primary calendar.
            DateTime now = new DateTime(System.currentTimeMillis());
            Events events = service.events().list("primary")
                    .setMaxResults(10)
                    .setTimeMin(now)
                    .setOrderBy("startTime")
                    .setSingleEvents(true)
                    .execute();
            List<Event> items = events.getItems();
            if (items.isEmpty()) {
                System.out.println("No upcoming events found.");
            } else {
                System.out.println("Upcoming events");
                for (Event event : items) {
                    DateTime start = event.getStart().getDateTime();
                    if (start == null) {
                        start = event.getStart().getDate();
                    }
                    System.out.println(event.getLocation());
                    System.out.printf("%s (%s)\n", event.getSummary(), start);
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }*/
        Server server = ServerBuilder.forPort(6969).addService(new com.dylanlin.AccountService.AccountService()).build();
        try {
            server.start();
            System.out.println("Server Started");
            server.awaitTermination();
            System.out.println("Server Ended");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}