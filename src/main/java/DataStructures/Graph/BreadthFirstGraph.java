package DataStructures.Graph;

import DataStructures.Queue.Node;
import DataStructures.Queue.Queue;

import java.util.*;

public class BreadthFirstGraph
{
    public static void main(String[] args)
    {
        System.out.println(shortestPathToWork());
    }

    public static String shortestPathToWork()
    {
        Map<String, List<GraphNode>> coords = new HashMap<>();

        GraphNode finderne = new GraphNode(null, "Finderne");
        GraphNode finderneN = new GraphNode(finderne, "Finderne North");
        GraphNode _22 = new GraphNode(finderne, "22");
        GraphNode accessRoad = new GraphNode(_22, "Access Road");
        GraphNode _28 = new GraphNode(finderne, "28");


        coords.put("Finderne", Arrays.asList(finderneN, _28));
        coords.put("Finderne North", Arrays.asList(_22));
        coords.put("22", Arrays.asList(accessRoad));
        coords.put("Access Road", Arrays.asList(new GraphNode(accessRoad, "Chimney Rock Road")));
        coords.put("28", Arrays.asList(new GraphNode(_28, "Chimney Rock Road")));

        GraphNode startingRoad = finderne;
        Queue<GraphNode> queue = new Queue<>(startingRoad);

        while (!queue.isEmpty())
        {
            Node<GraphNode> coord = queue.dequeue();
            if (coord.getData().name.equals("Chimney Rock Road"))
            {
                GraphNode node = coord.getData();
                List<String> paths = new ArrayList<>();
                while (node != null)
                {
                    paths.add(node.name);
                    node = node.parent;
                }
                Collections.reverse(paths);
                return paths.stream().reduce("", (a,b) -> a + " -> " + b);
            }
            else
            {
                List<GraphNode> neighbors = coords.getOrDefault(coord.getData().name, Collections.emptyList());
                for (GraphNode neighbor : neighbors)
                    queue.enqueue(neighbor);
            }
        }

        return "No path found";
    }

    private static class GraphNode
    {
        String name = "";
        GraphNode parent;

        public GraphNode(GraphNode parent, String name)
        {
            this.name = name;
            this.parent = parent;
        }
    }
}
