import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6021Tests {
    private final Solution6021 solution6021 = new Solution6021();

    @Test
    public void example1() {
        String text = "abdcdbc";
        String pattern = "ac";
        int expected = 4;
        Assertions.assertEquals(expected, solution6021.maximumSubsequenceCount(text, pattern));
    }

    @Test
    public void example2() {
        String text = "aabb";
        String pattern = "ab";
        int expected = 6;
        Assertions.assertEquals(expected, solution6021.maximumSubsequenceCount(text, pattern));
    }

    // 补充用例
    @Test
    public void example3() {
        String text = "vnedkpkkyxelxqptfwuzcjhqmwagvrglkeivowvbjdoyydnjrqrqejoyptzoklaxcjxbrrfmpdxckfjzahparhpanwqfjrpbslsyiwbldnpjqishlsuagevjmiyktgofvnyncizswldwnngnkifmaxbmospdeslxirofgqouaapfgltgqxdhurxljcepdpndqqgfwkfiqrwuwxfamciyweehktaegynfumwnhrgrhcluenpnoieqdivznrjljcotysnlylyswvdlkgsvrotavnkifwmnvgagjykxgwaimavqsxuitknmbxppgzfwtjdvegapcplreokicxcsbdrsyfpustpxxssnouifkypwqrywprjlyddrggkcglbgcrbihgpxxosmejchmzkydhquevpschkpyulqxgduqkqgwnsowxrmgqbmltrltzqmmpjilpfxocflpkwithsjlljxdygfvstvwqsyxlkknmgpppupgjvfgmxnwmvrfuwcrsadomyddazlonjyjdeswwznkaeaasyvurpgyvjsiltiykwquesfjmuswjlrphsdthmuqkrhynmqnfqdlwnwesdmiiqvcpingbcgcsvqmsmskesrajqwmgtdoktreqssutpudfykriqhblntfabspbeddpdkownehqszbmddizdgtqmobirwbopmoqzwydnpqnvkwadajbecmajilzkfwjnpfyamudpppuxhlcngkign";
        String pattern = "rr";
        int expected = 496;
        Assertions.assertEquals(expected, solution6021.maximumSubsequenceCount(text, pattern));
    }
}