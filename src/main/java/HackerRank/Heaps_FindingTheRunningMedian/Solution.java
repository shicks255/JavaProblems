package HackerRank.Heaps_FindingTheRunningMedian;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Solution
{
    public static BigDecimal currentAverage = null;

    public static void main(String[] args)
    {
        Heap minHeap = new Heap();
        Heap maxHeap = new Heap();

        addAndCalculate(1, minHeap, maxHeap);
        addAndCalculate(2, minHeap, maxHeap);
        addAndCalculate(3, minHeap, maxHeap);
        addAndCalculate(4, minHeap, maxHeap);
        addAndCalculate(5, minHeap, maxHeap);
        addAndCalculate(6, minHeap, maxHeap);
        addAndCalculate(7, minHeap, maxHeap);
        addAndCalculate(8, minHeap, maxHeap);
        addAndCalculate(9, minHeap, maxHeap);
        addAndCalculate(10, minHeap, maxHeap);

        String test = "howdidido";
    }

    public static void addAndCalculate(int number, Heap min, Heap max)
    {
        if (currentAverage == null)
        {
            currentAverage = new BigDecimal("" + number);
            min.add(number);
        }
        else
        {
            if (currentAverage.compareTo(new BigDecimal("" + number)) > 0)
                max.add(number);
            if (currentAverage.compareTo(new BigDecimal("" + number)) < 0)
                min.add(number);
        }

        DecimalFormat f = new DecimalFormat("0.0");
        if (min.size % 2 != 0)
        {
            int index = (min.size / 2) -1;
            if (index < 0)
                index = 0;

            System.out.println(f.format(min.heap[index]));
            currentAverage = new BigDecimal(min.heap[index] + "");
        }
        else
        {
            BigDecimal first = new BigDecimal("" + min.heap[0]);
            BigDecimal second = new BigDecimal("" + max.heap[0]);

            BigDecimal answer = first.add(second);
            answer = answer.divide(new BigDecimal("2"));
            answer = answer.setScale(2, RoundingMode.HALF_UP);
            System.out.println(f.format(answer));
            currentAverage = answer;
        }

    }
}