package tasks.HttpTest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import tasks.User.Address;
import tasks.User.Company;
import tasks.User.Geolocation;
import tasks.User.User;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;

public class HttpTest {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        //getting a particular user by ID
        //System.out.println(HttpUtil.getUserById(2));

        //getting a particular user by username
        // System.out.println(HttpUtil.getUsersByUserName("Kamren"));

        //posting a new user
        //System.out.println("HttpUtil.postNewUser(user) = " + HttpUtil.postNewUser(user));

        //putting a new username to existing user
        //System.out.println(HttpUtil.updateUser(1,"UKRAINE"));

        //deleted a user by their id
        //System.out.println("If user deleted status code:" + HttpUtil.deleteUser(2));

        //getting all users from server
       // HttpUtil.getAllUsers().forEach(System.out::println);
        User user = new Gson().fromJson(new FileReader("src/main/resources/newUser.json"), User.class);
        System.out.println(HttpUtil.postNewUser(user));
    }
}
