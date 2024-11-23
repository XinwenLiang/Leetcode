package Day8;

import java.util.Scanner;

public class ReplaceNumber {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        String s = myScanner.next();
        int len = s.length();
        // Get the size of new array.
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                len += 5; // If the element is a number, it will increase the space by 5.
            }
        }


        char[] result = new char[len];
        // Copy the original string s.
        for (int i = 0; i < s.length(); i++) {
            result[i] = s.charAt(i);
        }
        // Iterate the new char array from the end to the beginning.
        for (int i = s.length() - 1, j = len - 1; i >= 0; i--) {
            if (result[i] >= '0' && result[i] <= '9') {
                result[j--] = 'r';
                result[j--] = 'e';
                result[j--] = 'b';
                result[j--] = 'm';
                result[j--] = 'u';
                result[j--] = 'n';
            } else {
                result[j--] = result[i];
            }
        }
        System.out.println(result);
    }
}
