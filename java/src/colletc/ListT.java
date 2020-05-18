package colletc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListT {
    public static void main(String[] args) {
        //List.of 的结果只读
        //Array to List
        List<Person> list = List.of(
                new Person("wang", 18),
                new Person("li", 50),
                new Person("huang", 20)
        );

        boolean exist = list.contains(new Person("li", 18));
        System.out.println(exist ? "测试成功!" : "测试失败!");

        //list to Array
        Person[] pArr = list.toArray(Person[]::new);
        System.out.println(Arrays.toString(pArr));

        //sort
        List<Person> personList = new ArrayList<>(list);
        Collections.sort(personList);
        for (Person p:personList)
        {
            System.out.println(p.getAge());
        }

        //洗牌
        Collections.shuffle(personList);
        for (Person p:personList)
        {
            System.out.println(p.getAge());
        }
    }
}
