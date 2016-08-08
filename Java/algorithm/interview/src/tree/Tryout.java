package tree;

import java.util.*;

/**
 * Created by linjun on 16/7/4.
 */

public class Tryout {
    public static void main(String[] args){
        Boolean a = null;
        if(a == null){
            System.out.print("true");
        }else{
            System.out.print("false");
        }
        String b = "hiA;";
    }
}

class Note{
    String a;
    String b;
    public void setA(String a){
        this.a = a;
    }
    public String getA(){
        return a;
    }
    public void setB(String b){
        this.b = b;
    }
    public String getB(){
        return b;
    }
    /**
     * Overrides default hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((a == null) ? 0 : a.hashCode());
        result = prime * result + ((b == null) ? 0 : b.hashCode());

        return result;
    }

    /**
     * Overrides default equals()
     */
    @Override
    public boolean equals(Object obj) {

        if (!(obj instanceof Note)) {
            return false;
        }

        Note other = (Note) obj;
        if (a == null) {
            if (other.a != null) {
                return false;
            }
        } else if (!a.equals(other.getA())) {
            return false;
        }

        if (b == null) {
            if (other.b != null) {
                return false;
            }
        } else if (!b.equals(other.getB())) {
            return false;
        }

        return true;
    }
}
