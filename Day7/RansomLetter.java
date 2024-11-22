package Day7;

public class RansomLetter {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length() > magazine.length()){
            return false;
        }
        int[] arr1 = new int[26];
        // Iterate the magazine to store the number of every element in it.
        for (int i = 0; i < magazine.length(); i++) {
            arr1[magazine.charAt(i) - 'a'] ++;
        }
        // Iterate the ransomNote to look up if the element exists in the magazine.
        for(int j =0; j < ransomNote.length(); j++){
            arr1[ransomNote.charAt(j)-'a']--;
        }
        // If there exists negative number in arr1, that means there is element in ransomNote cannot find in magazine.
        for(int i : arr1){
            if(i < 0){
                return false;
            }
        }
        return true;
    }
}
