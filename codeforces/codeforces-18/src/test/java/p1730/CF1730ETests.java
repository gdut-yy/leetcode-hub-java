package p1730;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1730ETests extends AbstractOjTests {
    public CF1730ETests() {
        super("/p1730/E/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1730E.main(null);
        super.doAssertion(OUTPUT1);
    }
}