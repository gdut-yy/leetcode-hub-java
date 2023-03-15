package meituan;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Meituan004Tests extends AbstractOjTests {
    public Meituan004Tests() {
        super("/meituan/004/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        Meituan004.main(null);
        super.doAssertion();
    }

    @Test
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        Meituan004.main(null);
        super.doAssertion(OUTPUT2);
    }
}
