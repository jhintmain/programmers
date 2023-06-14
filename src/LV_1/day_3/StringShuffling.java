package LV_1.day_3;

/**
 * Date : 2023-05-29
 * Lessons : 코딩 기초 트레이닝 > 문자열 섞기
 * Comment :
 */
class StringShuffling {
    public static String solution(String str1, String str2) {

        String answer = "";
        char[] str1Array = str1.toCharArray();
        char[] str2Array = str2.toCharArray();

        for (int i = 0; i < str1Array.length; i++) {
            answer += str1Array[i] + Character.toString(str2Array[i]);
        }

        return answer;
    }

    /**
     * 다른 사람의 풀이 참고
     * 1. StringBuilder를 이용하여 부하를 줄인다.
     */
    public static String solution1(String str1, String str2) {
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars1.length; i++) {
            sb.append(chars1[i]).append(chars2[i]);
        }

        return sb.toString();
    }
}

