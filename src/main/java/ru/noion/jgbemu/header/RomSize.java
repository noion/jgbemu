package ru.noion.jgbemu.header;

import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.Arrays;

@ToString
@RequiredArgsConstructor
public enum RomSize {
    BANK_2((byte) 0x00, 2),
    BANK_4((byte) 0x01, 4),
    BANK_8((byte) 0x02, 8),
    BANK_16((byte) 0x03, 16),
    BANK_32((byte) 0x04, 32),
    BANK_64((byte) 0x05, 64),
    BANK_128((byte) 0x06, 128),
    BANK_256((byte) 0x07, 256),
    BANK_512((byte) 0x08, 512),
    BANK_72((byte) 0x52, 72),
    BANK_80((byte) 0x53, 80),
    BANK_96((byte) 0x54, 96),
    ;

    private final byte code;
    private final int amountOfBanks;

    public static RomSize getByCode(byte code) {
        return Arrays.stream(RomSize.values())
                .filter(romSize -> romSize.code == code)
                .findAny()
                .orElseThrow(() -> new EnumConstantNotPresentException(NewLicenseeCode.class, String.valueOf(code)));
    }
}
