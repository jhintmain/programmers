package LV_1.day_3;

/**
 * Date : 2023-05-29
 * Lessons : 코딩 기초 트레이닝 > 문자열 곱하기
 * Comment : StringBuilder 사용하기,  문자열 반복하기 String.repeat()
 */
public class MultiplyString {
    public static String solution(String my_string, int k) {

        // 풀이 1
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<k; i++){
            sb.append(my_string);
        }
        return sb.toString();

        // 풀이 2
//        return my_string.repeat(k);
    }
}
