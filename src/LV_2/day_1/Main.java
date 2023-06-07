package LV_2.day_1;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        System.out.println("========= Q1 ===========");
        int num1 = 2;
        int num2 = 3;
        int q1 = solution1(num1, num2);
        System.out.println(q1);

        System.out.println("========= Q2 ===========");
        String numbers = "onetwothreefourfivesixseveneightnine";
        long q2 = solution2(numbers);
        System.out.println(q2);

        System.out.println("\n========= Q3 ===========");
        int[] index_list = {1, 2, 3, 4, 5};
        int[] quiz_3 = solution3(index_list);
        for (int i : quiz_3) {
            System.out.println(i);
        }

        System.out.println("\n========= Q4 ===========");
        int money = 5500;
        int[] quiz_4 = solution4(money);
        for (int i : quiz_4) {
            System.out.println(i);
        }

        System.out.println("\n========= Q5 ===========");
        int price = 150000;
        int quiz_5 = solution5(price);
        System.out.println(quiz_5);

        System.out.println("\n========= Q6 ===========");
        String message = "happy birthday!";
        int quiz_6 = solution6(message);
        System.out.println(quiz_6);

        System.out.println("\n========= Q7 ===========");
        String s = "1 2 Z 3";
        int quiz_7 = solution7(s);
        System.out.println(quiz_7);
    }

    public static int solution1(int num1, int num2) {
        return num1 + num2;
    }

    public static long solution2(String numbers) {
        String[] guid = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for (int i = 0; i < guid.length; i++) {
            numbers = numbers.replace(guid[i], Integer.toString(i));
        }
        return Long.parseLong(numbers);
    }

    public static int[] solution3(int[] numbers) {
        return IntStream.of(numbers).map(i -> i * 2).toArray();
    }

    public static int[] solution4(int money) {
        int[] answer = new int[2];
        answer[0] = money / 5500;
        answer[1] = money % 5500;
        return answer;
    }

    public static int solution5(int price) {
        float answer = price;
        if (price >= 500000) {
            answer *= 0.8;
        } else if (price >= 300000) {
            answer *= 0.9;
        } else if (price >= 100000) {
            answer *= 0.95;
        }
        return (int) Math.floor(answer);
    }

    // 편지
    public static int solution6(String message) {
        return message.length() * 2;
    }

    // 컨트롤 제트
    public static int solution7(String s) {
        int answer = 0;
        String[] sArr = s.split(" ");
        for (int i = 0; i < sArr.length; i++) {
            if (sArr[i].equals("Z")) {
                answer -= Integer.parseInt(sArr[i - 1]);
            } else {
                answer += Integer.parseInt(sArr[i]);
            }
        }
        return answer;
    }

}
