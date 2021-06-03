import org.w3c.dom.Node;

import java.util.*;

/**
 * @author Ruimin Wu
 * @date 2021-06-02 22:27
 **/
public class CloneGraph {

    public Node cloneNode(Node node) {
        if (node == null) {
            return null;
        }
        HashMap<Node, Node> map = new HashMap<>(32);
        Node newNode = new Node(node.val, new ArrayList<>());
        map.put(node, newNode);
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            for (Node nei : cur.neighbors) {
                if (!map.containsKey(nei)) {
                    map.put(nei,new Node(nei.val,new ArrayList<>()));
                    queue.add(nei);
                }
                map.get(cur).neighbors.add(map.get(nei));
            }
        }
        return newNode;
    }

    class Node{
        public int val;
        public List<Node> neighbors;

        public Node() {
        }

        @Override
        public int hashCode() {
            return this.val;
        }

        @Override
        public boolean equals(Object obj) {
            return super.equals(obj);
        }

        public Node(int val, List<Node> neighbors) {
            this.val = val;
            this.neighbors = neighbors;
        }
    }
}
