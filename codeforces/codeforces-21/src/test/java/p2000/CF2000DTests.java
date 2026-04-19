package p2000;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF2000DTests extends AbstractOjTests {
    public CF2000DTests() {
        super("/p2000/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2000D.main(null);
        super.doAssertion(OUTPUT1);
    }
}