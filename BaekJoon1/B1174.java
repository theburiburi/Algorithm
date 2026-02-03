import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class B1174{ //1174 백트?�킹
    static List<Long> list = new ArrayList<>();
    static int arr[] = {9,8,7,6,5,4,3,2,1,0};

    public static void main(String args[])throws IOException{
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        dfs(0, 0);
        list.sort(Comparator.naturalOrder()); //?�름차순

        try{
            System.out.println(list.get(N-1));    
        }
        catch(Exception e){
            System.out.println(-1);
        }
    }
    public static void dfs(long num, int depth){
        if(!list.contains(num)){
            list.add(num);
        }
        if (depth >= 10){
            return;
        }
        dfs(num*10 + arr[depth], depth+1);
        dfs(num,depth+1);
    }
}
