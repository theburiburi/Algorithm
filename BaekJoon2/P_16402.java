import java.io.*;
import java.util.*;

public class P_16402 { // 16402 string union-find
    static int king[];
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();
        king = new int[N];
        String kingdomName[] = new String[N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            kingdomName[i] = cutString(str);
            map.put(kingdomName[i], i);
            king[i] = i;
        }

        for (int i = 0; i < M; i++) {
            String str[] = br.readLine().split(",");
            
            int leftIdx = map.get(cutString(str[0]));
            int rightIdx = map.get(cutString(str[1]));
            int win = Integer.parseInt(str[2]);

            int leftKingdom = find(leftIdx);
            int rightKingdom = find(rightIdx);

            if(leftKingdom == rightKingdom){ // ?êµ­ê³¼ì˜ ?¸ì?
                if(leftKingdom == leftIdx){ // ?¼ìª½???€ë¹?
                    if(win == 2){ // ?¤ë¥¸ìª½ì´ ?´ê?
                        king[rightIdx] = rightIdx;
                        king[leftIdx] = rightIdx;
                    }
                }
                else{ // ?¤ë¥¸ìª½ì´ ?€ë¹?
                    if(win == 1){ // ?¼ìª½???´ê?
                        king[leftIdx] = leftIdx;
                        king[rightIdx] = leftIdx;
                    }
                }
            }
            else{
                if (win == 1) { king[rightKingdom] = leftKingdom; }
                else{ king[leftKingdom] = rightKingdom; }
            }
        }

        Set<String> resultSet = new TreeSet<>(); 
        for (int i = 0; i < N; i++) {
            if (i == king[i]) {
                resultSet.add(kingdomName[i]);
            }
        }

        sb.append(resultSet.size()).append("\n");
        for (String now : resultSet) {
            sb.append("Kingdom of ").append(now).append("\n");
        }
        System.out.println(sb);
    }

    public static String cutString(String str) {
        String prefix = "Kingdom of ";
        return str.substring(prefix.length());
    }

    public static int find(int x){
        if(x == king[x]) return x;
        else{ return find(king[x]); }
    }

}
