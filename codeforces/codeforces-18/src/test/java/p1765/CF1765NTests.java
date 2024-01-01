package p1765;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1765NTests extends AbstractOjTests {
    public CF1765NTests() {
        super("/p1765/N/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1765N.main(null);
        super.doAssertion(OUTPUT1);
    }
}