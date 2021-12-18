package ru.noion.jgbemu.cpu.instruction;

import ru.noion.jgbemu.Bus;
import ru.noion.jgbemu.cpu.AddressMode;
import ru.noion.jgbemu.cpu.CpuState;

public class LdExecution implements InstructionExecution {

    @Override
    public boolean execute(CpuState cpuState, Bus bus, Instruction instruction, Short data) {
        var registerTo = instruction.getRegisterTo();
        var registerFrom = instruction.getRegisterFrom();
        if (instruction.getAddressMode() == AddressMode.D16_REG && registerTo != null) {
            cpuState.getRegisters().setRegisterShort(registerTo, data);
        } else if (instruction.getAddressMode() == AddressMode.REG_MEM && registerFrom != null) {
            var registerByte = cpuState.getRegisters().getRegisterByte(registerFrom);
            bus.write(data, registerByte);
        } else {
            throw new UnsupportedOperationException(instruction.toString());
        }
        return true;
    }
}
