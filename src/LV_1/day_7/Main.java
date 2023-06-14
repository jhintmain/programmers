package LV_1.day_7;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        System.out.println("========= Q1 ===========");
        int l = 10;
        int r = 20;
        int[] quiz_1 = solution1(l, r);

        for (int i : quiz_1) {
            System.out.print(i + ",");
        }

        System.out.println("\n========= Q2 ===========");
        int n = 10;
        int[] quiz_2 = solution2(n);

        for (int i : quiz_2) {
            System.out.print(i + ",");
        }

        System.out.println("\n========= Q3 ===========");
        int[] arr = {1, 4, 2, 5, 3};
        int[] quiz_3 = solution3(arr);

        for (int i : quiz_3) {
            System.out.print(i + ",");
        }
    }

    // 배열 만들기 2
    public static int[] solution1(int l, int r) {
        List<Integer> list = new ArrayList<>();

        for (int i = l; i <= r; i++) {
            String str = String.valueOf(i);
            boolean a = str.matches("[0,5]+");
            if (a) {
                list.add(i);
                boolean b = str.matches("[5]+");
                if (b) {
                    i = (int) (5 * Math.pow(10, str.length())) - 1; // 5 로만 이루어 져있으면 다음 자리수로 이동
                }
            }
        }
        if (list.isEmpty()) {
            list.add(-1);
        }

        return list.stream().mapToInt(i -> i).toArray();
    }

    // 콜라츠 수열 만들기
    public static int[] solution2(int n) {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(n);
        while (n != 1) {
            if (n % 2 == 0) {
                n = n / 2;
            } else {
                n = (n * 3) + 1;
            }
            list.add(n);
        }

        return list.stream().mapToInt(i -> i).toArray();
    }

    // 배열 만들기 4
    public static int[] solution3(int[] arr) {
        Stack<Integer> stk = new Stack<>();

        int i = 0;
        while (i != arr.length) {
            if (stk.isEmpty() || stk.peek() < arr[i]) {
                stk.push(arr[i]);
                i += 1;
            } else {
                stk.pop();
            }
        }

        return stk.stream().mapToInt(j -> j).toArray();
    }
}
