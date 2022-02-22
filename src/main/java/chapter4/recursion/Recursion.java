package chapter4.recursion;

import java.util.List;

public class Recursion {

    public static void main(String[] args) {


        System.out.println(getSumOfArray(new int[]{1, 2, 3, 4}, 0, 0));
    }

    public static int getSumOfArray(int[] array, int count, int sum) {
        if (count==array.length) return sum;
        sum += array[count];
        return getSumOfArray(array, ++count, sum);
    }

}
