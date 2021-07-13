package facebook;

public class ChangeInAForeignCurrency {

    boolean canGetExactChange(int targetMoney, int[] denominations) {
        // Write your code here
        if(targetMoney < 0) return false;
        if(targetMoney == 0) return true;
        for(int d : denominations){
            if(canGetExactChange(targetMoney - d, denominations)){
                return true;
            }
        }
        return false;
    }
}
