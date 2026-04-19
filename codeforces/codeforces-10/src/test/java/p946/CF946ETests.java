package p946;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF946ETests extends AbstractOjTests {
    public CF946ETests() {
        super("/p946/E/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF946E.main(null);
        super.doAssertion(OUTPUT1);
    }
}