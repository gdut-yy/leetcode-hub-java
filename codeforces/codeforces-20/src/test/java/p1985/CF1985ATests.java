package p1985;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1985ATests extends AbstractOjTests {
    public CF1985ATests() {
        super("/p1985/A/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1985A.main(null);
        super.doAssertion(OUTPUT1);
    }
}