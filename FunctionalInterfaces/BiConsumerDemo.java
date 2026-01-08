import java.util.function.BiConsumer;

public class BiConsumerDemo {
    public static void main(String[] args) {
        System.out.println("********************");
        BiConsumer<Integer, Integer> tableOne = (firstNumber, secondNumber) -> {
            for (int i = 1; i < 11; i++) {
                System.out.println(firstNumber + " * " + i + " : " + firstNumber * i);
            }
            System.out.println("********************");
        };

        BiConsumer<Integer, Integer> tableTwo = (firstNumber, secondNumber) -> {
            for (int i = 1; i < 11; i++) {
                System.out.println(secondNumber + " * " + i + " : " + secondNumber * i);
            }
            System.out.println("********************");
        };

        BiConsumer<Integer, Integer> tables = tableOne.andThen(tableTwo);

        tables.accept(5,10);

    }
}