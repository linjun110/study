package common;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by linjun on 17/2/13.
 */
public class P1 {
    private static Map<String, String> msg = new HashMap<>();
    private static String msg2 = "msg2";

    public static String get(String key){
        return msg.get(key);
    }

    public static String get2(){
        return msg2;
    }
}
