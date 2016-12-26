package generation;

import java.util.Arrays;

/**
 * Created by linjun on 16/11/23.
 */
public class Tryout2 {
    public static void main(String[] args){
        A2 a = new A2();
        a.<Integer>f(new Integer(1));
        a.<String>f(new String("yes"));
        a.f(new A3<String>());
    }
}

class A2{
    public <T> T f(T v){
        System.out.println("call me");
        System.out.println(v.getClass().getTypeParameters());
        System.out.println(Arrays.toString(v.getClass().getTypeParameters()));
        return null;
    }
}
class A3 <K> {
    K a;
}

class A4 <K> {
    Class<K> a;
}
