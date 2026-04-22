package p557;

import base.AbstractOjTests;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF557ETests extends AbstractOjTests {
    public CF557ETests() {
        super("/p557/E/");
    }

    @Test
    @Disabled("[ERROR] Java heap space")
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF557E.main(null);
        super.doAssertion(OUTPUT1);
    }

    @Test
    @Disabled("[ERROR] Java heap space")
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        CF557E.main(null);
        super.doAssertion(OUTPUT2);
    }

    @Test
    @Disabled("[ERROR] Java heap space")
    public void example3() throws IOException {
        super.doSetSystemInOut(INPUT3);
        CF557E.main(null);
        super.doAssertion(OUTPUT3);
    }
}