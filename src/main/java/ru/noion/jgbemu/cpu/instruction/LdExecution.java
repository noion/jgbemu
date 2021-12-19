package ru.noion.jgbemu.cpu.instruction;

import ru.noion.jgbemu.Bus;
import ru.noion.jgbemu.cpu.AddressMode;
import ru.noion.jgbemu.cpu.CpuState;

public class LdExecution implements InstructionExecution {

    @Override
    public void execute(CpuState cpuState, Bus bus, Instruction instruction, byte[] data) {
        var registerTo = instruction.getRegisterTo();
        var registerFrom = instruction.getRegisterFrom();
        var addressMode = instruction.getAddressMode();
        var registers = cpuState.getRegisters();
        if (addressMode == AddressMode.D16_REG && registerTo != null) {
            var value = ByteArrayConvertor.byteArrayToShort(data);
            registers.setRegister(registerTo, value);
        } else if (addressMode == AddressMode.REG_MEM && registerFrom != null) {
            var registerByte = registers.getRegister(registerFrom);
            var value = ByteArrayConvertor.byteArrayToShort(data);
            bus.write(value, registerByte);
        } else if (addressMode == AddressMode.D8_REG && registerTo != null) {
            var value = data[0];
            registers.setRegister(registerTo, value);
        } else {
            throw new UnsupportedOperationException(instruction.toString());
        }
    }
}
