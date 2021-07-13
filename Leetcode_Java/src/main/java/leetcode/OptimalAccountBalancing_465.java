package leetcode;
import java.util.*;
public class OptimalAccountBalancing_465 {

    //? what does it mean to settle the debt
    //nobody owes others
    //
    //? how do we represent how much money a person owes others
    //We build current debt situation debt[], e.g. debt[i] = 10 means a person owes others 10
    //
    //? how do we settle one's debt
    //assuming [0, curId - 1] has been settled,
    //for debt[curId],
    //any curId + 1 <= i <debt.length such that debt[i] * debt[curId] < 0 can settle it
    //
    //state
    //The next account to balance, curId, can uniquely identify a state
    //state function
    //state(debt[], curId) is the minimum transactions to balance debts[curId...debtLength - 1] such that debts[0...curId-1] are balanced.
    //goal state
    //state(initial debt[], 0)
    //state transition
    //now: state(debt[], curId)
    //next: state (debt[] after balance curId, curId + 1)
    //
    //state(debt[], curId) = 1 + min(state (debt[] after balance curId, curId + 1))

    public int minTransfers(int[][] transactions) {
        int[] debt = buildDebtArray(transactions); // Debt amount to balance for each person.

        return getMinTransfersAfter(0, debt);
    }

    private int getMinTransfersAfter(int curId, int[] debt) {
        while (curId < debt.length && debt[curId] == 0)
            curId++;
        // Base case.
        if (curId == debt.length)
            return 0;
        // Recursive case.
        int minTransactions = Integer.MAX_VALUE;
        for (int i = curId + 1; i < debt.length; i++) {
            if (debt[i] * debt[curId] < 0) {
                debt[i] += debt[curId];
                minTransactions = Math.min(minTransactions, getMinTransfersAfter(curId + 1, debt) + 1);
                debt[i] -= debt[curId];
            }
        }

        return minTransactions;
    }

    private int[] buildDebtArray(int[][] transactions) {
        Map<Integer, Integer> debtMap = new HashMap<>(); // Map person ID to debt amount.

        for (int[] transaction : transactions) {
            int giver = transaction[0];
            int taker = transaction[1];
            int amount = transaction[2];
            debtMap.put(giver, debtMap.getOrDefault(giver, 0) + amount);
            debtMap.put(taker, debtMap.getOrDefault(taker, 0) - amount);
        }

        int[] debt = new int[debtMap.size()];
        int i = 0;
        for (int amount : debtMap.values()) {
            debt[i++] = amount;
        }

        return debt;
    }

    public int minTransfers_(int[][] transactions) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int[] t : transactions) {
            m.put(t[0], m.getOrDefault(t[0], 0) - t[2]);
            m.put(t[1], m.getOrDefault(t[1], 0) + t[2]);
        }
        return settle(0, new ArrayList<>(m.values()));
    }

    int settle(int start, List<Integer> debt) {
        while (start < debt.size() && debt.get(start) == 0)
            start++;
        if (start == debt.size()) return 0;
        int r = Integer.MAX_VALUE;
        for (int i = start + 1; i < debt.size(); i++)
            if (debt.get(start) * debt.get(i) < 0) {
                debt.set(i, debt.get(i) + debt.get(start));
                r = Math.min(r, 1 + settle(start + 1, debt));
                debt.set(i, debt.get(i) - debt.get(start));
            }
        return r;
    }
}
