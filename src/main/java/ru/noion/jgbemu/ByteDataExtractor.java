package ru.noion.jgbemu;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ByteDataExtractor {

    public static byte[] extractData(byte[] romHeader, int offset, int end) {
        var result = new byte[end - offset];
        System.arraycopy(romHeader, offset, result, 0, result.length);
        return result;
    }
}