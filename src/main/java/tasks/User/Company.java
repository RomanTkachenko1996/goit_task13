package tasks.User;

import lombok.*;

@Data
@AllArgsConstructor
public class Company {
    private String name;
    private String catchPhrase;
    private String bs;

    public static class Builder{
        private String name;
        private String catchPhrase;
        private String bs;

        public Company build(){
            return new Company(name,catchPhrase,bs);
        }
        public Builder buildBS (String bs){
            this.bs = bs;
            return this;
        }

        public Builder buildCatchPhrase (String catchPhrase){
            this.catchPhrase = catchPhrase;
            return this;
        }
        public Builder buildName (String name){
            this.name = name;
            return this;
        }
    }
}
