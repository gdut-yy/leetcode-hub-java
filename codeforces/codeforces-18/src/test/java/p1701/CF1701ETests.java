package p1701;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1701ETests extends AbstractOjTests {
    public CF1701ETests() {
        super("/p1701/E/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1701E.main(null);
        super.doAssertion(OUTPUT1);
    }
}