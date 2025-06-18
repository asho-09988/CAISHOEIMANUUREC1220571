public class PrimeNumbers {
    public static void main(String[] args) {
        final int NUMBER_OF_PRIMES = 50;
        final int PRIMES_PER_LINE = 10;
        int count = 0;
        int number = 2;

        while (count < NUMBER_OF_PRIMES) {
            if (isPrime(number)) {
                count++;
                System.out.printf("%-5d", number);
                if (count % PRIMES_PER_LINE == 0) {
                    System.out.println(); // New line after 10 primes
                }
            }
            number++;
        }
    }
    public static boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int divisor = 2; divisor <= Math.sqrt(num); divisor++) {
            if (num % divisor == 0) {
                return false;
            }
        }
        return true;


    }
}