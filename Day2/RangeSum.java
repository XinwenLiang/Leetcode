package Day2;

import java.util.Scanner;

public class RangeSum {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int n = myScanner.nextInt();
        int[] vec = new int[n];
        int[] p = new int[n];
        int preSum = 0;
        for (int i = 0; i < n; i++) {
            vec[i] = myScanner.nextInt();
            preSum += vec[i];
            p[i] = preSum;
        }

        while (myScanner.hasNextInt()){
            int a = myScanner.nextInt();
            int b = myScanner.nextInt();

            int sum;
            if(a==0){
                sum = p[b];
            }else{
                sum = p[b] - p[a-1];
            }
            System.out.println(sum);
        }
        myScanner.close();
    }
}
