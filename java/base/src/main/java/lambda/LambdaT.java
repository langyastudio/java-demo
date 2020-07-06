package lambda;

import java.util.Arrays;

/**
 * @author hk
 */
public class LambdaT {
    public static void main(String[] args) {
        //FunctionalInterface
        String [] arr = new String[]{ "Apple", "Orange", "Banana"};
        Arrays.sort(arr, (s1, s2) -> {return s1.compareTo(s2);});

        System.out.println(String.join(",", arr));
    }
}