package Model;

import java.util.Stack;

public class MyStack<T> implements MyIStack<T> {
    Stack<T> stack = new Stack<T>();

    @Override
    public T pop() {
        return stack.pop();
    }

    @Override
    public void push(T v) {
        stack.push(v);
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public String toString() {
        return stack.toString();
    }
}
