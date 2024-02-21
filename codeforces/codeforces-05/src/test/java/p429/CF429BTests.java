package p429;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF429BTests extends AbstractOjTests {
    public CF429BTests() {
        super("/p429/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF429B.main(null);
        super.doAssertion(OUTPUT1);
    }
}