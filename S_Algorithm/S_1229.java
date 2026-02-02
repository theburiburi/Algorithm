import java.io.*;
import java.util.*;

public class S_1229 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= 10; t++) {
            int N = Integer.parseInt(br.readLine());
            
            List<Integer> list = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            int CN = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                String cmd = st.nextToken();
                if (cmd.equals("I")) {
                    int position = Integer.parseInt(st.nextToken());
                    int count = Integer.parseInt(st.nextToken());
                    for (int j = 0; j < count; j++) {
                        list.add(position++, Integer.parseInt(st.nextToken()));
                    }
                }
                else if(cmd.equals("D")){
                    int position = Integer.parseInt(st.nextToken());
                    int count = Integer.parseInt(st.nextToken());
                    for (int j = 0; j < count; j++) {
                        list.remove(position); //(position++, Integer.parseInt(st.nextToken()));
                    }
                }
            }

            sb.append("#").append(t).append(" ");
            for (int i = 0; i < 10; i++) {
                sb.append(list.get(i)).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}