package colletc;

import java.math.BigDecimal;
import java.util.*;


public class CollectT {
    /**
     * 入口函数
     * @param args 参数
     */
    public static void main(String[] args) {
        //【3】集合 List、Set、Map
        //ArrayList or LinkedList
        //Set --> HashSet TreeSet
        List<String> strList = new ArrayList<>();
        strList.add("list a");
        strList.add("list b");
        strList.set(1, "list bb");
        strList.add("list c");
        Iterator<String> itList = strList.iterator();
        int listSize = strList.size();
        while (itList.hasNext())
        {
            System.out.println("List : " + itList.next());
        }

        //Map --> HashMap TreeMap
        Map<String, String> strMap = new HashMap<>();
        strMap.put("H", "本田");
        strMap.put("日", "丰田");
        for (String key : strMap.keySet()) {
            System.out.println("Map : " + strMap.get(key));
        }
    }
}