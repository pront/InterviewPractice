package pront.practice.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prontidis on 29/06/14.
 */
public class FizzBuff {

    public static void main(String[] args) {
        fizzBuzz(20);

        List<Integer> list = new ArrayList<Integer>();
        for(int i=0; i<10; i++) {
            list.add(i+1);
        }

        List<Integer> reversedList = reverseList(list);

        System.out.println("Reversed list:");
        for(Integer i : reversedList)
            System.out.print(i + " ");
        System.out.println();
    }

    public static void fizzBuzz(int n) {
        for (int i = 1; i <= 100; i++) {
            if (i % 15 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }

    public static List reverseList(List list) {
        List reverseList = new ArrayList(list.size());

        for(int i=list.size()-1; i >= 0; i--) {
            reverseList.add(list.get(i));
        }

        return reverseList;
    }


}
