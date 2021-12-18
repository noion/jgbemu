package ru.noion.jgbemu.cpu.instruction;

import ru.noion.jgbemu.Bus;
import ru.noion.jgbemu.cpu.CpuState;

public class DiExecution implements InstructionExecution {
    @Override
    public boolean execute(CpuState cpuState, Bus bus, Instruction instruction, Short data) {
        cpuState.setIme(false);
        return true;
    }
}
