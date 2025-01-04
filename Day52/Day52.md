# 代码随想录算法训练营第五十二天

## [101. Total Area of Isolated Islands](https://kamacoder.com/problempage.php?pid=1173)
Given a matrix consisting of 1s (land) and 0s (water). An island is defined as a region made up of adjacent land cells (either horizontally or vertically connected), completely surrounded by water cells.
An isolated island refers to an island located entirely inside the matrix, where none of its cells touch the edges of the matrix.

Your task is to calculate the **total area of all isolated islands**, where the area of an island is defined as the total number of land cells that make up the island.

**Input Description**
* The first line contains two integers, N and M, representing the number of rows and columns in the matrix, respectively.
* The next N lines each contain M integers (either 1 or 0), representing the matrix.
**Output Description** <br>
Output a single integer representing the total area of all isolated islands. If no isolated islands exist, output 0.

**Example1:** <br>
**Input** <br>
4 5 <br>
1 1 0 0 0 <br>
1 0 0 0 0 <br>
0 0 0 0 0 <br>
0 0 0 1 1

**Output:**  1

**Ideas:** <br>
We only need to find the land on the perimeter and use DFS or BFS to turn the surrounding and adjacent land into water. Then, we can traverse the map again to count the remaining land, which will give us the desired 
result.

```Java
import java.util.Scanner;

public class TotalArea {
    static int[][] dir ={{0,1},{0,-1},{1,0},{-1,0}};
    static int count =0;
    public static void dfs(int[][] grid, int x,int y){
        grid[x][y] = 0;
        count++;
        for (int i = 0; i < 4; i++) {
            int nextX = x + dir[i][0];
            int nextY = y + dir[i][1];
            if(nextX >= grid.length || nextX <0 || nextY >= grid[0].length || nextY < 0) continue;
            if(grid[nextX][nextY] == 0) continue;
            dfs(grid, nextX, nextY);
        }
    }

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int n = myScanner.nextInt();
        int m = myScanner.nextInt();

        int[][] grid = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
               grid[i][j] = myScanner.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            if(grid[i][0] == 1) dfs(grid, i,0);
            if(grid[i][m-1] == 1) dfs(grid, i, m-1);
        }
        for (int j = 0; j < m; j++) {
            if(grid[0][j] == 1) dfs(grid,0,j);
            if(grid[n-1][j] == 1) dfs(grid, n-1,j);
        }
        count = 0;
        for (int i = 1; i < n-1; i++) {
            for (int j = 1; j < m-1; j++) {
                if(grid[i][j] == 1) {
                    count = 0;
                    dfs(grid,i,j);
                    System.out.println(count);
                }
            }
        }
    }
}
```

## [102. Sinking Islands](https://kamacoder.com/problempage.php?pid=1174)

Given a matrix composed of `1s` (land) and `0s` (water). An island is defined as a region of land cells connected horizontally or vertically and fully surrounded by water cells. Islands are regions located entirely 
inside the matrix, such that none of their cells touch the matrix boundary.

Your task is to "sink" all isolated islands, i.e., convert all land cells (1s) in isolated islands to water cells (0s).

**Input Description**
* The first line contains two integers N and M, representing the number of rows and columns in the matrix, respectively.
* The next N lines contain M numbers (either 1 or 0), representing the matrix cells.

**Output Description** <br>
Output the matrix after "sinking" all isolated islands.

**Note:** Ensure that each number in the output is followed by a space.

**Example1:**

**Input** <br>
4 5 <br>
1 1 0 0 0 <br>
1 0 0 0 0 <br>
0 0 0 0 0 <br>
0 0 0 1 1

**Output** <br>
1 1 0 0 0 <br>
1 0 0 0 0 <br>
0 0 0 0 0 <br>
0 0 0 1 1 

**Explanation** 
* The isolated island in the middle of the matrix (completely surrounded by 0s) has been "sunk" by converting its 1 to 0.
* Land cells at the boundary are not considered isolated islands, so they remain unchanged.

**Idea:** <br>
We don't need to create a visited array, we can modify the grid.
**Step 1:** <br>
Use DFS (Depth-First Search) or BFS (Breadth-First Search) to traverse the matrix. Find all cells with 1 (land) and expand from there, marking all connected 1s as 2, indicating that they have been processed.

**Step 2:** <br>
Change all cells marked as 2 to 0, effectively sinking these isolated islands.

**Step 3:** <br>
If there are any 2s that need to remain as land, revert them back to 1.

```Java
import java.util.Scanner;

public class SinkingIslands {
    static int[][] dir ={{0,1},{0,-1},{1,0},{-1,0}};

    public static void dfs(int[][] grid, int x, int y){
        grid[x][y] = 2;
        for(int []d : dir){
            int nextX = x + d[0];
            int nextY = y + d[1];
            if(nextX < 0 || nextX >= grid.length || nextY < 0 || nextY >= grid[0].length) continue;
            if(grid[nextX][nextY] == 2 || grid[nextX][nextY] == 0) continue;
            dfs(grid, nextX, nextY);
        }
    }

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int n = myScanner.nextInt();
        int m = myScanner.nextInt();
        int[][] grid = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = myScanner.nextInt();
            }
        }
        // Step1: Find all cells with 1 (land) and expand from there, marking as 2.
        for (int i = 0; i < n; i++) {
            if(grid[i][0] == 1) dfs(grid, i, 0);
            if(grid[i][m-1]==1) dfs(grid, i, m-1);
        }
        for (int j = 0; j < m; j++) {
            if(grid[0][j] == 1) dfs(grid, 0,j);
            if(grid[n-1][j]==1) dfs(grid, n-1, j);
        }

        // Step2: Change all cells marked as 2 to 0, effectively sinking these isolated islands.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(grid[i][j] == 1) grid[i][j]=0;
                if(grid[i][j] == 2) grid[i][j] = 1;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        myScanner.close();
    }
}



































