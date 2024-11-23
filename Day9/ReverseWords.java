package Day9;

public class ReverseWords {
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        // Remove extra spaces.
        chars = RemoveSpaces(chars);
        // Reverse the whole string.
        reverse(chars, 0, chars.length - 1);
        // Reverse each word.
        reverseEachWord(chars);
        return new String(chars);
    }

    public char[] RemoveSpaces(char[] chars) {
        int slow = 0;
        for (int fast = 0; fast < chars.length; fast++) {
            // Use fast to remove all the spaces.
            if (chars[fast] != ' ') {
                // Use slow to add spaces in the end of each word.
                if (slow != 0)
                    chars[slow++] = ' ';
                while (fast < chars.length && chars[fast] != ' ')
                    chars[slow++] = chars[fast++];
            }
        }
        char[] newChars = new char[slow];
        System.arraycopy(chars, 0, newChars, 0, slow);
        return newChars;
    }

    public void reverse(char[] chars, int left, int right) {
        if (right >= chars.length) {
            System.out.println("Set a wrong right.");
            return;
        }
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }

    public void reverseEachWord(char[] chars){
        int start = 0;
        for(int end = 0; end <= chars.length; end++){
            if(end == chars.length || chars[end] == ' '){
                reverse(chars,start, end-1);
                start = end + 1;
            }
        }
    }
}
