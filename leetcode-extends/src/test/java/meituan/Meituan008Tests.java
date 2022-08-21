package meituan;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Meituan008Tests extends AbstractOjTests {
    public Meituan008Tests() {
        super("/meituan/008/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        Meituan008.main(null);
        super.doAssertion();
    }
}
