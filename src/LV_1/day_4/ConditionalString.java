package LV_1.day_4;

/**
 * Date : 2023-05-29
 * Lessons : 코딩 기초 트레이닝 > 조건 문자열
 * Comment : -
 */
public class ConditionalString {
    public static int solution(String ineq, String eq, int n, int m) {
        int answer = 0;

        switch (ineq) {
            case ">" -> {
                if (eq.equals("=")) {
                    answer = (n >= m) ? 1 : 0;
                } else {
                    answer = (n > m) ? 1 : 0;
                }
            }
            case "<" -> {
                if (eq.equals("=")) {
                    answer = (n <= m) ? 1 : 0;
                } else {
                    answer = (n < m) ? 1 : 0;
                }
            }
        }
        return answer;
    }
}
