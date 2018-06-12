public class MergeSortMain {
    public static void main(String[] args) {
        int[] a = new int[]{2, 5, 1, 4, 1, 7};

        int[] sortedA = new MergeSort().sort(a);

        System.out.println("-- Sorted Element --");
        for (int eachArrayElement : sortedA) {
            System.out.println(eachArrayElement);
        }
    }
}

class MergeSort {
    public int[] sort(int[] a) {
        return sort(a, 0, a.length - 1);
    }

    private int[] mergeTwoArray(int[] leftArray, int[] rightArray) {
        int lengthL = leftArray.length;
        int lengthR = rightArray.length;

        int[] sorted = new int[lengthL + lengthR];
        int i = 0, j = 0, k = 0;

        while (i < lengthL && j < lengthR) {
            if (leftArray[i] < rightArray[j]) {
                sorted[k] = leftArray[i];
                i++;
                k++;
            } else {
                sorted[k] = rightArray[j];
                j++;
                k++;
            }
        }
        while (i < lengthL) {
            sorted[k] = leftArray[i];
            i++;
            k++;
        }
        while (j < lengthR) {
            sorted[k] = rightArray[j];
            j++;
            k++;
        }

        return sorted;
    }

    private int[] sort(int[] a, int l, int r) {
        if (l >= r) {
            return new int[]{a[Math.min(l, r)]};
        } else {
            int middle = l + (r - l) / 2;
            int[] leftArray = sort(a, l, middle);
            int[] rightArray = sort(a, middle + 1, r);

            return mergeTwoArray(leftArray, rightArray);
        }
    }
}
