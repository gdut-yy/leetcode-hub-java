package p474;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF474FTests extends AbstractOjTests {
    public CF474FTests() {
        super("/p474/F/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF474F.main(null);
        super.doAssertion(OUTPUT1);
    }
}