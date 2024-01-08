package wumpus.wumpusz;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class WUMPUSZTest {


    @Test
    public void testMainExitOption() throws IOException {
        String input = "username\n10\n3\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertDoesNotThrow(() -> WUMPUSZ.main(new String[0]));
    }



    @Test
    public void testPalyaSzerkesztoOption3() throws IOException {
        String input = "username\n10\n3\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertDoesNotThrow(() -> WUMPUSZ.main(new String[0]));
    }



    @Test
    public void testVeremLehelyezesOption1() throws IOException {
        String input = "username\n10\n3\n1\n1\n2\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertDoesNotThrow(() -> WUMPUSZ.main(new String[0]));
    }

    @Test
    public void testVeremLehelyezesOption2() throws IOException {
        String input = "username\n10\n3\n2\n1\n2\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertDoesNotThrow(() -> WUMPUSZ.main(new String[0]));
    }

    @Test
    public void testVeremLehelyezesOption3() throws IOException {
        String input = "username\n10\n3\n3\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertDoesNotThrow(() -> WUMPUSZ.main(new String[0]));
    }



    @Test
    public void testLovesEsakWumpuszra() throws IOException {
        String input = "username\n10\n4\n3\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertDoesNotThrow(() -> WUMPUSZ.main(new String[0]));
    }



    @Test
    public void testLovesNyugatFalra() throws IOException {
        // Similar tests for other directions
    }

    @Test
    public void testLovesDélFalra() throws IOException {
    }

    @Test
    public void testLovesKeletFalra() throws IOException {
    }



    @Test
    public void testMegadottErtek3() throws IOException {
        String input = "username\n10\n5\n3\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertDoesNotThrow(() -> WUMPUSZ.main(new String[0]));
    }



}