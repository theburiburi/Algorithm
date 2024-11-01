import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int DDD, hh, mm;
    static int F;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String line[] = br.readLine().split(" ");
        HashMap <String, String> rent = new HashMap<>();
        HashMap <String, Long> fine = new HashMap<>();
        
        N = Integer.parseInt(line[0]);
        DDD = Integer.parseInt(line[1].substring(0, 3));
        hh = Integer.parseInt(line[1].substring(4,6));
        mm = Integer.parseInt(line[1].substring(7,9));
        F = Integer.parseInt(line[2]);

        long rentRange = DDD*1440 + hh*60 + mm;

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String date = st.nextToken();
            String time = st.nextToken();
            String stuff = st.nextToken();
            String user = st.nextToken();
            String id = user + "_" + stuff;

            if(rent.containsKey(id)){
                String stringTime1 = rent.get(id);
                String stringTime2 = date+" "+time;
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

                long rentTime = (sdf.parse(stringTime2).getTime() - sdf.parse(stringTime1).getTime()) / (1000*60);
                if(rentRange < rentTime){
                    if(fine.containsKey(user)){
                        fine.put(user, fine.get(user)+(rentTime-rentRange)*F);
                    }
                    else{
                        fine.put(user, (rentTime-rentRange)*F);
                    }
                }
                rent.remove(id);
            }
            else{
                rent.put(id, date+" "+time);
            }
        }

        if(fine.size() > 0){
            ArrayList <String> al = new ArrayList<>(fine.keySet());
            StringBuilder sb = new StringBuilder();
            al.sort((s1,s2)->s1.compareTo(s2));
            for(String temp : al){
                sb.append(temp+" "+fine.get(temp)).append("\n");
            }
            System.out.println(sb.toString());
        }
        else{
            System.out.println(-1);
        }
    }
}