package LV_1.day_5;

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
        System.out.println();

        // Quiz 3
        String code = "abc1abc1abc";
        String quiz_3 = CodeProcessor.solution(code);
        System.out.println(quiz_3);

        // Quiz 4
        int a = 3;
        int d = 4;
        boolean[] included = {true, false, false, true, true};
        int quiz_4 = ArithmeticSequence.solution(a, d, included);
        System.out.println(quiz_4);

        // Quiz 5
        int a1 = 2;
        int b1 = 6;
        int c1 = 1;
        int quiz_5 = DiceGame2.solution(a1, b1, c1);
        int quiz_5_1 = DiceGame2.solution1(a1, b1, c1);
        System.out.println(quiz_5);

        // Quiz 6
        int[] num_list = {3, 4, 5, 2, 1};
        int quiz_6 = ElementSumMultiple.solution(num_list);
        System.out.println(quiz_6);

        // Quiz 7
        int quiz_7 = ConcatenatedNumber.solution(num_list);
        System.out.println(quiz_7);
    }
}
