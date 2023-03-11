package inheritance;

import java.math.BigDecimal;

public class AbstractMain {
    public static void main(String... args) {
       Animal tom = new Cat();
       System.out.println(tom);

       Animal balkan = new Dog(new BigDecimal(15));
       System.out.println(balkan);

    }
}
