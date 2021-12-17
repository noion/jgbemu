package ru.noion.jgbemu.cpu;

public class CpExecution implements InstructionExecution {

    @Override
    public boolean execute(CpuState cpuState, Instruction instruction, Short data) {
        var a = cpuState.getRegisters().getA();
        var registers = cpuState.getRegisters();
        registers.setFlag(Registers.Flag.n, true);
        var compare = a < data;
        registers.setFlag(Registers.Flag.c, compare);
        return true;
    }
}