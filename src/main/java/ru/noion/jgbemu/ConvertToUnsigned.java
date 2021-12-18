package ru.noion.jgbemu;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ConvertToUnsigned {

    public short unsigned(byte value) {
        return (short) (0xFF & value);
    }

    public int unsigned(short value) {
        return 0xF000 & value;
    }
}