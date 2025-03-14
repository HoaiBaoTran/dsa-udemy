public class factorialRecursive {
    public static void main(String[] args) {
        int number = 5;
        System.out.println(findFactorialRecursive(number));
        System.out.println(findFactorialIterative(number));
    }

    private static int findFactorialRecursive(int number) {
        if (number <= 1) {
            return 1;
        }

        if (number == 2) {
            return 2;
        }

        return number * findFactorialIterative(number - 1);
    }

    private static int findFactorialIterative(int number) {
        if (number <= 1) {
            return 1;
        }

        int result = 1;
        for (int i = 2; i <= number; i++) {
            result *= i;
        }
        return result;
    }
}

// Write two functions that finds the factorial of any
// number. One should use recursive, the other should just
// use a for loop
