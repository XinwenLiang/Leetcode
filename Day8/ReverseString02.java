package Day8;

import java.util.Arrays;

public class ReverseString02 {
    public String reverseStr(String s, int k) {
        char[] ch = s.toCharArray();
        for(int i = 0; i < ch.length; i += 2*k){
             int left = i;
             // Check if the tail has k elements to reverse.
             int right = Math.min(ch.length-1, left+k-1);
             while(left < right){
                 char temp = ch[left];
                 ch[left] = ch[right];
                 ch[right] = temp;
                 left++;
                 right--;
             }
        }
        return new String(ch);
    }
}
