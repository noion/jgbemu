package ru.noion.jgbemu.header;

import lombok.Getter;
import lombok.ToString;
import ru.noion.jgbemu.ByteDataExtractor;

import java.nio.charset.StandardCharsets;

@Getter
@ToString
public class CartridgeHeader {

    private final byte[] entryPoint;
    private final byte[] nintendoLogo;
    private final String title;
    private final String manufacturerCode;
    private final byte cgbFlag;
    private final byte[] newLicenseeCode;
    private final byte sgbFlag;
    private final byte cartridgeType;
    private final byte romSize;
    private final byte ramSize;
    private final byte destinationCode;
    private final byte oldLicenseeCode;
    private final byte maskRomVersionNumber;
    private final byte headerChecksum;
    private final byte[] globalChecksum;

    public CartridgeHeader(byte[] romByteArray) {
        //0100-0103 - Entry Point
        entryPoint = ByteDataExtractor.extractData(romByteArray, 0x100, 0x104);
        //0104-0133 - Nintendo Logo
        nintendoLogo = ByteDataExtractor.extractData(romByteArray, 0x104, 0x134);
        //0134-0143 - Title
        var titleByteArray = ByteDataExtractor.extractData(romByteArray, 0x134, 0x144);
        title = new String(titleByteArray, StandardCharsets.US_ASCII).trim();
        //013F-0142 - Manufacturer Code
        var manufacturerCodeByteArray = ByteDataExtractor.extractData(romByteArray, 0x13F, 0x143);
        manufacturerCode = new String(manufacturerCodeByteArray, StandardCharsets.US_ASCII).trim();
        //0143 - CGB Flag
        cgbFlag = romByteArray[0x143];
        //0144-0145 - New Licensee Code
        newLicenseeCode = ByteDataExtractor.extractData(romByteArray, 0x144, 0x146);
        //0146 - SGB Flag
        sgbFlag = romByteArray[0x146];
        //0147 - Cartridge Type
        cartridgeType = romByteArray[0x147];
        //0148 - ROM Size
        romSize = romByteArray[0x148];
        //0149 - RAM Size
        ramSize = romByteArray[0x149];
        //014A - Destination Code
        destinationCode = romByteArray[0x14A];
        //014B - Old Licensee Code
        oldLicenseeCode = romByteArray[0x14B];
        //014C - Mask ROM Version number
        maskRomVersionNumber = romByteArray[0x14C];
        //014D - Header Checksum
        headerChecksum = romByteArray[0x14D];
        //014E-014F - Global Checksum
        globalChecksum = ByteDataExtractor.extractData(romByteArray, 0x14E, 0x150);
    }

    public boolean isCgbOnly() {
        //80h - Game supports CGB functions, but also works on old Game Boys.
        //C0h - Game works on CGB only (physically the same as $80).
        return cgbFlag == (byte) 0xC0;
    }

    public boolean isSgb() {
        //$00: No SGB functions (Normal Game Boy or CGB only game)
        //$03: Game supports SGB functions
        return sgbFlag == (byte) 0x03;
    }

    public boolean isJapanese() {
        //$00: Japanese
        //$01: Non-Japanese
        return destinationCode == (byte) 0x00;
    }

    public boolean isOldLicenseCode() {
        // A value of $33 signals that the New Licensee Code.
        // Super Game Boy functions won’t work if <> $33.
        return oldLicenseeCode == (byte) 0x33;
    }
}