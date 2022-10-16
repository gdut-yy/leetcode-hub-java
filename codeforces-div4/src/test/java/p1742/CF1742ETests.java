package p1742;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1742ETests extends AbstractOjTests {
    public CF1742ETests() {
        super("/p1742/E/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1742E.main(null);
        super.doAssertion();
    }
}
