import java.nio.file.Path;

public class Main {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: emu <rom_file>");
            return;
        }
        var filePath = args[0];
        System.out.printf("Rom file name %s%n", filePath);
        var cart = new Cart();
        var path = Path.of(filePath);
        var romFile = path.toFile();
        if (!romFile.exists() || !romFile.isFile()) {
            System.out.println("Rom file incorrect");
        }
        if (!cart.loadCart(romFile)) {
            System.out.println("Rom not load");
            return;
        }
        //TODO calculate ticks
    }
}
