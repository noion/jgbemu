package ru.noion.jgbemu.cpu;

import lombok.RequiredArgsConstructor;
import ru.noion.jgbemu.Bus;
import ru.noion.jgbemu.ConvertToUnsigned;

@RequiredArgsConstructor
public class Cpu {

    private final CpuState cpuState;
    private final Bus bus;

    public boolean cpuStep() {
        if (!cpuState.isHalt()) {
            var instruction = fetchInstruction();
            var data = fetchData(instruction);
            System.out.printf("%s %n", data);
            instruction.getInstructionExecution().execute(cpuState, instruction, data);
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