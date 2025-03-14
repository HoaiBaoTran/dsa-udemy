public class fibonacciRecursive {
    // Given a number N return the index value of the
    // fibonacci sequence, where the sequence is:
    // 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144,...
    // the pattern of the sequence is that each value is the sum
    // of the 2 previous values, that means that for N=5 -> 2+3
    public static void main(String[] args) {
        int n = 8;
        System.out.println(findFibonacciRecursive(n));
        System.out.println(fibonacciIterative(n));
    }

    private static int fibonacciIterative(int n) {
        if (n < 2) {
            return n;
        }
        int first = 0;
        int second = 1;
        for (int i = 2; i <= n; i++) {
            int temp = first;
            first = second;
            second = second + temp;
        }
        return second;
    }

    private static int findFibonacciRecursive(int n) {
        if (n < 2) {
            return n;
        }

        return findFibonacciRecursive(n - 1) + findFibonacciRecursive(n - 2);
    }
}
