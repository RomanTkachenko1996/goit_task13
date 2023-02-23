package Server;

import User.Post.Post;
import User.Tasks.Task;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import User.UserProperties.User;
import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ServerUtils {
    static final String GET_ALL_USERS_URL = "https://jsonplaceholder.typicode.com/users";
    static final Gson GSON = new Gson();

    public static int deleteUserByID(int userID) throws IOException {
        return Jsoup.connect(String.format(GET_ALL_USERS_URL + "/%d", userID))
                .ignoreContentType(true)
                .method(Connection.Method.DELETE)
                .execute().statusCode();
    }

    public static String updateExistingUser(int userID, String username) throws IOException {
        User user = GSON.fromJson(getUserByID(userID), User.class);
        user.setUsername(username);
        String json = GSON.toJson(user);
        String url = String.format(GET_ALL_USERS_URL + "/%d", userID);
        return Jsoup.connect(url)
                .ignoreContentType(true)
                .method(Connection.Method.PUT)
                .requestBody(json)
                .execute().body();
    }

    public static String postNewUser(User user) throws IOException {
        return Jsoup.connect(GET_ALL_USERS_URL)
                .ignoreContentType(true)
                .followRedirects(false)
                .method(Connection.Method.POST)
                .requestBody(GSON.toJson(user))
                .execute().body();
    }

    public static String getUserByID(int userID) throws IOException {
        String url = String.format(GET_ALL_USERS_URL + "/%d", userID);
        return findUsers(url);
    }

    public static String getAllUsersByUserName(String username) throws IOException {
        String url = String.format(GET_ALL_USERS_URL + "?username=%s", username);
        return findUsers(url);
    }

    public static String getAllUsers() throws IOException {
        return findUsers(GET_ALL_USERS_URL);
    }

    private static String findUsers(String url) throws IOException {
        return getInformation(url);
    }

    private static String findAllUserPosts(int userID) throws IOException {
        String url = String.format("https://jsonplaceholder.typicode.com/users/%d/posts", userID);
        return getInformation(url);
    }

    private static int findTheLastPostID(int userID) throws IOException {
        String posts = findAllUserPosts(userID);
        List<Post> listOfPosts = GSON.fromJson(posts, new TypeToken<List<Post>>() {
        }.getType());
        System.out.println(listOfPosts.get(listOfPosts.size()-1));
        return listOfPosts.get(listOfPosts.size()-1).getId();
    }

    public static void showCommentsToUserLastPostAndWriteToJson(int userID) throws IOException {
        List<Post> listOfPosts = getAllPostsByUser(userID);
        Map<Integer, String> mapOfCommentsWithIdToLastPost = createMapOfCommentsToLastPostAndPrintToConsole(listOfPosts);
        writeToJsonFile(userID, mapOfCommentsWithIdToLastPost);
    }

    private static void writeToJsonFile(int userID, Map<Integer, String> mapOfCommentsWithIdToLastPost) throws IOException {
        String jsonFileNameToWrite = String.format("src/main/resources/user-%d-post-%d-comments.json", userID,findTheLastPostID(userID));
        FileWriter writer = new FileWriter(jsonFileNameToWrite);
        writer.write(new GsonBuilder().setPrettyPrinting().create().toJson(mapOfCommentsWithIdToLastPost));
        writer.flush();
    }

    private static Map<Integer, String> createMapOfCommentsToLastPostAndPrintToConsole(List<Post> listOfPosts) {
        return listOfPosts.stream()
                .collect(Collectors.toMap(Post::getId, Post::getBody));
    }

    private static List<Post> getAllPostsByUser(int userID) throws IOException {
        String url = String.format("https://jsonplaceholder.typicode.com/posts/%d/comments", findTheLastPostID(userID));
        String posts = getInformation(url);
        return GSON.fromJson(posts, new TypeToken<List<Post>>() {
        }.getType());
    }

    public static void showPendingTasks(int userID) throws IOException {
        String url = String.format("https://jsonplaceholder.typicode.com/users/%d/todos",userID);
        List <Task> listOfTasks = GSON.fromJson(getInformation(url), new TypeToken<List<Task>>() {
        }.getType());
        listOfTasks.stream()
                .filter(task -> !task.isCompleted())
                .forEach(System.out::println);

    }

    private static String getInformation(String url) throws IOException {
        return Jsoup.connect(url)
                .ignoreContentType(true)
                .get()
                .body()
                .text();
    }


}


