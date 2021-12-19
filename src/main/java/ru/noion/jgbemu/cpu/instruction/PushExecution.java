package ru.noion.jgbemu.cpu.instruction;

import ru.noion.jgbemu.Bus;
import ru.noion.jgbemu.StackUtility;
import ru.noion.jgbemu.cpu.AddressMode;
import ru.noion.jgbemu.cpu.CpuState;
import ru.noion.jgbemu.cpu.RegisterType;
import ru.noion.jgbemu.cpu.Registers;

public class PushExecution implements InstructionExecution {

    @Override
    public void execute(CpuState cpuState, Bus bus, Instruction instruction, byte[] data) {
        var registerFrom = instruction.getRegisterFrom();
        if (instruction.getAddressMode() == AddressMode.REG && registerFrom != null &&
                registerFrom.getRegisterType().length == 2) {
            var registers = cpuState.getRegisters();
            pushFromRegister(bus, registerFrom.getRegisterType()[0], registers);
            pushFromRegister(bus, registerFrom.getRegisterType()[1], registers);
        }
    }

    private void pushFromRegister(Bus bus, RegisterType registerType, Registers registers) {
        var registerData = registers.getRegister(registerType);
        StackUtility.push(bus, registers, registerData);
    }
}
