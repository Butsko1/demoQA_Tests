package source;

import com.github.javafaker.Faker;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class PracticeFormSource {
    static Faker faker = new Faker();
    static Stream<Arguments> methodSourse(){
        return Stream.of(
                Arguments.of(faker.name().firstName(), faker.name().lastName(), faker.internet().emailAddress(), "Female", faker.number().digits(10),
                        "Maths","Reading", "images/Test.PNG",faker.address().fullAddress(), "Rajasthan", "Jaipur"),
                Arguments.of(faker.name().firstName(), faker.name().lastName(), faker.internet().emailAddress(), "Male", faker.number().digits(10),
                        "Maths","Reading", "images/Test.PNG",faker.address().fullAddress(), "Rajasthan", "Jaipur"),
                Arguments.of(faker.name().firstName(), faker.name().lastName(), faker.internet().emailAddress(), "Other", faker.number().digits(10),
                        "Maths","Reading", "images/Test.PNG",faker.address().fullAddress(), "Rajasthan", "Jaipur")
        );
    }
}
