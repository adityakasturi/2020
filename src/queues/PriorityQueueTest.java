import java.util.PriorityQueue;
import java.util.Comparator;


public class PriorityQueueTest {

    public static void main(String args[]) {
        // WIP
        PriorityQueue<String> names = new PriorityQueue<String>();
        names.add("Su");
        names.add("Rong");
        names.add("Aditya");
        names.add("Kasturi");
        while(!names.isEmpty()) {
            System.out.println(names.remove());
        }
    }

//    public static void priorityQueueWithComparator(){
//        Comparator<Integer> comp = new Comparator<Integer>(){
//            // General comparator rules.
//            @Override
//            public int compare(Integer i1, Integer i2){
//                return i1 - i2;
//            }
//        }
//    }

}
