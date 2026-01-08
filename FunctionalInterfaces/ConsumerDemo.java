import java.util.function.Consumer;

public class ConsumerDemo {
    public static void main(String[] args) {
        Consumer<String> welcomeMessage = name -> System.out.println("Welcome to Consumer Demo!");
        Consumer<String> greetUser = name -> System.out.println("Welcome " + name + "!");
        Consumer<String> chainedGreetings = welcomeMessage.andThen(greetUser);
        chainedGreetings.accept("Digital Dragon");
    }
}