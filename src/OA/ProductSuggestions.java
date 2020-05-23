import java.util.*;

public class ProductSuggestions {

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < searchWord.length(); ++i) {
            ans.add(new ArrayList<>());
        }
        List<String> temp = null;
        // Sorting products -- nlogn - step.
        Arrays.sort(products);

        //
        for (int i = 0; i < products.length; ++i) {
            int commonPrefix = match(products[i], searchWord);
            for (int j = commonPrefix - 1; j >= 0; --j) {
                temp = ans.get(j);
                if (temp.size() == 3) {
                    break;
                }
                temp.add(products[i]);
            }
        }
        return ans;
    }

    private int match(String one, String two) {
        int i = 0;
        for (i = 0; i < one.length() && i < two.length(); ++i) {
            if (one.charAt(i) != two.charAt(i))
                return i;
        }
        return i;
    }

    // Second solution with binary search.
    public List<List<String>> suggestedProductsTwo(String[] products, String searchWord) {
        Arrays.sort(products);

        List<List<String>> ans = new ArrayList<>();
        for (int i=0;i<searchWord.length();i++) {
            ans.add(new ArrayList<>());
        }

        for (int i=0;i<searchWord.length();i++) {
            String str = searchWord.substring(0,i+1);
            int index = binarySearch(products,str,0,products.length-1);
            if (index == -1) {
                return ans;
            }

            while (products[index].startsWith(str) && index>0) {
                index--;
            }
            if (!products[index].startsWith(str)) index++;
            ans.get(i).add(products[index]);
            if (index+1<products.length && products[index+1].startsWith(str)) ans.get(i).add(products[index+1]);
            if (index+2<products.length && products[index+2].startsWith(str)) ans.get(i).add(products[index+2]);
        }
        return ans;
    }

    // Binary Search for the solution.
    public int binarySearch(String[] products, String str, int start, int end) {
        if (start>end) return -1;
        int mid = (start + end)/2;

        if (products[mid].startsWith(str)) {
            return mid;
        }

        if (products[mid].compareTo(str) < 0) {
            return binarySearch(products,str,mid+1,end);
        }
        else {
            return binarySearch(products,str,start,mid-1);
        }
    }


}
