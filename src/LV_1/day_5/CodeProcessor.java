package LV_1.day_5;
/**
 * Date : 2023-05-31
 * Lessons : 코딩 기초 트레이닝 > 코드 처리하기
 * Comment : -
 */
public class CodeProcessor {
    public static String solution(String code) {
        StringBuilder answer = new StringBuilder();
        char mode = '0';

        for (int i = 0; i < code.length(); i++) {
            char change_mode = (mode == '0') ? '1' : '0';
            int oddEven = (mode == '0') ? 0 : 1;

            if (code.charAt(i) == '1') {
                mode = change_mode;
            } else {
                if (i % 2 == oddEven) {
                    answer.append(code.charAt(i));
                }
            }
        }
        return answer.equals("") ? "EMPTY" : answer.toString();
    }
}
