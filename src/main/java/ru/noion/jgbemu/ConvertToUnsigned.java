package ru.noion.jgbemu;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ConvertToUnsigned {

    public byte unsigned(byte value) {
        return (byte) (0xFF & value);
    }

    public short unsigned(short value) {
        return (short) (0xFFFF & value);
    }
}