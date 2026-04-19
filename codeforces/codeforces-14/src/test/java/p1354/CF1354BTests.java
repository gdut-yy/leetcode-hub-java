package p1354;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1354BTests extends AbstractOjTests {
    public CF1354BTests() {
        super("/p1354/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1354B.main(null);
        super.doAssertion(OUTPUT1);
    }
}