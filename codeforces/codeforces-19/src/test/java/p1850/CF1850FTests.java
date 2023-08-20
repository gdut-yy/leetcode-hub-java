package p1850;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1850FTests extends AbstractOjTests {
    public CF1850FTests() {
        super("/p1850/F/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1850F.main(null);
        super.doAssertion();
    }
}