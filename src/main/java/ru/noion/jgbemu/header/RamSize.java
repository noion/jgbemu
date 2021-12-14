package ru.noion.jgbemu.header;

import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.Arrays;

@ToString
@RequiredArgsConstructor
public enum RamSize {
    NO_RAM((byte) 0x00, 0),
    UNUSED((byte) 0x01, -1),
    BANK_1((byte) 0x02, 8192),
    BANK_4((byte) 0x03, 32768),
    BANK_16((byte) 0x04, 131072),
    BANK_8((byte) 0x05, 65536);

    private final byte code;
    private final long sizeByte;

    public static RamSize getByCode(byte code) {
        return Arrays.stream(RamSize.values())
                .filter(ramSize -> ramSize.code == code)
                .findAny()
                .orElseThrow(() -> new EnumConstantNotPresentException(NewLicenseeCode.class, String.valueOf(code)));
    }
}
