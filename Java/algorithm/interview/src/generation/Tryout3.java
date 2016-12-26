package generation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by linjun on 16/11/23.
 */
public class Tryout3 {
    public static void main(String[] args){
        Map<String, List<Animal>> m = new HashMap<String, List<Animal>>();
        List<Animal> l = new ArrayList<Animal>();
        l.add(new Cat());
        m.put("a1", l);
        List<Cat> l2 = new ArrayList<Cat>();
        // compile error
        //m.put("a2", l2);

        Map<String, List<? extends Animal>> m2 = new HashMap<String, List<? extends Animal>>();
        m2.put("a1", l2);

        List<Human> l3 = new ArrayList<Human>();
        // compile error
        //m2.put("a1", l3);

        Map<Integer, Integer> map = New.map();
        map.put(1, 1);
        map.put(2, 2);

        Map<Integer, String> map2 = New.map();
        map2.put(1, "1");
        map2.put(2, "2");

        // compile error
        //f(map);
        f(map2);
        f(New.map());
        f(New.<Integer, String>map());
        // compile error
        //f(New.<Integer, Integer>map());

        g(New.map());
    }

    static void f(Map<Integer, String> m){
    }
    static void g(Map<Integer, List<? extends Animal>> m){
    }
}

class Human{

}
class Animal{

}
class Cat extends Animal{

}

class New{
    static <K, V> Map<K, V> map(){
        return new HashMap<K, V>();
    }
}
