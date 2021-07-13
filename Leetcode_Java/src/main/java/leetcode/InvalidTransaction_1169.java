package leetcode;
import java.util.*;
public class InvalidTransaction_1169 {

    public class Transaction {

    String name;
    int time;
    int amount;
    String city;
    public Transaction (String name, int time, int amount, String city) {
        this.name = name;
        this.time = time;
        this.amount = amount;
        this.city = city;
    }
    public String flatten() {
        return this.name + "," + this.time + "," + this.amount + "," + this.city;
    }
}

    public List<String> invalidTransactions(String[] transactions){
        //Runtime: 40 ms, faster than 36.63% of Java online submissions for Invalid Transactions.
        //Memory Usage: 39.8 MB, less than 93.77% of Java online submissions for Invalid Transactions.
        Set<String> out = new HashSet<>();
        Map<String,List<Transaction>> perPerson = new HashMap<>();

        for (String trans: transactions) {
            String[] split = trans.split(",");
            String name = split[0];
            int time = Integer.valueOf(split[1]);
            int amount = Integer.valueOf(split[2]);
            String city = split[3];

            if (amount > 1000) {
                out.add(trans);
            }

            List<Transaction> otherTransactions = perPerson.get(name);

            if (otherTransactions == null) {
                otherTransactions = new ArrayList<>();
                otherTransactions.add(new Transaction(name,time,amount,city));
                perPerson.put(name,otherTransactions);
            }
            else {
                for (Transaction transa : otherTransactions) {
                    if (!transa.city.equals(city) && Math.abs(transa.time - time) <=60) {
                        out.add(transa.flatten());
                        out.add(trans);
                    }
                }
                otherTransactions.add(new Transaction(name, time, amount, city));
            }


        }

        return new ArrayList<String>(out);
    }
}
