package ru.noion.jgbemu;

import lombok.experimental.UtilityClass;
import ru.noion.jgbemu.cpu.Registers;

@UtilityClass
public class StackUtility {

    public byte pop(Registers registers, Bus bus) {
        var sp = registers.getSpAndIncrement();
        return bus.read(sp);
    }

    public void push(Bus bus, Registers registers, byte data) {
        var sp = registers.getSpAndDecrement();
        bus.write(sp, data);
    }
}
