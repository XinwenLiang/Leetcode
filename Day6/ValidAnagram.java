package Day6;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;// Count the frequency of letters in String s.
        }

        for (int i = 0; i < t.length(); i++) {
            count[t.charAt(i) - 'a']--;
        }
        // If elements in count are all 0s, then s and t are anagrams.
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
