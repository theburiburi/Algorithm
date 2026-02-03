import java.io.*;
import java.util.*;

public class B9328 {
    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        while(T --> 0){
            Set<Character> key = new HashSet<>();
            st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            char map[][] = new char[h + 2][w + 2];
            for (int i = 0; i < h + 2; i++) Arrays.fill(map[i], '.');
            for (int i = 1; i <= h; i++) {
                String str = br.readLine();
                for (int j = 1; j <= w; j++) map[i][j] = str.charAt(j - 1);
            }

            String str = br.readLine();
            if(!str.equals("0")){
                for(int i=0; i<str.length(); i++){
                    key.add(str.charAt(i));
                }
            }

            sb.append(bfs(map, h, w, key)+"\n");
        }
        System.out.println(sb);
    }

    public static int bfs(char map[][], int h, int w, Set<Character> key){
        boolean visited[][] = new boolean[h+2][w+2];
        Queue<int[]> que = new LinkedList<>();
        Queue<int[]> waitQue[] = new LinkedList[26];
        int dx[] = {0, 0, -1, 1};
        int dy[] = {-1, 1, 0, 0};

        for(int i=0; i<26; i++) waitQue[i] = new LinkedList<>();

        que.add(new int[]{0,0});
        visited[0][0] = true;
        int answer = 0;

        while(!que.isEmpty()){
            int now[] = que.poll();
            int y = now[0];
            int x = now[1];

            for(int i=0; i<4; i++){
                int ddy = y+dy[i];
                int ddx = x+dx[i];

                if(!check(ddy,ddx, h, w)) continue;
                if(visited[ddy][ddx] || map[ddy][ddx] == '*') continue;

                visited[ddy][ddx] = true;
                char pattern = map[ddy][ddx];
                
                switch(pattern){
                    case '.' :
                        que.add(new int[]{ddy,ddx});
                        break;
                    
                    case '$' :
                        answer++;
                        que.add(new int[]{ddy,ddx});
                        break;

                    default:
                        if('a' <= pattern && pattern <= 'z'){
                            if(!key.contains(pattern)){
                                key.add(pattern);

                                int idx = pattern -'a';
                                while(!waitQue[idx].isEmpty()){
                                    que.add(waitQue[idx].poll());
                                }
                            }
                            que.add(new int[]{ddy,ddx});
                        }
                        else if(Character.isUpperCase(pattern)){
                            if(key.contains(Character.toLowerCase(pattern))){
                                que.add(new int[]{ddy,ddx});
                            }
                            else{
                                waitQue[pattern -'A'].add(new int[]{ddy,ddx});
                            }
                        }
                        break;
                }

            }
        }
        return answer;
    }

    public static boolean check(int y, int x, int h, int w){
        return (0<= y && y< h+2 && 0<=x && x<w+2);
    }
}
