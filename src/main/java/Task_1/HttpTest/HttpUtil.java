package Task_1.HttpTest;

import Task_1.User.User;
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
    static final String GET_USER_BY_ID_URL = "https://jsonplaceholder.typicode.com/users/{id}";

    static final String GET_USER_BY_USERNAME_URL = "https://jsonplaceholder.typicode.com/users?username={username}";
    static HttpResponse<String> response;
    static final Gson GSON = new Gson();


    public static int deleteUser (int userID) throws IOException, URISyntaxException, InterruptedException {
        String formattedURI = String.format(GET_USER_BY_ID_URL.replace("{id}", "%d"), userID);
        HttpRequest deleteUser = deleteHttpRequest(formattedURI);
        response = getHttpResponse(deleteUser);
        return response.statusCode();
    }

    public static User updateUser(int userID, String username) throws IOException, URISyntaxException, InterruptedException {
        User user = getUserById(userID);
        user.setUsername(username);
        String newUser = GSON.toJson(user);
        String formattedURI = String.format(GET_USER_BY_ID_URL.replace("{id}", "%d"), userID);
        HttpRequest updateUser = putHttpRequest(formattedURI,newUser);
        response = getHttpResponse(updateUser);
        System.out.println("Status Code: " + response.statusCode());
        return GSON.fromJson(response.body(),User.class);
    }

    public static User postNewUser(User user) throws URISyntaxException, IOException, InterruptedException {
        String newUser = GSON.toJson(user);
        HttpRequest postUser = postHttpRequest(GET_ALL_USERS_URL,newUser);
        response = getHttpResponse(postUser);
        System.out.println("Status Code: " + response.statusCode());
        return GSON.fromJson(response.body(),User.class);
    }

    public static List<User> getAllUsers() throws IOException, InterruptedException, URISyntaxException {
        HttpRequest getAllUsers = getHttpRequest(GET_ALL_USERS_URL);
        response = getHttpResponse(getAllUsers);
        return GSON.fromJson(response.body(), new TypeToken<List<User>>() {
        }.getType());
    }

    public static User getUserById(int userID) throws IOException, InterruptedException, URISyntaxException {
        String formattedURI = String.format(GET_USER_BY_ID_URL.replace("{id}", "%d"), userID);
        response = getHttpResponse(getHttpRequest(formattedURI));
        return GSON.fromJson(response.body(), User.class);
    }
    public static List<User> getUsersByUserName(String username) throws URISyntaxException, IOException, InterruptedException {
        String formattedURI = String.format(GET_USER_BY_USERNAME_URL.replace("{username}", "%s"), username);
        response = getHttpResponse(getHttpRequest(formattedURI));
        return GSON.fromJson(response.body(),  new TypeToken<List<User>>() {
        }.getType());
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

    private static HttpRequest deleteHttpRequest (String uri) throws URISyntaxException{
        return HttpRequest.newBuilder(new URI(uri))
                .header("Content-Type", "application/json")
                .DELETE()
                .build();
    }
}
