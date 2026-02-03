import java.io.*;
import java.util.*;

public class B2608 {//2608 String
    static char roma[] = {'I','V','X','L','C','D','M'};
    static int romaInt[] = {1,5,10,50,100,500,1000};
    static int stringToInt[] = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
    static String intToString[] = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String sen1 = br.readLine();
        String sen2 = br.readLine();
        int num1 = findNum(sen1);
        int num2 = findNum(sen2);

        sb.append(num1+num2+"\n");
        sb.append(numToString(num1+num2));
        System.out.println(sb);
    }
    static int findNum(String sen){
        int num = 0;
        int index = 100;
        for(int i=0; i<sen.length(); i++){
            char temp = sen.charAt(i);

            for(int j=0; j<roma.length; j++){
                if (temp == roma[j]){
                    if(index < j){
                        num-=romaInt[index]*2;
                    }
                    num+=romaInt[j];
                    index = j;
                    break;
                }
            }
        }
        return num;
    }
    static String numToString(int num){
        String temp = "";
        for(int i=0; i<stringToInt.length; i++){
            while(num - stringToInt[i] >= 0){
                num -= stringToInt[i];
                temp += intToString[i];
            }
        }
        
        return temp;
    }
}
