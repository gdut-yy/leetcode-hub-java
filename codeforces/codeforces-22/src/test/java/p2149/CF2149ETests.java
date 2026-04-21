package p2149;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF2149ETests extends AbstractOjTests {
    public CF2149ETests() {
        super("/p2149/E/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2149E.main(null);
        super.doAssertion(OUTPUT1);
    }
}