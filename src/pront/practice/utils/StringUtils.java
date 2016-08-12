package pront.practice.utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by prontidis on 29/06/14.
 */
public class StringUtils {
    public String s;
    private boolean b;

    public StringUtils() {

    }

    public static void main(String[] args) {
//        String str = "aaa";
//        System.out.println(str + " isPalindrome: " + isPalindrome("aaa"));
//
//        str = "abc";
//        System.out.println(str + "isPalindrome: " + isPalindrome("abc"));
//
//        str = "aaaabcaaadefgaaa";
//        System.out.println(removeChar(str, 'a'));
//
//        pront.practice.utils.EnumSingleton.INSTANCE.setDescription(str);
//        System.out.println(pront.practice.utils.EnumSingleton.INSTANCE.toString());
//
//        System.out.println(Integer.parseInt("-1010", 2));
//        System.out.println(Integer.parseInt("-A",16));
//        System.out.println(Integer.decode("0xA"));
//
//        str = "abcd";
//        System.out.println(containsUniqueChars(str));

        //System.out.println(printBinary(6));
        // System.out.println(longestSeqChar("aaaaavvdwwww"));

//        System.out.println(firstNonDuplicate("aaavvveeddccaab"));
//        System.out.println(longestRun("avvvvveddcaa"));
//        int[] data = {5,9,6,2,4,8,3,1};
//
//        int diff = 0;
//
//        int min = data[0];
//
//        for (int i=0; i < data.length; i++){
//            //get min
//            if (data[i] < min){
//                min = data[i];
//            }
//
//            int tempDiff = data[i] - min;
//
//            if (tempDiff > diff){
//                diff = tempDiff;
//            }
//
//        }
//
//        System.out.println(diff);

//        System.out.println(longestRun("awaweddwwwqafwq"));
        //methodA();

//        pront.practice.utils.StringUtils su1 = new pront.practice.utils.StringUtils();
//        su1.s = new String("aaa");
//        su1.methodA();
//        System.out.print(su1.b);
//        pront.practice.utils.StringUtils.isPalindrome("aaa");
//
//        pront.practice.utils.StringUtils su2 = new pront.practice.utils.StringUtils();
//        su2.b = true;
//        su2.s = new String("aaa");
//
//        replaceAndCount("aaaaaa", 'a', 'b');

        //printAllPerms("abc");
        System.out.println(isPermutationCount("abc", "c2a"));
    }

    /** my javadoc blah blah */
    public void methodA() {
        this.b = true;
    }

    public static boolean isPalindrome(String str) {
        if (str.equals(reverseString(str)))
            return true;
        return false;
    }

    public static String reverseString(String str) {
        StringBuilder stringBuilder = new StringBuilder(str.length());
        char[] charArr = str.toCharArray();

        for (int i = charArr.length - 1; i >= 0; i--) {
            stringBuilder.append(charArr[i]);
        }

        return stringBuilder.toString();
    }

    public static String removeChar(String str, char x) {
        StringBuilder stringBuilder = new StringBuilder(str.length());
        for (char c : str.toCharArray()) {
            if (c == x) {
                continue;
            }
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    public static boolean containsUniqueChars(String str) {
        Map<Character, Boolean> map = new HashMap<Character, Boolean>(str.length());
        for (char c : str.toCharArray()) {
            if (map.put(c, true) != null)
                return false;
        }
        return true;
    }

    /* Assumption: ASCII, 256 unique chars */
    public static boolean containsUniqueCharsEfficient(String str) {
        boolean[] charSet = new boolean[256];
        for (int c : str.toCharArray()) {
            if (charSet[c]) return false;
            charSet[c] = true;
        }
        return true;
    }

    public static boolean isPermutationSort(String str1, String str2) {
        //optimization
        if (str1.length() != str2.length()) {
            return false;
        }

        String sorted1 = sort(str1);
        String sorted2 = sort(str2);
        return sorted1.equals(sorted2);
    }

    public static boolean isPermutationCount(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        // works only for ASCII encoding
        int counts[] = new int[128];
        for (int i = 0; i < s1.length(); i++) {
            counts[s1.charAt(i)]++;
        }

        for (int i = 0; i < s2.length(); i++) {
            if(--counts[s2.charAt(i)] < 0) {
                return false;
            }
        }

        return true;
    }

    public static String sort(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return chars.toString();
    }

    public static String printBinary(int n) {
        if (n < 0) return "ERROR";

        System.out.println(1 << 15);
        System.out.println(Integer.MAX_VALUE);
        StringBuilder binary = new StringBuilder();
        for (int i = 1; i <= n; i = i * 2) {
            System.out.println(n & i);
            if ((n & i) > 0) binary.append(1);
            else binary.append(0);
        }
        return reverseString(binary.toString());
    }

    public static char longestSeqChar(String str) {
        int counts[] = new int[256];
        for (int i = 0; i < str.length(); i++) {
            counts[str.charAt(i)]++;
        }

        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < str.length(); i++) {
            if (max < counts[str.charAt(i)]) {
                max = counts[str.charAt(i)];
                maxIndex = i;
            }
        }

        return str.charAt(maxIndex);
    }

    public static Character firstNonDuplicate(String str) {
        char curChar = str.charAt(0);
        int count = 0;
        for (int i = 1; i < str.length(); i++) {
            if (curChar == str.charAt(i)) {
                count++;
                System.out.println(curChar + " " + str.charAt(i) + " | count = " + count);
            } else if (count == 0) {
                return curChar;
            } else {
                count = 0;
                curChar = str.charAt(i);
            }
        }

        if (count == 0)
            return str.charAt(str.length() - 1);
        else
            return null;
    }

    public static Character longestRun(String str) {
        if (str == null || str.length() == 0) return null;

        char chars[] = str.toCharArray();
        Arrays.sort(chars);
        String sortedStr = new String(chars);
        System.out.println(sortedStr);

        int maxCount = 0;
        Character maxChar = str.charAt(0);

        char curChar = str.charAt(0);
        int count = 0;

        for (int i = 1; i < sortedStr.length(); i++) {
            if (curChar == sortedStr.charAt(i)) {
                count++;
            } else {
                curChar = sortedStr.charAt(i);
                count = 0;
            }

            if (count > maxCount) {
                maxCount = count;
                maxChar = curChar;
            }
        }

        return maxChar;
    }

    public static int replaceAndCount(String input, char oldChar, char newChar) {
        int count = 0;
        char[] arr = input.toCharArray();
        for(int i = 0; i < arr.length; ++i) {
            if(arr[i] == oldChar) {
                arr[i] = newChar;
                count++;
            }
        }
        System.out.println(new String(arr));
        return count;
    }

    public static void printAllPerms(String str) {
        permutation(str, "");
    }

    public static void permutation(String str, String prefix) {
        if(str.length() == 0) {
            System.out.println(prefix);
        }
        else {
            for (int i = 0; i < str.length(); i++) {
                String rem = str.substring(0, i) + str.substring(i + 1);
                permutation(rem, prefix + str.charAt(i));
            }
        }
    }
}
