package DataStructures.Stack;

public class Driver
{
    public static void main(String[] args)
    {
        Stack<Integer> stack = new Stack<>(5);
        System.out.println(stack.toString());
        stack.push(4);
        System.out.println(stack.toString());
        stack.push(3);
        System.out.println(stack.toString());
        stack.push(2);
        System.out.println(stack.toString());
        stack.push(1);
        System.out.println(stack.toString());

        stack.pop();
        System.out.println(stack.toString());
        stack.pop();
        System.out.println(stack.toString());
        stack.pop();
        System.out.println(stack.toString());
        stack.pop();
        System.out.println(stack.toString());
        stack.pop();
        System.out.println(stack.toString());


    }


}
