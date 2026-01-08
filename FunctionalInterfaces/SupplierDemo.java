import java.util.function.Supplier;
public class SupplierDemo {
    public static void main(String[] args) {
        Supplier<String> greeting = () -> "Hello World!";
        System.out.println(greeting.get());
    }
}
