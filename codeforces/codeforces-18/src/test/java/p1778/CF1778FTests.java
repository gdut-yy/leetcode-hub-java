package p1778;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1778FTests extends AbstractOjTests {
    public CF1778FTests() {
        super("/p1778/F/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1778F.main(null);
        super.doAssertion(OUTPUT1);
    }
}