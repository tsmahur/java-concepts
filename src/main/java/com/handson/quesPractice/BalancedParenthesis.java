package com.handson.quesPractice;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BalancedParenthesis {
    public static void main(String[] args){

        String expression="{[(){[]}]([])}";
        String unBalancedExpression="{[(){[}]]}";

        System.out.println("expression : "+expression);
        System.out.println("isBalanced : "+isBalanced(expression));

        System.out.println("unBalancedExpression : "+unBalancedExpression);
        System.out.println("isBalanced : "+isBalanced(unBalancedExpression));
    }
    public static boolean isBalanced(String expression){
        Stack<Character> stack = new Stack<>();
        Map<Character,Character> expMap= new HashMap<>();
        expMap.put('{','}');
        expMap.put('[',']');
        expMap.put('(',')');
        for(Character ch:expression.toCharArray()){
            if(expMap.containsKey(ch)) stack.push(ch);//if opening parenthesis then push
            else if(stack.isEmpty() || expMap.get(stack.pop())!=ch) return false; //pop top opening parenthesis and get corresponding closing parenthesis and then match current closing with last pushed parenthesis
        }
        return stack.isEmpty();//if stack is empty means all the closing parenthesis are matched with opening parenthesis
    }

}
