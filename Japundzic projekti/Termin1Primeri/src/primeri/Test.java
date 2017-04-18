package primeri;

/**
 * Created by androiddevelopment on 28.3.17..
 */
public class Test {
    public static void main(String[] args) {
        int a = 13;
        int b = 1;
        int c = a << b; // ovo dodaje jednu nulu na kraj

        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(b));

        System.out.println(Integer.toBinaryString(c));


        int d = a >> b;  // ovo uklanja poslednji broj
        System.out.println(Integer.toBinaryString(d));


        int e = a >> b;  // ovo uklanja poslednji broj
        System.out.println(Integer.toBinaryString(e));
    }
}
