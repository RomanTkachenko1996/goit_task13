package Task_1.User;

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


    public Address(String street, String suite, String city, String zipcode, Geolocation geo) {
        this.street = street;
        this.suite = suite;
        this.city = city;
        this.zipcode = zipcode;
        this.geo = geo;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getSuite() {
        return suite;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public Geolocation getGeo() {
        return geo;
    }

    public void setGeo(Geolocation geo) {
        this.geo = geo;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", suite='" + suite + '\'' +
                ", city='" + city + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", geo=" + geo +
                '}';
    }
}
