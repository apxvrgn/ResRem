import io.grpc.Server;
import io.grpc.ServerBuilder;

public class Main {
    public static void main(String[] args) {
        Server server = ServerBuilder.forPort(6969).addService(new CalendarService()).build();
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
