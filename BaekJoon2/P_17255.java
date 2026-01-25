import java.io.*;
import java.util.*;

public class P_17255 {//17255 dfs
    static char arr[];
    static int answer = 0;
    static int arrLen;
    static HashSet<String> set = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = br.readLine().toCharArray();
        arrLen = arr.length;
        for(int i=0; i< arrLen; i++){
            dfs(i,i,arr[i]+"", arr[i]+"");
        }
        System.out.println(set.size());
    }
    static void dfs(int left, int right, String str , String path){
        if(left == 0 && right == arrLen-1){
            set.add(path);
        }
        if(left-1 >= 0){
            dfs(left-1,right, arr[left-1]+str, path + " " + arr[left-1]+str);
        }
        if(right+1 < arrLen){
            dfs(left,right+1, str+arr[right+1], path + " " + str+arr[right+1]);
        }
    }
}

