package p1882;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1882DTests extends AbstractOjTests {
    public CF1882DTests() {
        super("/p1882/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1882D.main(null);
        super.doAssertion(OUTPUT1);
    }
}