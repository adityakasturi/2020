import java.util.*;

public class ZombieInMatrix {

    public static void main(String[] args) {
        List<List<Integer>> grid = new ArrayList<>();
    }

    int minHours(int rows, int columns, List<List<Integer>> grid)
    {

        Queue<int[]> zombies = new LinkedList<>();
        int humanCount = 0;
        for (int i=0; i < rows ; i++) {
            for (int j=0; j < columns; j++) {
                //Adding zombies
                if (grid.get(i).get(j) == 1)
                    zombies.offer(new int[]{i,j});
                else
                    humanCount++;
            }
        }

        // Directions in which the zombies are capable of turning humans
        // Basically one up, down, left and right from current zombie location.
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

        int hours = 0;
        // Iterating until we have all humans are turned to zombies;
        while(!zombies.isEmpty() && humanCount > 0) {
            int currentZombieSize = zombies.size();
            for (int zombieIterator = 0; zombieIterator < currentZombieSize; zombieIterator++) {
                int[] currentZombie = zombies.poll();
                for(int[] currentDirection:directions){
                    int attackX = currentZombie[0] + currentDirection[0];
                    int attackY = currentZombie[1] + currentDirection[1];
                    //
                    if (attackX >=0 && attackX < rows && attackY >=0 && attackY < columns && grid.get(attackX).get(attackY) == 0) {
                        humanCount--;
                        zombies.offer(new int[]{attackX, attackY});
                        grid.get(attackX).set(attackY, 1);
                    }
                }
            }
            hours++;
        }

        return hours;
    }

    //
    int minHoursTwo(int rows, int columns, List<List<Integer>> grid)
    {
        Set<String> zombies=new HashSet<>();
        Set<String> humans=new HashSet<>();

        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<columns;j++)
            {
                if(grid.get(i).get(j)==1) zombies.add(""+i+j);
                else if(grid.get(i).get(j)==0) humans.add(""+i+j);
            }
        }

        int hours=0;
        int[][] dirs= {{0,1},{1,0},{0,-1},{-1,0}};
        while(humans.size()>0)
        {
            Set<String> infected=new HashSet<>();
            for(String s : zombies)
            {
                int i=s.charAt(0)-'0';
                int j=s.charAt(1)-'0';
                for(int[] dir: dirs)
                {
                    int newi=i+dir[0];
                    int newj=j+dir[1];
                    if(humans.contains(""+newi+newj))
                    {
                        humans.remove(""+newi+newj);
                        infected.add(""+newi+newj);
                    }
                }
            }

            if(infected.size()==0) return -1;
            zombies=infected;
            hours++;
        }
        return hours;
    }

}
