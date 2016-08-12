package pront.practice.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prontidis on 29/06/14.
 */
public class PrimeUtils {

    public static void main(String[] args) {
        int n = 12000;
        long start = System.nanoTime();
        printPrimes(n);
        long duration = System.nanoTime() - start;
        System.out.println("Simple implementation duration: " + duration/1000 + " ms");
        System.out.println();

        start = System.nanoTime();
        printPrimesEfficient(n);
        duration = System.nanoTime() - start;
        System.out.println("Alternative implementation duration: " + duration/1000 + " ms");
    }


    public static void printPrimes(int n) {
        for (int i = 2; i < n; i++) {
            boolean isPrime = true;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime)
                System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void printPrimesEfficient(int n) {
        List<Integer> primes = new ArrayList(n);
        primes.add(2);

        for(int currentNum = 3; currentNum < n; currentNum++ ) {
            boolean isPrime = true;
            for(int j=0; j*j < primes.size() && primes.get(j) * primes.get(j) <= currentNum; j++) {
                if(currentNum % primes.get(j) == 0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime)
                primes.add(currentNum);
        }

        for(int prime : primes) {
            System.out.print(prime + " ");
        }
        System.out.println();
    }

    public static List reverseList(List list) {
        List reverseList = new ArrayList(list.size());

        for(int i=list.size()-1; i >= 0; i--) {
            reverseList.add(list.get(i));
        }

        return reverseList;
    }


}
