import java.util.*;

public class LinkedListTest {

    public static void main(String args[]) {

        LinkedList<Integer> ll = new LinkedList<Integer>();

        // Add operation cost.
        ll.add(1);
        ll.add(2);
        ll.add(5);
        ll.add(2);
        // https://stackoverflow.com/questions/45220908/why-arraylist-add-and-addint-index-e-complexity-is-amortized-constant-time
        // Amortized O(1)
        // Asympotic O(n)
        Iterator i = ll.iterator();
        Iterator di = ll.descendingIterator();

        while (i.hasNext()) {
            System.out.println(i.next());
        }
        System.out.println(ll.size());
        if (ll.contains(5)) { // contains executes the list from the equals method.
            System.out.println("Hehehe ");
        } else {
            System.out.println("Not 5");
        }
        ll.remove(new Integer(2)); // removes element two
        ll.remove((2));// Removes second index
        i = ll.listIterator();

        while(di.hasNext()) {
            System.out.println(di.next());
        }
    }
}
