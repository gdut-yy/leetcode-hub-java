package p1846;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1846DTests extends AbstractOjTests {
    public CF1846DTests() {
        super("/p1846/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1846D.main(null);
        // 浮点数
//        super.doAssertion();
    }
}