package p292;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF292ETests extends AbstractOjTests {
    public CF292ETests() {
        super("/p292/E/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF292E.main(null);
        super.doAssertion(OUTPUT1);
    }
}