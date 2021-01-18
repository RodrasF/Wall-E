import java.util.HashMap;
import java.util.Scanner;

public class Program {

    enum Direction {
        N(Vector.of(0, 1)),
        S(Vector.of(0, -1)),
        E(Vector.of(-1, 0)),
        O(Vector.of(1, 0));

        private Vector vector;

        Direction(Vector vector) {
            this.vector = vector;
        }

        public Vector vector() {
            return this.vector;
        }
    }

    public static void main(String[] args) {
        System.out.println("\n.:: Wall-E cleaning service at your disposal! ::.");
        if (args.length > 0)
            move(args[0]);
        else
            interactiveMode();
    }

    public static void interactiveMode() {
        Scanner in = new Scanner(System.in);
        String moves = getInput(in);

        while (!moves.equalsIgnoreCase("EXIT")) {
            int clearedCount = move(moves.toUpperCase());

            if (clearedCount > 0) System.out.printf("Cleared %d Houses.\n", clearedCount);
            else System.out.println("Invalid move sequence.");

            moves = getInput(in);
        }

        System.out.println("Goodbye...");
    }

    public static String getInput(Scanner in) {
        System.out.println("\nInsert Move Sequence (EXIT to leave):");
        return in.nextLine();
    }

    public static int move(String moves) {
        if (moves.isEmpty()) return 1;

        if (!moves.matches("([NSEO])+")) {
            return -1;
        }

        HashMap<Vector, Boolean> clearedHouses = new HashMap<>();
        Vector currentPosition = Vector.of(0, 0);
        clearedHouses.put(currentPosition.copy(), true);

        //fori < moves.length; Direction.valueOf("" + moves.charAt(i))
        for (String move : moves.split("")) {
            currentPosition.add(
                    Direction.valueOf(move).vector()
            );
            clearedHouses.putIfAbsent(currentPosition.copy(), true);
        }
        return clearedHouses.size();
    }
}
