package ru.noion.jgbemu.cpu;

import lombok.experimental.UtilityClass;
import ru.noion.jgbemu.ByteToHexConvertor;
import ru.noion.jgbemu.cpu.instruction.AdcExecution;
import ru.noion.jgbemu.cpu.instruction.CallExecution;
import ru.noion.jgbemu.cpu.instruction.CpExecution;
import ru.noion.jgbemu.cpu.instruction.DiExecution;
import ru.noion.jgbemu.cpu.instruction.Instruction;
import ru.noion.jgbemu.cpu.instruction.JpExecution;
import ru.noion.jgbemu.cpu.instruction.JrExecution;
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
        var callExecution = new CallExecution();
        var jpExecution = new JpExecution();
        var jrExecution = new JrExecution();
        var tmpInstructions = new HashMap<Byte, Instruction>();
        tmpInstructions.put((byte) 0x00, Instruction.builder()
                .instructionMnemonic(InstructionMnemonic.NOP)
                .addressMode(AddressMode.NONE)
                .instructionExecution(new NopExecution())
                .build());
        tmpInstructions.put((byte) 0x18, Instruction.builder()
                .instructionMnemonic(InstructionMnemonic.JR)
                .addressMode(AddressMode.R8)
                .instructionExecution(jrExecution)
                .build());
        tmpInstructions.put((byte) 0x20, Instruction.builder()
                .instructionMnemonic(InstructionMnemonic.JR)
                .addressMode(AddressMode.R8)
                .conditionType(ConditionType.NZ)
                .instructionExecution(jrExecution)
                .build());
        tmpInstructions.put((byte) 0x28, Instruction.builder()
                .instructionMnemonic(InstructionMnemonic.JR)
                .addressMode(AddressMode.R8)
                .conditionType(ConditionType.Z)
                .instructionExecution(jrExecution)
                .build());
        tmpInstructions.put((byte) 0x30, Instruction.builder()
                .instructionMnemonic(InstructionMnemonic.JR)
                .addressMode(AddressMode.R8)
                .conditionType(ConditionType.NC)
                .instructionExecution(jrExecution)
                .build());
        tmpInstructions.put((byte) 0x31, Instruction.builder()
                .instructionMnemonic(InstructionMnemonic.LD)
                .addressMode(AddressMode.D16_REG)
                .registerTo(RegisterType.SP)
                .instructionExecution(ldExecution)
                .build());
        tmpInstructions.put((byte) 0x38, Instruction.builder()
                .instructionMnemonic(InstructionMnemonic.JR)
                .addressMode(AddressMode.R8)
                .conditionType(ConditionType.C)
                .instructionExecution(jrExecution)
                .build());
        tmpInstructions.put((byte) 0x3E, Instruction.builder()
                .instructionMnemonic(InstructionMnemonic.LD)
                .addressMode(AddressMode.D8_REG)
                .registerTo(RegisterType.A)
                .instructionExecution(ldExecution)
                .build());
        tmpInstructions.put((byte) 0xC1, Instruction.builder()
                .instructionMnemonic(InstructionMnemonic.POP)
                .addressMode(AddressMode.REG)
                .registerTo(RegisterType.BC)
                .instructionExecution(popExecution)
                .build());
        tmpInstructions.put((byte) 0xC2, Instruction.builder()
                .instructionMnemonic(InstructionMnemonic.JP)
                .addressMode(AddressMode.A16)
                .conditionType(ConditionType.NZ)
                .instructionExecution(jpExecution)
                .build());
        tmpInstructions.put((byte) 0xC3, Instruction.builder()
                .instructionMnemonic(InstructionMnemonic.JP)
                .addressMode(AddressMode.A16)
                .instructionExecution(jpExecution)
                .build());
        tmpInstructions.put((byte) 0xC4, Instruction.builder()
                .instructionMnemonic(InstructionMnemonic.CALL)
                .addressMode(AddressMode.A16)
                .conditionType(ConditionType.NZ)
                .instructionExecution(callExecution)
                .build());
        tmpInstructions.put((byte) 0xC5, Instruction.builder()
                .instructionMnemonic(InstructionMnemonic.PUSH)
                .addressMode(AddressMode.REG)
                .registerFrom(RegisterType.BC)
                .instructionExecution(pushExecution)
                .build());
        tmpInstructions.put((byte) 0xCA, Instruction.builder()
                .instructionMnemonic(InstructionMnemonic.JP)
                .addressMode(AddressMode.A16)
                .conditionType(ConditionType.Z)
                .instructionExecution(jpExecution)
                .build());
        tmpInstructions.put((byte) 0xCC, Instruction.builder()
                .instructionMnemonic(InstructionMnemonic.CALL)
                .addressMode(AddressMode.A16)
                .conditionType(ConditionType.Z)
                .instructionExecution(callExecution)
                .build());
        tmpInstructions.put((byte) 0xCD, Instruction.builder()
                .instructionMnemonic(InstructionMnemonic.CALL)
                .addressMode(AddressMode.A16)
                .instructionExecution(callExecution)
                .build());
        tmpInstructions.put((byte) 0xCE, Instruction.builder()
                .instructionMnemonic(InstructionMnemonic.ADC)
                .addressMode(AddressMode.D8_REG)
                .registerTo(RegisterType.A)
                .instructionExecution(new AdcExecution())
                .build());
        tmpInstructions.put((byte) 0xD1, Instruction.builder()
                .instructionMnemonic(InstructionMnemonic.POP)
                .addressMode(AddressMode.REG)
                .registerTo(RegisterType.DE)
                .instructionExecution(popExecution)
                .build());
        tmpInstructions.put((byte) 0xD2, Instruction.builder()
                .instructionMnemonic(InstructionMnemonic.JP)
                .addressMode(AddressMode.A16)
                .conditionType(ConditionType.NC)
                .instructionExecution(jpExecution)
                .build());
        tmpInstructions.put((byte) 0xD4, Instruction.builder()
                .instructionMnemonic(InstructionMnemonic.CALL)
                .addressMode(AddressMode.A16)
                .conditionType(ConditionType.NC)
                .instructionExecution(callExecution)
                .build());
        tmpInstructions.put((byte) 0xD5, Instruction.builder()
                .instructionMnemonic(InstructionMnemonic.PUSH)
                .addressMode(AddressMode.REG)
                .registerFrom(RegisterType.DE)
                .instructionExecution(pushExecution)
                .build());
        tmpInstructions.put((byte) 0xDA, Instruction.builder()
                .instructionMnemonic(InstructionMnemonic.JP)
                .addressMode(AddressMode.A16)
                .conditionType(ConditionType.C)
                .instructionExecution(jpExecution)
                .build());
        tmpInstructions.put((byte) 0xDC, Instruction.builder()
                .instructionMnemonic(InstructionMnemonic.CALL)
                .addressMode(AddressMode.A16)
                .conditionType(ConditionType.C)
                .instructionExecution(callExecution)
                .build());
        tmpInstructions.put((byte) 0xE0, Instruction.builder()
                .instructionMnemonic(InstructionMnemonic.LDH)
                .addressMode(AddressMode.REG_A8)
                .registerFrom(RegisterType.A)
                .instructionExecution(new LdhExecution())
                .build());
        tmpInstructions.put((byte) 0xE1, Instruction.builder()
                .instructionMnemonic(InstructionMnemonic.POP)
                .addressMode(AddressMode.REG)
                .registerTo(RegisterType.HL)
                .instructionExecution(popExecution)
                .build());
        tmpInstructions.put((byte) 0xE5, Instruction.builder()
                .instructionMnemonic(InstructionMnemonic.PUSH)
                .addressMode(AddressMode.REG)
                .registerFrom(RegisterType.HL)
                .instructionExecution(pushExecution)
                .build());
        tmpInstructions.put((byte) 0xE9, Instruction.builder()
                .instructionMnemonic(InstructionMnemonic.JP)
                .addressMode(AddressMode.REG)
                .instructionExecution(jpExecution)
                .build());
        tmpInstructions.put((byte) 0xEA, Instruction.builder()
                .instructionMnemonic(InstructionMnemonic.LD)
                .addressMode(AddressMode.REG_MEM)
                .registerFrom(RegisterType.A)
                .instructionExecution(ldExecution)
                .build());
        tmpInstructions.put((byte) 0xF1, Instruction.builder()
                .instructionMnemonic(InstructionMnemonic.POP)
                .addressMode(AddressMode.REG)
                .registerTo(RegisterType.AF)
                .instructionExecution(popExecution)
                .build());
        tmpInstructions.put((byte) 0xF5, Instruction.builder()
                .instructionMnemonic(InstructionMnemonic.PUSH)
                .addressMode(AddressMode.REG)
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