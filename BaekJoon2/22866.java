import java.io.IOException;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
import java.util.Stack;

public class Main{ //22866 자료구조, 스택
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
   
        Stack <Integer> stack = new Stack<>();
        int N = Integer.parseInt(br.readLine());
        Building[] building = new Building[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++){
            building[i] = new Building(Integer.parseInt(st.nextToken()));
        }

        for(int i=0; i<N; i++){ //left
            while(!stack.isEmpty() && building[stack.peek()].height <= building[i].height){
                stack.pop();
            }
            building[i].count = stack.size();
            if(!stack.isEmpty()){
                building[i].closeIndex = stack.peek();
            }
            stack.push(i);
        }

        stack = new Stack<>();
        for(int i = N-1; i>=0; i--){ //right
            while(!stack.isEmpty() && building[stack.peek()].height <= building[i].height){
                stack.pop();
            }
            building[i].count += stack.size();
            if(!stack.isEmpty()){
                if(stack.peek() - i < Math.abs(building[i].closeIndex - i)){
                    building[i].closeIndex = stack.peek();
                }
            }
            stack.push(i);
        }


        for (int i=0; i<N; i++){
            sb.append(building[i].count).append(" ");
            if (building[i].count > 0) sb.append(building[i].closeIndex + 1); // 건물번호 추가
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    static class Building{
        int closeIndex = Integer.MAX_VALUE;
        int height;
        int count = 0;
        public Building(int height){
            this.height = height;
        }
    }
}