import java.util.ArrayList;
import java.util.List;

// CLASS BEGINS, THIS CLASS IS REQUIRED
public class Amazon
{
    public static void main(String[] args)
    {
        Amazon a = new Amazon();

        List<Integer> answer = a.cellCompete(new int[]{1,1,1,0,1,1,1,1}, 2);

        System.out.println(answer);
    }

    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public List<Integer> cellCompete(int[] states, int days)
    {
        List<Integer> answer = new ArrayList<>(8);
        cellCompete(states, days, answer);

        return answer;
    }
    // METHOD SIGNATURE ENDS


    private void cellCompete(int[] states, int days, List<Integer> answer)
    {

        if (days == 0)
        {
            for (int i = 0; i < states.length; i++)
                answer.add(i, states[i]);

            return;
        }

        int[] newStates = new int[8];

        for (int i = 0; i < states.length; i++)
        {
            boolean leftInactive = true;
            boolean rightInactive = true;

            if (i > 0)
                leftInactive = states[i-1] == 0;
            if (i < states.length-1)
                rightInactive = states[i+1] == 0;

            if(leftInactive && rightInactive || (!leftInactive && !rightInactive))
                newStates[i] = 0;
            else
                newStates[i] = 1;
        }

        cellCompete(newStates, days-1, answer);
    }
}