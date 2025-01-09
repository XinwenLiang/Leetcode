package Day58;

import java.util.*;

public class TopologicalSort {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int n = myScanner.nextInt();
        int m = myScanner.nextInt();

        List<List<Integer>> uMap = new ArrayList<>();
        int[] inDegree = new int[n];

        for (int i = 0; i < n; i++) {
            uMap.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int s = myScanner.nextInt();
            int t = myScanner.nextInt();
            uMap.get(s).add(t);
            inDegree[t]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        List<Integer> result = new ArrayList<>();

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            result.add(cur);
            for (int file : uMap.get(cur)) {
                inDegree[file]--;
                if (inDegree[file] == 0) {
                    queue.add(file);
                }
            }
        }
        if (result.size() == n) {
            for (int i = 0; i < result.size(); i++) {
                System.out.println(result.get(i));
                if (i < result.size() - 1) {
                    System.out.println(" ");
                }
            }
        } else {
            System.out.println(-1);
        }
    }
}
