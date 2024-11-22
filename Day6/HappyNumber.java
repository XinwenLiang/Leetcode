package Day6;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public boolean isHappy(int n){
        Set<Integer> result = new HashSet<>();
        while (n != 1 && !result.contains(n)) {
            result.add(n);
            n = sumOfSquares(n);
        }
        return n == 1;

    }

    public int sumOfSquares(int num) {
        int sum = 0;
        while (num > 0) {
            int digit = num % 10;
            sum = sum + digit * digit;
            num = num / 10;
        }
        return sum;
    }

}
