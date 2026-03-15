public class Node implements Comparable<Node> {
    State state;
    Node parent;
    String action;

    public Node(State state, Node parent, String action) {
        this.state = state;
        this.parent = parent;
        this.action = action;
    }

    @Override
    public int compareTo(Node other) {
        return Integer.compare(this.state.getHeuristic(), other.state.getHeuristic());
    }
}
