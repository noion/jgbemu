package ru.noion.jgbemu.header;

import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.Arrays;

@ToString
@RequiredArgsConstructor
public enum CartridgeType {
    ROM_ONLY((byte) 0x00, "ROM ONLY"),
    MBC1((byte) 0x01, "MBC1"),
    MBC1_RAM((byte) 0x02, "MBC1+RAM"),
    MBC1_RAM_BATTERY((byte) 0x03, "MBC1+RAM+BATTERY"),
    MBC2((byte) 0x05, "MBC2"),
    MBC2_BATTERY((byte) 0x06, "MBC2+BATTERY"),
    ROM_RAM_1((byte) 0x08, "ROM+RAM 1"),
    ROM_RAM_BATTERY_1((byte) 0x09, "ROM+RAM+BATTERY 1"),
    MMM01((byte) 0x0B, "MMM01"),
    MMM01_RAM((byte) 0x0C, "MMM01+RAM"),
    MMM01_RAM_BATTERY((byte) 0x0D, "MMM01+RAM+BATTERY"),
    MBC3_TIMER_BATTERY((byte) 0x0F, "MBC3+TIMER+BATTERY"),
    MBC3_TIMER_RAM_BATTERY_2((byte) 0x10, "MBC3+TIMER+RAM+BATTERY 2"),
    MBC3((byte) 0x11, "MBC3"),
    MBC3_RAM_2((byte) 0x12, "MBC3+RAM 2"),
    MBC3_RAM_BATTERY_2((byte) 0x13, "MBC3+RAM+BATTERY 2"),
    MBC5((byte) 0x19, "MBC5"),
    MBC5_RAM((byte) 0x1A, "MBC5+RAM"),
    MBC5_RAM_BATTERY((byte) 0x1B, "MBC5+RAM+BATTERY"),
    MBC5_RUMBLE((byte) 0x1C, "MBC5+RUMBLE"),
    MBC5_RUMBLE_RAM((byte) 0x1D, "MBC5+RUMBLE+RAM"),
    MBC5_RUMBLE_RAM_BATTERY((byte) 0x1E, "MBC5+RUMBLE+RAM+BATTERY"),
    MBC6((byte) 0x20, "MBC6"),
    MBC7_SENSOR_RUMBLE_RAM_BATTERY((byte) 0x22, "MBC7+SENSOR+RUMBLE+RAM+BATTERY"),
    POCKET_CAMERA((byte) 0xFC, "POCKET CAMERA"),
    BANDAI_TAMA5((byte) 0xFD, "BANDAI TAMA5"),
    HuC3((byte) 0xFE, "HuC3"),
    HuC1_RAM_BATTERY((byte) 0xFF, "HuC1+RAM+BATTERY");


    private final byte code;
    private final String type;

    public static CartridgeType getByCode(byte code) {
        return Arrays.stream(CartridgeType.values())
                .filter(cartridgeType -> cartridgeType.code == code)
                .findAny()
                .orElseThrow(() -> new EnumConstantNotPresentException(CartridgeType.class, String.valueOf(code)));
    }
}