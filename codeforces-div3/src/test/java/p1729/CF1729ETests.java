package p1729;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1729ETests extends AbstractOjTests {
    public CF1729ETests() {
        super("/p1729/E/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1729E.main(null);
        // 交互题
//        super.doAssertion();
    }
}
