package ru.noion.jgbemu.cpu;

public class AdcExecution implements InstructionExecution {

    @Override
    public boolean execute(CpuState cpuState, Instruction instruction, Short data) {
        var registers = cpuState.getRegisters();
        var a = registers.getA();
        a += data + registers.getFlag(Registers.Flag.c);
        registers.setA(a);
        registers.setFlag(Registers.Flag.n, false);
        return true;
    }
}