import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AmazonFreshPromotion {

    public static void main(String[] args) {


        List<String> first = Arrays.asList("apple", "apple");
        List<String> second = Arrays.asList("banana", "anything", "banana");
        List<List<String>> codeList = Arrays.asList(first, second);
        List<String> shoppingCart = Arrays.asList("apple", "apple", "banana", "banana", "banana");
        boolean winner = freshPromotion(codeList, shoppingCart);
        System.out.println("Winner true: " + winner);

        // ------------------------------------

        first = Arrays.asList("apple", "apple");
        second = Arrays.asList("banana", "anything", "banana");
        codeList = Arrays.asList(first, second);
        shoppingCart = Arrays.asList("banana", "orange", "banana", "apple", "apple");
        winner = freshPromotion(codeList, shoppingCart);
        System.out.println("Winner false: " + winner);

        // ------------------------------------

        first = Arrays.asList("apple", "apple");
        second = Arrays.asList("banana", "anything", "banana");
        codeList = Arrays.asList(first, second);
        shoppingCart = Arrays.asList("apple", "banana", "apple", "banana", "orange", "banana");
        winner = freshPromotion(codeList, shoppingCart);
        System.out.println("Winner false: " + winner);

        // ------------------------------------

        first = Arrays.asList("apple", "apple");
        second = Arrays.asList("apple", "apple", "banana");
        codeList = Arrays.asList(first, second);
        shoppingCart = Arrays.asList("apple", "apple", "apple", "banana");
        winner = freshPromotion(codeList, shoppingCart);
        System.out.println("Winner false: " + winner);
    }

    public static int winPrize(List<List<String>> codeList, List<String> shoppingCart) {

        // checking corner cases
        if (codeList == null || codeList.size() == 0)
            return 1;
        if (shoppingCart == null || shoppingCart.size() == 0)
            return 0;

        int i = 0; // loops trough code lists
        int j = 0; // loops trough shopping carts

        while (i < codeList.size() && j + codeList.get(i).size() <= shoppingCart.size()) {
            boolean match = true;
            for (int k = 0; k < codeList.get(i).size(); k++) {
                if (!codeList.get(i).get(k).equals("anything") && !shoppingCart.get(j + k).equals(codeList.get(i).get(k))) {
                    match = false;
                    break;
                }
            }
            if (match) {
                j += codeList.get(i).size();
                i++;
            } else {
                j++;
            }
        }

        return (i == codeList.size()) ? 1 : 0;
    }

    private static boolean freshPromotion(List<List<String>> codeList, List<String> products) {

        Map<Integer, Integer> indexCode = new HashMap();

        for (int i = 0; i < codeList.size(); i++) {

            Integer index = getIndexOfSubArray(codeList.get(i), products);

            if (index == null) {
                return false;
            }

            indexCode.put(i, index);

        }

        for (int i = 1; i < indexCode.values().size(); i++) {
            if (indexCode.get(i - 1) + codeList.get(i - 1).size() > indexCode.get(i)) {
                return false;
            }
        }

        return true;
    }

    private static Integer getIndexOfSubArray(List<String> array, List<String> subarray) {

        for (int j = 0; j < subarray.size(); j++) {

            if (subarray.get(j).equals(array.get(0))) {
                int found = 1;

                for (int i = 1; i < array.size() && i + j < subarray.size(); i++) {
                    if (subarray.get(j + i).equals(array.get(i)) || array.get(i).equals("anything")) {
                        found++;
                    }
                }

                if (found == array.size()) {
                    return j;
                }

            }
        }

        return null;

    }

}

