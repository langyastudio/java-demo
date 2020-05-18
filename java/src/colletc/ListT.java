package colletc;

import java.util.Arrays;
import java.util.List;

public class ListT {
    public static void main(String[] args) {
        List<Person> list = List.of(
                new Person("wang", 18),
                new Person("li", 18),
                new Person("huang", 18)
        );

        boolean exist = list.contains(new Person("li", 18));
        System.out.println(exist ? "测试成功!" : "测试失败!");

        Person[] pArr = list.toArray(Person[]::new);
        System.out.println(Arrays.toString(pArr));
    }
}
