package tasks.HttpTest;

import com.google.gson.Gson;
import tasks.User.User;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import static tasks.HttpTest.HttpUtil.*;

public class HttpTest {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        User user = new Gson().fromJson(new FileReader("src/main/resources/newUser.json"), User.class);

        //deleting user via jsoup
       // System.out.println("deleteUserByID(2) = " + deleteUserByID(2));

        //updating user via jsoup
        //System.out.println("HttpUtil.updateExistingUser(2,\"MIKEWASOVSKI\") = " + HttpUtil.updateExistingUser(2, "MIKEWASOVSKI"));

        //posting new user via jsoup
        //System.out.println("HttpUtil.postNewUser(user) = " + HttpUtil.postNewUser(user));

        //posting a new user
        //System.out.println("HttpUtil.postNewUser(user) = " + HttpUtil.postNewUser(user));

        //putting a new username to existing user
        //System.out.println(HttpUtil.updateUser(1,"UKRAINE"));

        //deleted a user by their id
        //System.out.println("If user deleted status code:" + HttpUtil.deleteUser(2));

        //getting all users
        //List<User> list = new Gson().fromJson( HttpUtil.getAllUsers(), new TypeToken<List<User>>(){}.getType());
        //list.forEach(System.out::println);

        //getting a particular user by username
        //System.out.println("Bret Username: " + HttpUtil.getAllUsersByUserName("Bret"));

        //getting a particular user by ID
        //System.out.println(HttpUtil.getUserByID(2));


    }
}
