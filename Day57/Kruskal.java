package Day57;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Edge {
    int l, r, val;

    public Edge(int l, int r, int val) {
        this.l = l;
        this.r = r;
        this.val = val;
    }
}

public class Kruskal {
    private static int n = 10001;
    private static int[] father = new int[n];

    public static void init(){
        for (int i = 0; i < n; i++) {
            father[i] = i;
        }
    }
    public static int find(int u){
        if(u == father[u]) return u;
        return father[u]= find(father[u]);
    }
    public static void join(int u, int v){
        u = find(u);
        v = find(v);
        if(u == v) return;
        father[v] = u;
    }

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int v = myScanner.nextInt();
        int e = myScanner.nextInt();
        List<Edge> edges = new ArrayList<>();
        int result_val = 0;

        for (int i = 0; i < e; i++) {
            int v1 = myScanner.nextInt();
            int v2 = myScanner.nextInt();
            int val = myScanner.nextInt();
            edges.add(new Edge(v1,v2,val));
        }
        edges.sort(Comparator.comparingInt(edge-> edge.val));

        init();
        for(Edge edge : edges){
            int x = find(edge.l);
            int y = find(edge.r);
            if(x != y){
                result_val += edge.val;
                join(x,y);
            }
        }
        System.out.println(result_val);
        myScanner.close();
    }
}
