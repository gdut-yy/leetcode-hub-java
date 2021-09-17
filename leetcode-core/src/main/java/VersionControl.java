/**
 * VersionControl
 *
 * @since Solution278
 */
public class VersionControl {
    int bad;

    public VersionControl(int bad) {
        this.bad = bad;
    }

    boolean isBadVersion(int version) {
        return version >= bad;
    }
}