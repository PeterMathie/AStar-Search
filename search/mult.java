package Search.src.uk.ac.hw.macs.search;

public class mult{
    
    static int Mult(int x, int y) {
        int sum = 0;
        while (y > 0) {
            sum += x;
            y--;
        }
        return sum;
    }

    public static void main(String[] args) {
        int mult = Mult(8, 4);
        System.out.println(mult);
    }
}
