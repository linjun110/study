package tree;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by linjun on 16/7/4.
 */

public class Tryout {
    //final private static Map<String, String> m = new HashMap<>();
    public static void main(String[] args){
        List<P> o = new ArrayList<>();
        o.add(new P(6));
        o.add(new P(3));
        o.add(new P(2));
        o.add(new P(5));
        o.add(new P(0));
        o.add(new P(1));
        o.add(new P(4));
        List<P> n = o.subList(1, 3);
        n.sort(new Comparator<P>() {
            @Override
            public int compare(P o1, P o2) {
                return o1.i - o2.i;
            }
        });
        if(o.containsAll(n)){
            System.out.println("TRUE");
        }else{
            System.out.println("FALSE");
        }
        Iterator<P> it = o.iterator();
        while(it.hasNext()){
            System.out.println(it.next().i);
        }
        f(null);
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
    public static void f(Object a){
    }
}
class P{
    public int i;
    P(int i){
        this.i = i;
    }
}
