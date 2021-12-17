package ru.noion.jgbemu.cpu;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class Instruction {
    private final InstructionMnemonic instructionMnemonic;
    private final AddressMode addressMode;
    private final Registers registerFrom;
    private final Registers registerTo;
    private final ConditionType conditionType;
    private final byte duration; // TODO may be not need not in current state not obvious
    private final InstructionExecution instructionExecution;
}
