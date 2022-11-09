package lesson9;

public class StackRunner {

    public static void main(String[] args) {
        Stackable stack = new MyStack(3);
        stack.push(1);
        stack.push(10);
        stack.push(100);
        System.out.println("Is full? " + stack.isFull());
        System.out.println("Is empty? " + stack.isEmpty());
        System.out.println("Check top element: " + stack.peek());
        stack.pop();
        System.out.println("Check top element: " + stack.peek());
        System.out.println("Check size: " + stack.size());
        stack.pop();
        System.out.println("Check top element: " + stack.peek());
        System.out.println("Check size: " + stack.size());
        stack.pop();
        System.out.println("Is full? " + stack.isFull());
        System.out.println("Is empty? " + stack.isEmpty());
    }
}
