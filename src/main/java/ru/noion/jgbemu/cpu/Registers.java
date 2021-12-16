package ru.noion.jgbemu.cpu;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
//TODO need set?
@Setter
@ToString
public class Registers {
    private byte a = 0;
    private byte f = 0;
    private byte b = 0;
    private byte c = 0;
    private byte d = 0;
    private byte e = 0;
    private byte h = 0;
    private byte l = 0;
    private short sp = 0;
    private short pc = 0;

    public short getPcAndIncrement() {
        return pc++;
    }
}