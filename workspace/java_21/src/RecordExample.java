import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

record  Person(String name, int age) {
    public Person {
        if(age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
    }


    @Override
    public String name() {
        return name.toUpperCase();
    }
}

record Product(String name, double price) {}

public class RecordExample {

    public static void main(String[] args) {
        Product product = new Product("Laptop", 1000.0);
        System.out.println(product);
        System.out.println(product.name());
        System.out.println(product.price());

        if(product instanceof Product(String n,double p)) {
            System.out.println(n + " : " + p);
        }
        List<String> names = List.of("John", "Doe", "Jane", "Larson", "Angelina");

        String longest = getLongest(names);
        System.out.println(longest);
    }

    private static String getLongest(List<String> names) {
        record Pair(String name, int length){}
       return names.stream()
                .map(name -> new Pair(name, name.length()))
                .collect(Collectors.toList())
                .stream().max(Comparator.comparingInt(pair -> pair.length))
                .map(pair -> pair.name)
                .orElseThrow();
            }
}
