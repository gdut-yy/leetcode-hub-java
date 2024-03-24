package p939;

import base.AbstractOjTests;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;

@Disabled("浮点数")
public class CF939ETests extends AbstractOjTests {
    public CF939ETests() {
        super("/p939/E/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF939E.main(null);
        super.doAssertion(OUTPUT1);
    }

    @Test
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        CF939E.main(null);
        super.doAssertion(OUTPUT2);
    }
}