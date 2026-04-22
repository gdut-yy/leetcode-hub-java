package p903;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

public class CF903FTests extends AbstractOjTests {
    public CF903FTests() {
        super("/p903/F/");
    }

    @Test
    public void test1() throws Exception {
        doSetSystemInOut(INPUT1);
        CF903F.main(new String[0]);
        doAssertion(OUTPUT1);
    }

    @Test
    public void test2() throws Exception {
        doSetSystemInOut(INPUT2);
        CF903F.main(new String[0]);
        doAssertion(OUTPUT2);
    }

    @Test
    public void test3() throws Exception {
        doSetSystemInOut(INPUT3);
        CF903F.main(new String[0]);
        doAssertion(OUTPUT3);
    }
}