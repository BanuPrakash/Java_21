import java.util.List;

import static java.lang.StringTemplate.RAW;
import static java.lang.StringTemplate.STR;

public class Template {
    public static void main(String[] args) {
        int x = 10;
        int y = 20;
        String result = STR."\{x} + \{y} = \{x + y}";

        System.out.println(result);

        String student = "Mary";
        String teacher = "Johnson";
        String result1 = STR."The student \{student} is in \{teacher}'s classroom.";
        String result2[] = RAW."The student \{student} is in \{teacher}'s classroom.".values(STR);



    }
}
