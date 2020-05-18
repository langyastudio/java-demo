package colletc;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapT {
    public static void main(String[] args) {
        //HashMap
        Map<String, Integer> map = new HashMap<>();
        map.put("wang", 18);
        map.put("li", 20);

        for(Map.Entry<String, Integer> entry : map.entrySet())
        {
            System.out.println(entry.getKey() + entry.getValue());
        }

        //TreeMap - sorted map
        Map<Person, Integer> treeMap = new TreeMap<>();
        treeMap.put(new Person("B", 70), 70);
        treeMap.put(new Person("A", 50), 50);
        treeMap.put(new Person("C", 90), 90);
        for (Person key : treeMap.keySet()) {
            System.out.println(key.getAge());
        }
    }
}
