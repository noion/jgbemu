package ru.noion.jgbemu.cpu.instruction;

import ru.noion.jgbemu.Bus;
import ru.noion.jgbemu.StackUtility;
import ru.noion.jgbemu.cpu.AddressMode;
import ru.noion.jgbemu.cpu.CpuState;

public class CallExecution extends ConditionalInstructionExecution {

    @Override
    public void execute(CpuState cpuState, Bus bus, Instruction instruction, byte[] data) {
        if (instruction.getAddressMode() == AddressMode.A16 && data != null && data.length == 2) {
            executeWithCondition(cpuState, bus, instruction, data);
        }
    }

    @Override
    protected void defaultLogic(CpuState cpuState, Bus bus, byte[] data) {
        var registers = cpuState.getRegisters();
        var pc = registers.getPC();
        var pcByteArray = ByteArrayConvertor.shortToByteArray(pc);
        StackUtility.push(bus, registers, pcByteArray[1]);
        StackUtility.push(bus, registers, pcByteArray[0]);
        var dataShort = ByteArrayConvertor.byteArrayToShort(data);
        registers.setPC(dataShort);
    }
}
