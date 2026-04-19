package p1775;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1775BTests extends AbstractOjTests {
    public CF1775BTests() {
        super("/p1775/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1775B.main(null);
        super.doAssertion(OUTPUT1);
    }
}
