package HackerRank.Queues_ATaleOfTwoStacks;

public class Solution
{
    public static void main(String[] args)
    {

        MyQueue<Integer> myQueue = new MyQueue<>();

//        myQueue.enqueue(92118642);
//        myQueue.dequeue();
//        myQueue.enqueue(107858633);
//        myQueue.enqueue(110186788);
//        myQueue.enqueue(883309178);
//        myQueue.enqueue(430939631);
//        myQueue.dequeue();
//        myQueue.enqueue(739711408);
//        myQueue.enqueue(803703507);
//        myQueue.enqueue(643797161);
//        myQueue.enqueue(538560826);


        myQueue.enqueue(1);
        myQueue.enqueue(2);
        System.out.println(myQueue.peek());  //should be 1
        myQueue.enqueue(3);
        myQueue.dequeue();
        System.out.println(myQueue.peek()); // should be 2
        myQueue.dequeue();
        System.out.println(myQueue.peek()); // should be 2
        myQueue.dequeue();


        String test = "howisit";
    }
}
