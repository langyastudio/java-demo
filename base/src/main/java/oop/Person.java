package oop;

public class Person {
    protected int      age;
    protected String   name;
    private   String[] names;  // 默认初始化为null

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    //不允许被override
    public final int getAge() {
        return this.age;
    }

    public void setNames(String... names) {
        this.names = names;
    }

    public void run() {
        System.out.println("person run");
    }

    //覆盖
    @Override
    public String toString() {
        return "person age=" + age;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Person)
        {
            Person p = (Person)obj;

            // 并且name字段相同时，返回true:
            return this.name.equals(p.name);
        }

        return false;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }
}
