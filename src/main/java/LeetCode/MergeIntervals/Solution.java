package LeetCode.MergeIntervals;

import java.util.*;

public class Solution
{
    public static void main(String[] args)
    {
        System.out.println(Arrays.deepToString(merge2(new int[][]{{1,3}, {2,6}, {8,10}, {15,18}})));
        System.out.println(Arrays.deepToString(merge2(new int[][]{{1,4}, {4,5}})));
        System.out.println(Arrays.deepToString(merge2(new int[][]{{1,4},{0,4}})));
        System.out.println(Arrays.deepToString(merge2(new int[][]{{1,4},{1,5}})));
        System.out.println(Arrays.deepToString(merge2(new int[][]{{1,4},{0,0}})));
        System.out.println(Arrays.deepToString(merge2(new int[][]{{1,4},{0,1}})));
        System.out.println(Arrays.deepToString(merge2(new int[][]{{1,4},{0,2},{3,5}})));
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
                temp.add(Integer.min(current[0], next[0]));
                temp.add(Integer.max(current[1], next[1]));
                tempAnswer.add(temp);
                current = queue.pollFirst();
            }

//            if (queue.isEmpty())
//            {
//                temp = new ArrayList<>();
//                temp.add(next[0]);
//                temp.add(next[1]);
//                tempAnswer.add(temp);
//            }
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
