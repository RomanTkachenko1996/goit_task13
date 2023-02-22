package tasks.User;

import lombok.*;

@Data
@AllArgsConstructor

public class User {
    private int id;
    private String name;
    private String username;
    private String email;
    private Address address;
    private String phone;
    private String website;
    private Company company;

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
}
