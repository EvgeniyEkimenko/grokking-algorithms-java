package introduction_to_algorithms;

public class BinarySearch {

    private static Integer binarySearch(int[] list, int number) {
        int left = 0;
        int right = list.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int temp = list[mid];
            if (temp == number) {
                return mid;
            }
            if (temp > number) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        int[] myList = {1, 3, 5, 7, 9};

        System.out.println(binarySearch(myList, 3)); // 1
        System.out.println(binarySearch(myList, -1)); // null
    }
}
