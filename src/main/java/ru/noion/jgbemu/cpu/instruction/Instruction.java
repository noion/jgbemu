package ru.noion.jgbemu.cpu.instruction;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import ru.noion.jgbemu.cpu.AddressMode;
import ru.noion.jgbemu.cpu.ConditionType;
import ru.noion.jgbemu.cpu.InstructionMnemonic;
import ru.noion.jgbemu.cpu.RegisterType;

@Getter
@Builder
@ToString
public class Instruction {
    private final InstructionMnemonic instructionMnemonic;
    private final AddressMode addressMode;
    private final RegisterType registerFrom;
    private final RegisterType registerTo;
    private final ConditionType conditionType;
    private final byte duration; // TODO may be not need not in current state not obvious
    private final InstructionExecution instructionExecution;
}
