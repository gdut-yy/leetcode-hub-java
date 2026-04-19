package p765;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF765FTests extends AbstractOjTests {
    public CF765FTests() {
        super("/p765/F/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF765F.main(null);
        super.doAssertion(OUTPUT1);
    }
}
