package common;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by linjun on 16/12/1.
 */
public class Tryout1 {
    public static void main(String[] args){
        Map<String, Object> m = new HashMap<>();
        if(Boolean.TRUE.equals(m.get("s1"))){
            System.out.print("YES");
        }else{
            System.out.print("NO");
        }

    }
}
