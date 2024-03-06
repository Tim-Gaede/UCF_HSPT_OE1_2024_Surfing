import java.io.*;
import java.util.*;
import java.math.*;
public class SurfingGenerator {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        String path = "surfing";
        int counter = 10;
        int[][] distri = {{-100,-50},{-2000,-1000},{10000,20000},{-1,1},
                                {-1000000000,1000000000},{-10000000,10000000},{-100000,100000},{-1337,10000}};
        for(int i = 0;i<12;i++){
            PrintWriter out = new PrintWriter(new File(path+threeDigit(counter)+".in"));
            int w = (int)(Math.random()*5)+99_996;
            int n = (int)(Math.random()*1_000_000_000)+1;
            if(i>=8 && n>1e7){
                n/=100;
            }
            int range = distri[i%8][1] - distri[i%8][0]+1;
            while(n<range+distri[i%8][0]-1){
                n = (int)(Math.random()*1_000_000_000)+1;
            }
            out.println(w+" "+n);
            for(int j = 0;j<w;j++){
                int numa = (int)(Math.random()*range)+distri[i%8][0];
                int numb = -1000000007;
                while(numb<numa){
                    numb = (int)(Math.random()*range)+distri[i%8][0];
                }
                out.println(numa+" "+numb);
            }
            out.println();
            out.flush();
            out.close();
            counter++;
        }
    }
    public static String threeDigit(int n){
        String s = Integer.toString(n);
        while(s.length()<3){
            s = "0"+s;
        }
        return s;
    }
}
