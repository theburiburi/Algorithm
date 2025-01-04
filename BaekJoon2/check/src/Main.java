import java.io.*;
import java.util.*;

public class Main {//1774 그리디
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> negList = new ArrayList<>();
        List<Integer> posList = new ArrayList<>();
        
        for(int i=0; i<N; i++){
            int temp = Integer.parseInt(br.readLine());
            if(temp > 0){
                posList.add(temp);
            }
            else{
                negList.add(temp);
            }
        }
        posList.sort((s1,s2) -> s2-s1);
        negList.sort((s1,s2) -> s1-s2);

        int posLen = posList.size();
        int negLen = negList.size();

        int sum=0;
        if(posLen == 1 && negLen == 1){
            if(posList.get(0)*negList.get(0)> posList.get(0)+negList.get(0)){
                sum += posList.get(0)*negList.get(0);
            }
            else sum += posList.get(0)+negList.get(0);
        }
        else if (posLen == 1){
            sum += posList.get(0);
        }
        else if (negLen == 1){
            sum += negList.get(0);
        }

        for(int j=0; j<posLen-1; j++){
            if(posList.get(j) * posList.get(j+1) > posList.get(j) + posList.get(j+1)){
                sum += posList.get(j) * posList.get(j+1);
                j++;
                if(j==posLen-2){
                    sum += posList.get(j+1);
                }
            }
            else{
                sum += posList.get(j);
                if(j==posLen-2){
                    sum += posList.get(j+1);
                }
            }
        }
        for(int j=0; j<negLen-1; j++){
            if(negList.get(j) * negList.get(j+1) > negList.get(j) + negList.get(j+1)){
                sum += negList.get(j) * negList.get(j+1);
                j++;
                if(j==posLen-2){
                    sum += posList.get(j+1);
                }
            }
            else{
                sum += negList.get(j);
                if(j==posLen-2){
                    sum += negList.get(j+1);
                }
            }
        }
            
        System.out.println(sum);
    }
}