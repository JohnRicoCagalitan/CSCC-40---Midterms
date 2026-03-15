import java.util.*;

public class VacuumAgent {
    public void solve(State initialState) {
        PriorityQueue<Node> frontier = new PriorityQueue<>();
        Set<State> explored = new HashSet<>();

        frontier.add(new Node(initialState, null, "START"));

        while (!frontier.isEmpty()) {
            Node currentNode = frontier.poll();
            State currentState = currentNode.state;

            if (currentState.isGoal()) {
                printSolution(currentNode);
                return;
            }

            explored.add(currentState);

            for (String action : new String[]{"SUCK", "LEFT", "RIGHT"}) {
                State nextState = transition(currentState, action);

                if (!explored.contains(nextState)) {
                    frontier.add(new Node(nextState, currentNode, action));
                }
            }
        }
    }

    private State transition(State s, String action) {
        boolean a = s.isADirty;
        boolean b = s.isBDirty;
        int loc = s.agentLocation;

        if (action.equals("SUCK")) {
            if (loc == 0) {
                a = false;
            } else {
                b = false;
            }
        } else if (action.equals("LEFT")) {
            loc = 0;
        } else if (action.equals("RIGHT")) {
            loc = 1;
        }

        return new State(loc, a, b);
    }

    private void printSolution(Node goalNode) {
        Stack<Node> path = new Stack<>();
        Node current = goalNode;

        while (current != null) {
            path.push(current);
            current = current.parent;
        }

        System.out.println("\n--- SOLUTION NARRATIVE ---");
        int step = 0;

        while (!path.isEmpty()) {
            Node node = path.pop();
            String action = node.action;
            State state = node.state;

            if (action.equals("START")) {
                System.out.println("Initial State: " + state);
            } else {
                step++;
                System.out.printf("Step %d: [Action: %s] -> New State: %s%n", step, action, state);
            }
        }
        System.out.println("--------------------------");
        System.out.println("Goal Reached in " + step + " steps.");
    }
}
