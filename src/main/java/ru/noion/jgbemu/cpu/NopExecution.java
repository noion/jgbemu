package ru.noion.jgbemu.cpu;

public class NopExecution implements InstructionExecution{
    @Override
    public boolean execute(CpuState cpuState, Instruction instruction, Short data) {
        return true;
    }
}