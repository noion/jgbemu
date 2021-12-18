package ru.noion.jgbemu.cpu.instruction;

import ru.noion.jgbemu.Bus;
import ru.noion.jgbemu.cpu.CpuState;

public class JpExecution implements InstructionExecution {

    @Override
    public boolean execute(CpuState cpuState, Bus bus, Instruction instruction, Short data) {
        cpuState.getRegisters().setPC(data);
        return true;
    }
}