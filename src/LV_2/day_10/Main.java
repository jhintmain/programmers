package LV_2.day_10;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("========= Q1 ===========");
        String my_string = "3 + 4";
        System.out.println(solution1(my_string));

        System.out.println("========= Q1 ===========");
        String[] quiz = {"19 - 6 = 13", "5 + 66 = 71", "5 - 15 = 63", "3 - 1 = 2"};
        System.out.println(Arrays.toString(solution2(quiz)));
    }

    // 다항식 더하기
    public static String[] solution2(String[] quiz) {
        String[] answer = new String[quiz.length];
        for (int i = 0; i < quiz.length; i++) {
            String[] tmp = Arrays.stream(quiz[i].split(" ")).map(String::trim).toArray(String[]::new);
            if (tmp[1].equals("+")) {
                answer[i] = Integer.parseInt(tmp[0]) + Integer.parseInt(tmp[2]) == Integer.parseInt(tmp[4]) ? "O" : "X";
            } else {
                answer[i] = Integer.parseInt(tmp[0]) - Integer.parseInt(tmp[2]) == Integer.parseInt(tmp[4]) ? "O" : "X";
            }
        }
        return answer;
    }

    // 문자열 계산하기
    public static int solution1(String my_string) {
        String[] temp = my_string.split(" ");
        int answer = Integer.parseInt(temp[0]);
        for (int i = 1; i < temp.length; i += 2) {
            temp[i] = temp[i].trim();
            if (temp[i].equals("+")) {
                answer += Integer.parseInt(temp[i + 1]);
            } else if (temp[i].equals("-")) {
                answer -= Integer.parseInt(temp[i + 1]);
            }
        }

        return answer;
    }
}
