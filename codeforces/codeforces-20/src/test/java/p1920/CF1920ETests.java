package p1920;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1920ETests extends AbstractOjTests {
    public CF1920ETests() {
        super("/p1920/E/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1920E.main(null);
        super.doAssertion(OUTPUT1);
    }
}