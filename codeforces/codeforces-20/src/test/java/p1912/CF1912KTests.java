package p1912;

import base.AbstractOjTests;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1912KTests extends AbstractOjTests {
    public CF1912KTests() {
        super("/p1912/K/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1912K.main(null);
        super.doAssertion(OUTPUT1);
    }

    @Test
    @Disabled("uses static PrintWriter that gets closed after first run")
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        CF1912K.main(null);
        super.doAssertion(OUTPUT2);
    }

    @Test
    @Disabled("uses static PrintWriter that gets closed after first run")
    public void example3() throws IOException {
        super.doSetSystemInOut(INPUT3);
        CF1912K.main(null);
        super.doAssertion(OUTPUT3);
    }

    @Test
    @Disabled("uses static PrintWriter that gets closed after first run")
    public void example4() throws IOException {
        super.doSetSystemInOut(INPUT4);
        CF1912K.main(null);
        super.doAssertion(OUTPUT4);
    }

    @Test
    @Disabled("uses static PrintWriter that gets closed after first run")
    public void example5() throws IOException {
        super.doSetSystemInOut(INPUT5);
        CF1912K.main(null);
        super.doAssertion(OUTPUT5);
    }
}