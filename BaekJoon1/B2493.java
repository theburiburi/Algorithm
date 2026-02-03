import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;


public class B2493{ //2493
    static class building{
        int place;
        int height;
        building(int place, int height){
            this.place = place;
            this.height = height;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        Stack<building> stack = new Stack<>();
        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i=1; i<N+1; i++){
            building temp = new building(i, Integer.parseInt(st.nextToken()));
            building left;
            if(stack.size()==0){
                sb.append("0 ");
                stack.add(temp);
            }
            else{
                while(!stack.isEmpty()){
                    left = stack.peek();
                    if(left.height < temp.height){
                        stack.pop();
                        if(stack.isEmpty()){
                            sb.append("0 ");
                            stack.add(temp);
                            break;
                        }
                    }
                    else{
                        sb.append(left.place+" ");
                        stack.add(temp);
                        break;
                    }
                }
            }
        }
        System.out.println(sb.toString());
    }
}
