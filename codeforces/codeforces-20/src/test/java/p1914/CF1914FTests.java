package p1914;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1914FTests extends AbstractOjTests {
    public CF1914FTests() {
        super("/p1914/F/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1914F.main(null);
        super.doAssertion(OUTPUT1);
    }
}