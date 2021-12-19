package ru.noion.jgbemu.cpu;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public enum RegisterType {
    A,
    F,
    B,
    C,
    D,
    E,
    H,
    L,
    AF(new RegisterType[]{A, F}),
    BC(new RegisterType[]{B, C}),
    DE(new RegisterType[]{D, E}),
    HL(new RegisterType[]{H, L}),
    SP,
    PC;

    private final RegisterType[] registerType;

    RegisterType() {
        this.registerType = new RegisterType[]{RegisterType.valueOf(this.toString())};
    }
}
