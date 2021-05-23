import java.io.IOException;
import java.util.Set;

public class testLekarstw {
    public static void main(String[] args) throws IOException {
        Set<Float> skladniki = Set.of(1.0f,2.0f,3.0f,4.0f,5.0f,6.0f,7.0f);

        lekarstwo lekarstwo = new lekarstwo("polopiryna",40.0f,0.05f,skladniki,true);
        lekarstwo.podajCene(true);
        lekarstwo.zapisz("nazwaLeku.txt");
        System.out.println(lekarstwo.sprzedajLekarstwo(false,true));
        System.out.println(lekarstwo.podajCene(true));
        System.out.println(lekarstwo.sredniaWagaSkladnikaCzynnego());
    }

}
 