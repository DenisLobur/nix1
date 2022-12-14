package lesson16;

import java.util.Locale;

public class Person {
    private final String name;
    private final int age;
    private final Sex sex;

    public Person(String name, int age, Sex sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Sex getSex() {
        return sex;
    }

    @Override
    public String toString() {
        return "Person(" +
                "name: " + name +
                ", age: " + age +
                ", sex:" + sex +
                ")";
    }

    public String toCSVFormat() {
        return name + ", " + age + ", " + sex.toString().toLowerCase(Locale.ROOT);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;

        if (age != person.age) return false;
        if (!name.equals(person.name)) return false;
        return sex == person.sex;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + age;
        result = 31 * result + sex.hashCode();
        return result;
    }
}


