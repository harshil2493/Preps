public class QuickSortMain {
    public static void main(String[] args) {
        int[] a = new int[]{2, 5, 4, 1, 7};
        new QuickSort().sort(a);
        System.out.println("-- Sorted Element --");
        for (int eachArrayElement : a) {
            System.out.println(eachArrayElement);
        }
    }
}

class QuickSort {
    public void sort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    private void sort(int[] a, int left, int right) {
        if (left <= right) {
            int pivot = getPivot(a, left, right);
            sort(a, left, pivot - 1);
            sort(a, pivot + 1, right);
        }
    }

    private int getPivot(int[] a, int left, int right) {
        int pivotIndex = left;
        int pivotNumber = a[right];

        for (int i = left; i < right; i++) {
            if (a[i] <= pivotNumber) {
                int temp = a[pivotIndex];
                a[pivotIndex] = a[i];
                a[i] = temp;
                pivotIndex++;
            }
        }

        int temp = a[pivotIndex];
        a[pivotIndex] = a[right];
        a[right] = temp;

        return pivotIndex;
    }
}
