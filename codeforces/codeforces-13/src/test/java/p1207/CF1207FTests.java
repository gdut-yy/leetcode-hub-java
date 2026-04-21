package p1207;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1207FTests extends AbstractOjTests {
    public CF1207FTests() {
        super("/p1207/F/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1207F.main(null);
        super.doAssertion(OUTPUT1);
    }
}