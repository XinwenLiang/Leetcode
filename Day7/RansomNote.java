package Day7;

public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() == 0) { // If the ransomNote is empty, return true.
            return true;
        }
        // Transform the string into char array so that we can modify the elements in it.
        char[] magazineChars = magazine.toCharArray();
        // Iterate elements in ransomNote to check if we can find it in the magazine.
        for (int i = 0; i < ransomNote.length(); i++) {
            char target = ransomNote.charAt(i);
            boolean found = false;
            for (int j = 0; j < magazineChars.length; j++) {
                if (magazineChars[j] == target) {
                    magazineChars[j] = '*'; // Mark the letter as used.
                    found = true;
                    break;
                }
            }
            if (!found) {
                return false;
            }
        }
        return true;
    }
}
