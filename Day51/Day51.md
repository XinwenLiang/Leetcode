# 代码随想录算法训练营第五十一天
## [99. Number of Islands](https://kamacoder.com/problempage.php?pid=1171)

Given a grid consisting of `1`s (land) and `0`s (water), you need to calculate the number of islands. An island is formed by horizontally or vertically adjacent lands, and the grid is surrounded by water. You can assume 
that the entire grid is fully surrounded by water.

**Input Description:**
The first line contains two integers `N` and `M`, representing the number of rows and columns in the grid.
The next `N` lines each contain `M` integers, where each number is either `1` or `0`.

**Output Description:**
Output a single integer, representing the number of islands. If no islands exist, output 0.

**Example1:**

**Input:** <br>
4 5<br>
1 0 0 0 0<br>
1 1 0 0 0<br>
0 0 0 0 1<br>
0 0 0 1 1<br>
**Output:** 3

![image](https://github.com/user-attachments/assets/c8418194-4aae-4275-93a6-2ebc773118dc)

**Ideas:** When encountering an unvisited node, increment the counter by 1, then mark all the land nodes that can be traversed from this node. For nodes that are already marked as land or water, simply skip them. 
Finally, the counter will be the result we are looking for.

```Java
import java.util.Scanner;

public class NumOfIslands {
    public static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}}; // Represents four directions.

    public static void dfs(boolean[][] visited, int x, int y, int[][] grid) {
        for (int i = 0; i < 4; i++) {
            int nextX = x + dir[i][0];
            int nextY = y + dir[i][1];
            if (nextX < 0 || nextY < 0 || nextX >= grid.length || nextY >= grid[0].length) {
                continue;
            }
            if (!visited[nextX][nextY] && grid[nextX][nextY] == 1) {
                visited[nextX][nextY] = true;
                dfs(visited, nextX,nextY, grid);
            }
        }
    }

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int m = myScanner.nextInt();
        int n = myScanner.nextInt();
        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = myScanner.nextInt();
            }
        }
        boolean[][] visited = new boolean[m][n];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(!visited[i][j] && grid[i][j] == 1){ //If neither the land is marked or it's an ocean.
                    ans++;
                    visited[i][j] = true;
                    dfs(visited,i,j,grid);
                }
            }
        }
        System.out.println(ans);
    }
}
```

```
//bfs
public class NumOfIslands02 {
    public static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}}; // Represents four directions.
    public static void bfs(boolean[][] visited, int[][]grid, int X, int Y){
        Queue<pair> queue = new LinkedList<pair>();
        queue.add(new pair(X,Y));
        visited[X][Y] = true;
        while(!queue.isEmpty()){
            int curX = queue.peek().first;
            int curY = queue.poll().second;
            for (int i = 0; i < 4; i++) {
                int nextX = curX +dir[i][0];
                int nextY = curY + dir[i][1];
                if(nextX <0 || nextX >= grid.length || nextY < 0 || nextY >= grid[0].length){
                    continue;
                }
                if(!visited[nextX][nextY] && grid[nextX][nextY] == 1){
                    queue.add(new pair(nextX, nextY));
                    visited[nextX][nextY] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int m = myScanner.nextInt();
        int n = myScanner.nextInt();
        int[][] grid = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = myScanner.nextInt();
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(!visited[i][j] && grid[i][j] == 1){
                    ans++;
                    bfs(visited, grid, i,j);
                }
            }
        }
        System.out.println(ans);
    }
}
class pair{
    int first;
    int second;

    public pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
```

## [100. Maximum Area of an Island](https://kamacoder.com/problempage.php?pid=1172)

Given a matrix consisting of `1` (land) and `0` (water), calculate the maximum area of an island. The area of an island is calculated as the total number of connected 1s that make up the island. An island is formed 
by connecting adjacent 1s horizontally or vertically, and the edges of the matrix are surrounded by water. You can assume the outside of the matrix is also water.

**Input Description:** <br>
The first line contains two integers `N` and `M`, representing the number of rows and columns in the matrix. The next `N` lines each contain `M` integers, where each integer is either `1` or `0`, representing a unit 
cell of the island.

**Output Description:** <br>
Output an integer representing the maximum area of an island. If no islands exist, output `0`.

**Example1:**

**Input:** <br>
4 5<br>
1 0 0 0 0<br>
1 1 0 0 0<br>
0 0 0 0 1<br>
0 0 0 1 1<br>
**Output:** 4

![image](https://github.com/user-attachments/assets/c8418194-4aae-4275-93a6-2ebc773118dc)

**Ideas:** When encountering an unvisited node, increment the counter by 1, then mark all the land nodes that can be traversed from this node. For nodes that are already marked as land or water, simply skip them. 
Finally, the maxmum of the counter is what we are looking for.

```Java
import java.util.Scanner;

public class MaxAreaIslands {
    public static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    public static int result = 0;
    public static int count = 0;
    public static void dfs(int[][] grid, boolean[][] visited, int x, int y){
        count++;
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nextX = x + dir[i][0];
            int nextY = y + dir[i][1];
            if(nextX < 0 || nextY < 0 || nextX >= grid.length || nextY >= grid[0].length ||grid[nextX][nextY] == 0 || visited[nextX][nextY]){
                continue;
            }
            dfs(grid, visited, nextX, nextY);
        }
    }

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int m = myScanner.nextInt();
        int n = myScanner.nextInt();
        int[][] grid = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = myScanner.nextInt();
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(!visited[i][j] && grid[i][j] == 1){
                    count = 0;
                    dfs(grid,visited,i,j);
                    result = Math.max(count,result);
                }
            }
        }
        System.out.println(result);
    }
}
```




















