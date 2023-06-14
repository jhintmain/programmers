package LV_3.Hash;

import java.util.*;

/**
 * 해시 > 베스트 앨범
 * URL : https://school.programmers.co.kr/learn/courses/30/lessons/42579
 */
public class BestAlbum {
    public static void main(String[] args) {
        String[] genres = {"pop","classic", "pop", "classic", "classic", "pop"};
        int[] plays = {2500,500, 600, 150, 800, 2500};
//        System.out.println(Arrays.toString(solution(genres, plays)));
//
//        genres = new String[]{"classic", "pop", "classic", "classic", "pop"};
//        plays = new int[]{500, 600, 150, 800, 2500};
//        System.out.println(Arrays.toString(solution(genres, plays)));

        genres = new String[]{"classic", "pop", "classic", "classic", "pop", "test"};
        plays = new int[]{500, 600, 150, 800, 2500, 100};
        System.out.println(Arrays.toString(solution(genres, plays)));

//        genres = new String[]{"classic"};
//        plays = new int[]{300};
//        System.out.println(Arrays.toString(solution(genres, plays)));

    }

    public static int[] solution(String[] genres, int[] plays) {
        // 1. 속한 노래가 많이 재생된 장르 총합 카운트 하여 mapping (class,4000) ,(pop,24000)
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }

        // 2. 역정렬
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(map.entrySet());
        entryList.sort((o1, o2) -> o2.getValue() - o1.getValue());


        // 3. 역정렬후 순서대로 장르만 넣기 (pop, class)
        List<String> bestGenres = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : entryList) {
            bestGenres.add(entry.getKey());
        }

        Map<String, List<Map.Entry<Integer, Integer>>> mapMap = new HashMap<>();

        for (String gen : bestGenres) {
            Map<Integer, Integer> tmpMap = new HashMap<>();
            for (int i = 0; i < plays.length; i++) {
                if (genres[i].equals(gen)) {
                    tmpMap.put(i, plays[i]);
                }
            }
            List<Map.Entry<Integer, Integer>> tmpList = new LinkedList<>(tmpMap.entrySet());
            tmpList.sort((o1, o2) -> o2.getValue() - o1.getValue());
            mapMap.put(gen, tmpList);
        }


        int limit = 2;
        List<Integer> rstList = new ArrayList<>();
        for (String gen : bestGenres) {
            int cnt = 0;
            for (Map.Entry<Integer, Integer> m : mapMap.get(gen)) {
                rstList.add(m.getKey());
                if (++cnt >= limit) {
                    break;
                }
            }
        }

        return rstList.stream().mapToInt(i -> i).toArray();
    }
}
