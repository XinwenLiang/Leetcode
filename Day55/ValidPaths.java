package Day55;

import java.util.Scanner;

public class ValidPaths {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int N = myScanner.nextInt();
        int M = myScanner.nextInt();
        Disjoint disjoint = new Disjoint(N+1);
        for (int i = 0; i < M; i++) {
            disjoint.join(myScanner.nextInt(),myScanner.nextInt());
        }
        if(disjoint.isSame(myScanner.nextInt(), myScanner.nextInt())){
            System.out.println("1");
        }else{
            System.out.println("0");
        }
    }

}

class Disjoint {
    private int[] father;

    // Initialize the father array.
    public Disjoint(int N) {
        father = new int[N];
        for (int i = 0; i < N; i++) {
            father[i] = i;
        }
    }

    public int find(int n) {
        return n == father[n] ? n : (father[n] = find(father[n]));
    }

    public void join(int n, int m) {
        n = find(n);
        m = find(m);
        if (n == m) return;
        father[m] = n;
    }

    public boolean isSame(int n, int m) {
        n = find(n);
        m = find(m);
        return n == m;
    }
}
