package helpers;


import com.github.javafaker.Faker;

public class RandomDataGenerator {

    private String name;
    private String email;
    private final Faker faker;
    public  RandomDataGenerator(){
        this.faker = new Faker();
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String generateName() {
       /* Faker faker = new Faker();
        name = faker.name().fullName();
        return  name;*/
        return  faker.name().fullName();
    }


}
