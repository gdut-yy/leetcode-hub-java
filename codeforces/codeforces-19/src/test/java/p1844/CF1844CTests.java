package p1844;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1844CTests extends AbstractOjTests {
    public CF1844CTests() {
        super("/p1844/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1844C.main(null);
        super.doAssertion(OUTPUT1);
    }
}