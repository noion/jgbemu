package ru.noion.jgbemu.cpu.instruction;

import ru.noion.jgbemu.Bus;
import ru.noion.jgbemu.cpu.AddressMode;
import ru.noion.jgbemu.cpu.CpuState;

public class JrExecution extends ConditionalInstructionExecution {

    @Override
    public void execute(CpuState cpuState, Bus bus, Instruction instruction, byte[] data) {
        if (instruction.getAddressMode() == AddressMode.R8 && data != null && data.length == 1) {
            executeWithCondition(cpuState, bus, instruction, data);
        }
    }

    @Override
    protected void defaultLogic(CpuState cpuState, Bus bus, byte[] data) {
        var registers = cpuState.getRegisters();
        var pc = registers.getPC();
        pc += data[0];
        registers.setPC(pc);
    }
}
