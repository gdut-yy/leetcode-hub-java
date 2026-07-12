package p1980;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1980ETests extends AbstractOjTests {
    public CF1980ETests() {
        super("/p1980/E/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1980E.main(null);
        super.doAssertion(OUTPUT1);
    }
}
