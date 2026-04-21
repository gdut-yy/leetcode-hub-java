package p1725;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1725MTests extends AbstractOjTests {
    public CF1725MTests() {
        super("/p1725/M/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1725M.main(null);
        super.doAssertion(OUTPUT1);
    }
}