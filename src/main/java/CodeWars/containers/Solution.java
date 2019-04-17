package CodeWars.containers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution
{

    public static void main(String[] args)
    {
        int x = containers("CODEWARS");
    }

    public static int containers(String input)
    {
        List<List<Integer>> containers = new ArrayList<>();
        List<Integer> inputs = input.chars().collect(ArrayList::new, ArrayList::add, (x,y) -> x.addAll(y));

        for (Integer in : inputs)
        {
            if (containers.size() == 0)
                containers.add(new ArrayList<>(Arrays.asList(in)));
            else
            {
                final boolean[] added = {false};
                containers.forEach(x -> {
                    if (x.get(x.size()-1) >= in && !added[0])
                    {
                        x.add(in);
                        added[0] = true;
                    }
                });

                if (!added[0])
                    containers.add(new ArrayList<>(Arrays.asList(in)));
            }
        }

        return containers.size();
    }
}
