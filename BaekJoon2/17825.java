import java.io.*;
import java.util.*;

public class 17825 {

    static class Node {
        int scoreNumber;
        int nowPosition;
        int horseTotalScore;

        public Node(int scoreNumber, int nowPosition, int horseTotalScore) {
            this.scoreNumber = scoreNumber;
            this.nowPosition = nowPosition;
            this.horseTotalScore = horseTotalScore;
        }

        public Node copy() {
            return new Node(scoreNumber, nowPosition, horseTotalScore);
        }
    }

    static int max;
    static Node horse[];
    static int dice[];
    static int[] score1, score2, score3, score4;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 점수 배열 정의
        score1 = new int[]{2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40};
        score2 = new int[]{10, 13, 16, 19, 25, 30, 35, 40};
        score3 = new int[]{20, 22, 24, 25, 30, 35, 40};
        score4 = new int[]{30, 28, 27, 26, 25, 30, 35, 40};
        

        horse = new Node[5];
        for (int i = 1; i <= 4; i++) {
            horse[i] = new Node(1, -1, 0); // 초기화
        }

        max = 0;
        dice = new int[10];
        for (int i = 0; i < 10; i++) {
            dice[i] = Integer.parseInt(st.nextToken());
        }

        backtrack(0);
        System.out.println(max);
    }

    static void backtrack(int count) {
        if (count == 10) {
            int total = 0;
            for (int i = 1; i <= 4; i++) {
                total += horse[i].horseTotalScore;
            }
            max = Math.max(max, total);
            return;
        }

        for (int i = 1; i <= 4; i++) {
            if (horse[i].nowPosition == -2) continue; // 이미 도착한 말은 스킵

            Node original = horse[i].copy();

            if (moveHorse(horse[i], dice[count], i)) {
                backtrack(count + 1);
            }

            horse[i] = original;
        }
    }

    static boolean moveHorse(Node horse, int diceValue, int horseNumber) {
        int score = 0;

        switch (horse.scoreNumber) {
            case 1:
                if (checkBoundary(horse, diceValue, score1)) return true;
                score = score1[horse.nowPosition];
                break;

            case 2:
                if (checkBoundary(horse, diceValue, score2)) return true;
                score = score2[horse.nowPosition];
                break;

            case 3:
                if (checkBoundary(horse, diceValue, score3)) return true;
                score = score3[horse.nowPosition];
                break;

            case 4:
                if (checkBoundary(horse, diceValue, score4)) return true;
                score = score4[horse.nowPosition];
                break;
        }

        if (checkCollision(horseNumber, score)) return false;

        horse.horseTotalScore += score;

        // 경로 변경
        if (horse.scoreNumber == 1) {
            if (score == 10) {
                horse.scoreNumber = 2;
                horse.nowPosition = 0;
            } else if (score == 20) {
                horse.scoreNumber = 3;
                horse.nowPosition = 0;
            } else if (score == 30) {
                horse.scoreNumber = 4;
                horse.nowPosition = 0;
            }
        }
        return true;
    }

    static boolean checkBoundary(Node horse, int diceValue, int[] scoreArray) {
        horse.nowPosition += diceValue;
        if (horse.nowPosition >= scoreArray.length) {
            horse.nowPosition = -2; // 도착 처리
            return true;
        }
        return false;
    }

    static boolean checkCollision(int horseNumber, int nextScore) {
        for (int i = 1; i <= 4; i++) {
            if (i == horseNumber || horse[i].nowPosition == -2 || horse[i].nowPosition == -1) continue;

            int currentScore = getScore(horse[i].scoreNumber, horse[i].nowPosition);
            if (currentScore == nextScore) {
                return true;
            }
        }
        return false;
    }

    static int getScore(int scoreNumber, int nowPosition) {
        if (nowPosition == -1) return -1;
        switch (scoreNumber) {
            case 1:
                return score1[nowPosition];
            case 2:
                return score2[nowPosition];
            case 3:
                return score3[nowPosition];
            case 4:
                return score4[nowPosition];
        }
        return -1;
    }
}
