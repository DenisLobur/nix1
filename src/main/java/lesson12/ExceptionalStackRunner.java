package lesson12;

public class ExceptionalStackRunner {


    public static void main(String[] args) {
        ExceptionalStack exceptionalStack = new ExceptionalStack(1);
        ExceptionalStack emptyStack = new ExceptionalStack(0);

        try {
            exceptionalStack.push(1);
            //TODO: uncomment to throw Exception
            //exceptionalStack.push(2);
        } catch (StackFullException e) {
            System.out.printf("This stack can't handle more items. %s", e.getMessage());
        }

        System.out.println(exceptionalStack.popIfPresent());

        try {
            int i = emptyStack.pop();
            System.out.println(i);
        } catch (StackEmptyException e) {
            System.out.printf("This stack could have had more items. %s", e.getMessage());
        }

    }
}
