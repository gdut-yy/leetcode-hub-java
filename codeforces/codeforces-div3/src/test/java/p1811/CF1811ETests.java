package p1811;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1811ETests extends AbstractOjTests {
    public CF1811ETests() {
        super("/p1811/E/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1811E.main(null);
        super.doAssertion();
    }
}