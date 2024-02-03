package p247;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF247BTests extends AbstractOjTests {
    public CF247BTests() {
        super("/p247/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF247B.main(null);
        super.doAssertion(OUTPUT1);
    }
}