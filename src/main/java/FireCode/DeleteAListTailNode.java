package FireCode;

public class DeleteAListTailNode
{

    public static void main(String[] args)
    {
        LinkedList<ListNode> list = new LinkedList<>();

        list.add(new ListNode<String>("First"));

        list.add(new ListNode<String>("Second"));
        list.add(new ListNode<String>("Third"));
        list.add(new ListNode<String>("Fourth"));

        list.remove(new ListNode<String>("Third"));

        String test = "test";
    }



    public static class ListNode<T> implements Comparable<T>
    {
        private T data;
        private ListNode<T> next;

        public  ListNode(T data)
        {
            this.data = data;
            this.next = null;
        }

        @Override
        public int compareTo(T obj)
        {
            if (obj == data)
                return 1;
            else
                return 0;
        }
    }

    public static class LinkedList<T>
    {
        private ListNode<T> root;
        private int count;

        private LinkedList()
        {
            root = null;
            count = 0;
        }

        private void add(ListNode node)
        {
            if (root == null)
                root = node;

            else if (root.next == null)
                root.next = node;
            else
            {
                ListNode<T> temp = root.next;
                for (int i = 0; i < count; i++)
                {
                    if (temp.next == null)
                    {
                        temp.next = node;
                        break;
                    }
                    temp = temp.next;
                }
            }

            count++;
        }

        private void remove(ListNode node)
        {
            if (root == null)
                return;
            else
            {
                if (root.data.equals(node.data))
                    root = root.next;
                else
                {
                    ListNode<T> previous = root;
                    for (int i = 1; i < count; i++)
                    {
                        ListNode<T> temp = previous.next;

                        if (temp.data.equals(node.data))
                        {
                            previous.next = temp.next;
                            break;
                        }

                        previous = previous.next;
                    }
                }
                count--;
            }
        }
    }
}
