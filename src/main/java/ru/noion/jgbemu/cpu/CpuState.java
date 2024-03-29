package ru.noion.jgbemu.cpu;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
public class CpuState {

    @Setter
    private boolean halt = false;
    @Setter
    //Interrupt Master Enable Flag
    private boolean ime = true;
    private final Registers registers = new Registers();
}