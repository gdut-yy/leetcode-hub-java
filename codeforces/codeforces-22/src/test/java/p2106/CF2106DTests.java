package p2106;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF2106DTests extends AbstractOjTests {
    public CF2106DTests() {
        super("/p2106/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2106D.main(null);
        super.doAssertion(OUTPUT1);
    }
}