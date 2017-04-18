package primeri;

public class Primer3Enumeracija {

    enum Size { SMALL , MEDIUM , LARGE , EXTRA_LARGE }; // enum literali koji su vrednosti u zagradi su vrednosti za SIZE, nemoze se prosiriti posle u hodu
    enum Days { MON , TUE , WEN , THU , FRI , SAT , SUN };

    public static void main(String[] args) {
        Size s = Size.MEDIUM ;
        System.out.println("s= "+s.ordinal()); // ordinal daje koja jae pozicija u "nizu" u zagradi
        Days d = Days.MON ;
        System.out.println("d= "+d);
    }
}
