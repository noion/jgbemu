package ru.noion.jgbemu.header;

import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@RequiredArgsConstructor
public enum CartridgeType {

    ROM_ONLY("00",	"ROM ONLY"),
    MBC1("01",	"MBC1"),
    MBC1_RAM("02",	"MBC1+RAM"),
    MBC1_RAM_BATTERY("03",	"MBC1+RAM+BATTERY"),
    MBC2("05",	"MBC2"),
    MBC2_BATTERY("06",	"MBC2+BATTERY"),
    ROM_RAM_1("08",	"ROM+RAM 1"),
    ROM_RAM_BATTERY_1("09",	"ROM+RAM+BATTERY 1"),
    MMM01("0B",	"MMM01"),
    MMM01_RAM("0C",	"MMM01+RAM"),
    MMM01_RAM_BATTERY("0D",	"MMM01+RAM+BATTERY"),
    MBC3_TIMER_BATTERY("0F",	"MBC3+TIMER+BATTERY"),
    MBC3_TIMER_RAM_BATTERY_2("10",	"MBC3+TIMER+RAM+BATTERY 2"),
    MBC3("11",	"MBC3"),
    MBC3_RAM_2("12",	"MBC3+RAM 2"),
    MBC3_RAM_BATTERY_2("13",	"MBC3+RAM+BATTERY 2"),
    MBC5("19",	"MBC5"),
    MBC5_RAM("1A",	"MBC5+RAM"),
    MBC5_RAM_BATTERY("1B",	"MBC5+RAM+BATTERY"),
    MBC5_RUMBLE("1C",	"MBC5+RUMBLE"),
    MBC5_RUMBLE_RAM("1D",	"MBC5+RUMBLE+RAM"),
    MBC5_RUMBLE_RAM_BATTERY("1E",	"MBC5+RUMBLE+RAM+BATTERY"),
    MBC6("20",	"MBC6"),
    MBC7_SENSOR_RUMBLE_RAM_BATTERY("22",	"MBC7+SENSOR+RUMBLE+RAM+BATTERY"),
    POCKET_CAMERA("FC",	"POCKET CAMERA"),
    BANDAI_TAMA5("FD",	"BANDAI TAMA5"),
    HuC3("FE",	"HuC3"),
    HuC1_RAM_BATTERY("FF",	"HuC1+RAM+BATTERY");


    private final String hexCode;
    private final String type;

    public static CartridgeType getByHexCode(String hexCode) {
        return Arrays.stream(CartridgeType.values())
                .filter(cartridgeType -> cartridgeType.hexCode.equals(hexCode))
                .findAny()
                .orElseThrow(() -> new EnumConstantNotPresentException(CartridgeType.class, hexCode));
    }
}