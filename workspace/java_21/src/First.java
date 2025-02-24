import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

@interface NotNull { }

public class First {
    public static void main(String[] args) {
        Map<String, List<Integer>> result = getData();
        // Type inference with var
        var result2 = getData();

        var str = "Hello World";
//       var obj = null; Not valid

       doTask((@NotNull String s) -> s.length() > 5);

        doTask(s -> s.length() > 5);

//        doTask(@NotNull  s -> s.length() > 5);

        doTask((@NotNull var s) -> s.length() > 5);
    }

    private static  void doTask(Predicate<String> str) {

    }
    private static Map<String, List<Integer>> getData() {
        return null;
    }


}
