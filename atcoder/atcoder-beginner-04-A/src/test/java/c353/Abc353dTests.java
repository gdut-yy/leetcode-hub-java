package c353;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;
import java.io.IOException;

public class Abc353dTests extends AbstractOjTests {
    public Abc353dTests() {
        super("/c353/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        Abc353_d.main(null);
        super.doAssertion(OUTPUT1);
    }

    @Test
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        Abc353_d.main(null);
        super.doAssertion(OUTPUT2);
    }
}
