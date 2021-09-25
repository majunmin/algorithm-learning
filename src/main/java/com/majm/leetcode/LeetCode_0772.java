package com.majm.leetcode;

import com.majm.Solution;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * 基本计算器3 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2021-09-25 19:47
 * @since
 */
public class LeetCode_0772 implements Solution {


    @Override
    public int calculate(String s) {
        List<String> pe = parsePE(s);
        int res = evalPE(pe);
        return res;
    }

    private List<String> parsePE(String s) {
        List<String> list = new LinkedList<>();
        Deque<String> opStack = new LinkedList<>();
        final char[] chars = s.toCharArray();
        int num = -1;
        for (int i = chars.length - 1; i >= 0; i--) {
            char c = chars[i];
            if (c == ' ') {
                continue;
            }
            if (c >= '0' && c <= '9') {
                if (num == -1) {
                    num = c - '0';
                } else {
                    num = num + (c - '0') * 10;
                }
            } else {
                if (num != -1) {
                    list.add(0, String.valueOf(num));
                    num = -1;
                }
                if (c == ')') {
                    opStack.push(")");
                } else if (c == '(') {
                    while (!Objects.equals(opStack.peek(), ")")) {
                        list.add(0, opStack.pop());
                    }
                    opStack.pop();
                } else {
                    // 运算符
                    String op = String.valueOf(c);
                    while (!opStack.isEmpty()) {
                        if (Objects.equals(opStack.peek(), ")")) {
                            break;
                        }
                        if (getPriority(op) >= getPriority(opStack.peek())) {
                            break;
                        }
                        list.add(0, opStack.pop());
                    }
                    opStack.push(op);
                }
            }
        }
        if (num != -1) {
            list.add(0, String.valueOf(num));
        }
        while (!opStack.isEmpty()) {
            list.add(0, opStack.pop());
        }

        return list;
    }

    /**
     * 解析 波兰表达式
     * ++a*bc**+*efg
     *
     * @param pe
     * @return
     */
    private int evalPE(List<String> pe) {
        Deque<String> stack = new LinkedList<>();
        // 从右向左遍历
        for (int i = pe.size() - 1; i >= 0; i--) {
            String curStr = pe.get(i);
            if (curStr.charAt(0) >= '0' && curStr.charAt(0) <= '9') {
                stack.push(curStr);
            } else {
                int num = 0;
                int num1 = parseInt(stack.pop());
                int num2 = parseInt(stack.pop());
                switch (curStr) {
                    case "+":
                        num = num1 + num2;
                        break;
                    case "-":
                        num = num1 - num2;
                        break;
                    case "*":
                        num = num1 * num2;
                        break;
                    case "/":
                        num = num1 / num2;
                        break;
                    default:
                        throw new IllegalArgumentException("Unexcept error.");
                }
                stack.push(String.valueOf(num));
            }
        }
        return parseInt(stack.pop());
    }

    /**
     * 逆波兰表达式解法
     *
     * @param s
     * @return
     */
    private int solution1(String s) {
        List<String> rpe = parseRPE(s);
        int result = evalRPE(rpe);
        return result;
    }


    /**
     * 逆波兰表达式
     * <p>
     * rpe 表达式仅包含 {@text 数字 +-/*}
     *
     * @param rpe
     * @return
     */
    private int evalRPE(List<String> rpe) {

        Deque<String> stack = new LinkedList<>();

        for (String item : rpe) {
            if (item.charAt(0) >= '0' && item.charAt(0) <= '9') {
                stack.push(item);
            } else {
                int num1 = parseInt(stack.pop());
                int num2 = parseInt(stack.pop());
                int result;
                if (!validOperator(item)) {
                    throw new IllegalArgumentException("");
                }
                switch (item) {
                    case "+":
                        result = num2 + num1;
                        break;
                    case "-":
                        result = num2 - num1;
                        break;
                    case "*":
                        result = num2 * num1;
                        break;
                    default:
                        result = num2 / num1;
                        break;
                }
                stack.push(String.valueOf(result));
            }
        }
        return Integer.parseInt(stack.pop());
    }

    private boolean validOperator(String operator) {
        return "+".equals(operator) || "-".equals(operator)
                || "*".equals(operator) || "/".equals(operator);
    }

    private int parseInt(String item) {
        return Integer.parseInt(item);
    }


    /**
     * 将中最表达式转化为  逆波兰表达式
     * 1. 遇到数字直接 放入 list
     * 2. 遇到 符号
     * 2.1  `(` 直接放入
     * 2.2  `)` 将栈中 所有的字符 pop 放入到结果集
     * 2.3  `符号`
     * 2.3.1 符号优先级 <= 栈顶元素优先级,直接放入
     * 2.3.2 符号优先级 > 栈顶元素优先级,将栈中元素pop 并放入结果集, 直到遇到 `(` 或者 栈 为空
     *
     * @param s
     * @return
     */
    private List<String> parseRPE(String s) {
        List<String> rpe = new ArrayList<>();
        Deque<String> stack = new LinkedList<>();
        int num = -1;
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                continue;
            }
            // 是一个数字
            if (c >= '0' && c <= '9') {
                if (num == -1) {
                    num = c - '0';
                } else {
                    num = num * 10 + (c - '0');
                }
            } else {
                //判断数字
                if (num != -1) {
                    rpe.add(String.valueOf(num));
                    num = -1;
                }

                if (c == '(') {
                    stack.push(String.valueOf(c));
                } else if (c == ')') {
                    while (!stack.isEmpty()) {
                        if (!"(".equals(stack.peek())) {
                            rpe.add(stack.pop());
                        } else {
                            stack.pop();
                            break;
                        }
                    }
                } else {
                    // + - * /
                    while (!stack.isEmpty()) {
                        if ("(".equals(stack.peek())) {
                            break;
                        }
                        if (getPriority(String.valueOf(c)) > getPriority(stack.peek())) {
                            break;
                        }
                        rpe.add(stack.pop());
                    }
                    stack.push(String.valueOf(c));
                }
            }
        }
        if (num != -1) {
            rpe.add(String.valueOf(num));
        }
        while (!stack.isEmpty()) {
            rpe.add(stack.pop());
        }
        return rpe;
    }

    private int getPriority(String op) {
        switch (op) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            default:
                throw new IllegalArgumentException("Unexpected value: " + op);
        }
    }

    public static void main(String[] args) {
        Solution leetCode = new LeetCode_0772();
        System.out.println(leetCode.calculate("6 - 4/2"));
        System.out.println(leetCode.calculate("(2 + 6*3 +5 - (3*14/7+2) *5)+3"));
    }

}
