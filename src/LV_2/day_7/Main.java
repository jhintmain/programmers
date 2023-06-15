package LV_2.day_7;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        System.out.println("========= Q1 ===========");
        String my_string = "jaron";
        System.out.println(solution1(my_string));

        System.out.println("========= Q2 ===========");
//        solution2(3);

        System.out.println("========= Q3 ===========");
        int[] num_list = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(solution3(num_list)));

        System.out.println("========= Q4 ===========");
        my_string = "hello";
        int n = 3;
        System.out.println(solution4(my_string,n));

        System.out.println("========= Q5 ===========");
        my_string = "BCBdbe";
        String letter = "B";
        System.out.println(solution5(my_string,letter));

        System.out.println("========= Q6 ===========");
        System.out.println(solution6(70));

        System.out.println("========= Q7 ===========");
        System.out.println(solution7(10));
    }

    // 짝수의 합
    public static int solution7(int n) {
        return IntStream.range(1,n+1).filter(i->i%2==0).sum();
    }
    // 각도기
    public static int solution6(int angle) {
        int answer = 0;
        if(angle < 90){
            answer = 1;
        }else if(angle == 90){
            answer = 2;
        }else if(angle < 180){
            answer = 3;
        }else if(angle == 180){
            answer = 4;
        }
        return answer;
    }

    // 특정 문자 제거하기
    public static String solution5(String my_string, String letter) {
        return my_string.replaceAll(letter,"");
    }

    // 문자 반복 출력하기
    public static String solution4(String my_string, int n) {
        return Arrays.stream(my_string.split(""))
                .map(i-> i.repeat(n))
                .collect(Collectors.joining());
    }
    // 짝수 홀수 개수
    public static int[] solution3(int[] num_list) {
        int[] answer = new int[2];
        for (int num : num_list) {
            answer[num%2] += 1;
        }
        return answer;
    }

    // 직각삼각형 출력하기
    public static void solution2(int tmp) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            System.out.println("*".repeat(i));
        }
    }

    // 문자열 뒤집기
    public static String solution1(String my_string) {
        StringBuilder sb = new StringBuilder(my_string);
        return sb.reverse().toString();
    }
}
