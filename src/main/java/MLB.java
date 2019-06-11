import java.util.*;
import java.util.stream.Collectors;

public class MLB
{
    public static void main(String[] args)
    {
        List<String> strings = Arrays.asList("joe: Hey man how's it going?",
                "john: yo yo whats up big dawg",
                "joe: not much just chilling",
                "alex: hi");
        printTopNChatters(strings, 1);
    }

    private static void printTopNChatters(List<String> chats, int n)
    {
        List<String[]> arrays = chats.stream()
                .map(x -> x.split(":"))
                .map(x -> {
                    String[] y = new String[2];
                    y[0] = x[0];
                    String chat = x[1];
                    int chatLength = chat.trim().split(" ").length;
                    y[1] = "" + chatLength;
                    return y;
                })
                .collect(Collectors.toList());

        Map<String, Integer> map = new HashMap<>();
        for (String[] a : arrays)
        {
            Integer count = map.getOrDefault(a[0], 0);
            count += Integer.valueOf(a[1]);
            map.put(a[0], count);
        }

        map = map.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toMap(o -> o.getKey(), j -> j.getValue(), (e1, e2) -> e2, LinkedHashMap::new));

        System.out.println(map);
    }
}
