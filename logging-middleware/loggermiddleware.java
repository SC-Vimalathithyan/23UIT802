
import java.net.URI;
import java.net.http.*;
public class loggermiddleware {
    private static final String URL ="http://4.224.186.213/evaluation-service/logs";

    private static final String Token="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJNYXBDbGFpbXMiOnsiYXVkIjoiaHR0cDovLzIwLjI0NC41Ni4xNDQvZXZhbHVhdGlvbi1zZXJ2aWNlIiwiZW1haWwiOiJzYy52aW1hbGF0aGl0aHlhbkBnbWFpbC5jb20iLCJleHAiOjE3ODI3OTk2NzYsImlhdCI6MTc4Mjc5ODc3NiwiaXNzIjoiQWZmb3JkIE1lZGljYWwgVGVjaG5vbG9naWVzIFByaXZhdGUgTGltaXRlZCIsImp0aSI6IjMyZDNlZTYxLTM0MzAtNDM4Yi05OTUwLTc1MDA2NzdmNGMzNyIsImxvY2FsZSI6ImVuLUlOIiwibmFtZSI6InZpbWFsYXRoaXRoeWFuIHMgYyIsInN1YiI6IjUzYzg1NTRjLTE2OWUtNGNhZS04YTVmLTkwZWY1NGNiZTQ5YyJ9LCJlbWFpbCI6InNjLnZpbWFsYXRoaXRoeWFuQGdtYWlsLmNvbSIsIm5hbWUiOiJ2aW1hbGF0aGl0aHlhbiBzIGMiLCJyb2xsTm8iOiIyM3VpdDgwMiIsImFjY2Vzc0NvZGUiOiJXak55Q1QiLCJjbGllbnRJRCI6IjUzYzg1NTRjLTE2OWUtNGNhZS04YTVmLTkwZWY1NGNiZTQ5YyIsImNsaWVudFNlY3JldCI6InJ3eEFVVEN5U3NkbmRBVXEifQ.zFjoroFG0bujuClrLjP6S_8YrMJ3MVGjV1HQpdzir-s";

    public static void log(String Stack,String log,String Package,String Message
    ){
        try {
            String json=String.format("""
                {
                "Stack":"%s";
                "log":"%s";
                "Package":%s";
                "Message":%s";
                }
                    """,Stack,log,Package,Message);
        
        HttpRequest request= HttpRequest.newBuilder().uri(URI.create(URL)).header("Content-Type","application/json").header("Authorization", "Bearer " + TOKEN)
                    .POST(HttpRequest.BodyPublishers.ofString(json))
                    .build();

        HttpClient client=HttpClient.newHttpClient();

        HttpResponse <String> response=client.send(request, HttpResponse.BodyHandlers.OfString());
        
        System.out.println(response.body());
            }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}