package ru.noion.jgbemu.cpu.instruction;

import lombok.experimental.UtilityClass;
import ru.noion.jgbemu.UnsignedConvertor;

@UtilityClass
public class ByteArrayConvertor {

    public short byteArrayToShort(byte[] bytes) {
        var lo = bytes[0];
        var hi = bytes[1];
        return (short) (UnsignedConvertor.unsigned(lo) | hi << 8);
    }
}