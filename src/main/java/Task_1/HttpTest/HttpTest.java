package Task_1.HttpTest;

import Task_1.User.Address;
import Task_1.User.Company;
import Task_1.User.Geolocation;
import Task_1.User.User;

import java.io.IOException;
import java.net.URISyntaxException;

public class HttpTest {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        User user = new User.Builder()
                .buildID(24)
                .buildName("Mark Chambers")
                .buildUserName("SoccerPlayer")
                .buildEmail("markchambers@gmail.com")
                .buildAddress(new Address.Builder()
                        .buildStreet("Henrys Str")
                        .buildCity("Rochester")
                        .buildSuite("Suite 12")
                        .buildZipcode("123592-34")
                        .buildGeo(new Geolocation.Builder()
                                .buildLat("23.234")
                                .buildLng("36.695")
                                .build())
                        .build())
                .buildPhone("(234)345-1234")
                .buildWebsite("soccer.info")
                .buildCompany(new Company.Builder()
                        .buildName("SoccPlayer LLC")
                        .buildCatchPhrase("One bet-one win")
                        .buildBS("Play and Win betting on soccer")
                        .build())
                .build();

        //getting all users from server
        //HttpUtil.getAllUsers().forEach(System.out::println);

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

    }
}
