import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1044Tests {
    private final Solution1044 solution1044 = new Solution1044();

    @Test
    public void example1() {
        String s = "banana";
        String expected = "ana";
        Assertions.assertEquals(expected, solution1044.longestDupSubstring(s));
    }

    @Test
    public void example2() {
        String s = "abcd";
        String expected = "";
        Assertions.assertEquals(expected, solution1044.longestDupSubstring(s));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/332229974/
        // 哈希冲突 BASE=26 MOD=10^9+7 hash=612244298
        // dacbececeeaebaecbdeecdbaeeeeeadececcdcabbddadecdddabdeeedccabbaebddedecccacdbdcbbcddc
        // dcedaddeaeddecdecbeebeedaadbcbbebcbeecedaabcacaabdbaecaeebeaedadbabecbaabbebadaccadee
        String s = UtUtils.loadingString("solution1044-example3-input.txt", 0);
        String expected = "dccdbcebdda";
        Assertions.assertEquals(expected, solution1044.longestDupSubstring(s));
    }

    @Test
    public void example4() {
        // https://leetcode.cn/submissions/detail/332230980/
        // 哈希冲突 BASE=26 MOD=10^9+9 hash=230526211
        // nbbljzuxyjslvdjocycekromsvcowbdquscmbvtpbhqectujmdvjnucdcxrwhalhclfhljqknjcaihuybdcwtempgeekhykmorfgopzootvprenqacxgkovsnanvtnbabhenqzrrkjlobnzkiabgqcpiyxfqhzuxteqfmeaalssfxuktnpaoohmcxsdjyoukyfdlelqrymginyvtzpfwhwzphbowpsyupyglvwxbhqocnfircfarycsxrxdfzpzaxmexthfknkptxafmjiwpeecughwgmbyemkusvxkwxyxdgxufcdurqoeswamvododfuwkcdgccfvackexifecomnobgfdoalkrpckhigobcralegsunbrobijtposrecubalvkrkoklbqsmvsveeazqgtiqrvqwulporfoivxwysqcwzbadycjravngdabaetlhncsmlbtobcaentmlpvtjfvkntvufumbigxacnerqogdnrurleqbiwmvpuvgzmuhxjkprdaujckrsicowesqvtegglhcgymcttqdxwzxhrmgcirlacwkzyvoynfhbbhabtyfcqfdkwjpcndcybojkazhmyjbnlsljcasqtphtogpfvmosoonpbakounqukawaqsranduqjmawmqynvzxmqxgcmztapbzhlggyjfmftrgtmxrrfvnuxvcjvfttiyduxraeysmcpqfuyjsiwunnklvxynvqmanllaiiftgcfftxlaxrtukczjvosnaejwkdwatolzvmxydheypeemjhegmbsupfpmeoketnrnpttbkgwoxffmltoliqzvkhxskszdkkftfrvhmjffacvafvhdqzsexeipfykexeqcrjzxtejghpemcoqlliheyjjdgtwcvhhstcfnqahvovtdbkjmgruciorzhywiyqhigmicyggtmbbptwwkrpwvoxwqladcqfdlhymmydmjvgdqcxutsxsfdasodibreowoiyjiifmdiggpdmkqterzppaejjeazbffspmajqxmxbdtttubakavciohbduspcxdybhzzepcknimtriabrlebbvsyleyfksyanaqsykbvotdfzunyfumobfgynstrazobcjntjcntddcogdsyjqgpctukhnrawscbwrpecmainibqtkxesyvrcrpiysrtiqkdxehjbovsfoldcrfctoamgcltdmphwtwpqvmkkzypwotkhzcplzxstnsdvugarkuvxbuedhrxipcmwyrixetuizofwjfosdhzsfovvxpcdkhdpnfiyjopufnopqfstnouygpvzhouiintykfxkt
        // nnqevzlndnwncofmtjkgxshqqntjcfhpbzxmhiebkreawllddumhjebpworxtvnwvkfvtvbvkilddvdaqvoesdfwuxqbdgttylkvjacjbufrcxexaopyddybfziickkfcfkuditudmaskgpwfbmaxevglqlpsznojbthnppikdexcfphfmhrzfemehvqtckmuqhuewljelhtqzptvquxfgsykdksuydqaoxhzgjxixobhfsehcbnrjzvgdwlryivwdstbiaajggszntwdoymwkiyemfjfdwaqgnqwwyllxubbhglwsstfeftngzqlnlqhxewxoireeqyllvbhgykqwpmfghjijwrtchabrsztgjzbpqwqobvssduzgfjrjdlshimopirlgarmmatznwawjynxujdryjmtlppftvnwxgajpovveeqxzlalaaxcgqoytcmplrgtbljuysybcjgiugmkszqgcrywpunzjcqxhbusuajowpxoeyincuwlsahvbzfcaxjiuxsgcpiolaanbewniihbigxruobajdhaqoqmzdsacyzjheyaagkabbawlffsmsnauyjzmmolsxqzacbatdirofgwlqhgwxnlrxmyzywwthextmfdkdfxiqcunamcnpfftsicxcsmhxphtustiewomntzzulkpjectzkgidvhiubqsgyereshkxbwfedmpwejixujbasmepnsjcrzmqztczpxpbtmwigdbsvfswxazxvxsrgicosfwtlbbuyxshymodhpdejdyojbldupcxtahuyabkpzpmyumooxtggazdkhjoyskzikrrxefoueqturcafszcsttemnkscafbalkoivwjowjrbkddvpdruhskghefrghnrcqutciajfplkvecppwpacobsfrluevebccyivelnruenavisglsiticlpzavruhnzlritvrktevphifrqqqdvkzynkzscxrjqjplptrjatzheypewhjhxqxvhszlvwxxsobbyypozcpqmlgqzhavmpcmxodbdxgytbybjvkblfyspvhxmejowdjrwzfviqsvvudsdwtqvtdxajlhfasbghfnfzkhfhkffpsctzwpiyrhhpvxnuyyllkzxytfbtehdycdigfbwpdmucjucabowgwehkrlbtknrorcnfkgsfzvgqtytcrsepykuowthayulbcikkuclovnhhlqxdzbaktsziaixgfxhqgpycmlekhbkofntjhxylqdtykmfmhikfwogyiwmjdejitzvxhdhzfpwpuozwtbezygdxsqeappvwaougxogcvstkynjah
        String s = UtUtils.loadingString("solution1044-example4-input.txt", 0);
        String expected = "ezyxc";
        String actual = solution1044.longestDupSubstring(s);
        System.out.println(actual);
        Assertions.assertEquals(expected, actual);
    }

    public static void main(String[] args) {
        String s = "nqevzlndnwncofmtjkgxshqqntjcfhpbzxmhiebkreawllddumhjebpworxtvnwvkfvtvbvkilddvdaqvoesdfwuxqbdgttylkvjacjbufrcxexaopyddybfziickkfcfkuditudmaskgpwfbmaxevglqlpsznojbthnppikdexcfphfmhrzfemehvqtckmuqhuewljelhtqzptvquxfgsykdksuydqaoxhzgjxixobhfsehcbnrjzvgdwlryivwdstbiaajggszntwdoymwkiyemfjfdwaqgnqwwyllxubbhglwsstfeftngzqlnlqhxewxoireeqyllvbhgykqwpmfghjijwrtchabrsztgjzbpqwqobvssduzgfjrjdlshimopirlgarmmatznwawjynxujdryjmtlppftvnwxgajpovveeqxzlalaaxcgqoytcmplrgtbljuysybcjgiugmkszqgcrywpunzjcqxhbusuajowpxoeyincuwlsahvbzfcaxjiuxsgcpiolaanbewniihbigxruobajdhaqoqmzdsacyzjheyaagkabbawlffsmsnauyjzmmolsxqzacbatdirofgwlqhgwxnlrxmyzywwthextmfdkdfxiqcunamcnpfftsicxcsmhxphtustiewomntzzulkpjectzkgidvhiubqsgyereshkxbwfedmpwejixujbasmepnsjcrzmqztczpxpbtmwigdbsvfswxazxvxsrgicosfwtlbbuyxshymodhpdejdyojbldupcxtahuyabkpzpmyumooxtggazdkhjoyskzikrrxefoueqturcafszcsttemnkscafbalkoivwjowjrbkddvpdruhskghefrghnrcqutciajfplkvecppwpacobsfrluevebccyivelnruenavisglsiticlpzavruhnzlritvrktevphifrqqqdvkzynkzscxrjqjplptrjatzheypewhjhxqxvhszlvwxxsobbyypozcpqmlgqzhavmpcmxodbdxgytbybjvkblfyspvhxmejowdjrwzfviqsvvudsdwtqvtdxajlhfasbghfnfzkhfhkffpsctzwpiyrhhpvxnuyyllkzxytfbtehdycdigfbwpdmucjucabowgwehkrlbtknrorcnfkgsfzvgqtytcrsepykuowthayulbcikkuclovnhhlqxdzbaktsziaixgfxhqgpycmlekhbkofntjhxylqdtykmfmhikfwogyiwmjdejitzvxhdhzfpwpuozwtbezygdxsqeappvwaougxogcvstkynjah";
        final int BASE = 26;
        final long MOD = 1000000009;

        long hash = 0;
        for (int i = 0; i < s.length(); i++) {
            hash = (hash * BASE + (s.charAt(i) - 'a')) % MOD;
        }
        System.out.println(hash);
    }
}
