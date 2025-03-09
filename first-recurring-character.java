import java.util.HashMap;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        int[] array1 = new int[] { 2, 5, 1, 2, 3, 5, 1, 2, 4 };
        int[] array2 = new int[] { 2, 1, 1, 2, 3, 5, 1, 2, 4 };
        int[] array3 = new int[] { 2, 3, 4, 5 };
        System.out.println(firstRecurringCharacter(array1));
        System.out.println(firstRecurringCharacter(array2));
        System.out.println(firstRecurringCharacter(array3));
    }

    public static int firstRecurringCharacter(int[] arr) {
        // check input
        if (arr.length <= 0) {
            return -1;
        }

        Map<Integer, Boolean> hashMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (hashMap.get(arr[i]) != null) {
                return arr[i];
            }
            hashMap.put(arr[i], true);
        }
        return -1;
    }
}