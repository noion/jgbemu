package ru.noion.jgbemu.cpu;

import lombok.experimental.UtilityClass;

import java.util.HashMap;
import java.util.Map;

@UtilityClass
public class CpuInstruction {

    private static final Map<Byte, Instruction> instructions;

    static {
        var tmpInstructions = new HashMap<Byte, Instruction>();
        tmpInstructions.put((byte) 0x00, Instruction.builder()
                .instructionMnemonic(InstructionMnemonic.NOP)
                .build());
        //add all
        tmpInstructions.put((byte) 0xC3, Instruction.builder()
                .instructionMnemonic(InstructionMnemonic.JP)
                .addressMode(AddressMode.D16)
                .build());
        instructions = Map.copyOf(tmpInstructions);
    }

    Instruction getInstructionByOpCode(byte opCode) {
        var instruction = instructions.get(opCode);
        if (instruction == null) {
            System.out.printf("Unknown opCode %s%n", opCode);
        }
        System.out.printf("Instruction %s%n", instruction);
        return instruction;
    }
}