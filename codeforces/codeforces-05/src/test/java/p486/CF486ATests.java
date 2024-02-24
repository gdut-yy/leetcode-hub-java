package p486;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF486ATests extends AbstractOjTests {
    public CF486ATests() {
        super("/p486/A/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF486A.main(null);
        super.doAssertion(OUTPUT1);
    }

    @Test
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        CF486A.main(null);
        // 答案不唯一
//        super.doAssertion(OUTPUT2);
    }
}