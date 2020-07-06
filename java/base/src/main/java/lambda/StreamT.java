package lambda;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author hk
 */
public class StreamT {
    public static void main(String[] args) {
        //map
        List.of("1a", "2b", "3C").stream()
                .map(String::toLowerCase)
                .forEach(System.out::println);

        //filter
        //获取休息日
        Stream.generate(new LocalDateSupplier())
                .limit(31)
                .filter(ld -> ld.getDayOfWeek() == DayOfWeek.SATURDAY || ld.getDayOfWeek() == DayOfWeek.SUNDAY)
                .forEach(System.out::println);

        //collect
        Map<String, String> map = List.of("a:1", "b:7")
                .stream()
                .collect(Collectors.toMap(
                        k -> k.substring(0, k.indexOf(":")),
                        v -> v.substring(v.indexOf(":") + 1))
                );
        System.out.println(map);

        //分组
        Map<String, List<String>> map2 = List.of("Apple", "Banana", "Blackberry", "Coconut", "Avocado", "Cherry", "Apricots")
                .stream()
                .collect(Collectors.groupingBy(k -> k.substring(0, 1), Collectors.toList()));
        System.out.println(map2);
    }
}
