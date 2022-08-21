package meituan;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Meituan001Tests extends AbstractOjTests {
    public Meituan001Tests() {
        super("/meituan/001/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        Meituan001.main(null);
        super.doAssertion();
    }
}
