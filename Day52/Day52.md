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

## [103. Water Flow Problem](https://kamacoder.com/problempage.php?pid=1175)

Given an **N×M** matrix where each cell contains an integer representing the **relative height** at that position. The **left and top edges** of the matrix are considered as the first boundary group, while the right and bottom edges are considered as the second boundary group.

The matrix simulates a terrain where, when rain falls on the surface, water flows based on the slope of the terrain. Water can only flow from a higher or equal height to a lower or equal height, and it can only flow to adjacent cells (in up, down, left, or right directions).

Your task is to determine all the cells from which water can flow to both the first boundary group and the second boundary group.

**Input Description**
* The first line contains two integers N and M, representing the number of rows and columns in the matrix.
* The next N lines each contain M integers, representing the height of each cell in the matrix.

**Output Description**
* The output consists of multiple lines. Each line contains two integers separated by a space, representing the coordinates of a cell (row and column indices) from which water can flow to both boundary groups.
* The order of the output lines does not matter.

**Example1:**

**Input:** <br>
5 5 <br>
1 3 1 2 4 <br>
1 2 1 3 2 <br>
2 4 7 2 1 <br>
4 5 6 1 1 <br>
1 4 1 2 1 <br>

**Output:** <br>
0 4<br>
1 3<br>
2 2<br>
3 0<br>
3 1<br>
3 2<br>
4 0<br>
4 1

**Explanation** <br>
In the example:

The cells listed in the output can reach both the left/top edges (first boundary group) and the right/bottom edges (second boundary group) by following the flow rules.
For example, cell (0, 4) (height = 4) can reach both the top edge and the right edge. Similarly, cell (2, 2) (height = 7) can also reach both boundary groups.

![image](https://github.com/user-attachments/assets/14512e67-58f4-457b-a68e-6580bbced583)

**Ideas:**
One way to optimise this problem is to go upstream from the nodes on the first set of boundaries and mark all the nodes that have been traversed. Similarly, from the nodes on the edges of the second set of
boundaries, go upstream and mark the nodes that have been traversed. The intersection of these nodes is then the answer to the problem.

```Java
public class WaterFlow {
    public static void dfs(int[][] heights, int x, int y, boolean[][] visited, int preH){
        if(x < 0 || x >= heights.length || y< 0 || y >= heights.length || visited[x][y]) return;
        if(heights[x][y] < preH) return;
        visited[x][y] = true;

        dfs(heights, x+1,y,visited, heights[x][y]);
        dfs(heights, x-1, y, visited, heights[x][y]);
        dfs(heights,x,y+1, visited, heights[x][y]);
        dfs(heights,x,y-1,visited,heights[x][y]);
    }

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int m = myScanner.nextInt();
        int n = myScanner.nextInt();

        int [][] heights = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                heights[i][j] = myScanner.nextInt();
            }
        }
        // The border.
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            dfs(heights,i,0,pacific,Integer.MIN_VALUE);
            dfs(heights,i,n-1,atlantic,Integer.MIN_VALUE);
        }
        for (int j = 0; j < n; j++) {
            dfs(heights, 0,j,pacific,Integer.MIN_VALUE);
            dfs(heights,m-1,j,atlantic,Integer.MIN_VALUE);
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Get the intersection.
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        for (List<Integer> list : res) {
            for (int k = 0; k < list.size(); k++) {
                if (k == 0) {
                    System.out.print(list.get(k) + " ");
                } else {
                    System.out.print(list.get(k));
                }
            }
            System.out.println();
        }
    }
}
```

## [104.Construction of the largest island](https://kamacoder.com/problempage.php?pid=1176)

Given a matrix consisting of `1s` (land) and `0s` (water). You are allowed to change at most one water cell into a land cell. After performing this operation, determine the maximum island area in the matrix.

* The island area is defined as the total number of land cells in an island.
* An island is a region of connected land cells that are surrounded by water. Land cells are connected if they are adjacent horizontally or vertically.
* You may assume that the matrix is surrounded by water outside its boundaries.
**Input Description** <br>
* The first line contains two integers N and M, representing the number of rows and columns in the matrix.
* The next N lines each contain M integers, where each integer is either 1 or 0, representing land or water cells, respectively.
**Output Description** <br>
Output a single integer, representing the maximum possible island area after changing at most one water cell into a land cell.

**Example1:**

**Input:**
4 5 <br>
1 1 0 0 0 <br>
1 1 0 0 0 <br>
0 0 1 0 0 <br>
0 0 0 1 1 <br>
**Output:** 6 

![image](https://github.com/user-attachments/assets/60f26143-6db9-4903-ac90-6afad8d81455)
![image](https://github.com/user-attachments/assets/8b518218-0e96-4341-a808-f6c98ea8afa7)

**Ideas:**
**Step 1:** Traverse the grid once to calculate the area of each island and assign a unique ID to each island for identification.

**Step 2:** Traverse the grid again, focusing on cells with a value of 0 (since we want to change a 0 to 1). For each 0, calculate the total area by adding the areas of its neighboring islands. After traversing all 0 
cells, the maximum area obtained by changing one 0 to 1 is the desired result.

```Java
public class BuildLargestIsland {
    static int count;
    static int mark;
    static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};

    public static void dfs(int[][] grid, int x, int y, boolean[][] visited){
        if(x < 0 || x >= grid.length || y < 0 || y <= grid[0].length) return;
        if(visited[x][y] || grid[x][y]== 0 ) return;

        visited[x][y] = true;
        count++;
        grid[x][y] = mark;

        dfs(grid,x,y+1, visited);
        dfs(grid, x, y-1, visited);
        dfs(grid,x-1,y,visited);
        dfs(grid,x+1, y, visited);
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
        mark = 2;
        HashMap<Integer,Integer> getSize = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        boolean isAllIslands = true;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 0) isAllIslands = false;
                if(grid[i][j] == 1) {
                    count = 0;
                    dfs(grid,i,j,visited);
                    getSize.put(mark,count);
                    mark++;
                }
            }
        }
        int result = 0;
        if(isAllIslands) result = m*n;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[0][0] == 0) set.clear();
                int curSize = 0;

                for(int[] d: dir){
                    int curRow = i + d[0];
                    int curColumn = j + d[1];
                    if(curRow < 0 || curRow >= grid.length || curColumn < 0 || curColumn >= grid[0].length) continue;
                    int curMark = grid[curRow][curColumn];
                    if(set.contains(curMark) || !getSize.containsKey(curMark)) continue;
                    set.add(curMark);
                    curSize += getSize.get(curMark);
                }
                result = Math.max(result, curSize);
            }
        }
        System.out.println(result);
    }
}
```






























