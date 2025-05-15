package multithreading.intermediate;

public class Q18_Createthreadsafesingletonusingsynchronization {
    public static void main(String[] args) {
        Person person = Person.getPersonInstance("King", 31);
        System.out.println(person.toString());
    }
}

class Person {
    private String name;
    private int age;
    private static Person person = null;

    private Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public static synchronized Person getPersonInstance(String name, int age) {
        if (person == null) {
            person = new Person(name, age);
        }
        return person;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }

}
