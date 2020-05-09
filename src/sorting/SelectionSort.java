public class SelectionSort{

    public static void main(String args[]) {

        int[] array = {7,3,4,0,-1,2,1,5,6,-11};
        SelectionSort object = new SelectionSort();
        array = object.sort(array);

        for (int i = 0 ; i < array.length; i++ ) {
            System.out.println(array[i]);
        }

    }

    public int[] sort(int[] array){

        for (int i = 0;  i < array.length-1; i++) {
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[i]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }

        return array;
    }

}
