package collections;

import java.math.BigInteger;
import java.util.stream.IntStream;

public class FactorialPuzzle {

    public static void main(String[] args) {
        System.out.println(factorial(10000));
    }

    public static BigInteger factorial(int n) {
        return IntStream.rangeClosed(1, n).mapToObj(BigInteger::valueOf).parallel().reduce(BigInteger.ONE, BigInteger::multiply);
    }
}
