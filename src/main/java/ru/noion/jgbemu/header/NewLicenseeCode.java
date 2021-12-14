package ru.noion.jgbemu.header;

import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@RequiredArgsConstructor
public enum NewLicenseeCode {
    NONE("00", "None"),
    NINTENDO_RD1("01", "Nintendo R&D1"),
    CAPCOM("08", "Capcom"),
    ELECTRONIC_ARTS("13", "Electronic Arts"),
    HUDSON_SOFT("18", "Hudson Soft"),
    B_AI("19", "b-ai"),
    KSS("20", "kss"),
    POW("22", "pow"),
    PCM_COMPLETE("24", "PCM Complete"),
    SAN_X("25", "san-x"),
    KEMCO_JAPAN("28", "Kemco Japan"),
    SETA("29", "seta"),
    VIACOM("30", "Viacom"),
    NINTENDO("31", "Nintendo"),
    BANDAI("32", "Bandai"),
    OCEAN_ACCLAIM("33", "Ocean/Acclaim"),
    KONAMI("34", "Konami"),
    HECTOR("35", "Hector"),
    TAITO("37", "Taito"),
    HUDSON("38", "Hudson"),
    BANPRESTO("39", "Banpresto"),
    UBI_SOFT("41", "Ubi Soft"),
    ATLUS("42", "Atlus"),
    MALIBU("44", "Malibu"),
    ANGEL("46", "angel"),
    BULLET_PROOF("47", "Bullet-Proof"),
    IREM("49", "irem"),
    ABSOLUTE("50", "Absolute"),
    ACCLAIM("51", "Acclaim"),
    ACTIVISION("52", "Activision"),
    AMERICAN_SAMMY("53", "American sammy"),
    KONAMI_1("54", "Konami"),
    HI_TECH_ENTERTAINMENT("55", "Hi tech entertainment"),
    LJN("56", "LJN"),
    MATCHBOX("57", "Matchbox"),
    MATTEL("58", "Mattel"),
    MILTON_BRADLEY("59", "Milton Bradley"),
    TITUS("60", "Titus"),
    VIRGIN("61", "Virgin"),
    LUCASARTS("64", "LucasArts"),
    OCEAN("67", "Ocean"),
    ELECTRONIC_ARTS_1("69", "Electronic Arts"),
    INFOGRAMES("70", "Infogrames"),
    INTERPLAY("71", "Interplay"),
    BRODERBUND("72", "Broderbund"),
    SCULPTURED("73", "sculptured"),
    SCI("75", "sci"),
    THQ("78", "THQ"),
    ACCOLADE("79", "Accolade"),
    MISAWA("80", "misawa"),
    LOZC("83", "lozc"),
    TOKUMA_SHOTEN_INTERMEDIA("86", "Tokuma Shoten Intermedia"),
    TSUKUDA_ORIGINAL("87", "Tsukuda Original"),
    CHUNSOFT("91", "Chunsoft"),
    VIDEO_SYSTEM("92", "Video system"),
    OCEAN_ACCLAIM_1("93", "Ocean/Acclaim"),
    VARIE("95", "Varie"),
    YONEZAWA_SPAL("96", "Yonezawa/s’pal"),
    KANEKO("97", "Kaneko"),
    PACK_IN_SOFT("99", "Pack in soft"),
    KONAMI_YU_GI_OH("A4", "Konami (Yu-Gi-Oh!)");

    private final String asciiCode;
    private final String publisher;

    public static NewLicenseeCode getByCode(String asciiCode) {
        return Arrays.stream(NewLicenseeCode.values())
                .filter(newLicenseeCode -> newLicenseeCode.asciiCode.equals(asciiCode))
                .findAny()
                .orElseThrow(() -> new EnumConstantNotPresentException(NewLicenseeCode.class, asciiCode));
    }
}