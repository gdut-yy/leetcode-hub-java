package p1624;

import base.AbstractOjTests;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1624FTests extends AbstractOjTests {
    public CF1624FTests() {
        super("/p1624/F/");
    }

    @Test
    @Disabled("交互题")
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1624F.main(null);
        super.doAssertion(OUTPUT1);
    }

    @Test
    @Disabled("交互题")
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        CF1624F.main(null);
        super.doAssertion(OUTPUT2);
    }

    @Test
    @Disabled("交互题")
    public void example3() throws IOException {
        super.doSetSystemInOut(INPUT3);
        CF1624F.main(null);
        super.doAssertion(OUTPUT3);
    }
}