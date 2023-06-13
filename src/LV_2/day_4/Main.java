package LV_2.day_4;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int day = 6;
        int k = 25;
        int[] q = solution(day, k);
        for (int n : q) {
            System.out.print(n + " ");
        }
    }

    public static int[] solution(int day, int k) {
        int[] answer = new int[12];    // return 배열갯수 12개 : 1~12월
        int[] last_day = {31,28,31,30,31,30,31,31,30,31,30,31}; // 각 월별 마지막날짜 셋팅
        int check = day;    // 1~12월 날짜를 돌면서 0~6까지계속 변화하는 변수

        // 월
        for (int i = 1; i <= 12; i++) {
            // 일
            for (int j = 1; j <= last_day[i-1]; j++) {
                System.out.print("["+i+"월]"+j+"일 ("+check+")");
                // 일이 납일일과 같을때 check 변수가 주말(5,6)이면 1 , 아니면 0 으로 answer[] 배열에 순서대로 담는다.
                if(k == j){
                    System.out.print(" ==> 납입일");
                    answer[i-1] = (check == 5 || check == 6) ? 1 : 0;
                }
                System.out.println();
                check = (check+1)%7;    // 7일 주기로 반복셋팅
            }
        }

        return answer;
    }
}
