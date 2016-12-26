package functionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by linjun on 17/1/14.
 */
public class SupplierTest {
    public static void main(String[] argv){
        System.out.println("yes");
        Supplier<Object> s = ()->{return new Object();};
        Predicate<Integer> t = x-> x>5;
        Supplier<String> supp = () -> {return "Supplier";};
        BinaryOperator<String> bina = (x, y) ->{return "BinaryOperator";};
        System.out.println(bina.apply("a","b"));
        System.out.println(supp.get());
        Stream<List> stream = Stream.of(Arrays.asList(1, 2, 3), Arrays.asList(2, 3, 4));
        stream.flatMap(x->x.stream()).collect(Collectors.toList());

        Stream<F> stream2 = Stream.of(
                new F("linjun", 30),
                new F("lichun", 30),
                new F("zhaomin", 31),
                new F("liweiyong", 31));
        Stream<F> stream3 = stream2.flatMap(x->Arrays.asList(x, new F(x.getName()+ "+1", 33), new F(x.getName() + "+2", 33)).stream());
        Map<Integer, List<F>> rc = stream3.collect(Collectors.groupingBy(f->f.getAge()));
        System.out.println(rc.get(30));

        Stream<Integer> stream4 = Stream.of(1,2,3,4,5);
        Integer rc2 = stream4.reduce(0, (mem, ele)-> mem+ele);
        System.out.println(rc2);

        Stream<Integer> stream5 = Stream.of(1,2,3,4,5);
        Stream<Integer> stream6 = stream5.map(x->x*2);
        System.out.println(stream6.collect(Collectors.toList()));
    }
}

class F{
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    private String name;
    private Integer age;
    public F(String name, Integer age){
        this.name = name;
        this.age = age;
    }

    public String toString(){
        return "name:"+name + " age:"+age;
    }
}
