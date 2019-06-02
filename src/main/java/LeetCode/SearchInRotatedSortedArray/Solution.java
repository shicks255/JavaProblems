package LeetCode.SearchInRotatedSortedArray;

public class Solution
{
    public static void main(String[] args)
    {
//        System.out.println(search(new int[]{4,5,6,7,0,1,2}, 0));
//        System.out.println(search(new int[]{4,5,6,7,0,1,2}, 3));
//        System.out.println(search(new int[]{4,5,6,7,0,1,2}, 4));
//        System.out.println(search(new int[]{4,5,6,7,0,1,2}, 2));
//        System.out.println(search(new int[]{3,1}, 1));
        System.out.println(search(new int[]{3,5,1}, 1));
    }

    public static int search(int[] nums, int target)
    {
        if (nums.length == 0)
            return -1;
        if (nums.length == 1)
            return nums[0] == target ? 0 : -1;
        if (nums.length < 3)
        {
            if (nums[0] == target)
                return 0;
            if (nums[1] == target)
                return 1;
            return -1;
        }

        int pivot = 0;
        int current = 0;
        int next = 1;
        while (nums.length-1 >= next)
        {
            int currentValue = nums[current];
            int nextValue = nums[next];

            if (nextValue < currentValue)
                pivot = next;
            current++;
            next++;
        }

        int left = search(nums, 0, pivot, target);
        if (left >= 0)
            return left;

        int right = search(nums, pivot, nums.length-1, target);
        if (right >= 0)
            return right;

        return -1;
    }

    private static int search(int[] nums, int left, int right, int target)
    {
        while (left <= right)
        {
            int mid = (left+right)/2;
            int midValue = nums[mid];

            if (midValue == target)
                return mid;

            if (midValue < target)
                left = mid+1;
            if (midValue > target)
                right = mid-1;
        }

        return -1;
    }
}
