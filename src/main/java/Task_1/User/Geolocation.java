package Task_1.User;

public class Geolocation {
    private String lat;
    private String lng;

    public Geolocation(String lat, String lng) {
        this.lat = lat;
        this.lng = lng;
    }
    public static class Builder{
        private String lat;
        private String lng;

        public Geolocation build (){
            return new Geolocation(lat,lng);
        }
        public Builder buildLng(String lng){
            this.lng = lng;
            return this;
        }
        public Builder buildLat(String lat){
            this.lat = lat;
            return this;
        }
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    @Override
    public String toString() {
        return "Geolocation{" +
                "lat='" + lat + '\'' +
                ", lng='" + lng + '\'' +
                '}';
    }
}
