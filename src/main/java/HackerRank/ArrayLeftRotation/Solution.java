package HackerRank.ArrayLeftRotation;

import java.util.Scanner;

public class Solution
{
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args)
    {
//        String[] nd = scan.nextLine().split(" ");
//        int n = Integer.parseInt(nd[0].trim());
//        int d = Integer.parseInt(nd[1].trim());
//        int[] a = new int[n];

//        String[] aItems = scan.nextLine().split(" ");

//        for (int aItr = 0; aItr < n; aItr++) {
//            int aItem = Integer.parseInt(aItems[aItr].trim());
//            a[aItr] = aItem;
//        }

        int n = 2000000;

        int[] a = new int[n];
        for (int i = 0; i < n ; i++)
            a[i] = i+1;

        int d = 20000;

        printArrayRotated(a, d);
    }


    /*
        make a temp variable for the first item,
        then loop through rest of items, shifting them 1 to the left
        add temp item to the end

        Time Analysis:
        d = number of rotates
        n = size of array

        d for the while loop
        n for for loop

        o(dn)
     */
    public static void printArrayRotated(int[] array, int rotate)
    {
        long startTime = System.currentTimeMillis();
        while (rotate > 0)
        {
            int temp = array[0];

            for (int a = 1; a < array.length; a++)
                array[a-1] = array[a];

            array[array.length-1] = temp;

            rotate--;
        }

        System.out.println(array);

//        long totalTime = System.currentTimeMillis() - startTime;
//        System.out.println(totalTime / 1000.00);
//        System.out.println(Arrays.toString(array));
    }

}
