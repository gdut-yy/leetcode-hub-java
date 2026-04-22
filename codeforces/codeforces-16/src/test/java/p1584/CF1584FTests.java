package p1584;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1584FTests extends AbstractOjTests {
    public CF1584FTests() {
        super("/p1584/F/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1584F.main(null);
        super.doAssertion(OUTPUT1);
    }
}