package p1720;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1720D2Tests extends AbstractOjTests {
    public CF1720D2Tests() {
        super("/p1720/D2/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1720D2.main(null);
        super.doAssertion();
    }
}