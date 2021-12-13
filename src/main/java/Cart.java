import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class Cart {

    private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();

    private static final String[] ROM_TYPES =
            {
                    "ROM ONLY",
                    "MBC1",
                    "MBC1+RAM",
                    "MBC1+RAM+BATTERY",
                    "0x04 ???",
                    "MBC2",
                    "MBC2+BATTERY",
                    "0x07 ???",
                    "ROM+RAM 1",
                    "ROM+RAM+BATTERY 1",
                    "0x0A ???",
                    "MMM01",
                    "MMM01+RAM",
                    "MMM01+RAM+BATTERY",
                    "0x0E ???",
                    "MBC3+TIMER+BATTERY",
                    "MBC3+TIMER+RAM+BATTERY 2",
                    "MBC3",
                    "MBC3+RAM 2",
                    "MBC3+RAM+BATTERY 2",
                    "0x14 ???",
                    "0x15 ???",
                    "0x16 ???",
                    "0x17 ???",
                    "0x18 ???",
                    "MBC5",
                    "MBC5+RAM",
                    "MBC5+RAM+BATTERY",
                    "MBC5+RUMBLE",
                    "MBC5+RUMBLE+RAM",
                    "MBC5+RUMBLE+RAM+BATTERY",
                    "0x1F ???",
                    "MBC6",
                    "0x21 ???",
                    "MBC7+SENSOR+RUMBLE+RAM+BATTERY"
                    //TODO add:
                    //$FC	POCKET CAMERA
                    //$FD	BANDAI TAMA5
                    //$FE	HuC3
                    //$FF	HuC1+RAM+BATTERY
            };

    public boolean loadCart(File romFile) {
        try {
            byte[] romData = Files.readAllBytes(romFile.toPath());
            System.out.printf("Rom file size %s%n", romData.length);
            byte[] romHeader = new byte[romData.length - 0x100];
            System.arraycopy(romData, 0x100, romHeader, 0, romHeader.length);
            System.out.println("Cartridge Loaded:");
            //0100-0103 - Entry Point
            var entryPointByteArray = extractDataFromHeader(romHeader, 0, 0x04);
            var entryPoint = bytesToHex(entryPointByteArray);
            System.out.printf("Entry point %s%n", entryPoint);
            //0104-0133 - Nintendo Logo
            var nintendoLogoByteArray = extractDataFromHeader(romHeader, 0x04, 0x34);
            var nintendoLogo = bytesToHex(nintendoLogoByteArray);
            System.out.printf("Nintendo logo %s%n", nintendoLogo);
            //0134-0143 - Title
            var titleByteArray = extractDataFromHeader(romHeader, 0x034, 0x44);
            var title = new String(titleByteArray, StandardCharsets.US_ASCII).trim();
            System.out.printf("Title %s%n", title);
            //TODO add extracting
            var cartridgeType = romHeader[0x47];
            System.out.printf("Cartridge type %s%n", ROM_TYPES[cartridgeType]);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to load rom");
            return false;
        }
    }

    private byte[] extractDataFromHeader(byte[] romHeader, int offset, int end) throws UnsupportedEncodingException {
        var result = new byte[end - offset];
        System.arraycopy(romHeader, offset, result, 0, result.length);
        return result;
    }

    public static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = HEX_ARRAY[v >>> 4];
            hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
        }
        var stringBuilder = new StringBuilder();
        for (int i = 0; i < hexChars.length; i++) {
            if (i != 0 && i % 2 == 0) {
                stringBuilder.append(' ');
            }
            stringBuilder.append(hexChars[i]);
        }
        return stringBuilder.toString();
    }
}
