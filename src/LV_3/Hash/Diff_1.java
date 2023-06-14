package LV_3.Hash;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.*;

public class Diff_1 {
    public static void main(String[] args) {
        String[] genres = {"pop","classic", "pop", "classic", "classic", "pop"};
        int[] plays = {2500,500, 600, 150, 800, 2500};
        System.out.println(Arrays.toString(solution(genres, plays)));
    }


    public static int[] solution(String[] genres, int[] plays) {
        return IntStream.range(0, genres.length)
                .mapToObj(i -> new Music(genres[i], plays[i], i))
                .collect(Collectors.groupingBy(Music::getGenre))
                .entrySet().stream()
                .sorted((a, b) -> sum(b.getValue()) - sum(a.getValue()))
                .flatMap(x -> x.getValue().stream().sorted().limit(2))
                .mapToInt(x -> x.id).toArray();
    }

    private static int sum(List<Music> value) {
        int answer = 0;
        for (Music music : value) {
            answer += music.played;
        }
        return answer;
    }
}

class Music implements Comparable<Music> {

    int played;
    int id;
    private String genre;

    public Music(String genre, int played, int id) {
        this.genre = genre;
        this.played = played;
        this.id = id;
    }

    @Override
    public int compareTo(Music other) {
        if (this.played == other.played) return this.id - other.id;
        return other.played - this.played;
    }

    public String getGenre() {
        return genre;
    }
}

