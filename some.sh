
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
var person = new Person("Roger", 44);
person.name()
var x = 100;