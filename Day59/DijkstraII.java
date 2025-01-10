package Day59;

import java.util.*;

public class DijkstraII {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int n = myScanner.nextInt();
        int m = myScanner.nextInt();

        List<List<Edge>> grid = new ArrayList<>(n+1);
        for (int i = 0; i <= n; i++) {
            grid.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int p1 = myScanner.nextInt();
            int p2 = myScanner.nextInt();
            int val = myScanner.nextInt();
            grid.get(p1).add(new Edge(p2, val));
        }

        int start = 1;
        int end = n;

        int[] minDist = new int[n+1];
        Arrays.fill(minDist, Integer.MAX_VALUE);

        boolean[] visited = new boolean[n+1];

        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(new MyComparison());

        pq.add(new Pair<>(start,0));
        minDist[start] = 0;
        while(!pq.isEmpty()){
            Pair<Integer,Integer> cur = pq.poll();
            if(visited[cur.first]) continue;

            visited[cur.first] = true;

            for(Edge edge : grid.get(cur.first));
        }
    }

}
class Edge{
    int to;
    int val;

    Edge(int to, int val){
        this.to = to;
        this.val = val;
    }
}
class MyComparison implements Comparator<Pair<Integer,Integer>>{
    @Override
    public int compare(Pair<Integer,Integer> lhs, Pair<Integer,Integer> rhs){
        return Integer.compare(lhs.second, rhs.second);
    }
}
class Pair<U,V>{
    public final U first;
    public final V second;

    public Pair(U first, V second) {
        this.first = first;
        this.second = second;
    }
}