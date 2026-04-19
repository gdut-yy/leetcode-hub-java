package p1997;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1997DTests extends AbstractOjTests {
    public CF1997DTests() {
        super("/p1997/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1997D.main(null);
        super.doAssertion(OUTPUT1);
    }
}