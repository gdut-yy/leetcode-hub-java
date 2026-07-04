package aising2020;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Aising2020eTests extends AbstractOjTests {
    public Aising2020eTests() {
        super("/aising2020/E/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        Aising2020_e.main(null);
        super.doAssertion(OUTPUT1);
    }
}
