package Task_1.User;

/**
 * Cтворення нового об'єкта в https://jsonplaceholder.typicode.com/users.
 * Можливо, ви не побачите одразу змін на сайті.
 * Метод працює правильно, якщо у відповідь на JSON з об'єктом повернувся такий самий JSON,
 * але зі значенням id більшим на 1, ніж найбільший id на сайті.
 */
public class User {
    private int id;
    private String name;
    private String username;
    private String email;
    private Address address;
    private String phone;
    private String website;
    private Company company;

    public User(int id, String name, String username, String email, Address address, String phone, String website, Company company) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.website = website;
        this.company = company;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }


    public static class Builder {
        private int id;
        private String name;
        private String username;
        private String email;
        private Address address;
        private String phone;
        private String website;
        private Company company;

        public User build (){
            return new User(id,name,username,email,address,phone,website,company);
        }
        public Builder buildCompany(Company company){
            this.company = company;
            return this;
        }
        public Builder buildWebsite(String website){
            this.website = website;
            return this;
        }
        public Builder buildPhone(String phone){
            this.phone = phone;
            return this;
        }
        public Builder buildAddress(Address address){
            this.address = address;
            return this;
        }

        public Builder buildEmail(String email){
            this.email = email;
            return this;
        }
        public Builder buildUserName(String username){
            this.username = username;
            return this;
        }
        public Builder buildID(int id){
            this.id = id;
            return this;
        }
        public Builder buildName(String name){
            this.name = name;
            return this;
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", address=" + address +
                ", phone='" + phone + '\'' +
                ", website='" + website + '\'' +
                ", company=" + company +
                '}';
    }
}
