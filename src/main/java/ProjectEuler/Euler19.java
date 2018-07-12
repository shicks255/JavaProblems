package ProjectEuler;


import java.util.List;
import java.util.ArrayList;

public class Euler19
{
    public static void main(String[] args)
    {
        int week = 7;
        int year = 1900;
        int count = 0;
        int sundays = 0;

        String[] dow = new String[7];

        dow[0] = "mon";
        dow[1] = "tue";
        dow[2] = "wed";
        dow[3] = "thu";
        dow[4] = "fri";
        dow[5] = "sat";
        dow[6] = "sun";

        int[] months = new int[12];
        months[0] = 1;
        months[1] = 2;
        months[2] = 3;
        months[3] = 4;
        months[4] = 5;
        months[5] = 6;
        months[6] = 7;
        months[7] = 8;
        months[8] = 9;
        months[9] = 10;
        months[10] = 11;
        months[11] = 12;

        for (int i = 1900; i < 2001; i++) //each year
        {
            int rem;
            rem = i%4;
            if (rem == 0)
            {
                months[1] = 13; //if divisble by 4, then leap year with 29 days
            }
            else
            {
                months[1] = 2; //if not divisible by four, not leap year with 28 days
            }
            for (int mont : months) //each month for each year
            {
                month z = daysPerMonth(mont);
                System.out.println(i + " " + mont + " " + z.getDays());

                for (int c = 1; c <= z.getDays(); c++)//for each day of each month
                {
                    if (count == 7)
                    {
                        count = 0;
                    }

                    if (c == 1 && dow[count].equals("sun"))
                    {
                        sundays += 1;
                    }

                    System.out.println(dow[count]);
                    count++;

                }
            }
            System.out.println("");
        }

        System.out.println(sundays);
    }

    public static month daysPerMonth(int x)
    {
        month mon = new month();
        if (x == 4 || x == 6 || x == 9 || x == 11)
        {
            mon.setDays(30);
        }
        else if (x == 1 || x == 3 || x == 5 || x == 7 || x == 8 || x == 10 || x == 12)
        {
            mon.setDays(31);
        }
        else if (x == 2)
        {
            mon.setDays(28);
        }
        else if (x == 13)
        {
            mon.setDays(29);
        }
        return mon;
    }
}


