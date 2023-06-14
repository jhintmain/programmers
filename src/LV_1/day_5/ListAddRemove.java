package LV_1.day_5;

import java.util.Stack;
/**
 * Date : 2023-05-30
 * Lessons : 코딩 기초 트레이닝 >
 * Comment : -
 */
public class ListAddRemove {
    public static int[] solution(int[] arr, boolean[] flag) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < flag.length; i++) {
            if (flag[i]) {
                for (int j = 0; j < arr[i] * 2; j++) {
                    stack.add(arr[i]);
                }
            } else {
                for (int j =0; j<arr[i]; j++) {
                    stack.pop();
                }
            }
        }

        return stack.stream().mapToInt(i->i).toArray();
    }
}
