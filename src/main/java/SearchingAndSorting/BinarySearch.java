package SearchingAndSorting;

public class BinarySearch
{
    public final int[] SORTED_ARRAY = {1,3,5,6,7,9,12,15,17,19,20};


    public static void main(String[] args)
    {
        BinarySearch bs = new BinarySearch();
        System.out.println(bs.findIndex(bs.SORTED_ARRAY, 7));
    }

    public int findIndex(int[] sortedArray, int numberToFind)
    {
        int low = 0;
        int high = sortedArray.length - 1;

        while (low <= high)
        {
            int mid = (low + high) / 2;
            if (sortedArray[mid] == numberToFind)
                return mid;

            if (sortedArray[mid] < numberToFind)
                low = mid+1;
            if (sortedArray[mid] > numberToFind)
                high = mid;
        }

        return -1;
    }


}
