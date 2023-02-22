package tasks.HttpTest;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import tasks.User.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;


public class HttpUtil {
    private static final HttpClient client = HttpClient.newBuilder().build();
    static final String GET_ALL_USERS_URL = "https://jsonplaceholder.typicode.com/users";
    static HttpResponse<String> response;
    static final Gson GSON = new Gson();

    public static int deleteUser(int userID) throws IOException, URISyntaxException, InterruptedException {
        String formattedURI = GET_ALL_USERS_URL + "/" + userID;
        HttpRequest deleteUser = deleteHttpRequest(formattedURI);
        response = getHttpResponse(deleteUser);
        return response.statusCode();
    }

    public static User updateUser(int userID, String username) throws IOException, URISyntaxException, InterruptedException {
        User user = GSON.fromJson(getUserByID(userID), User.class);
        user.setUsername(username);
        String newUser = GSON.toJson(user);
        String formattedURI = GET_ALL_USERS_URL + "/" + userID;
        HttpRequest updateUser = putHttpRequest(formattedURI, newUser);
        response = getHttpResponse(updateUser);
        System.out.println("Status Code: " + response.statusCode());
        return GSON.fromJson(response.body(), User.class);
    }

    private static HttpResponse<String> getHttpResponse(HttpRequest request) throws IOException, InterruptedException, URISyntaxException {
        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }

    private static HttpRequest getHttpRequest(String uri) throws URISyntaxException {
        return HttpRequest.newBuilder(new URI(uri))
                .header("Content-Type", "application/json")
                .GET()
                .build();
    }

    private static HttpRequest postHttpRequest(String uri, String user) throws URISyntaxException {
        return HttpRequest.newBuilder(new URI(uri))
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

    private static HttpRequest deleteHttpRequest(String uri) throws URISyntaxException {
        return HttpRequest.newBuilder(new URI(uri))
                .header("Content-Type", "application/json")
                .DELETE()
                .build();
    }


    // TODO: Using JSOUP
    public static String postNewUser(User user) throws IOException {
        Jsoup.connect(GET_ALL_USERS_URL)
                .ignoreContentType(true)
                .userAgent(GSON.toJson(user,User.class))
                .post()
                .body()
                .text();
        return findUsers(GET_ALL_USERS_URL + "?username=" + user.getUsername());
    }

    public static String getUserByID(int id) throws IOException {
        return findUsers(GET_ALL_USERS_URL + "/" + id);
    }

    public static String getAllUsersByUserName(String username) throws IOException {
        return findUsers(GET_ALL_USERS_URL + "?username=" + username);
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


