package ru.noion.jgbemu.cpu.instruction;

import ru.noion.jgbemu.Bus;
import ru.noion.jgbemu.cpu.AddressMode;
import ru.noion.jgbemu.cpu.CpuState;

public class JpExecution extends ConditionalInstructionExecution {

    @Override
    public void execute(CpuState cpuState, Bus bus, Instruction instruction, byte[] data) {
        boolean executed = executeWithCondition(cpuState, bus, instruction, data);
        if (!executed && instruction.getAddressMode() == AddressMode.REG && instruction.getRegisterFrom() != null &&
                instruction.getRegisterFrom().getRegisterType().length == 2) {
            var registerType = instruction.getRegisterFrom().getRegisterType();
            var registers = cpuState.getRegisters();
            var hi = registers.getRegister(registerType[0]);
            var lo = registers.getRegister(registerType[1]);
            ByteArrayConvertor.byteArrayToShort(lo, hi);
        }
    }

    @Override
    protected void defaultLogic(CpuState cpuState, Bus bus, byte[] data) {
        var value = ByteArrayConvertor.byteArrayToShort(data);
        cpuState.getRegisters().setPC(value);
    }
}