import java.util.function.Function;

public class FunctionDemo {
    public static void main(String[] args) {
        Function<String, String> greet = name -> "Hello " + name;
        System.out.println(greet.apply("Digital Dragon"));

        Function<String, String> identityFunction = Function.identity();
        System.out.println(identityFunction.apply("Hello World!"));

        Function<String, String> thenFunc = txt -> txt + "!";
        Function<String, String> andFunc = txt -> txt.toUpperCase().substring(txt.length() - 5);
        Function<String, String> andThenFunc = andFunc.andThen(thenFunc);
        System.out.println(andThenFunc.apply("Hello wOrld"));

        Function<String, String> doThis = txt -> txt + "!";
        Function<String, String> doThat = txt -> txt.toUpperCase().substring(txt.length() - 5);
        Function<String, String> doThisAndThenThat = doThat.compose(doThis);

        System.out.println(doThisAndThenThat.apply("Hello wOrld"));
    }
}
