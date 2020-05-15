public class ArrayMultiplication {

    public static void main(String args[]) {
        int[][] one = {
            new int[]{1,2},
            new int[]{3,4}
        };
        int[][] two = {
            new int[]{2,3},
            new int[]{5,8}
        };
        int[][] result = multiply(one, two);
        printArray(result);
    }

    public static int[][] multiply(int[][] one, int[][] two){
        // Length is very important in solving this one...
        if (one.length != two[0].length) {
            return new int[][]{};
        } else {
            int[][] result = new int[one.length][two[0].length];

            for (int i=0; i < result.length; i++) {
                for (int j=0; j < result[i].length; j++) {
                    result[i][j] = multipleMatrix(one, two, i, j);
                }
            }

            return result;
        }
    }

    public static int multipleMatrix(int[][] one, int[][] two,int row,int col) {

        int result = 0;

        for (int i=0; i < two.length; i++){
            result += one[row][i] * two[i][col];
        }

        return result;
    }


    public static void printArray(int[][] array) {
        for (int i=0; i < array.length; i++) {
            for (int j=0; j < array[0].length; j++){
                System.out.print(array[i][j]+" ");
            }
            System.out.println();
        }
    }
}
