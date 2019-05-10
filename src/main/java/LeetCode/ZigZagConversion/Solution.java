package LeetCode.ZigZagConversion;

public class Solution
{
    public static void main(String[] args)
    {
        System.out.println(convert2("PAYPALISHIRING", 3));
        System.out.println(convert2("PAYPALISHIRING", 4));
        System.out.println(convert2("PAYPALISHIRING", 5));
        System.out.println(convert2("A", 1));
    }

    private static String convert2(String s, int numRows)
    {
        if (numRows == 1 || s.length() < 2)
            return s;

        StringBuilder answer = new StringBuilder();
        int zigColumns = numRows-2;
        int downMover = zigColumns * 2;
        int upMover = 2;

        for (int i = 0; i < numRows; i++)
        {
            int getter = i;
            if (i == 0 || i == numRows-1)
            {
                while (getter < s.length())
                {
                    answer.append(s, getter, getter+1);
                    getter += numRows + zigColumns;
                }
            }
            else
            {
                boolean goDown = true;
                while (getter < s.length())
                {
                    if (goDown)
                    {
                        answer.append(s, getter, getter+1);
                        getter += downMover;
                        goDown = false;
                    }
                    else
                    {
                        answer.append(s, getter, getter+1);
                        getter += upMover;
                        goDown = true;
                    }
                }
                upMover += 2;
                downMover -=2 ;
            }
        }

        return answer.toString();
    }
}
