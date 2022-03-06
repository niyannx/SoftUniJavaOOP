package InheritanceLab.StackOfStrings;

/*
Create a class Stack that can store only strings and has the following functionality:
 Private field: data: ArrayList<String>
 Public method: push(String item): void
 Public method: pop(): String
 Public method: peek(): String
 Public method: isEmpty(): boolean
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        StackOfStrings stack = new StackOfStrings();
        stack.push("one");
        stack.push("two");
        stack.push("three");

        System.out.println(stack.isEmpty());
        System.out.println(stack.peek());

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
