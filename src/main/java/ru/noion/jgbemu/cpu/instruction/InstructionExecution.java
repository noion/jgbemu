package ru.noion.jgbemu.cpu.instruction;

import ru.noion.jgbemu.Bus;
import ru.noion.jgbemu.cpu.CpuState;

public interface InstructionExecution {

    //TODO may be not correct signature
    boolean execute(CpuState cpuState, Bus bus, Instruction instruction, Short data);
}