package p2020;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF2020DTests extends AbstractOjTests {
    public CF2020DTests() {
        super("/p2020/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2020D.main(null);
        super.doAssertion(OUTPUT1);
    }
}