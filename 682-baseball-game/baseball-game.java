import java.util.*;

class Solution {
    public int calPoints(String[] ops) {
        Deque<Integer> stack = new ArrayDeque<>();
        int sum = 0;

        for (String op : ops) {
            if (op.equals("+")) {
                int a = stack.pop();
                int b = stack.peek();
                int val = a + b;
                stack.push(a);
                stack.push(val);
                sum += val;
            } else if (op.equals("D")) {
                int val = stack.peek() * 2;
                stack.push(val);
                sum += val;
            } else if (op.equals("C")) {
                sum -= stack.pop();
            } else {
                int val = Integer.parseInt(op);
                stack.push(val);
                sum += val;
            }
        }
        return sum;
    }
}