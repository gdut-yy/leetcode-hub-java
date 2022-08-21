package meituan;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Meituan013Tests extends AbstractOjTests {
    public Meituan013Tests() {
        super("/meituan/013/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        Meituan013.main(null);
        super.doAssertion();
    }
}
