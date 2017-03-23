package common;

/**
 * Created by linjun on 17/2/13.
 */
public class P1<Input, Output> {
    public static void main(String[] args){
        C3 c = new C3<S1, M>();
        M r = c.func(new S1());
    }
}

abstract class P<Input, Output> {
    public abstract Output func(Input input);
}

abstract class C1<Input extends S, Output> extends P<Input, Output>{
    void common(Input input){
        input.eat();
    }
}

class C3<Input extends S, Output extends M> extends C1<Input, Output>{
    public Output func(Input input){
        input.eat();
        return null;
    };
}

class S{
    M eat(){
        return new M("fish", 5);
    }
}
class S1 extends S{
    M eat(){
        return new M("sub fish", 4);
    }
}

class M{
    String name;
    Integer age;
    M(String name, Integer age){
        this.name = name;
        this.age = age;
    }
}
