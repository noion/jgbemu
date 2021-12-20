package ru.noion.jgbemu.cpu.instruction;

import ru.noion.jgbemu.Bus;
import ru.noion.jgbemu.cpu.CpuState;
import ru.noion.jgbemu.cpu.Registers;

public class AdcExecution implements InstructionExecution {

    @Override
    public void execute(CpuState cpuState, Bus bus, Instruction instruction, byte[] data) {
        //TODO check is correct
        var registers = cpuState.getRegisters();
        var a = registers.getA();
//        TODO check address mode
        a += data[0] + registers.getFlag(Registers.Flag.c);
        registers.setA(a);
        registers.setFlag(Registers.Flag.n, false);
    }
}