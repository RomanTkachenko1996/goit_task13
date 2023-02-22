package tasks.User;

import lombok.*;

@Data
@AllArgsConstructor

public class Geolocation {
    private String lat;
    private String lng;

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
}
