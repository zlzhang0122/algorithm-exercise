package com.github.algorithm.util;

/**
 * @Author: zlzhang0122
 * @Date: 2021/11/26 下午9:01
 */
public class MathUtils {
    public static int murmurHash(int code) {
        code *= 0xcc9e2d51;
        code = Integer.rotateLeft(code, 15);
        code *= 0x1b873593;

        code = Integer.rotateLeft(code, 13);
        code = code * 5 + 0xe6546b64;

        code ^= 4;
        code = bitMix(code);

        if (code >= 0) {
            return code;
        } else if (code != Integer.MIN_VALUE) {
            return -code;
        } else {
            return 0;
        }
    }

    public static int bitMix(int in) {
        in ^= in >>> 16;
        in *= 0x85ebca6b;
        in ^= in >>> 13;
        in *= 0xc2b2ae35;
        in ^= in >>> 16;
        return in;
    }
}
