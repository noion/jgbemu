package ru.noion.jgbemu.cpu.instruction;

import ru.noion.jgbemu.Bus;
import ru.noion.jgbemu.cpu.AddressMode;
import ru.noion.jgbemu.cpu.CpuState;

public class LdhExecution implements InstructionExecution {
    @Override
    public void execute(CpuState cpuState, Bus bus, Instruction instruction, byte[] data) {
        var registerFrom = instruction.getRegisterFrom();
        if (instruction.getAddressMode() == AddressMode.REG_A8 && registerFrom != null) {
            var address = ByteArrayConvertor.byteArrayToShort(data[0], (byte) 0xFF);
            var registerValue = cpuState.getRegisters().getRegister(registerFrom);
            bus.write(address, registerValue);
        }
    }
}