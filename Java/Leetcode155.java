import java.util.*;

public class Leetcode155 {

}

// 最小栈

// 维护两个栈
// 一个栈放数据, 一个栈放最小值
class MinStack {

    public Stack<Integer> data;
    public Stack<Integer> min;

    public MinStack() {
        data = new Stack<Integer>();
        min = new Stack<Integer>();
    }

    public void push(int val) {
        data.push(val);
        if (min.isEmpty() || val <= min.peek()) {
            min.push(val);
        } else { // !min.isEmpty() && val > min.peek()
            // 如果不是更小的数, 那就把栈顶再压一遍, 保持单调性
            min.push(min.peek());
        }
    }

    public void pop() {
        data.pop();
        min.pop();
    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
        return min.peek();
    }
}

// 用数组实现
class MinStack2 {
    // leetcode的数据在测试时，同时在栈里的数据不超过这个值
    // 这是几次提交实验出来的，哈哈
    // 如果leetcode补测试数据了，超过这个量导致出错，就调大
    public final int MAXN = 8001;

    public int[] data;
    public int[] min;
    int size;

    public MinStack2() {
        data = new int[MAXN];
        min = new int[MAXN];
        size = 0;
    }

    public void push(int val) {
        data[size] = val;
        if (size == 0 || val <= min[size - 1]) {
            min[size] = val;
        } else {
            min[size] = min[size - 1];
        }
        size++;
    }

    public void pop() {
        size--;
    }

    public int top() {
        return data[size - 1];
    }

    public int getMin() {
        return min[size - 1];
    }
}

// 用数组的第二位记录此时的 curMin
class MinStack3 {
    public Stack<int[]> stack;

    public MinStack3() {
        stack = new Stack<int[]>();
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(new int[] { val, val });
        } else {
            int curMin = stack.peek()[1];
            stack.push(new int[] { val, Math.min(val, curMin) });
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek()[0];
    }

    public int getMin() {
        return stack.peek()[1];
    }

}