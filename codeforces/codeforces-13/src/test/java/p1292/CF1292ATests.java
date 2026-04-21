package p1292;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1292ATests extends AbstractOjTests {
    public CF1292ATests() {
        super("/p1292/A/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1292A.main(null);
        super.doAssertion(OUTPUT1);
    }
}