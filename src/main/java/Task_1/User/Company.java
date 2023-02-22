package Task_1.User;

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

    public Company(String name, String catchPhrase, String bs) {
        this.name = name;
        this.catchPhrase = catchPhrase;
        this.bs = bs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCatchPhrase() {
        return catchPhrase;
    }

    public void setCatchPhrase(String catchPhrase) {
        this.catchPhrase = catchPhrase;
    }

    public String getBs() {
        return bs;
    }

    public void setBs(String bs) {
        this.bs = bs;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", catchPhrase='" + catchPhrase + '\'' +
                ", bs='" + bs + '\'' +
                '}';
    }
}
