import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Closure
{

    public static void main(String[] args)
    {
        List<String> titles = new ArrayList<>(Arrays.asList("king robert", "queen mary", "prince william", "prince henry"));

        Predicate<String> isKing = startsWith("king");
        Predicate<String> isQueen = startsWith("queen");

//        titles.removeIf(isKing);
//        titles.removeIf(isQueen);
        //or
        titles.removeIf(startsWith("king"));
        titles.removeIf(startsWith("queen"));


        System.out.println(titles);
    }

    public static Predicate<String> startsWith(String letter)
    {
        return x -> x.startsWith(letter);
    }

    //old way, none lambda
//    public static Predicate<String> startsWith(String letter)
//    {
//        return new Predicate<String>()
//        {
//            @Override
//            public boolean test(String s)
//            {
//                return s.startsWith(letter);
//            }
//        };
//    }

}
