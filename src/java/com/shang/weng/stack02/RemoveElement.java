package com.shang.weng.stack02;

import java.util.Stack;

public class RemoveElement {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
//        stack.push(3);
        int andRemoveLastElement = getAndRemoveLastElement(stack);
        System.out.println(andRemoveLastElement);
    }

    /**
     * 一个栈中数据，54321,12345
     * 1-找到这个最底下的，最后放入空栈中，所以是迭代器最初始最底下的。
     * 2-如何得到最下层的，我们先把所有的拿出来，再把倒第二个抛出来
     */
    public static int getAndRemoveLast(Stack<Integer> stack) {
        Integer result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        } else {
            int last = getAndRemoveLast(stack);
            stack.push(result);
            return last;
        }
    }

    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        } else {
            int andRemoveLast = getAndRemoveLast(stack);
            reverse(stack);
            stack.push(andRemoveLast);
        }
    }

    public static int getAndRemoveLastElement(Stack<Integer> stack) {
        Integer result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        } else {
            int last = getAndRemoveLastElement(stack);
            stack.push(result);
            return last;
        }
    }
}
