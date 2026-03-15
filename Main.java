import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Vacuum World GBFS Solver");

        System.out.print("Enter Agent Location (0 for Room A, 1 for Room B): ");
        int loc = scanner.nextInt();

        System.out.print("Is Room A Dirty? (true/false): ");
        boolean aDirty = scanner.nextBoolean();

        System.out.print("Is Room B Dirty? (true/false): ");
        boolean bDirty = scanner.nextBoolean();

        State initialState = new State(loc, aDirty, bDirty);
        VacuumAgent agent = new VacuumAgent();

        System.out.println("\nStarting Greedy Best-First Search...");
        agent.solve(initialState);
    }
}
