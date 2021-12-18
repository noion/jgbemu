package ru.noion.jgbemu;

public class Ram {

    private final byte[] wRam = new byte[0x2000];
    private final byte[] hRam = new byte[0x80];

    public byte readWRam(int unsignedAddress) {
        unsignedAddress -= 0xC000;
        if (unsignedAddress >= 0x2000) {
            throw new UnsupportedOperationException(String.valueOf(unsignedAddress));
        }
        return wRam[unsignedAddress];
    }

    public void writeWRam(int unsignedAddress, byte value) {
        unsignedAddress -= 0xC000;
        if (unsignedAddress >= 0x2000) {
            throw new UnsupportedOperationException(String.valueOf(unsignedAddress));
        }
        wRam[unsignedAddress] = value;
    }

    public byte readHRam(int unsignedAddress) {
        unsignedAddress -= 0x80;
        if (unsignedAddress >= 80) {
            throw new UnsupportedOperationException(String.valueOf(unsignedAddress));
        }
        return hRam[unsignedAddress];
    }

    public void writeHRam(int unsignedAddress, byte value) {
        unsignedAddress -= 0x80;
        if (unsignedAddress >= 80) {
            throw new UnsupportedOperationException(String.valueOf(unsignedAddress));
        }
        hRam[unsignedAddress] = value;
    }
}
