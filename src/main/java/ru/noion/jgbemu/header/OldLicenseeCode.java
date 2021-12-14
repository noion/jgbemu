package ru.noion.jgbemu.header;

import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.Arrays;

@ToString
@RequiredArgsConstructor
public enum OldLicenseeCode {
    NONE("00", "none"),
    NINTENDO("01", "nintendo"),
    CAPCOM("08", "capcom"),
    HOT_B("09", "hot-b"),
    JALECO("0A", "jaleco"),
    COCONUTS("0B", "coconuts"),
    ELITESYSTEMS("0C", "elitesystems"),
    ELECTRONICARTS("13", "electronicarts"),
    HUDSONSOFT("18", "hudsonsoft"),
    ITCENTERTAINMENT("19", "itcentertainment"),
    YANOMAN("1A", "yanoman"),
    CLARY("1D", "clary"),
    VIRGIN("1F", "virgin"),
    PCMCOMPLETE("24", "pcmcomplete"),
    SAN_X("25", "san-x"),
    KOTOBUKISYSTEMS("28", "kotobukisystems"),
    SETA("29", "seta"),
    INFOGRAMES("30", "infogrames"),
    NINTENDO_1("31", "nintendo"),
    BANDAI("32", "bandai"),
    SEEABOVE("33", "\"seeabove\""),
    KONAMI("34", "konami"),
    HECTOR("35", "hector"),
    CAPCOM_1("38", "capcom"),
    BANPRESTO("39", "banpresto"),
    ENTERTAINMENTI("3C", "*entertainmenti"),
    GREMLIN("3E", "gremlin"),
    UBISOFT("41", "ubisoft"),
    ATLUS("42", "atlus"),
    MALIBU("44", "malibu"),
    ANGEL("46", "angel"),
    SPECTRUMHOLOBY("47", "spectrumholoby"),
    IREM("49", "irem"),
    VIRGIN_1("4A", "virgin"),
    MALIBU_1("4D", "malibu"),
    U_S_GOLD("4F", "u.s.gold"),
    ABSOLUTE("50", "absolute"),
    ACCLAIM("51", "acclaim"),
    ACTIVISION("52", "activision"),
    AMERICANSAMMY("53", "americansammy"),
    GAMETEK("54", "gametek"),
    PARKPLACE("55", "parkplace"),
    LJN("56", "ljn"),
    MATCHBOX("57", "matchbox"),
    MILTONBRADLEY("59", "miltonbradley"),
    MINDSCAPE("5A", "mindscape"),
    ROMSTAR("5B", "romstar"),
    NAXATSOFT("5C", "naxatsoft"),
    TRADEWEST("5D", "tradewest"),
    TITUS("60", "titus"),
    VIRGIN_2("61", "virgin"),
    OCEAN("67", "ocean"),
    ELECTRONICARTS_1("69", "electronicarts"),
    ELITESYSTEMS_1("6E", "elitesystems"),
    ELECTROBRAIN("6F", "electrobrain"),
    INFOGRAMES_1("70", "infogrames"),
    INTERPLAY("71", "interplay"),
    BRODERBUND("72", "broderbund"),
    SCULPTEREDSOFT("73", "sculpteredsoft"),
    THESALESCURVE("75", "thesalescurve"),
    T_HQ("78", "t*hq"),
    ACCOLADE("79", "accolade"),
    TRIFFIXENTERTAINMENT("7A", "triffixentertainment"),
    MICROPROSE("7C", "microprose"),
    KEMCO("7F", "kemco"),
    MISAWAENTERTAINMENT("80", "misawaentertainment"),
    LOZC("83", "lozc"),
    TOKUMASHOTENI("86", "*tokumashoteni"),
    BULLET_PROOFSOFTWARE("8B", "bullet-proofsoftware"),
    VICTOKAI("8C", "victokai"),
    APE("8E", "ape"),
    I_MAX("8F", "i'max"),
    CHUNSOFT("91", "chunsoft"),
    VIDEOSYSTEM("92", "videosystem"),
    TSUBURAVA("93", "tsuburava"),
    VARIE("95", "varie"),
    YONEZAWA_S_PAL("96", "yonezawa/s'pal"),
    KANEKO("97", "kaneko"),
    ARC("99", "arc"),
    NIHONBUSSAN("9A", "nihonbussan"),
    TECMO("9B", "tecmo"),
    IMAGINEER("9C", "imagineer"),
    BANPRESTO_1("9D", "banpresto"),
    NOVA("9F", "nova"),
    HORIELECTRIC("A1", "horielectric"),
    BANDAI_1("A2", "bandai"),
    KONAMI_2("A4", "konami"),
    KAWADA("A6", "kawada"),
    TAKARA("A7", "takara"),
    TECHNOSJAPAN("A9", "technosjapan"),
    BRODERBUND_1("AA", "broderbund"),
    TOEIANIMATION("AC", "toeianimation"),
    TOHO("AD", "toho"),
    NAMCO("AF", "namco"),
    ACCLAIM_1("B0", "acclaim"),
    ASCIIORNEXOFT("B1", "asciiornexoft"),
    BANDAI_2("B2", "bandai"),
    ENIX("B4", "enix"),
    HAL("B6", "hal"),
    SNK("B7", "snk"),
    PONYCANYON("B9", "ponycanyon"),
    CULTUREBRAINO("BA", "*culturebraino"),
    SUNSOFT("BB", "sunsoft"),
    SONYIMAGESOFT("BD", "sonyimagesoft"),
    SAMMY("BF", "sammy"),
    TAITO("C0", "taito"),
    KEMCO_1("C2", "kemco"),
    SQUARESOFT("C3", "squaresoft"),
    TOKUMASHOTENI_1("C4", "*tokumashoteni"),
    DATAEAST("C5", "dataeast"),
    TONKINHOUSE("C6", "tonkinhouse"),
    KOEI("C8", "koei"),
    UFL("C9", "ufl"),
    ULTRA("CA", "ultra"),
    VAP("CB", "vap"),
    USE("CC", "use"),
    MELDAC("CD", "meldac"),
    PONYCANYONOR("CE", "*ponycanyonor"),
    ANGEL_1("CF", "angel"),
    TAITO_1("D0", "taito"),
    SOFEL("D1", "sofel"),
    QUEST("D2", "quest"),
    SIGMAENTERPRISES("D3", "sigmaenterprises"),
    ASKKODANSHA("D4", "askkodansha"),
    NAXATSOFT_1("D6", "naxatsoft"),
    COPYASYSTEMS_1("D7", "copyasystems"),
    BANPRESTO_2("D9", "banpresto"),
    TOMY("DA", "tomy"),
    LJN_1("DB", "ljn"),
    NCS("DD", "ncs"),
    HUMAN("DE", "human"),
    ALTRON("DF", "altron"),
    JALECO_1("E0", "jaleco"),
    TOWACHIKI("E1", "towachiki"),
    UUTAKA("E2", "uutaka"),
    VARIE_1("E3", "varie"),
    EPOCH("E5", "epoch"),
    ATHENA("E7", "athena"),
    ASMIK("E8", "asmik"),
    NATSUME("E9", "natsume"),
    KINGRECORDS("EA", "kingrecords"),
    ATLUS_1("EB", "atlus"),
    EPIC_SONYRECORDS("EC", "epic/sonyrecords"),
    IGS("EE", "igs"),
    AWAVE("F0", "awave"),
    EXTREMEENTERTAINMENT("F3", "extremeentertainment"),
    LJN_2("FF", "ljn");

    private final String hexCode;
    private final String publisher;

    public static OldLicenseeCode getByHexCode(String hexCode) {
        return Arrays.stream(OldLicenseeCode.values())
                .filter(oldLicenseeCode -> oldLicenseeCode.hexCode.equals(hexCode))
                .findAny()
                .orElseThrow(() -> new EnumConstantNotPresentException(OldLicenseeCode.class, hexCode));
    }
}