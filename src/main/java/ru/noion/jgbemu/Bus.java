package ru.noion.jgbemu;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Bus {

    //0000h – 3FFFh	ROM0			Non-switchable ROM Bank.
    //4000h – 7FFFh	ROMX			Switchable ROM bank.
    //8000h – 9FFFh	VRAM			Video RAM, switchable (0-1) in GBC mode.
    //A000h – BFFFh	SRAM			External RAM in cartridge, often battery buffered.
    //C000h – CFFFh	WRAM0			Work RAM.
    //D000h – DFFFh	WRAMX			Work RAM, switchable (1-7) in GBC mode
    //E000h – FDFFh	ECHO			Description of the behaviour below.
    //FE00h – FE9Fh	OAM				(Object Attribute Table) Sprite information table.
    //FEA0h – FEFFh	UNUSED			Description of the behaviour below.
    //FF00h – FF7Fh	I/O Registers	I/O registers are mapped here.
    //FF80h – FFFEh	HRAM			Internal CPU RAM
    //FFFFh			IE Register		Interrupt enable flags.

    private final Cartridge cartridge;
    private final Ram ram;

    public byte read(short address) {
        var unsignedAddress = UnsignedConvertor.unsigned(address);
        var maxRomAddress = 0x7FFF;
        var maxVRamAddress = 0x9FFF;
        var maxSRamAddress = 0xBFFF;
        var maxWRamAddress = 0xDFFF;
        var maxEchoAddress = 0xFDFF;
        var maxOamAddress = 0xFE9F;
        var maxUnusedAddress = 0xFEFF;
        var maxIORegistersAddress = 0xFF7F;
        var maxHRamAddress = 0xFFFE;
        var ieRegisterAddress = 0xFFFF;
        if (unsignedAddress <= maxRomAddress) {
//            ROM in cartridge.
            return cartridge.read(unsignedAddress);
        } else if (unsignedAddress <= maxVRamAddress) {
//            Video RAM, switchable (0-1) in GBC mode.
//            TODO
            throw new UnsupportedOperationException(String.valueOf(unsignedAddress));
        } else if (unsignedAddress <= maxSRamAddress) {
//            External RAM in cartridge, often battery buffered.
            return cartridge.read(unsignedAddress);
        } else if (unsignedAddress <= maxWRamAddress) {
//            Work RAM.
            return ram.readWRam(unsignedAddress);
        } else if (unsignedAddress <= maxEchoAddress) {
//            Reserved echo ram
            return 0;
        } else if (unsignedAddress <= maxOamAddress) {
//            (Object Attribute Table) Sprite information table.
//            TODO
            throw new UnsupportedOperationException(String.valueOf(unsignedAddress));
        } else if (unsignedAddress <= maxUnusedAddress) {
//            Unused ram
            throw new UnsupportedOperationException(String.valueOf(unsignedAddress));
        } else if (unsignedAddress <= maxIORegistersAddress) {
//            I/O registers are mapped here.
//            TODO
            throw new UnsupportedOperationException(String.valueOf(unsignedAddress));
        } else if (unsignedAddress <= maxHRamAddress) {
//            Internal CPU RAM
            return ram.readHRam(unsignedAddress);
        } else if (unsignedAddress == ieRegisterAddress) {
//            Interrupt enable flags
//            TODO
            throw new UnsupportedOperationException(String.valueOf(unsignedAddress));
        }
        throw new UnsupportedOperationException(String.valueOf(unsignedAddress));
    }

    public void write(short address, byte value) {
        var unsignedAddress = UnsignedConvertor.unsigned(address);
        var maxRomAddress = 0x7FFF;
        var maxVRamAddress = 0x9FFF;
        var maxSRamAddress = 0xBFFF;
        var maxWRamAddress = 0xDFFF;
        var maxEchoAddress = 0xFDFF;
        var maxOamAddress = 0xFE9F;
        var maxUnusedAddress = 0xFEFF;
        var maxIORegistersAddress = 0xFF7F;
        var maxHRamAddress = 0xFFFE;
        var ieRegisterAddress = 0xFFFF;
        if (unsignedAddress <= maxRomAddress) {
//            ROM in cartridge.
            cartridge.write(unsignedAddress, value);
        } else if (unsignedAddress <= maxVRamAddress) {
//            Video RAM, switchable (0-1) in GBC mode.
//            TODO
            throw new UnsupportedOperationException(String.valueOf(unsignedAddress));
        } else if (unsignedAddress <= maxSRamAddress) {
//            External RAM in cartridge, often battery buffered.
            cartridge.write(unsignedAddress, value);
            return;
        } else if (unsignedAddress <= maxWRamAddress) {
//            Work RAM.
            ram.writeWRam(unsignedAddress, value);
            return;
        } else if (unsignedAddress <= maxEchoAddress) {
//            Reserved echo ram
            return;
        } else if (unsignedAddress <= maxOamAddress) {
//            (Object Attribute Table) Sprite information table.
//            TODO
            throw new UnsupportedOperationException(String.valueOf(unsignedAddress));
        } else if (unsignedAddress <= maxUnusedAddress) {
//            Unused ram
            throw new UnsupportedOperationException(String.valueOf(unsignedAddress));
        } else if (unsignedAddress <= maxIORegistersAddress) {
//            I/O registers are mapped here.
//            TODO
            throw new UnsupportedOperationException(String.valueOf(unsignedAddress));
        } else if (unsignedAddress <= maxHRamAddress) {
//            Internal CPU RAM
            ram.writeHRam(unsignedAddress, value);
            return;
        } else if (unsignedAddress == ieRegisterAddress) {
//            Interrupt enable flags
//            TODO
            throw new UnsupportedOperationException(String.valueOf(unsignedAddress));
        }
        throw new UnsupportedOperationException(String.valueOf(unsignedAddress));
    }
}