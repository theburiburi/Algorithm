import java.io.*;
import java.util.*;

public class P_1744 { //1744 그리??
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> negList = new ArrayList<>();
        List<Integer> posList = new ArrayList<>();
        int sum = 0;

        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(br.readLine());
            if (temp > 0) {
                posList.add(temp);
            } else {
                negList.add(temp);
            }
        }

        posList.sort((s1, s2) -> s2 - s1);
        negList.sort((s1, s2) -> s1 - s2);

        for (int i = 0; i < posList.size(); i += 2) {
            if (i + 1 < posList.size()) {
                sum += Math.max(posList.get(i) * posList.get(i + 1), posList.get(i) + posList.get(i + 1));
            } 
            else {
                sum += posList.get(i);
            }
        }

        for (int i = 0; i < negList.size(); i += 2) {
            if (i + 1 < negList.size()) {
                sum += negList.get(i) * negList.get(i + 1);
            } 
            else {
                sum += negList.get(i);
            }
        }

        System.out.println(sum);
    }
}

