package p1862;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1862FTests extends AbstractOjTests {
    public CF1862FTests() {
        super("/p1862/F/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1862F.main(null);
        super.doAssertion();
    }
}