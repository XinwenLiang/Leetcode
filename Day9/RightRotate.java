package Day9;

import java.util.Scanner;

public class RightRotate {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int n = Integer.parseInt(myScanner.nextLine());
        String s = myScanner.nextLine();

        int len = s.length();
        char[] ch = s.toCharArray();
        reverseString(ch, 0, len - 1);
        reverseString(ch, 0, n - 1);
        reverseString(ch, n, len - 1);
        System.out.println(ch);
    }

    public static void reverseString(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }
}
