package ru.noion.jgbemu.cpu;

import lombok.Getter;

@Getter
public class CpuState {
    private final Registers registers = new Registers();
}