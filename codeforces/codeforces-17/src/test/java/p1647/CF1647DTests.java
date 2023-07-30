package p1647;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1647DTests extends AbstractOjTests {
    public CF1647DTests() {
        super("/p1647/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1647D.main(null);
        super.doAssertion();
    }
}