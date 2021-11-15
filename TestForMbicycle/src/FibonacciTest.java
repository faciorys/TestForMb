public class FibonacciTest {
    public static void main(String[] args) {
        int first = 0;
        int second = 1;
        int result;
        for (int i = 1; i < 20; i++) {
            result = first + second;
            first = second;
            second = result;
            System.out.print(result + " ");
        }
    }
}
