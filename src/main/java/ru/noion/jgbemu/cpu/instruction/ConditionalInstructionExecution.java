package ru.noion.jgbemu.cpu.instruction;

import ru.noion.jgbemu.Bus;
import ru.noion.jgbemu.cpu.AddressMode;
import ru.noion.jgbemu.cpu.ConditionType;
import ru.noion.jgbemu.cpu.CpuState;

public abstract class ConditionalInstructionExecution implements InstructionExecution {

    protected boolean executeWithCondition(CpuState cpuState, Bus bus, Instruction instruction, byte[] data) {
        if (instruction.getAddressMode() == AddressMode.A16 && data != null && data.length == 2) {
            var conditionType = instruction.getConditionType();
            if (conditionType != null) {
                executeWithCondition(cpuState, bus, data, conditionType);
                return true;
            }
            defaultLogic(cpuState, bus, data);
            return true;
        }
        return false;
    }

    protected void executeWithCondition(CpuState cpuState, Bus bus, byte[] data, ConditionType conditionType) {
        var registersPredicate = conditionType.getRegistersPredicate();
        if (registersPredicate.test(cpuState.getRegisters())) {
            defaultLogic(cpuState, bus, data);
        }
    }

    protected abstract void defaultLogic(CpuState cpuState, Bus bus, byte[] data);
}
