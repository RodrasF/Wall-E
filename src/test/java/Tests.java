import org.junit.Assert;
import org.junit.Test;

public class Tests {

    @Test
    public void testNoMoves() {
        String moves = "";
        assertClearedHousesCount(moves, 1);
    }

    @Test
    public void testSingleMove() {
        String moves = "E";
        assertClearedHousesCount(moves, 2);
    }

    @Test
    public void testStraightPathN() {
        String moves = "NNNNNNNNNNNNNNN";
        assertClearedHousesCount(moves, moves.length() + 1);
    }

    @Test
    public void testStraightPathS() {
        String moves = "SSSSSSSSSSSSSSS";
        assertClearedHousesCount(moves, moves.length() + 1);
    }

    @Test
    public void testStraightPathE() {
        String moves = "EEEEEEEEEEEEEEE";
        assertClearedHousesCount(moves, moves.length() + 1);
    }

    @Test
    public void testStraightPathO() {
        String moves = "OOOOOOOOOOOOOOO";
        assertClearedHousesCount(moves, moves.length() + 1);
    }

    @Test
    public void testBackAndForth() {
        String moves = "NSNSNSNSNSNS";
        assertClearedHousesCount(moves, 2);
    }

    @Test
    public void testCircles() {
        String moves = "NESONESO";
        assertClearedHousesCount(moves, 4);
    }

    @Test
    public void testLongStraightPath() {
        String moves = generateString("N", 50000);
        assertClearedHousesCount(moves, moves.length() + 1);
    }

    @Test
    public void testLongCirclePath() {
        String moves = generateString("NESO", 250000);
        assertClearedHousesCount(moves, 4);
    }

    private static void assertClearedHousesCount(String moves, int expectedCount) {
        int count = Program.move(moves);
        Assert.assertEquals(expectedCount, count);
    }

    private static String generateString(String pattern, int repetitions) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < repetitions; i++) {
            sb.append(pattern);
        }
        return sb.toString();
    }
}
