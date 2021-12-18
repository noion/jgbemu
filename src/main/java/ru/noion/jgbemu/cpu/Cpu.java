package ru.noion.jgbemu.cpu;

import lombok.RequiredArgsConstructor;
import ru.noion.jgbemu.Bus;
import ru.noion.jgbemu.ConvertToUnsigned;
import ru.noion.jgbemu.cpu.instruction.Instruction;

@RequiredArgsConstructor
public class Cpu {

    private final CpuState cpuState;
    private final Bus bus;

    public boolean cpuStep() {
        if (!cpuState.isHalt()) {
            var instruction = fetchInstruction();
            System.out.printf("Instruction %s%n", instruction);
            var data = fetchData(instruction);
            System.out.printf("%s %n", data);
            System.out.printf("Cpu state before execute %s%n", cpuState);
            instruction.getInstructionExecution().execute(cpuState, bus, instruction, data);
            System.out.printf("Cpu state before after %s%n", cpuState);
            return true;
        }
        return false;
    }

    private Instruction fetchInstruction() {
        var pc = cpuState.getRegisters().getPcAndIncrement();
        var opCode = bus.read(pc);
        return CpuInstruction.getInstructionByOpCode(opCode);
    }

    private Short fetchData(Instruction instruction) {
        var addressMode = instruction.getAddressMode();
        switch (addressMode) {
            case NONE:
                return null;
            case D16:
                var pc = cpuState.getRegisters().getPcAndIncrement();
                byte lo = bus.read(pc);
                pc = cpuState.getRegisters().getPcAndIncrement();
                short hi = bus.read(pc);
                return (short) (ConvertToUnsigned.unsigned(lo) | hi << 8);
            case D8:
                pc = cpuState.getRegisters().getPcAndIncrement();
                return (short) bus.read(pc);
            default:
                throw new UnsupportedOperationException(instruction.toString());
        }
    }
}