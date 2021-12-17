package ru.noion.jgbemu.cpu;

import lombok.AccessLevel;
import lombok.Getter;

@Getter(AccessLevel.PACKAGE)
public class CpuState {

    private final boolean halt = false;
    private final Registers registers = new Registers();
}