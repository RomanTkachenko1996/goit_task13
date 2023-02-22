package tasks.User;

import lombok.*;

@Data
@AllArgsConstructor

public class Address {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private Geolocation geo;

    public static class Builder{
        private String street;
        private String suite;
        private String city;
        private String zipcode;
        private Geolocation geo;

        public Address build (){
            return new Address(street,suite,city,zipcode,geo);
        }
        public Builder buildGeo(Geolocation geo){
            this.geo = geo;
            return this;
        }
        public Builder buildZipcode(String zipcode){
            this.zipcode = zipcode;
            return this;
        }

        public Builder buildCity(String city){
            this.city = city;
            return this;
        }
        public Builder buildSuite(String suite){
            this.suite = suite;
            return this;
        }

        public Builder buildStreet(String street){
            this.street = street;
            return this;
        }
    }
}
