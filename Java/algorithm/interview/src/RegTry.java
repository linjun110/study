import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by linjun on 16/7/4.
 */

public class RegTry {
    //final private static Map<String, String> m = new HashMap<>();
    public static void main(String[] args){
        String s = "222 333-4444";
        String s2 = "222 333-44444";
        //Pattern pattern = Pattern.compile("//(//d{3}//)//s//d{3}-//d{4}");
        String re = "\\d{3}\\s\\d{3}-\\d{4}";
        Pattern pattern = Pattern.compile(re);
        Matcher matcher = pattern.matcher(s);
        Matcher matcher2 = pattern.matcher(s2);

        if (matcher.find()) {
            System.out.println(matcher.group());
        }
        if (matcher2.matches()) {
            System.out.println(matcher2.group());
        }

    }
}
