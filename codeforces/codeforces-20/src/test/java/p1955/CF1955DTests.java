package p1955;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1955DTests extends AbstractOjTests {
    public CF1955DTests() {
        super("/p1955/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1955D.main(null);
        super.doAssertion(OUTPUT1);
    }
}