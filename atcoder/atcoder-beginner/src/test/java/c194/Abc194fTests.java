package c194;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Abc194fTests extends AbstractOjTests {
    public Abc194fTests() {
        super("/c194/F/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        Abc194_f.main(null);
        super.doAssertion(OUTPUT1);
    }

    @Test
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        Abc194_f.main(null);
        super.doAssertion(OUTPUT2);
    }

    @Test
    public void example3() throws IOException {
        super.doSetSystemInOut(INPUT3);
        Abc194_f.main(null);
        super.doAssertion(OUTPUT3);
    }

    @Test
    public void example4() throws IOException {
        super.doSetSystemInOut(INPUT4);
        Abc194_f.main(null);
        super.doAssertion(OUTPUT4);
    }

    @Test
    public void example5() throws IOException {
        super.doSetSystemInOut(INPUT5);
        Abc194_f.main(null);
        super.doAssertion(OUTPUT5);
    }
}
