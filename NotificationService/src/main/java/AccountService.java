package com.dylanlin.AccountService;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;

import java.util.Collections;

public class AccountService extends AccountServiceGrpc.AccountServiceImplBase {
    public AccountService() {
        super();
    }

    @Override
    public void authenticate(Account.AuthenticationRequest request, StreamObserver<Empty> responseObserver) {
        try {
            final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
            final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();


            GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(new NetHttpTransport(), JacksonFactory.getDefaultInstance())
                    .setAudience(Collections.singletonList("946460541416-sc523ondrpu36v8sh2i1f263u1sh3m98.apps.googleusercontent.com"))
                    .build();
            GoogleIdToken idToken = verifier.verify(request.getIdToken());

            System.out.println(request.getIdToken());
            if (idToken != null) {
                GoogleIdToken.Payload payload = idToken.getPayload();
                System.out.println(payload.getEmail());
                responseObserver.onNext(com.google.protobuf.Empty.newBuilder().build());
                responseObserver.onCompleted();
            } else {
                System.out.println("invalid token");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void retrieveEvent(Account.EventsRequest request, StreamObserver<Account.EventsResponse> responseObserver) {
        //super.retrieveEvent(request, responseObserver);
    }
}
