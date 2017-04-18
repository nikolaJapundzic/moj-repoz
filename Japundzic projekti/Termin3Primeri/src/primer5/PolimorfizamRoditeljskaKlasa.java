package primer5;

import primer3.Figura;
import primer3.Kvadrat;

import java.util.ArrayList;

public class PolimorfizamRoditeljskaKlasa {
    public static void main(String[] args) {
        Figura f=new Kvadrat(8);
        System.out.println("f.izracunajObim() = " + f.izracunajObim());
        ArrayList<Figura> figure=new ArrayList<Figura>();
        figure.add(new Kvadrat(5));
        figure.add(new Kvadrat(3));
        System.out.println("Prolazak kroz listu figura");
        for(Figura figura:figure)
            System.out.println("figura = " + figura);
    }
}
