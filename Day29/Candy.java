package Day29;

public class Candy {
    public int candy(int[] ratings) {
        int len = ratings.length;
        int[] Candy = new int[len];
        Candy[0] = 1;
        for (int i = 1; i < len; i++) {
            if(ratings[i] > ratings[i-1]){
                Candy[i] = Candy[i-1] + 1;
            }else{
                Candy[i] = 1;
            }
        }
        for (int i = len - 2; i >= 0 ; i--) {
            if(ratings[i] > ratings[i+1]){
                Candy[i] = Math.max(Candy[i+1] + 1, Candy[i]);
            }
        }
        int result = 0;
        for (int i = 0; i < len; i++) {
            result += Candy[i];
        }
        return result;
    }
}
