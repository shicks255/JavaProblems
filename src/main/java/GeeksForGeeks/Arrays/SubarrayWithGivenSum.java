package GeeksForGeeks.Arrays;

public class SubarrayWithGivenSum
{
    public static void main(String[] args)
    {
        findSum(new Integer[]{142,112,54,69,148,45,63,158,38,60,124,142,130,179,117,36,191,43,89,107,41,143,65,49,47,6,91,130,171,151,7,102,194,149,30,24,85,155,157,41,167,177,132,109,145,40,27,124,138,139,119,83,130,142,34,116, 40, 59, 105, 131, 178, 107, 74, 187, 22, 146, 125, 73, 71, 30, 178, 174, 98, 113,
        }, 74, 665);
        findSum(new Integer[]{1,2,3,7,5}, 5, 12);
        findSum(new Integer[]{1,2,3,4,5,6,7,8,9,10}, 10, 15);
        findSum(new Integer[]{8,4,1,2,3,5},6,6);
    }

    public static void findSum(Integer[] arr, int n, int s)
    {
        int left = 0;
        int right = 0;

        while (left < n && right < n)
        {
            int sum = 0;
            int tempLeft = left;
            int tempRight = right;
            while (tempLeft <= tempRight)
                sum += arr[tempRight--];

            if (sum == s)
            {
                System.out.println(++left + " " + ++right);
                return;
            }

            if (sum > s)
                left++;
            if (sum < s)
                right++;
        }

        System.out.println(-1);
    }

}
