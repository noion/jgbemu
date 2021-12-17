package ru.noion.jgbemu.cpu;

import lombok.experimental.UtilityClass;
import ru.noion.jgbemu.ByteToHex;

import java.util.HashMap;
import java.util.Map;

@UtilityClass
public class CpuInstruction {

    private static final Map<Byte, Instruction> instructions;

    static {
        var tmpInstructions = new HashMap<Byte, Instruction>();
        tmpInstructions.put((byte) 0x00, Instruction.builder()
                .instructionMnemonic(InstructionMnemonic.NOP)
                .addressMode(AddressMode.NONE)
                .instructionExecution(new NopExecution())
                .build());
        //TODO add all
        tmpInstructions.put((byte) 0xC3, Instruction.builder()
                .instructionMnemonic(InstructionMnemonic.JP)
                .addressMode(AddressMode.D16)
                .instructionExecution(new JpExecution())
                .build());
        tmpInstructions.put((byte) 0xCE, Instruction.builder()
                .instructionMnemonic(InstructionMnemonic.ADC)
                .addressMode(AddressMode.D8)
                .instructionExecution(new AdcExecution())
                .build());
        tmpInstructions.put((byte) 0xFE, Instruction.builder()
                .instructionMnemonic(InstructionMnemonic.CP)
                .addressMode(AddressMode.D8)
                .instructionExecution(new CpExecution())
                .build());
        instructions = Map.copyOf(tmpInstructions);
    }

    Instruction getInstructionByOpCode(byte opCode) {
        var instruction = instructions.get(opCode);
        if (instruction == null) {
            System.out.printf("Unknown opCode %s%n", ByteToHex.bytesToHex(opCode));
            throw new UnsupportedOperationException(String.valueOf(opCode));
        }
        System.out.printf("Instruction %s%n", instruction);
        return instruction;
    }
}