package LeetCode.MergeIntervals;

import java.util.*;

public class Solution
{
    public static void main(String[] args)
    {
        System.out.println(Arrays.deepToString(merge4(new int[][]{{1,3}, {2,6}, {8,10}, {15,18}})));
        System.out.println(Arrays.deepToString(merge4(new int[][]{{1,4}, {4,5}})));
        System.out.println(Arrays.deepToString(merge4(new int[][]{{1,4},{0,4}})));
        System.out.println(Arrays.deepToString(merge4(new int[][]{{1,4},{1,5}})));
        System.out.println(Arrays.deepToString(merge4(new int[][]{{1,4},{0,0}})));
        System.out.println(Arrays.deepToString(merge4(new int[][]{{1,4},{0,1}})));
        System.out.println(Arrays.deepToString(merge4(new int[][]{{1,4},{0,2},{3,5}})));
        System.out.println(Arrays.deepToString(merge4(new int[][]{{4,5},{1,4},{0,1}})));
        System.out.println(Arrays.deepToString(merge4(new int[][]{{2,3},{4,5},{6,7},{8,9},{1,10}})));
        System.out.println(Arrays.deepToString(merge4(new int[][]{})));
        System.out.println(Arrays.deepToString(merge4(new int[][]{{1,3}})));
        System.out.println(Arrays.deepToString(merge4(new int[][]{{2,3}, {2,2}, {3,3}, {1,3}, {5,7}, {2,2}, {4,6}})));
    }

    public static int[][] merge4(int[][] intervals)
    {
        if (intervals.length == 0)
            return new int[][]{};

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        Deque<int[]> stack = new ArrayDeque<>();
        stack.push(intervals[0]);
        for (int i = 1; i < intervals.length; i++)
        {
            int[] toCheck = intervals[i];
            int[] temp = stack.peek();
            if (toCheck[0] > temp[1])
                stack.push(toCheck);
            else
            {
                int[] toChange = stack.pop();
                if (toCheck[0] < toChange[0])
                    toChange[0] = toCheck[0];
                if (toCheck[1] > toChange[1])
                    toChange[1] = toCheck[1];

                stack.push(toChange);
            }
        }

        int[][] answer = new int[stack.size()][2];
        int stackSize = stack.size();
        for (int i = stackSize-1; i >= 0; i--)
        {
            int[] popped = stack.pop();
            answer[i][0] = popped[0];
            answer[i][1] = popped[1];
        }

        return answer;
    }


    public static int[][] merge3(int[][] intervals)
    {
        if (intervals.length < 2)
            return intervals;

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        Deque<int[]> stack = new ArrayDeque<>();

        stack.addLast(intervals[0]);

        for (int i = 1; i < intervals.length; i++)
        {
            int[] test = intervals[i];
            int[] fromStack = stack.peekLast();

            if (test[0] > fromStack[1])
                stack.addLast(test);
            else
            {
                if (test[0] < fromStack[0])
                {
                    fromStack[0] = test[1];
                    stack.pollLast();
                    stack.addLast(fromStack);
                }
                if (test[1] > fromStack[1])
                {
                    fromStack[1] = test[1];
                    stack.pollLast();
                    stack.addLast(fromStack);
                }
            }
        }

        int[][] answer = new int[stack.size()][2];
        int counter = 0;
        while (!stack.isEmpty())
        {
            int[] sta = stack.pollFirst();
            answer[counter][0] = sta[0];
            answer[counter][1] = sta[1];
            counter++;
        }
        return answer;
    }

    public static int[][] merge2(int[][] intervals)
    {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<List<Integer>> tempAnswer = new ArrayList<>();

        Deque<int[]> queue = new ArrayDeque<>();
        for (int[] a : intervals)
            queue.addLast(a);

        int[] current = queue.pollFirst();
        while (queue.peekFirst() != null)
        {
            List<Integer> temp = new ArrayList<>();
            int[] next = queue.pollFirst();

            if (current[1] < next[0])
            {
                temp.add(current[0]);
                temp.add(current[1]);
                tempAnswer.add(temp);
                current = next;
            }
            else
            {
                while (queue.peekFirst() != null && queue.peekFirst()[0] <= next[1])
                    next = queue.pollFirst();

                temp.add(Integer.min(current[0], next[0]));
                temp.add(Integer.max(current[1], next[1]));
                tempAnswer.add(temp);
                current = queue.pollFirst();
            }
        }

        if (current != null)
        {
            List<Integer> temp = new ArrayList<>();
            temp.add(current[0]);
            temp.add(current[1]);
            tempAnswer.add(temp);
        }

        int[][] answer = new int[tempAnswer.size()][2];
        for (int i = 0; i < tempAnswer.size(); i++)
        {
            answer[i][0] = tempAnswer.get(i).get(0);
            answer[i][1] = tempAnswer.get(i).get(1);
        }

        return answer;
    }

    public static int[][] merge(int[][] intervals)
    {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<List<Integer>> tempAnswer = new ArrayList<>();
        int size = intervals.length-1;
        int start = 0;
        while (start <= size)
        {
            int[] current = intervals[start];
            if (start == size)
            {
                List<Integer> list = new ArrayList<>();
                list.add(current[0]);
                list.add(current[1]);
                tempAnswer.add(list);
                break;
            }

            int[] next = intervals[++start];

            List<Integer> temp = new ArrayList<>();
            if (current[1] < next[0])
            {
                temp.add(current[0]);
                temp.add(current[1]);
            }
            else
            {
                temp.add(Integer.min(current[0], next[0]));
                temp.add(Integer.max(current[1], next[1]));

                start++;
            }

            tempAnswer.add(temp);
        }

        int[][] answer = new int[tempAnswer.size()][2];
        for (int i = 0; i < tempAnswer.size(); i++)
        {
            answer[i][0] = tempAnswer.get(i).get(0);
            answer[i][1] = tempAnswer.get(i).get(1);
        }

        return answer;
    }

}
