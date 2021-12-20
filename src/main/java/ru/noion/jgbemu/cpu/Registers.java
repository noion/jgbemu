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

    public short getSpAndDecrement() {
        return --SP;
    }

    public short getSpAndIncrement() {
        return SP++;
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

    public void setRegister(RegisterType registerType, short value) {
        switch (registerType) {
            case SP:
                SP = value;
                break;
            default:
                throw new UnsupportedOperationException(registerType.toString());
        }
    }

    public void setRegister(RegisterType registerType, byte value) {
        switch (registerType) {
            case A:
                A = value;
                break;
            case F:
                F = value;
                break;
            case B:
                B = value;
                break;
            case C:
                C = value;
                break;
            case D:
                D = value;
                break;
            case E:
                E = value;
                break;
            case H:
                H = value;
                break;
            case L:
                L = value;
                break;
            default:
                throw new UnsupportedOperationException(registerType.toString());
        }
    }

    public byte getRegister(RegisterType registerType) {
        switch (registerType) {
            case A:
                return A;
            case F:
                return F;
            case B:
                return B;
            case C:
                return C;
            case D:
                return D;
            case E:
                return E;
            case H:
                return H;
            case L:
                return L;
            default:
                throw new UnsupportedOperationException(registerType.toString());
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