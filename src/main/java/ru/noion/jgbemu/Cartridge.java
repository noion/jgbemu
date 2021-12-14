package ru.noion.jgbemu;

import ru.noion.jgbemu.header.CartridgeHeader;
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
            var romSize = RomSize.getByCode(cartridgeHeader.getCartridgeType());
            System.out.printf("Rom size %s%n", romSize);
            var ramSize = RamSize.getByCode(cartridgeHeader.getRamSize());
            System.out.printf("Ram size %s%n", ramSize);
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
        var licenseCode = ByteToHex.bytesToHex(cartridgeHeader.getOldLicenseeCode());
        var oldLicenseeCode = OldLicenseeCode.getByHexCode(licenseCode);
        System.out.printf("OldLicenseeCode %s%n", oldLicenseeCode);
    }
}