package colletc;

import java.util.HashSet;
import java.util.Set;

public class SetT {
    public static void main(String[] args) {
        //HashSet
        Set<String> stringSet = new HashSet<>();
        stringSet.add("apple");
        stringSet.add("banana");
        stringSet.add("peach");
        for (String str:stringSet)
        {
            System.out.println(str);
        }

        //TreeSet
    }
}

