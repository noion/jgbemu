package ru.noion.jgbemu;

import ru.noion.jgbemu.header.CartridgeHeader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Cartridge {

    public boolean loadCartridge(File romFile) {
        try {
            byte[] romData = Files.readAllBytes(romFile.toPath());
            System.out.printf("Rom file size %s%n", romData.length);
            System.out.println("Cartridge Loading:");
            var cartridgeHeader = new CartridgeHeader(romData);
            System.out.println(cartridgeHeader);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to load rom");
            return false;
        }
    }
}