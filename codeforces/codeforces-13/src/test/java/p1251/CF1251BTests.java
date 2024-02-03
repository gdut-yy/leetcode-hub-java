package p1251;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1251BTests extends AbstractOjTests {
    public CF1251BTests() {
        super("/p1251/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1251B.main(null);
        super.doAssertion(OUTPUT1);
    }
}