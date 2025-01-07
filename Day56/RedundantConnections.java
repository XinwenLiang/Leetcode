package Day56;

import java.util.Scanner;

public class RedundantConnections {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int n = myScanner.nextInt(); // The number of nodes.
        disjoint.initialize(n);
        for (int i = 0; i < n; i++) {
            int s = myScanner.nextInt();
            int t = myScanner.nextInt();
            if (disjoint.isSame(s, t)) {
                System.out.println(s + " " + t);
            } else {
                disjoint.join(s, t);
            }
        }
        myScanner.close();
    }
}

class disjoint {
    static int[] father;

    // Initialize the father array.
    public static void initialize(int N) {
        father = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            father[i] = i;
        }
    }

    public static int find(int n) {
        return n == father[n] ? n : (father[n] = find(father[n]));
    }

    public static void join(int n, int m) {
        n = find(n);
        m = find(m);
        if (n == m) return;
        father[m] = n;
    }

    public static boolean isSame(int n, int m) {
        n = find(n);
        m = find(m);
        return n == m;
    }
}
