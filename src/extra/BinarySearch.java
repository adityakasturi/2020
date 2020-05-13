public class BinarySearch {

    public static void main(String args[]) {
        int[] array = {1,2,3,5,7,8,19,20,22,24,25,26,28,29,42};

        int index = findUsingBinarySearch(array,42);

        System.out.println(index);

    }

    // Returns the index of binary search.
    public static int findUsingBinarySearch(int[] array, int target){

        int left = 0;
        int right = array.length-1;

        while (left <= right ) {
            int mid = left + (right - left)/2;
            System.out.println(array[mid]);
            if (array[mid] == target) {
                found = true;
                return mid;
            }
            if (array[mid] < target) {
                left = mid + 1;
            }
            if (array[mid] > target) {
                right = mid - 1;
            }
        }

        return -1;
    }

}
