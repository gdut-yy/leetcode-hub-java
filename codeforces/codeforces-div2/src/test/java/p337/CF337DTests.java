package p337;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF337DTests extends AbstractOjTests {
    public CF337DTests() {
        super("/p337/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF337D.main(null);
        super.doAssertion();
    }
}