package OOD.BuilderPattern;

/**
 * @author BorisMirage
 * Time: 2019/10/23 13:50
 * Created with IntelliJ IDEA
 */

public class BuilderPattern {
    public static void main(String[] args) {
        User user = new User.UserBuilder("Mirage09", "12345")
                .setFirstName("Boris")
                .setLastName("Mirage")
                .setAddress("123 Ave")
                .setPhone("123456789")
                .setEmail("abc@gmail.com")
                .build();

        System.out.println(user);
    }
}
