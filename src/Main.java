import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1,2,3,4);
        List<Integer> list2 =  Arrays.asList(1,2,3,4,5,6);

        // Traditional approach -s
        BiFunctionExample biFunctionExample = new BiFunctionExample();
        List<Integer> list3 = biFunctionExample.apply(list1, list2);
        System.out.println(list3);

        // By anonymous method -
        BiFunction<List<Integer>, List<Integer>, List<Integer>> biFunction = new BiFunction<List<Integer>, List<Integer>, List<Integer>>() {
            @Override
            public List<Integer> apply(List<Integer> integers, List<Integer> integers2) {
                return Stream.of(list1, list2).flatMap(Collection::stream).distinct().collect(Collectors.toList());
            }
        };
        List<Integer> list4 = biFunction.apply(list1, list2);
        System.out.println(list4);

        // Lambda function approach -
        BiFunction<List<Integer>, List<Integer>, List<Integer>> biFunction1 = (integers, integers2) -> {
            return Stream.of(list1, list2).flatMap(Collection::stream).distinct().collect(Collectors.toList());
        };
        System.out.println(biFunction1.apply(list1, list2));

        // real time implementation of bifunctional interface
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 10000);
        map.put("b", 120000);
        map.put("c", 30000);

        BiFunction<String, Integer, Integer> biFunction2 = new BiFunction<String, Integer, Integer>() {
            @Override
            public Integer apply(String s, Integer integer) {
                return integer + 5000;
            }
        };
        BiFunction<String, Integer, Integer>  biFunction3 = (s, i) -> i + 5000;
        map.replaceAll(biFunction3);
        System.out.println(map);
    }
}