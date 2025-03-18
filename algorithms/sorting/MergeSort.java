class MergeSort {
    public static void main(String[] args) {
        int[] array = new int[] { 99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0 };
        mergeSort(array, 0, array.length - 1);
        for (int i : array) {
            System.out.print(i + " ");
        }
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        // create sub array
        int leftSize = mid - left + 1;
        int rightSize = right - mid;
        int[] leftArr = new int[leftSize];
        int[] rightArr = new int[rightSize];

        for (int i = 0; i < leftSize; i++) {
            leftArr[i] = arr[left + i];
        }

        for (int i = 0; i < rightSize; i++) {
            rightArr[i] = arr[i + mid + 1];
        }
        int i = 0;
        int j = 0;
        int k = left;
        while (i < leftSize && j < rightSize) {
            arr[k++] = leftArr[i] <= rightArr[j] ? leftArr[i++] : rightArr[j++];
        }

        while (i < leftSize) {
            arr[k++] = leftArr[i++];
        }

        while (j < rightSize) {
            arr[k++] = rightArr[j++];
        }

    }

}