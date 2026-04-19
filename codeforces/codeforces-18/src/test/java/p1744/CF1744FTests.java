package p1744;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1744FTests extends AbstractOjTests {
    public CF1744FTests() {
        super("/p1744/F/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1744F.main(null);
        super.doAssertion(OUTPUT1);
    }
}