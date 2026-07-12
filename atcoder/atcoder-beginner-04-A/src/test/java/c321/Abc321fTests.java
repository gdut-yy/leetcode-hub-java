package c321;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;
import java.io.IOException;

public class Abc321fTests extends AbstractOjTests {
    public Abc321fTests() {
        super("/c321/F/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        Abc321_f.main(null);
        super.doAssertion(OUTPUT1);
    }
}
