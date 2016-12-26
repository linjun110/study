package generation;

/**
 * Created by linjun on 16/11/22.
 */
public class Tryout {
    public static void main(String[]  args){
        A b = new B();
        A c = new C();
        if(b instanceof B){
            System.out.println("b is B");
        }else{
            System.out.println("b is Not B");
        }
        if(c instanceof B){
            System.out.println("c is B");
        }else{
            System.out.println("c is Not B");
        }
        if(b instanceof C){
            System.out.println("b is C");
        }else{
            System.out.println("b is Not C");
        }
        if(c instanceof C){
            System.out.println("c is C");
        }else{
            System.out.println("c is Not C");
        }

        if(B.class.isInstance(b)){
            System.out.println("b is B");
        }else{
            System.out.println("b is Not B");
        }
        if(B.class.isInstance(c)){
            System.out.println("c is B");
        }else{
            System.out.println("c is Not B");
        }
        if(C.class.isInstance(b)){
            System.out.println("b is C");
        }else{
            System.out.println("b is Not C");
        }
        if(C.class.isInstance(c)){
            System.out.println("c is C");
        }else{
            System.out.println("c is Not C");
        }
    }
}

class A{
    A(){
    }
}

class B extends A{
    B(){
    }
}
class C extends A{
    C(){
    }
}
