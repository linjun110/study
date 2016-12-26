package annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

/**
 * Created by linjun on 16/11/22.
 */
public class Tryout {
    public static void main(String[] args){
        A a = new A("hi, there", "here");
        Annotation[] an = a.getClass().getDeclaredAnnotations();
        for(int i = 0; i< an.length; i++){
            System.out.println(an[i]);
        }

        Field[] fs = a.getClass().getDeclaredFields();
        for(int i = 0; i< fs.length; i++){
            if(fs[i].isAnnotationPresent(linjun.class)){
                System.out.println(fs[i].getName());
                System.out.println(fs[i].getAnnotation(linjun.class).name());
                System.out.println(fs[i].getAnnotation(linjun.class).lichun().name());
                System.out.println(fs[i].getAnnotation(linjun.class).lichun().age());
            }
        }
    }
}

class A{
    @linjun(name="lic", lichun = @lichun(name="oh"))
    private String s;
    private String s2;

    A(String s, String s2){
        this.s = s;
        this.s2 = s2;
    }

    //@linjun
    void func(){
    }
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface linjun{
    String name() default "";
    lichun lichun() default @lichun(age = "20");
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface lichun{
    String name() default "";
    String age() default "28";
}
