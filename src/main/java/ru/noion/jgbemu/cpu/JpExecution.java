package ru.noion.jgbemu.cpu;

public class JpExecution implements InstructionExecution {

    @Override
    public boolean execute(CpuState cpuState, Instruction instruction, Short data) {
        cpuState.getRegisters().setPC(data);
        return true;
    }
}