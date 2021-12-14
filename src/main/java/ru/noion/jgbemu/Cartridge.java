package ru.noion.jgbemu;

import ru.noion.jgbemu.header.CartridgeHeader;
import ru.noion.jgbemu.header.CartridgeType;
import ru.noion.jgbemu.header.NewLicenseeCode;
import ru.noion.jgbemu.header.OldLicenseeCode;
import ru.noion.jgbemu.header.RamSize;
import ru.noion.jgbemu.header.RomSize;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class Cartridge {

    public boolean loadCartridge(File romFile) {
        try {
            byte[] romData = Files.readAllBytes(romFile.toPath());
            System.out.printf("Rom file size %s%n", romData.length);
            System.out.println("Cartridge Loading:");
            var cartridgeHeader = new CartridgeHeader(romData);
            System.out.println(cartridgeHeader);
            System.out.printf("Title %s%n", cartridgeHeader.getTitle());
            printLicenseCode(cartridgeHeader);
            var cartridgeType = CartridgeType.getByCode(cartridgeHeader.getCartridgeType());
            System.out.printf("Cartridge type %s%n", cartridgeType);
            var romSize = RomSize.getByCode(cartridgeHeader.getRomSize());
            System.out.printf("Rom size %s%n", romSize);
            var ramSize = RamSize.getByCode(cartridgeHeader.getRamSize());
            System.out.printf("Ram size %s%n", ramSize);
            var isCheckPassed = checkHeader(romData, cartridgeHeader.getHeaderChecksum());
            System.out.printf("Check passed %s%n", isCheckPassed);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to load rom");
            return false;
        }
    }

    private void printLicenseCode(CartridgeHeader cartridgeHeader) {
        if (cartridgeHeader.isSgb()) {
            var licenseCode = new String(cartridgeHeader.getNewLicenseeCode(), StandardCharsets.US_ASCII);
            var newLicenseeCode = NewLicenseeCode.getByCode(licenseCode);
            System.out.printf("NewLicenseeCode %s%n", newLicenseeCode);
            return;
        }
        var oldLicenseeCode = OldLicenseeCode.getCode(cartridgeHeader.getOldLicenseeCode());
        System.out.printf("OldLicenseeCode %s%n", oldLicenseeCode);
    }

    private boolean checkHeader(byte[] romData, byte headerChecksum) {
        byte x = 0;
        for (var i = 0x0134; i <= 0x014C; i++) {
            x = (byte) (x - romData[i] - 1);
        }
        return headerChecksum == x;
    }
}