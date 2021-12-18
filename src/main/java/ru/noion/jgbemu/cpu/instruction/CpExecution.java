package ru.noion.jgbemu.cpu.instruction;

import ru.noion.jgbemu.Bus;
import ru.noion.jgbemu.cpu.CpuState;
import ru.noion.jgbemu.cpu.Registers;

public class CpExecution implements InstructionExecution {

    @Override
    public boolean execute(CpuState cpuState, Bus bus, Instruction instruction, byte[] data) {
        var a = cpuState.getRegisters().getA();
        var registers = cpuState.getRegisters();
        registers.setFlag(Registers.Flag.n, true);
//        TODO check address mode
        var compare = a < data[0];
        registers.setFlag(Registers.Flag.c, compare);
        return true;
    }
}