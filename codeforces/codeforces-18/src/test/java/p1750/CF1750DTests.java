package p1750;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1750DTests extends AbstractOjTests {
    public CF1750DTests() {
        super("/p1750/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1750D.main(null);
        super.doAssertion(OUTPUT1);
    }
}