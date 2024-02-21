package p44;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF44HTests extends AbstractOjTests {
    public CF44HTests() {
        super("/p44/H/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF44H.main(null);
        super.doAssertion(OUTPUT1);
    }

    @Test
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        CF44H.main(null);
        super.doAssertion(OUTPUT2);
    }
}