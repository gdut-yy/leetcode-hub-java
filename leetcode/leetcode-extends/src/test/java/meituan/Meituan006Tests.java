package meituan;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Meituan006Tests extends AbstractOjTests {
    public Meituan006Tests() {
        super("/meituan/006/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        Meituan006.main(null);
        super.doAssertion();
    }
}
