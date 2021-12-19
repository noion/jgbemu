package ru.noion.jgbemu.cpu.instruction;

import ru.noion.jgbemu.Bus;
import ru.noion.jgbemu.cpu.CpuState;

public class NopExecution implements InstructionExecution {
    @Override
    public void execute(CpuState cpuState, Bus bus, Instruction instruction, byte[] data) {
    }
}