package ru.noion.jgbemu;

import ru.noion.jgbemu.cpu.Cpu;
import ru.noion.jgbemu.cpu.CpuState;

import java.nio.file.Path;

public class Main {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: emu <rom_file>");
            return;
        }
        var filePath = args[0];
        System.out.printf("Rom file name %s%n", filePath);
        var cartridge = new Cartridge();
        var path = Path.of(filePath);
        var romFile = path.toFile();
        if (!romFile.exists() || !romFile.isFile()) {
            System.out.println("Rom file incorrect");
        }
        if (!cartridge.loadCartridge(romFile)) {
            System.out.println("Rom not load");
            return;
        }
        var cpuState = new CpuState();
        var ram = new Ram();
        var bus = new Bus(cartridge, ram);
        var cpu = new Cpu(cpuState, bus);
        while (true) {
            cpu.cpuStep();
        }
        //TODO calculate ticks
    }
}