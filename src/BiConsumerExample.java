import java.util.function.BiConsumer;

public class BiConsumerExample implements BiConsumer<String, Integer> {

    @Override
    public void accept(String i1, Integer i2) {
        System.out.println("input1 " + i1 + " input2 " + i2);
    }
}
