package tasks.HttpTest;


import org.jsoup.Jsoup;
import tasks.User.User;
import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;



public class HttpUtil {
    private static final HttpClient client = HttpClient.newBuilder().build();
    static final String GET_ALL_USERS_URL = "https://jsonplaceholder.typicode.com/users";
    static HttpResponse<String> response;
    static final Gson GSON = new Gson();

    // TODO: Using HTTPClient, HTTPRequest, HTTPResponse
    public static int deleteUser (int userID) throws IOException, URISyntaxException, InterruptedException {
        String formattedURI = String.format(GET_ALL_USERS_URL + "/%d", userID);
        HttpRequest deleteUser = deleteHttpRequest(formattedURI);
        response = getHttpResponse(deleteUser);
        return response.statusCode();
    }

    public static User updateUser(int userID, String username) throws IOException, URISyntaxException, InterruptedException {
        User user = GSON.fromJson(getUserByID(userID),User.class);
        user.setUsername(username);
        String newUser = GSON.toJson(user);
        String formattedURI = String.format(GET_ALL_USERS_URL + "/%d", userID);
        HttpRequest updateUser = putHttpRequest(formattedURI,newUser);
        response = getHttpResponse(updateUser);
        System.out.println("Status Code: " + response.statusCode());
        return GSON.fromJson(response.body(),User.class);
    }

    public static User postNewUser(User user) throws URISyntaxException, IOException, InterruptedException {
        String newUser = GSON.toJson(user);
        HttpRequest postUser = postHttpRequest(newUser);
        response = getHttpResponse(postUser);
        System.out.println("Status Code: " + response.statusCode());
        return GSON.fromJson(response.body(),User.class);
    }

    private static HttpResponse<String> getHttpResponse(HttpRequest request) throws IOException, InterruptedException, URISyntaxException {
        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }

    private static HttpRequest postHttpRequest(String user) throws URISyntaxException {
        return HttpRequest.newBuilder(new URI(GET_ALL_USERS_URL))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(user))
                .build();
    }

    private static HttpRequest putHttpRequest(String uri, String user) throws URISyntaxException {
        return HttpRequest.newBuilder(new URI(uri))
                .header("Content-Type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(user))
                .build();
    }

    private static HttpRequest deleteHttpRequest (String uri) throws URISyntaxException{
        return HttpRequest.newBuilder(new URI(uri))
                .header("Content-Type", "application/json")
                .DELETE()
                .build();
    }


    // TODO: Using JSOUP

    public static String getUserByID(int userID) throws IOException {
        String formatted = String.format(GET_ALL_USERS_URL+"/%d",userID);
        return findUsers(formatted);
    }

    public static String getAllUsersByUserName(String username) throws IOException {
        String formatted = String.format(GET_ALL_USERS_URL+"?username=%s",username);
        return findUsers(formatted);
    }

    public static String getAllUsers() throws IOException {
        return findUsers(GET_ALL_USERS_URL);
    }

    private static String findUsers(String url) throws IOException {
        return Jsoup.connect(url)
                .ignoreContentType(true)
                .get()
                .body()
                .text();
    }
}


