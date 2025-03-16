class BubbleSort {
    public static void main(String[] args) {
        int[] array = new int[] { 99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0 };
        bubbleSort(array);
        for (int i : array) {
            System.out.print(i + " ");
        }
    }

    private static void bubbleSort(int[] array) {
        // edge case
        if (array.length <= 1) {
            return;
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] >= array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}