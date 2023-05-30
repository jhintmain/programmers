package day_5;

public class Main {
    public static void main(String[] args) {

        // Quiz 1
        int[] arr = {0, 1, 2, 4, 3};
        int[][] queries = {{0, 4, 1}, {0, 3, 2}, {0, 3, 3}};
        int[] quiz_1 = SeqAndInterval4.solution(arr, queries);
        for (int num : quiz_1) {
            System.out.print(num + " ");
        }

        System.out.println();
        // Quiz 2
        int[] arr2 = {3, 2, 4, 1, 3};
        boolean[] flag = {true, false, true, false, false};
        int[] quiz_2 = ListAddRemove.solution(arr2, flag);
        for (int num : quiz_2) {
            System.out.print(num + " ");
        }

    }
}
