import java.io.*;
import java.util.*;

public class B1525 {//1525 ?´ì‹œë§?
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new HashMap<>();
        Queue<String> que = new LinkedList();

        String answer = "123456780";
        String tempStr = "";
        for(int i=1; i<4; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<4; j++){
                tempStr += st.nextToken().charAt(0);
            }
        }
        que.add(tempStr);
        map.put(tempStr, 0);

        int num = -1;
        while(!que.isEmpty()){
            String str = que.poll();
            if(str.equals(answer)){
                num = map.get(str);
            }

            int dx[] = {1, -1, 0, 0};
            int dy[] = {0, 0, 1, -1};

            int str0Index = str.indexOf('0');
            int px = str0Index % 3;
            int py = str0Index / 3;

            for(int i=0; i<4; i++){
                int nx = px + dx[i];
                int ny = py + dy[i];
                if(0 <= nx && nx <= 2 && 0 <= ny && ny <= 2){
                    int charIndex = ny*3 + nx;

                    char ch = str.charAt(charIndex);
                    String temp = str.replace('0', 'A');
                    temp = temp.replace(ch, '0');
                    temp = temp.replace('A', ch);

                    if(!map.containsKey(temp)){
                        que.add(temp);
                        map.put(temp, map.get(str)+1);
                    }
                }
            }

        }
        System.out.println(num);
    }
}
