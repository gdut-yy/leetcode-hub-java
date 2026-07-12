package p1670;

import base.AbstractOjTests;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1670FTests extends AbstractOjTests {
    public CF1670FTests() {
        super("/p1670/F/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1670F.main(null);
        super.doAssertion(OUTPUT1);
    }

    @Test
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        CF1670F.main(null);
        super.doAssertion(OUTPUT2);
    }

    @Test
    public void example3() throws IOException {
        super.doSetSystemInOut(INPUT3);
        CF1670F.main(null);
        super.doAssertion(OUTPUT3);
    }

    @Test
    public void example4() throws IOException {
        super.doSetSystemInOut(INPUT4);
        CF1670F.main(null);
        super.doAssertion(OUTPUT4);
    }

    // 补充用例
    @Test
    public void example5() throws IOException {
        super.doSetSystemInOut(INPUT5);
        CF1670F.main(null);
        super.doAssertion(OUTPUT5);
    }
}