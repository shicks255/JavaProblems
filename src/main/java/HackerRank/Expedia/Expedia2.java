package HackerRank.Expedia;

//shift a string left n times, then right k times
public class Expedia2
{
    public static void main(String[] args)
    {
        String toShift = "abc";
        String answer = getShiftedString(toShift, 0, 1);
        System.out.println(answer);
    }

    public static String getShiftedString(String s, int left, int right)
    {
        if (left > right)
            return shiftLeft(s, left-right);
        if (right > left)
            return shiftRight(s, right-left);

        return s;
    }

    private static String shiftLeft(String s, int shifts)
    {
        if (shifts > s.length())
            shifts = shifts % s.length();
        return s.substring(shifts) + s.substring(0,shifts);
    }

    private static String shiftRight(String s, int shifts)
    {
        if (shifts > s.length())
            shifts = shifts % s.length();
        StringBuilder temp = new StringBuilder(s).reverse();
        String answer = temp.substring(shifts) + temp.substring(0, shifts);
        return new StringBuilder(answer).reverse().toString();
    }

}

