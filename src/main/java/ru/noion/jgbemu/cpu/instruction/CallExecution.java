package ru.noion.jgbemu.cpu.instruction;

import ru.noion.jgbemu.Bus;
import ru.noion.jgbemu.StackUtility;
import ru.noion.jgbemu.cpu.AddressMode;
import ru.noion.jgbemu.cpu.ConditionType;
import ru.noion.jgbemu.cpu.CpuState;

public class CallExecution implements InstructionExecution {

    @Override
    public void execute(CpuState cpuState, Bus bus, Instruction instruction, byte[] data) {
        if (instruction.getAddressMode() == AddressMode.A16 && data != null && data.length == 2) {
            var conditionType = instruction.getConditionType();
            if (conditionType != null) {
                callWithCondition(cpuState, bus, data, conditionType);
                return;
            }
            callLogic(cpuState, bus, data);
        }
    }

    private void callWithCondition(CpuState cpuState, Bus bus, byte[] data, ConditionType conditionType) {
        var registersPredicate = conditionType.getRegistersPredicate();
        if (registersPredicate.test(cpuState.getRegisters())) {
            callLogic(cpuState, bus, data);
        }
    }

    private void callLogic(CpuState cpuState, Bus bus, byte[] data) {
        var registers = cpuState.getRegisters();
        var pc = registers.getPC();
        var pcByteArray = ByteArrayConvertor.shortToByteArray(pc);
        StackUtility.push(bus, registers, pcByteArray[1]);
        StackUtility.push(bus, registers, pcByteArray[0]);
        var dataShort = ByteArrayConvertor.byteArrayToShort(data);
        registers.setPC(dataShort);
    }
}
