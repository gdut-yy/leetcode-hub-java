package p484;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF484ATests extends AbstractOjTests {
    public CF484ATests() {
        super("/p484/A/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF484A.main(null);
        super.doAssertion(OUTPUT1);
    }
}