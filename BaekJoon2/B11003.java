import java.io.*;
import java.util.*;

public class B11003{
    static StringBuilder sb;
    static int L, M;
    public static void main(String args[])throws IOException{
        inputFile();
    }
    static void inputFile()throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Deque<Integer> dq = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<L; i++){
            int now = Integer.parseInt(st.nextToken());

            dq.size()
        }
        
    }
}