package p1611;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1611FTests extends AbstractOjTests {
    public CF1611FTests() {
        super("/p1611/F/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1611F.main(null);
        super.doAssertion();
    }
}