package p1251;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1251DTests extends AbstractOjTests {
    public CF1251DTests() {
        super("/p1251/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1251D.main(null);
        super.doAssertion(OUTPUT1);
    }
}