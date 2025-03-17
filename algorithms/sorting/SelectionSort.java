class SelectionSort {
    public static void main(String[] args) {
        int[] array = new int[] { 99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0 };
        selectionSort(array);
        for (int i : array) {
            System.out.print(i + " ");
        }
    }

    private static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int smallestIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[smallestIndex] > arr[j]) {
                    smallestIndex = j;
                }
            }
            int temp = arr[smallestIndex];
            arr[smallestIndex] = arr[i];
            arr[i] = temp;
        }
    }
}