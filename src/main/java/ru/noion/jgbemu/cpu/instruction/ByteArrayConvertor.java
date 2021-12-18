package ru.noion.jgbemu.cpu.instruction;

import lombok.experimental.UtilityClass;
import ru.noion.jgbemu.ConvertToUnsigned;

@UtilityClass
public class ByteArrayConvertor {

    public short byteArrayToShort(byte[] bytes) {
        var lo = bytes[0];
        var hi = bytes[1];
        return (short) (ConvertToUnsigned.unsigned(lo) | hi << 8);
    }
}