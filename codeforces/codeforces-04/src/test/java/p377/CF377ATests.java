package p377;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF377ATests extends AbstractOjTests {
    public CF377ATests() {
        super("/p377/A/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF377A.main(null);
        // 答案不唯一
//        super.doAssertion(OUTPUT1);
    }

    @Test
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        CF377A.main(null);
        // 答案不唯一
//        super.doAssertion(OUTPUT2);
    }
}