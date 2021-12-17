package ru.noion.jgbemu.cpu;

public interface InstructionExecution {

    //TODO may be not correct signature
    boolean execute(CpuState cpuState, Instruction instruction, Short data);
}