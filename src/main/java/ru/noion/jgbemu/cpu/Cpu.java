package ru.noion.jgbemu.cpu;

import lombok.RequiredArgsConstructor;
import ru.noion.jgbemu.Bus;

@RequiredArgsConstructor
public class Cpu {

    private final CpuState cpuState;
    private final Bus bus;

    public boolean cpuStep() {
        fetchInstruction();
        //TODO fetchData for instruction if need
        //TODO execute instruction
        return false;
    }

    private void fetchInstruction() {
        var pc = cpuState.getRegisters().getPcAndIncrement();
        var opCode = bus.read(pc);
        CpuInstruction.getInstructionByOpCode(opCode);
    }
}
