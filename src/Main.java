import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
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

        // andThen
        Function<List<Integer>, List<Integer>> sortedFunction = (list) ->
            list.stream().sorted().collect(Collectors.toList());

        biFunction.andThen(sortedFunction).apply(list1, list2);

        // BiConsumer
        BiConsumerExample biConsumerExample = new BiConsumerExample();
        biConsumerExample.accept("abc", 1);

        BiConsumer<String, Integer> biConsumer = new BiConsumer<String, Integer>() {
            @Override
            public void accept(String i1, Integer i2) {
                System.out.println("input1 " + i1 + " input2 " + i2);
            }
        };
        BiConsumer<String, Integer> biConsumer1 = (i1, i2) -> System.out.println("input1 " + i1 + " input2 " + i2);
        biConsumer1.accept("def", 2);

        // real time example of BiConsumer
        map.forEach(biConsumer1);

        // BiPredicate

        BiPredicate<String, String> biPredicate = new BiPredicate<String, String>() {
            @Override
            public boolean test(String s, String s1) {
                return s.equals(s1);
            }
        };
        BiPredicate<String, String> biPredicate1 = String::equals; // here lambda is replaced by method reference (s, s1) -> s.equals(s1);
        biPredicate1.test("test", "true");
    }



}