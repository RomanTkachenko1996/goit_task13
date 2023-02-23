package tasks.HttpTest;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import tasks.User.User;
import com.google.gson.Gson;
import java.io.IOException;

public class HttpUtil {
    static final String GET_ALL_USERS_URL = "https://jsonplaceholder.typicode.com/users";
    static final Gson GSON = new Gson();

    public static int deleteUserByID (int userID) throws IOException{
        return Jsoup.connect(String.format(GET_ALL_USERS_URL + "/%d", userID))
                .ignoreContentType(true)
                .method(Connection.Method.DELETE)
                .execute().statusCode();
    }
    public static String updateExistingUser(int userID, String username)throws IOException {
        User user = GSON.fromJson(getUserByID(userID),User.class);
        user.setUsername(username);
        String json = GSON.toJson(user);
        return Jsoup.connect(String.format(GET_ALL_USERS_URL + "/%d", userID))
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
        String formatted = String.format(GET_ALL_USERS_URL + "/%d", userID);
        return findUsers(formatted);
    }

    public static String getAllUsersByUserName(String username) throws IOException {
        String formatted = String.format(GET_ALL_USERS_URL + "?username=%s", username);
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


