package p1921;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1921ETests extends AbstractOjTests {
    public CF1921ETests() {
        super("/p1921/E/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1921E.main(null);
        super.doAssertion(OUTPUT1);
    }
}
