package meituan;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Meituan015Tests extends AbstractOjTests {
    public Meituan015Tests() {
        super("/meituan/015/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        Meituan015.main(null);
        super.doAssertion();
    }
}
