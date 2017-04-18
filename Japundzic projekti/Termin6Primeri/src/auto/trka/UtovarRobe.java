package auto.trka;

import java.util.ArrayList;

/**
 * Created by androiddevelopment on 8.4.17..
 */
public class UtovarRobe {
    public static void main(String[] args) {
        ArrayList<KontejnerNit> listaKontejnera = new ArrayList<KontejnerNit>();

        KontejnerNit k1 = new KontejnerNit(1111);
        KontejnerNit k2 = new KontejnerNit(2222);
        KontejnerNit k3 = new KontejnerNit(3333);
        KontejnerNit k4 = new KontejnerNit(4444);
        KontejnerNit k5 = new KontejnerNit(5555);

        listaKontejnera.add(k1);
        listaKontejnera.add(k2);
        listaKontejnera.add(k3);
        listaKontejnera.add(k4);
        listaKontejnera.add(k5);

        for(KontejnerNit ko : listaKontejnera){

        }

    }
}
