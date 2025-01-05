package Day53;

import java.util.*;

public class WordLadder {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int n = myScanner.nextInt();
        myScanner.nextLine();
        String beginStr = myScanner.next();
        String endStr = myScanner.next();
        myScanner.nextLine();
        List<String> wordList = new ArrayList<>();
        wordList.add(beginStr);
        wordList.add(endStr);
        for (int i = 0; i < n; i++) {
            wordList.add(myScanner.nextLine());
        }
        int count = bfs(beginStr, endStr, wordList);
        System.out.println(count);
    }

    public static int bfs(String beginStr, String endStr, List<String> wordList) {
        int len = 1; // Keep track of the current length of the transformation sequence.
        Set<String> set = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        visited.add(beginStr);
        queue.add(beginStr);
        queue.add(null);
        while (!queue.isEmpty()) {
            String node = queue.remove();
            if (node == null) {
                if (!queue.isEmpty()) {
                    len++;
                    queue.add(null);
                }
                continue;
            }
            char[] charArray = node.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                char old = charArray[i];
                for (char j = 'a'; j <= 'z'; j++) {
                    charArray[i] = j;
                    String newWord = new String(charArray);
                    if (set.contains(newWord) && !visited.contains(newWord)) {
                        queue.add(newWord);
                        visited.add(newWord);
                        // Found the end.
                        if (newWord.equals(endStr)) return len + 1;
                    }
                }
                charArray[i] = old;
            }
        }
        return 0;
    }
}
