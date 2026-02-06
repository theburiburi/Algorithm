import java.io.*;
import java.util.*;

public class S3421_1 {
    static int N, M;
    static List<Integer> condition[];
    static int ans = 0;
    static Set<List<Integer>> set;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            condition = new ArrayList[N+1];
            for(int i=0; i<N+1; i++){
                condition[i] = new ArrayList<>();
            }

            for(int i=0;i<M; i++){
                st = new StringTokenizer(br.readLine());
                int small = Integer.parseInt(st.nextToken());
                int big = Integer.parseInt(st.nextToken());
                if(small > big){
                    int temp = small;
                    small= big;
                    big = temp;
                }

                condition[big].add(small);
            }
            ans = 0;
            set = new HashSet<>();
            subset(1, new ArrayList<>());

            sb.append("#"+t+" "+ (set.size())+"\n");
        }
        System.out.println(sb);
    }
    public static void subset(int num ,List<Integer> list){
        if(num > N) {
            set.add(new ArrayList<>(list));
            return;
        }

        subset(num+1, list);
        boolean check = true;
        for(int j=0; j<condition[num].size(); j++){
            if(list.contains(condition[num].get(j))){
                check = false;
            }   
        }

        if(check){
            list.add(num);
            subset(num+1, list);
            list.remove(list.size()-1);
        }

    }
}
