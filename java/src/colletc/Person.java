package colletc;

import java.util.Objects;

public class Person implements Comparable<Person> {
    private String name;
    private int    age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge()
    {
        return this.age;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Person) {
            Person o = (Person)obj;
            return Objects.equals(o.name, this.name) && o.age == this.age;
        }

        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.age);
    }

    @Override
    public int compareTo(Person o) {
        if(this.age > o.age)
        {
            return 1;
        }
        else if (this.age < o.age)
        {
            return -1;
        }

        return 0;
    }
}
