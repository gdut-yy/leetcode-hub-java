package p13;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF13ETests extends AbstractOjTests {
    public CF13ETests() {
        super("/p13/E/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF13E.main(null);
        super.doAssertion(OUTPUT1);
    }
}