package ru.noion.jgbemu;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ByteToHex {
    private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();

    public static String bytesToHex(byte... bytes) {
        if (bytes == null) {
            return null;
        }
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = HEX_ARRAY[v >>> 4];
            hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
        }
        return new String(hexChars);
    }

    public static String glorify(String hex) {
        var stringBuilder = new StringBuilder();
        for (int i = 0; i < hex.length(); i++) {
            if (i != 0 && i % 2 == 0) {
                stringBuilder.append(' ');
            }
            stringBuilder.append(hex.charAt(i));
        }
        return stringBuilder.toString();
    }
}