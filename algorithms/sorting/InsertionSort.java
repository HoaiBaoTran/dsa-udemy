class InsertionSort {
    public static void main(String[] args) {
        int[] array = new int[] { 99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0 };
        insertionSort(array);
        for (int i : array) {
            System.out.print(i + " ");
        }
    }

    private static void insertionSort(int[] arr) {
        if (arr.length <= 1)
            return;

        for (int i = 1; i < arr.length; i++) {
            int currentIndex = i;
            int j = i - 1;
            while (j >= 0 && arr[j] >= arr[currentIndex]) {
                int temp = arr[j];
                arr[j] = arr[currentIndex];
                arr[currentIndex] = temp;
                currentIndex = j;
                j--;
            }

        }
    }
}