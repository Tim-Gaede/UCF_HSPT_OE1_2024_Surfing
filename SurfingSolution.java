import java.io.*;
import java.util.*;
import java.math.BigInteger;
import java.math.BigInteger.*;
public class SurfingSolution {
    public static void main(String[] args) throws FileNotFoundException {
        File dir = new File("../surfing");
        File[] directoryListing = dir.listFiles();
        String path = "surfing";
        int counter = 1;
        if(directoryListing!=null){
            for (File child:directoryListing){
                if(!child.getName().endsWith(".in"))continue;
                PrintWriter out = new PrintWriter(new File(path+threeDigit(counter)+".out"));
                Scanner scan = new Scanner(child);
                int w = scan.nextInt();
                int n = scan.nextInt();
                int[] a=  new int[w];
                int[] b = new int[w];
                long sumA = 0, sumB = 0;
                long mostLeft = n*2;
                long mostRight = -1*n*2;
                for(int i = 0;i<w;i++){
                    a[i] = scan.nextInt();
                    b[i] = scan.nextInt();
                    sumA+=a[i];
                    sumB+=b[i];
                    mostLeft = Math.min(sumA,mostLeft);
                    mostRight = Math.max(sumB,mostRight);
                }
                long gap = mostRight-mostLeft;
                if(gap<=2*n && mostLeft >= -n*2 && mostRight <= n*2){
                    out.println("Hang ten, dude!");
                }else{
                    out.println("Free fallin'");
                }
                counter++;
                out.flush();
                out.close();
            }
        }else{
            System.out.println("it's alright try again!");
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
