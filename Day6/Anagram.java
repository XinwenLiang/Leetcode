package Day6;

import java.util.Arrays;

public class Anagram {
        public boolean isAnagram(String s, String t) {
            if(s.length() != t.length()){
                return false;
            }
            // Transform the Strings to char array.
            char[] sArray = s.toCharArray();
            char[] tArray = t.toCharArray();
            Arrays.sort(sArray);
            Arrays.sort(tArray);

           return Arrays.equals(sArray, tArray);
        }
}
