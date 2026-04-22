package p1980;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1980DTests extends AbstractOjTests {
    public CF1980DTests() {
        super("/p1980/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1980D.main(null);
        super.doAssertion(OUTPUT1);
    }
}