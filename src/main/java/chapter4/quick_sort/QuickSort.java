package chapter4.quick_sort;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class QuickSort {

    public static void main(String[] args) {
    }

    public static List<Integer> quickSort(List<Integer> list) {
        if (list.size() < 2) {
            return list;
        } else {
            Integer pivot = list.get(0);

            List<Integer> less = list.stream().skip(1).filter(el -> el <= pivot)
                    .collect(Collectors.toList());

            List<Integer> greater = list.stream().skip(1).filter(el -> el > pivot)
                    .collect(Collectors.toList());

            return Stream.of(
                            quickSort(less).stream(),
                            Stream.of(pivot),
                            quickSort(greater).stream())
                    .flatMap(Function.identity()).collect(Collectors.toList());
        }
    }


    public static void defaultQuickSort(int[] array, int leftBorder, int rightBorder) {
        int leftMarker = leftBorder;
        int rightMarker = rightBorder;
        int pivot = array[(leftMarker + rightMarker) / 2];
        do {
            // Двигаем левый маркер слева направо пока элемент меньше, чем pivot
            while (array[leftMarker] < pivot) {
                leftMarker++;
            }
            // Двигаем правый маркер, пока элемент больше, чем pivot
            while (array[rightMarker] > pivot) {
                rightMarker--;
            }
            // Проверим, не нужно обменять местами элементы, на которые указывают маркеры
            if (leftMarker <= rightMarker) {
                // Левый маркер будет меньше правого только если мы должны выполнить swap
                if (leftMarker < rightMarker) {
                    int tmp = array[leftMarker];
                    array[leftMarker] = array[rightMarker];
                    array[rightMarker] = tmp;
                }
                // Сдвигаем маркеры, чтобы получить новые границы
                leftMarker++;
                rightMarker--;
            }
        } while (leftMarker <= rightMarker);

        // Выполняем рекурсивно для частей
        if (leftMarker < rightBorder) {
            defaultQuickSort(array, leftMarker, rightBorder);
        }
        if (leftBorder < rightMarker) {
            defaultQuickSort(array, leftBorder, rightMarker);
        }
    }
}
