public class IntPower {
    public static void main(String[] args){
        int num_base = 2, num_exp = 4;
        int result = 1;
        while(num_exp != 0){
            result = result * num_base;
            num_exp = num_exp - 1;
        }
        System.out.println("Answer = " + result);
    }
}
