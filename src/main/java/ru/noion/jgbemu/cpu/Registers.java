package ru.noion.jgbemu.cpu;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
//TODO need set?
@Setter
@ToString
public class Registers {
    private byte A = 0;
    private byte F = 0;
    private byte B = 0;
    private byte C = 0;
    private byte D = 0;
    private byte E = 0;
    private byte H = 0;
    private byte L = 0;
    private short SP = 0;
    private short PC = 0x100;

    public short getPcAndIncrement() {
        return PC++;
    }

    public boolean getFlagState(Flag flag) {
        return (F >> flag.position & 1) == 1;
    }

    public byte getFlag(Flag flag) {
        return (byte) (F >> flag.position & 1);
    }

    public void setFlag(Flag flag, boolean state) {
        if (state) {
            F |= 1 << flag.position;
        } else {
            F &= ~(1 << flag.position);
        }
    }

    @RequiredArgsConstructor
    public enum Flag {
        z((byte) 7),
        n((byte) 6),
        h((byte) 5),
        c((byte) 4);

        private final byte position;
    }
}