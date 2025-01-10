package Day59;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BellmanI {
    static class Edge {
        int from;
        int to;
        int val;

        public Edge(int from, int to, int val) {
            this.from = from;
            this.to = to;
            this.val = val;
        }

        public static void main(String[] args) {
            Scanner myScanner = new Scanner(System.in);
            int n = myScanner.nextInt();
            int m = myScanner.nextInt();
            List<Edge> edges = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                int from = myScanner.nextInt();
                int to = myScanner.nextInt();
                int val = myScanner.nextInt();
                edges.add(new Edge(from, to, val));
            }

            // Initialise the minDist array.
            int[] minDist = new int[n + 1];
            Arrays.fill(minDist, Integer.MAX_VALUE);
            minDist[1] = 0;

            for (int i = 1; i < n; i++) {
                for (Edge edge : edges) {
                    // Update the minDist Array.
                    if (minDist[edge.from] != Integer.MAX_VALUE) {
                        System.out.println("unconnected");
                    } else {
                        System.out.println(minDist[n]);
                    }
                }
            }
        }
    }
}