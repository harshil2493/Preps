public class BinarySearchMain {
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6};
        System.out.println(new BinarySearch().findElement(array, 6));
        System.out.println(new BinarySearch().findElement(array, 1));
        System.out.println(new BinarySearch().findElement(array, 10));
        System.out.println(new BinarySearch().findElement(array, -1));
        System.out.println(new BinarySearch().findElement(array, 3));
    }
}

class BinarySearch {
    public int findElement(int[] array, int element) {
        return findElement(array, element, 0, array.length - 1);
    }

    public int findElement(int[] array, int element, int left, int right) {
        if (left > right || left > array.length - 1 || right < 0) {
            return -1;
        }
        int middle = (left + right) / 2;

        if (array[middle] == element) {
            return middle;
        } else if (array[middle] > element) {
            return findElement(array, element, left, middle - 1);
        } else {
            return findElement(array, element, middle + 1, right);
        }
    }
}
