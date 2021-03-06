package com.zeetcode.string.decode;

import java.util.Stack;

/**
 * implement a basic calculator to evaluate a simple expression string.
 * The expression string may contain open ( and closing parentheses ), the plus
 * + or minus sign -, non-negative integers and empty spaces .
 */
public class BasicCalculator {
	public int calculate(String s) {
		Stack<Integer> stack = new Stack<Integer>();
		int result = 0, sign = 1;

		for (int i = 0; i < s.length(); i++) {
			if (Character.isDigit(s.charAt(i))) {
				int sum = s.charAt(i) - '0';
				while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
					sum = sum * 10 + s.charAt(i + 1) - '0';
					i++;
				}

				result += sum * sign;
			} else if (s.charAt(i) == '+') {
				sign = 1;
			} else if (s.charAt(i) == '-') {
				sign = -1;
			} else if (s.charAt(i) == '(') {
				stack.push(result);
				stack.push(sign);
				result = 0;
				sign = 1;
			} else if (s.charAt(i) == ')') {
				// first pop is sign
				result = result * stack.pop() + stack.pop();
			}
		}

		return result;

	}

	public static void main(String[] args) {
		BasicCalculator b = new BasicCalculator();

	}
}
