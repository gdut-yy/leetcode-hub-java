package didi;

import base.AbstractOjTests;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class DD2019009Tests extends AbstractOjTests {
    public DD2019009Tests() {
        super("/didi/2019009/");
    }

    @Test
    @Disabled
    public void example1() throws IOException {
        super.doSetSystemInOut();
        DD2019009.main(null);
        super.doAssertion();
    }
}
