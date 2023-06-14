package LV_1.day_3;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Date : 2023-05-29
 * Lessons : 코딩 기초 트레이닝 > 문자 리스트를 문자열로 변환하기
 * Comment : Array > String : String.join("", strArray);
 */
public class ArrayToString {
    public static String solution(String[] arr) {
        return String.join("",arr);
    }

    /**
     * 다른 사람의 풀이 참고
     * 1. stream을 이용
     */
    public static String solution1(String[] arr) {
        return Arrays.stream(arr).collect(Collectors.joining());
    }


}
