package ru.noion.jgbemu.cpu;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.function.Predicate;

@Getter
@RequiredArgsConstructor
public enum ConditionType {
    NZ(registers -> !registers.getFlagState(Registers.Flag.z)),
    Z(registers -> registers.getFlagState(Registers.Flag.z)),
    NC(registers -> !registers.getFlagState(Registers.Flag.c)),
    C(registers -> registers.getFlagState(Registers.Flag.c));

    private final Predicate<Registers> registersPredicate;
}
