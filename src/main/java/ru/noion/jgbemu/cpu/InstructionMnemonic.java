package ru.noion.jgbemu.cpu;

public enum InstructionMnemonic {
    //Misc/control instructions
    NOP,
    STOP,
    HALT,
    DI,
    EI,
    //Jumps/calls
    JR,
    JP,
    RET,
    RETI,
    CALL,
    RST,
    //8bit load/store/move instructions
    LD,
    LDH,
    //16bit load/store/move instructions
    POP,
    PUSH,
    //8bit arithmetic/logical instructions
    ADD,
    SUB,
    ADC,
    SBC,
    AND,
    OR,
    INC,
    DEC,
    DAA,
    SCF,
    XOR,
    CP,
    //8bit rotations/shifts and bit instructions
    RLCA,
    RLA,
    RRCA,
    RRA,
    //Prefix CB
    RLC,
    RRC,
    RL,
    RR,
    SLA,
    SRA,
    SWAP,
    SRL,
    BIT,
    RES,
    SET;
}