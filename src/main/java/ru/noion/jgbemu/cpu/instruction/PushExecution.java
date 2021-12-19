package ru.noion.jgbemu.cpu.instruction;

import ru.noion.jgbemu.Bus;
import ru.noion.jgbemu.cpu.CpuState;
import ru.noion.jgbemu.cpu.RegisterType;
import ru.noion.jgbemu.cpu.Registers;

public class PushExecution implements InstructionExecution {

    @Override
    public void execute(CpuState cpuState, Bus bus, Instruction instruction, byte[] data) {
        var registerFrom = instruction.getRegisterFrom();
        if (registerFrom != null && registerFrom.getRegisterType().length == 2) {
            var registers = cpuState.getRegisters();
            push(bus, registerFrom.getRegisterType()[0], registers);
            push(bus, registerFrom.getRegisterType()[1], registers);
        }
    }

    private void push(Bus bus, RegisterType registerType, Registers registers) {
        var sp = registers.getSpAndDecrement();
        var registerData = registers.getRegister(registerType);
        bus.write(sp, registerData);
    }
}
