package p379;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF379FTests extends AbstractOjTests {
    public CF379FTests() {
        super("/p379/F/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF379F.main(null);
        super.doAssertion(OUTPUT1);
    }
}