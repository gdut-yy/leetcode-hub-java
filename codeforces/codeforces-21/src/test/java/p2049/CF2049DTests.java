package p2049;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF2049DTests extends AbstractOjTests {
    public CF2049DTests() {
        super("/p2049/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2049D.main(null);
        super.doAssertion(OUTPUT1);
    }
}
