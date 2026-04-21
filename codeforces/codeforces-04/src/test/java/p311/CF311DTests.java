package p311;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF311DTests extends AbstractOjTests {
    public CF311DTests() {
        super("/p311/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF311D.main(null);
        super.doAssertion(OUTPUT1);
    }
}