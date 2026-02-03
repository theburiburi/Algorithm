import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class B1914 {//1914 dfs
    static BufferedWriter bw;
    public static void main(String args[]) throws IOException { //1943
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        // BigInteger bigNumber1 = new BigInteger("2");
        // BigInteger bigNumber2 = new BigInteger("1");
        // bw.write(bigNumber1.pow(N).subtract(bigNumber2).toString());
        bw.write(BigInteger.TWO.pow(N).subtract(BigInteger.ONE).toString());
        bw.newLine();
        if(N <= 20){
            hanoi(N, 1, 2, 3);
        }
        bw.flush();
    }
    static void hanoi(int N, int from, int temp, int to) throws IOException{
        if(N ==1) {
            bw.write(from + " " + to + "\n");
            return;
        }
        hanoi(N-1, from, to, temp);
        bw.write(from + " " + to + "\n");
        hanoi(N-1, temp, from, to);
    }
}

