package ru.noion.jgbemu.cpu;

import lombok.experimental.UtilityClass;
import ru.noion.jgbemu.ByteToHexConvertor;
import ru.noion.jgbemu.cpu.instruction.AdcExecution;
import ru.noion.jgbemu.cpu.instruction.CpExecution;
import ru.noion.jgbemu.cpu.instruction.DiExecution;
import ru.noion.jgbemu.cpu.instruction.Instruction;
import ru.noion.jgbemu.cpu.instruction.JpExecution;
import ru.noion.jgbemu.cpu.instruction.LdExecution;
import ru.noion.jgbemu.cpu.instruction.LdhExecution;
import ru.noion.jgbemu.cpu.instruction.NopExecution;
import ru.noion.jgbemu.cpu.instruction.PopExecution;
import ru.noion.jgbemu.cpu.instruction.PushExecution;

import java.util.HashMap;
import java.util.Map;

@UtilityClass
public class CpuInstruction {

    private static final Map<Byte, Instruction> instructions;

    static {
        var ldExecution = new LdExecution();
        var popExecution = new PopExecution();
        var pushExecution = new PushExecution();
        var tmpInstructions = new HashMap<Byte, Instruction>();
        tmpInstructions.put((byte) 0x00, Instruction.builder()
                .instructionMnemonic(InstructionMnemonic.NOP)
                .addressMode(AddressMode.NONE)
                .instructionExecution(new NopExecution())
                .build());
        //TODO add all
        tmpInstructions.put((byte) 0x31, Instruction.builder()
                .instructionMnemonic(InstructionMnemonic.LD)
                .addressMode(AddressMode.D16_REG)
                .registerTo(RegisterType.SP)
                .instructionExecution(ldExecution)
                .build());
        tmpInstructions.put((byte) 0x3E, Instruction.builder()
                .instructionMnemonic(InstructionMnemonic.LD)
                .addressMode(AddressMode.D8_REG)
                .registerTo(RegisterType.A)
                .instructionExecution(ldExecution)
                .build());
        tmpInstructions.put((byte) 0xC1, Instruction.builder()
                .instructionMnemonic(InstructionMnemonic.POP)
                .addressMode(AddressMode.NONE)
                .registerTo(RegisterType.BC)
                .instructionExecution(popExecution)
                .build());
        tmpInstructions.put((byte) 0xC3, Instruction.builder()
                .instructionMnemonic(InstructionMnemonic.JP)
                .addressMode(AddressMode.D16)
                .instructionExecution(new JpExecution())
                .build());
        tmpInstructions.put((byte) 0xC5, Instruction.builder()
                .instructionMnemonic(InstructionMnemonic.PUSH)
                .addressMode(AddressMode.NONE)
                .registerFrom(RegisterType.BC)
                .instructionExecution(pushExecution)
                .build());
        tmpInstructions.put((byte) 0xCE, Instruction.builder()
                .instructionMnemonic(InstructionMnemonic.ADC)
                .addressMode(AddressMode.D8_REG)
                .registerTo(RegisterType.A)
                .instructionExecution(new AdcExecution())
                .build());
        tmpInstructions.put((byte) 0xD1, Instruction.builder()
                .instructionMnemonic(InstructionMnemonic.POP)
                .addressMode(AddressMode.NONE)
                .registerTo(RegisterType.DE)
                .instructionExecution(popExecution)
                .build());
        tmpInstructions.put((byte) 0xD5, Instruction.builder()
                .instructionMnemonic(InstructionMnemonic.PUSH)
                .addressMode(AddressMode.NONE)
                .registerFrom(RegisterType.DE)
                .instructionExecution(pushExecution)
                .build());
        tmpInstructions.put((byte) 0xE0, Instruction.builder()
                .instructionMnemonic(InstructionMnemonic.LDH)
                .addressMode(AddressMode.REG_A8)
                .registerFrom(RegisterType.A)
                .instructionExecution(new LdhExecution())
                .build());
        tmpInstructions.put((byte) 0xE1, Instruction.builder()
                .instructionMnemonic(InstructionMnemonic.POP)
                .addressMode(AddressMode.NONE)
                .registerTo(RegisterType.HL)
                .instructionExecution(popExecution)
                .build());
        tmpInstructions.put((byte) 0xE5, Instruction.builder()
                .instructionMnemonic(InstructionMnemonic.PUSH)
                .addressMode(AddressMode.NONE)
                .registerFrom(RegisterType.HL)
                .instructionExecution(pushExecution)
                .build());
        tmpInstructions.put((byte) 0xEA, Instruction.builder()
                .instructionMnemonic(InstructionMnemonic.LD)
                .addressMode(AddressMode.REG_MEM)
                .registerFrom(RegisterType.A)
                .instructionExecution(ldExecution)
                .build());
        tmpInstructions.put((byte) 0xF1, Instruction.builder()
                .instructionMnemonic(InstructionMnemonic.POP)
                .addressMode(AddressMode.NONE)
                .registerTo(RegisterType.AF)
                .instructionExecution(popExecution)
                .build());
        tmpInstructions.put((byte) 0xF5, Instruction.builder()
                .instructionMnemonic(InstructionMnemonic.PUSH)
                .addressMode(AddressMode.NONE)
                .registerFrom(RegisterType.AF)
                .instructionExecution(pushExecution)
                .build());
        tmpInstructions.put((byte) 0xFE, Instruction.builder()
                .instructionMnemonic(InstructionMnemonic.CP)
                .addressMode(AddressMode.D8)
                .instructionExecution(new CpExecution())
                .build());
        tmpInstructions.put((byte) 0xF3, Instruction.builder()
                .instructionMnemonic(InstructionMnemonic.DI)
                .addressMode(AddressMode.NONE)
                .instructionExecution(new DiExecution())
                .build());
        instructions = Map.copyOf(tmpInstructions);
    }

    Instruction getInstructionByOpCode(byte opCode) {
        var instruction = instructions.get(opCode);
        if (instruction == null) {
            System.out.printf("Unknown opCode %s%n", ByteToHexConvertor.bytesToHex(opCode));
            throw new UnsupportedOperationException(String.valueOf(opCode));
        }
        return instruction;
    }
}