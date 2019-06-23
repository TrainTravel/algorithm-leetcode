package Lib;

/**
 * @author BorisMirage
 * Time: 2019/06/22 16:18
 * Created with IntelliJ IDEA
 */

public class VersionControl {
    public VersionControl() {

    }

    public boolean isBadVersion(int version) {
        return version / 2 == 0;
    }
}
