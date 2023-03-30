package p1807;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1807FTests extends AbstractOjTests {
    public CF1807FTests() {
        super("/p1807/F/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1807F.main(null);
        super.doAssertion();
    }
}
