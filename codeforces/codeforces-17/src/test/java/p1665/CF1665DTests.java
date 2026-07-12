package p1665;

import base.AbstractOjTests;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;

@Disabled("交互题")
public class CF1665DTests extends AbstractOjTests {
    public CF1665DTests() {
        super("/p1665/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1665D.main(null);
        super.doAssertion(OUTPUT1);
    }
}
