package meituan;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Meituan010Tests extends AbstractOjTests {
    public Meituan010Tests() {
        super("/meituan/010/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        Meituan010.main(null);
        super.doAssertion();
    }
}
