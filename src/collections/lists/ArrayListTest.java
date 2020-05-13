import java.util.*;

public class ArrayListTest {

    public static void main(String args[]) {

        List<Integer> arrayList = new ArrayList<Integer>();

        // Add operation cost.
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(5);
        arrayList.add(2);
        // https://stackoverflow.com/questions/45220908/why-arraylist-add-and-addint-index-e-complexity-is-amortized-constant-time
        // Amortized O(1)
        // Asympotic O(n)
        Iterator i = arrayList.iterator();

        while (i.hasNext()) {
            System.out.println(i.next());
        }
        System.out.println(arrayList.size());
        if (arrayList.contains(5)) { // contains executes the list from the equals method.
            System.out.println("Hehehe ");
        } else {
            System.out.println("Not 5");
        }
        arrayList.remove(new Integer(2)); // removes element two
        arrayList.remove((2));// Removes second index
        i = arrayList.listIterator();

        while(i.hasNext()) {
            System.out.println(i.next());
        }

    }
}
