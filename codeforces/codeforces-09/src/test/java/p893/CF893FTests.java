package p893;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF893FTests extends AbstractOjTests {
    public CF893FTests() {
        super("/p893/F/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF893F.main(null);
        super.doAssertion(OUTPUT1);
    }
}
