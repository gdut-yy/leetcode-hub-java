package p1598;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1598DTests extends AbstractOjTests {
    public CF1598DTests() {
        super("/p1598/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1598D.main(null);
        super.doAssertion();
    }
}