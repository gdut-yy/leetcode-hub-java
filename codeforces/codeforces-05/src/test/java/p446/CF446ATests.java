package p446;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF446ATests extends AbstractOjTests {
    public CF446ATests() {
        super("/p446/A/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF446A.main(null);
        super.doAssertion(OUTPUT1);
    }
}