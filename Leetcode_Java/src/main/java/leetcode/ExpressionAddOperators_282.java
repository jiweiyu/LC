package leetcode;
import java.util.ArrayList;
import java.util.List;
public class ExpressionAddOperators_282 {

    public List<String> addOperators(String num, int target) {
        List<String> list = new ArrayList<>();
        dfs(0, 0, 0, new StringBuilder(), num, target, list);
        return list;
    }

    private void dfs(int index, long pre, long res, StringBuilder sb, String num, int target, List<String> list) {
        if (index == num.length()) {
            if (res == target) list.add(sb.toString());
            return;
        }

        long val = 0;
        for (int i = index; i < num.length(); i++) {
            val = val * 10 + num.charAt(i) - '0';
            if (index == 0) {
                sb.append(val);
                dfs(i + 1, val, val, sb, num, target, list);
                sb.setLength(sb.length() - (i - index + 1));
            } else {
                sb.append('+').append(val);
                dfs(i + 1, val, res + val, sb, num, target, list);
                sb.setLength(sb.length() - (i - index + 2));

                sb.append('-').append(val);
                dfs(i + 1, -val, res - val, sb, num, target, list);
                sb.setLength(sb.length() - (i - index + 2));

                sb.append('*').append(val);
                dfs(i + 1, pre * val, res - pre + pre * val, sb, num, target, list);
                sb.setLength(sb.length() - (i - index + 2));
            }
            if (val == 0) break;
        }
    }
}
