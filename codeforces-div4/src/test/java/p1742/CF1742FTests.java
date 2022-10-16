package p1742;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1742FTests extends AbstractOjTests {
    public CF1742FTests() {
        super("/p1742/F/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1742F.main(null);
        super.doAssertion();
    }
}
