package ru.noion.jgbemu.cpu;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public enum AddressMode {
    NONE,
    REG_D16(DataFetchMode.D16),
    REG_D8(DataFetchMode.D8),
    REG_REG,
    REG_MEM(DataFetchMode.D16),
    REG_A8(DataFetchMode.D8),
    REG_A16(DataFetchMode.D16),
    REG,
    D16(DataFetchMode.D16),
    D8(DataFetchMode.D8),
    A16(DataFetchMode.D16),
    D16_REG(DataFetchMode.D16),
    D8_REG(DataFetchMode.D8),
    MEM_REG(DataFetchMode.D16),
    A8_REG(DataFetchMode.D8);

    private final DataFetchMode dataFetchMode;

    AddressMode() {
        this.dataFetchMode = DataFetchMode.NONE;
    }
}