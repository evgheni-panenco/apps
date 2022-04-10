package apps.util;

import lombok.val;
import org.apache.commons.lang3.StringUtils;

public class BinaryUtil {

    public final static int BITS_NUMBER = 7;

    public static String toBinaryForm(final int x) {
        val binaryForm = Integer.toBinaryString(x);
        return StringUtils.repeat("0", BITS_NUMBER - binaryForm.length()) + binaryForm;
    }
}
