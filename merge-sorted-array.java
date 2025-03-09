class Solution {
    public static void main(String[] args) {
        int[] arr1 = new int[] { 0, 3, 4, 31 };
        int[] arr2 = new int[] { 4, 6, 30 };
        int[] result = mergeSortedArray(arr1, arr2);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

    public static int[] mergeSortedArray(int[] arr1, int[] arr2) {
        // check input
        if (arr1.length == 0)
            return arr2;
        if (arr2.length == 0)
            return arr1;

        int[] result = new int[arr1.length + arr2.length];
        int i = 0, j = 0, index = 0;
        while (index < result.length) {
            if (j == arr2.length || (i < arr1.length && arr1[i] <= arr2[j])) {
                result[index] = arr1[i];
                i++;
            }

            else if (i == arr1.length || (j < arr2.length && arr2[j] < arr1[i])) {
                result[index] = arr2[j];
                j++;
            }

            index++;
        }
        return result;
    }
}