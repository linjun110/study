package common;

import com.sun.istack.internal.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by linjun on 16/12/1.
 */
public class Tryout1 {
    public static void main(String[] args){
        System.out.println(f(null));
    }

    private static String f(String a) {
        @NotNull String b = a;
        return b;
    }
}
