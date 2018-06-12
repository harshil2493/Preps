public class Recurse {

    public static void main(String[] args) throws Exception {
        System.out.println("Factorial 6: " + new Factorial().fact(6));
        System.out.println("Factorial 0: " + new Factorial().fact(0));
        System.out.println("Factorial 1: " + new Factorial().fact(1));

        try {
            System.out.println("Factorial -1 " + new Factorial().fact(-1));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Fibonacci 1: " + new Fibonacci().fib(1));
        System.out.println("Fibonacci 0: " + new Fibonacci().fib(0));
        System.out.println("Fibonacci 5: " + new Fibonacci().fib(5));

        long startTime = System.nanoTime();
        System.out.println("Fibonacci 40: " + new Fibonacci().fib(40));
        long endTime = System.nanoTime();

        System.out.println("Execution Lasted For " + (endTime - startTime) / 1000000.0 + "ms");

        startTime = System.nanoTime();
        System.out.println("Fibonacci 40: " + new FibonacciMemoization().fib(40));
        endTime = System.nanoTime();

        System.out.println("Execution Lasted For " + (endTime - startTime) / 1000000.0 + "ms");
    }
}


class Factorial {

    int fact(int number) throws Exception {
        if (number == 0) {
            return 1;
        } else if (number < 0) {
            throw new Exception(number + " number cannot be lesser than zero");
        } else {
            return number * fact(number - 1);
        }
    }
}

class Fibonacci {

    int fib(int number) throws Exception {
        if (number < 0) {
            throw new Exception(number + " number cannot be lesser than zero");
        } else if (number == 0 || number == 1) {
            return 1;
        } else {
            return fib(number - 1) + fib(number - 2);
        }
    }
}

class FibonacciMemoization {

    int fib(int number) throws Exception {
        int[] arrayOfCalculatedFib = new int[number + 1];
        return fib(number, arrayOfCalculatedFib);
    }

    int fib(int number, int[] arrayOfCalculatedFib) throws Exception {
        if (number < 0) {
            throw new Exception(number + " number cannot be lesser than zero");
        } else if (number == 0 || number == 1) {
            return 1;
        } else if (arrayOfCalculatedFib[number] != 0) {
            return arrayOfCalculatedFib[number];
        } else {
            arrayOfCalculatedFib[number] =
                    fib(number - 1, arrayOfCalculatedFib)
                            + fib(number - 2, arrayOfCalculatedFib);
            return arrayOfCalculatedFib[number];
        }
    }
}
