package primer6;

//import primer4.IFigura;
import primer3.Figura;

public class TestAnonimna {
    public static void main(String[] args) {
        final double stranica=8;
        Figura f=new Figura() {

            @Override
            public double izracunajPovrsinu() {
                return stranica*stranica;
            }

            @Override
            public double izracunajObim() {
                return 4*stranica;
            }
        };
        System.out.println("f.izracunajObim() = " + f.izracunajObim());
    }
}
