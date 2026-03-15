import java.util.Objects;

public class State {
    int agentLocation;
    boolean isADirty;
    boolean isBDirty;

    public State(int loc, boolean a, boolean b) {
        this.agentLocation = loc;
        this.isADirty = a;
        this.isBDirty = b;
    }

    public int getHeuristic() {
        int h = 0;

        if (isADirty) {
            h++;
        }

        if (isBDirty) {
            h++;
        }

        return h;
    }

    public boolean isGoal() {
        return !isADirty && !isBDirty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof State)) {
            return false;
        }

        State state = (State) o;
        return agentLocation == state.agentLocation && isADirty == state.isADirty && isBDirty == state.isBDirty;
    }

    @Override
    public int hashCode() {
        return Objects.hash(agentLocation, isADirty, isBDirty);
    }

    @Override
    public String toString() {
        String loc = (agentLocation == 0) ? "A" : "B";
        return String.format("Pos: %s | A: %s | B: %s", loc, isADirty ? "Dirty" : "Clean", isBDirty ? "Dirty" : "Clean");
    }
}
