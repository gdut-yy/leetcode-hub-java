package p1882;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1882ATests extends AbstractOjTests {
    public CF1882ATests() {
        super("/p1882/A/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1882A.main(null);
        super.doAssertion(OUTPUT1);
    }
}