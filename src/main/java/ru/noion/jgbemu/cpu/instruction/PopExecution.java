package ru.noion.jgbemu.cpu.instruction;

import ru.noion.jgbemu.Bus;
import ru.noion.jgbemu.cpu.CpuState;
import ru.noion.jgbemu.cpu.RegisterType;
import ru.noion.jgbemu.cpu.Registers;

public class PopExecution implements InstructionExecution {

    @Override
    public boolean execute(CpuState cpuState, Bus bus, Instruction instruction, byte[] data) {
        var registerTo = instruction.getRegisterTo();
        if (registerTo != null && registerTo.getRegisterType().length == 2) {
            var registers = cpuState.getRegisters();
            popAndSetRegister(bus, registerTo.getRegisterType()[1], registers);
            popAndSetRegister(bus, registerTo.getRegisterType()[0], registers);
        }
        return true;
    }

    private void popAndSetRegister(Bus bus, RegisterType registerTo, Registers registers) {
        var pop = pop(registers, bus);
        registers.setRegister(registerTo, pop);
    }

    private byte pop(Registers registers, Bus bus) {
        var sp = registers.getSpAndIncrement();
        return bus.read(sp);
    }
}
