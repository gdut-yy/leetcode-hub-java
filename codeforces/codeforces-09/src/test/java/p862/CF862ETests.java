package p862;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF862ETests extends AbstractOjTests {
    public CF862ETests() {
        super("/p862/E/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF862E.main(null);
        super.doAssertion(OUTPUT1);
    }
}