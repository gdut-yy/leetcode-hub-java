package p1921;

import base.AbstractOjTests;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1921FTests extends AbstractOjTests {
    public CF1921FTests() {
        super("/p1921/F/");
    }

    @Test
    @Disabled("[ERROR] Java heap space")
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1921F.main(null);
        super.doAssertion(OUTPUT1);
    }
}
