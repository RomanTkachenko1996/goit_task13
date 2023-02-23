package ServerTests;

import User.Tasks.Task;
import com.google.gson.Gson;
import User.UserProperties.User;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import static Server.ServerUtils.*;

public class ServerTests {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        User user = new Gson().fromJson(new FileReader("src/main/resources/newUser.json"), User.class);

        //show pending tasks of a particular user
        //showPendingTasks(1);

        //show and write comments to the last post of the give user
        //showCommentsToUserLastPostAndWriteToJson(5);

        //deleting user
        // System.out.println("deleteUserByID(2) = " + deleteUserByID(2));

        //updating user
        //System.out.println("updateExistingUser(2,\"MIKEWASOVSKI\") = " + updateExistingUser(2, "MIKEWASOVSKI"));

        //posting new user
        //System.out.println("postNewUser(user) = " + postNewUser(user));


        //getting all users
        //List<User> list = new Gson().fromJson(getAllUsers(), new TypeToken<List<User>>(){}.getType());
        //list.forEach(System.out::println);

        //getting a particular user by username
        //System.out.println("Bret Username: " + getAllUsersByUserName("Bret"));

        //getting a particular user by ID
        //System.out.println(getUserByID(2));

    }
}
