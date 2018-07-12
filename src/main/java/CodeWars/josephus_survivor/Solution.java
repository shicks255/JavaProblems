package CodeWars.josephus_survivor;

//In this kata you have to correctly return who is the "survivor", ie: the last element of a Josephus permutation.
//
//        Basically you have to assume that n people are put into a circle and that they are eliminated in steps of k elements, like this:
//
//  josephus_survivor(7,3) => means 7 people in a circle;
//  one every 3 is eliminated until one remains
//  [1,2,3,4,5,6,7] - initial sequence
//  [1,2,4,5,6,7] => 3 is counted out
//  [1,2,4,5,7] => 6 is counted out
//  [1,4,5,7] => 2 is counted out
//  [1,4,5] => 7 is counted out
//  [1,4] => 5 is counted out
//  [4] => 1 counted out, 4 is the last element - the survivor!
//  The above link about the "base" kata description will give you a more thorough insight about the origin of this kind of permutation,
// but basically that's all that there is to know to solve this kata.
//
//        Notes and tips: using the solution to the other kata to check your function may be helpful, but as much larger numbers will be used, using an array/list to compute the number of the survivor may be too slow; you may assume that both n and k will always be >=1.

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Solution
{
    //n = number of people in cricle, k = every k people die
    protected static int josephusSurvivor(final int n, final int k)
    {
        //build the arrayList
        List<Integer> circle = new ArrayList<>();
        for (int i = 0; i<n; i++)
            circle.add(i+1);

        int currentPosition = 0;
        while (circle.size() > 1)
        {
            for (ListIterator<Integer> i = circle.listIterator(); i.hasNext();)
            {
                Integer element = i.next();
                currentPosition++;
                if (currentPosition == k)
                {
                    if (circle.size() == 1)
                        break;
                    i.remove();
                    currentPosition = 0;
                }
            }
        }

        return circle.get(0);
    }
}
