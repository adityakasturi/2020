package arrays.twoDimensional;

import java.util.Stack;

public class DFSTwoD {

    public static void main(String[] args) {
        int[][] zombieArray = {{0, 1, 1, 0, 1},{0, 1, 0, 1, 0},{0, 0, 0, 0, 1},{0, 1, 0, 0, 0}};
        printDFS(zombieArray);
    }

    // returns the index of the element present in the array.
    public static void printDFS(int[][] array) {
        int length = array.length;
        int height = array[0].length;
        if (height < 0) return;
        boolean[][] visited = new boolean[length][height];
        Stack<int[]> stack = new Stack<int[]>();
        int[] firstIndex = {0,0};
        stack.push(firstIndex);
        while(!stack.isEmpty()){
            int[] indexes=stack.pop();
            int x = indexes[0];
            int y = indexes[1];
            if (x < 0 || y < 0 || x > (array.length-1) || y > (array[0].length -1) || visited[x][y])
                continue;
//            else {
//               // Checking if the current one is zombie or not.
//               // If zombie -- fixing the current one, into --
//               if ((x-1) < 0);
//            }
            System.out.print(array[x][y] +" ");
            visited[x][y] = true;
            stack.push(new int[]{x-1,y});
            stack.push(new int[]{x+1,y});
            stack.push(new int[]{x,y-1});
            stack.push(new int[]{x,y+1});
        }
    }

}
