import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Bytedance010Tests extends AbstractOjTests {
    public Bytedance010Tests() {
        super("meituan/001");
    }

    @Test
    public void example1() throws IOException {
        super.doSetInOut();
        Meituan001.main(null);
        super.doAssertion();
    }


}
