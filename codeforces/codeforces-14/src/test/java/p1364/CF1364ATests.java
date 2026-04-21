package p1364;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1364ATests extends AbstractOjTests {
    public CF1364ATests() {
        super("/p1364/A/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1364A.main(null);
        super.doAssertion(OUTPUT1);
    }
}