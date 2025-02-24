import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StringUpdate {
    public static void main(String[] args) {
        String str = "   Hello World   ";
        System.out.println(str.isBlank());
        System.out.println(str.strip());
        System.out.println(str.stripLeading());
        System.out.println(str.stripTrailing());

        System.out.println("*".repeat(10));
        record Person(String name, String city, int age) {
        }
        List<Person> people = List.of(new Person("Alex", "Paris", 32),
                new Person("Martin", "Paris", 24),
                new Person("Tim", "Paris", 23),
                new Person("Emilie", "Berlin", 25),
                new Person("Albert", "Chicago", 24),
                new Person("Mateo", "Madrid", 25),
                new Person("Adrien", "Barcelone", 27));

        var minMaxAge = people.stream().collect(
                Collectors.teeing(
                        Collectors.minBy(Comparator.comparingInt(Person::age)),
                        Collectors.maxBy(Comparator.comparingInt(Person::age)),
                        (min, max) -> "Min = " + min.get() + ", Max = " + max.get() // Merge
                )
        );
        System.out.println(minMaxAge);


    }
}
