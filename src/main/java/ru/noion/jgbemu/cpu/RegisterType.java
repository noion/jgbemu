package ru.noion.jgbemu.cpu;

import lombok.ToString;

@ToString
public enum RegisterType {
    A,
    F,
    B,
    C,
    D,
    E,
    H,
    L,
    AF,
    BC,
    DE,
    HL,
    SP,
    PC;
}
