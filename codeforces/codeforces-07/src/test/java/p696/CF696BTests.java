package p696;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF696BTests extends AbstractOjTests {
    public CF696BTests() {
        super("/p696/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF696B.main(null);
        super.doAssertion(OUTPUT1);
    }

    @Test
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        CF696B.main(null);
        super.doAssertion(OUTPUT2);
    }
}