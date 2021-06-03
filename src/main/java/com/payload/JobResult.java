package com.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.MultiValueMap;

import java.util.List;
import java.util.Map;

// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString), Root.class); */
//public class Sample {
//    @JsonProperty("0")
//    public String _0;
//    @JsonProperty("1")
//    public String _1;
//    @JsonProperty("2")
//    public String _2;
//    @JsonProperty("3")
//    public String _3;
//    @JsonProperty("4")
//    public String _4;
//    @JsonProperty("5")
//    public String _5;
//    @JsonProperty("6")
//    public String _6;
//    @JsonProperty("7")
//    public String _7;
//    @JsonProperty("8")
//    public String _8;
//    @JsonProperty("9")
//    public String _9;
//    @JsonProperty("10")
//    public String _10;
//    @JsonProperty("11")
//    public String _11;
//    @JsonProperty("12")
//    public String _12;
//    @JsonProperty("13")
//    public String _13;
//    @JsonProperty("14")
//    public String _14;
//    @JsonProperty("15")
//    public String _15;
//    @JsonProperty("16")
//    public String _16;
//    @JsonProperty("17")
//    public String _17;
//    @JsonProperty("18")
//    public String _18;
//    @JsonProperty("19")
//    public String _19;
//    @JsonProperty("20")
//    public String _20;
//    @JsonProperty("21")
//    public String _21;
//    @JsonProperty("22")
//    public String _22;
//    @JsonProperty("23")
//    public String _23;
//    @JsonProperty("24")
//    public String _24;
//    @JsonProperty("25")
//    public String _25;
//    @JsonProperty("26")
//    public String _26;
//    @JsonProperty("27")
//    public String _27;
//    @JsonProperty("28")
//    public String _28;
//    @JsonProperty("29")
//    public String _29;
//    @JsonProperty("30")
//    public String _30;
//    @JsonProperty("31")
//    public String _31;
//    @JsonProperty("32")
//    public String _32;
//    @JsonProperty("33")
//    public String _33;
//    @JsonProperty("34")
//    public String _34;
//    @JsonProperty("35")
//    public String _35;
//    @JsonProperty("36")
//    public String _36;
//    @JsonProperty("37")
//    public String _37;
//    @JsonProperty("38")
//    public String _38;
//    @JsonProperty("39")
//    public String _39;
//    @JsonProperty("40")
//    public String _40;
//    @JsonProperty("41")
//    public String _41;
//    @JsonProperty("42")
//    public String _42;
//    @JsonProperty("43")
//    public String _43;
//    @JsonProperty("44")
//    public String _44;
//    @JsonProperty("45")
//    public String _45;
//    @JsonProperty("46")
//    public String _46;
//    @JsonProperty("47")
//    public String _47;
//    @JsonProperty("48")
//    public String _48;
//    @JsonProperty("49")
//    public String _49;
//    @JsonProperty("50")
//    public String _50;
//    @JsonProperty("51")
//    public String _51;
//    @JsonProperty("52")
//    public String _52;
//    @JsonProperty("53")
//    public String _53;
//    @JsonProperty("54")
//    public String _54;
//    @JsonProperty("55")
//    public String _55;
//    @JsonProperty("56")
//    public String _56;
//    @JsonProperty("57")
//    public String _57;
//    @JsonProperty("58")
//    public String _58;
//    @JsonProperty("59")
//    public String _59;
//    @JsonProperty("60")
//    public String _60;
//    @JsonProperty("61")
//    public String _61;
//    @JsonProperty("62")
//    public String _62;
//    @JsonProperty("63")
//    public String _63;
//    @JsonProperty("64")
//    public String _64;
//    @JsonProperty("65")
//    public String _65;
//    @JsonProperty("66")
//    public String _66;
//    @JsonProperty("67")
//    public String _67;
//    @JsonProperty("68")
//    public String _68;
//    @JsonProperty("69")
//    public String _69;
//    @JsonProperty("70")
//    public String _70;
//    @JsonProperty("71")
//    public String _71;
//    @JsonProperty("72")
//    public String _72;
//    @JsonProperty("73")
//    public String _73;
//    @JsonProperty("74")
//    public String _74;
//    @JsonProperty("75")
//    public String _75;
//    @JsonProperty("76")
//    public String _76;
//    @JsonProperty("77")
//    public String _77;
//    @JsonProperty("78")
//    public String _78;
//    @JsonProperty("79")
//    public String _79;
//    @JsonProperty("80")
//    public String _80;
//    @JsonProperty("81")
//    public String _81;
//    @JsonProperty("82")
//    public String _82;
//    @JsonProperty("83")
//    public String _83;
//    @JsonProperty("84")
//    public String _84;
//    @JsonProperty("85")
//    public String _85;
//    @JsonProperty("86")
//    public String _86;
//    @JsonProperty("87")
//    public String _87;
//    @JsonProperty("88")
//    public String _88;
//    @JsonProperty("89")
//    public String _89;
//    @JsonProperty("90")
//    public String _90;
//    @JsonProperty("91")
//    public String _91;
//    @JsonProperty("92")
//    public String _92;
//    @JsonProperty("93")
//    public String _93;
//    @JsonProperty("94")
//    public String _94;
//}
//
//public class SMILE {
//    @JsonProperty("0")
//    public String _0;
//    @JsonProperty("1")
//    public String _1;
//    @JsonProperty("2")
//    public String _2;
//    @JsonProperty("3")
//    public String _3;
//    @JsonProperty("4")
//    public String _4;
//    @JsonProperty("5")
//    public String _5;
//    @JsonProperty("6")
//    public String _6;
//    @JsonProperty("7")
//    public String _7;
//    @JsonProperty("8")
//    public String _8;
//    @JsonProperty("9")
//    public String _9;
//    @JsonProperty("10")
//    public String _10;
//    @JsonProperty("11")
//    public String _11;
//    @JsonProperty("12")
//    public String _12;
//    @JsonProperty("13")
//    public String _13;
//    @JsonProperty("14")
//    public String _14;
//    @JsonProperty("15")
//    public String _15;
//    @JsonProperty("16")
//    public String _16;
//    @JsonProperty("17")
//    public String _17;
//    @JsonProperty("18")
//    public String _18;
//    @JsonProperty("19")
//    public String _19;
//    @JsonProperty("20")
//    public String _20;
//    @JsonProperty("21")
//    public String _21;
//    @JsonProperty("22")
//    public String _22;
//    @JsonProperty("23")
//    public String _23;
//    @JsonProperty("24")
//    public String _24;
//    @JsonProperty("25")
//    public String _25;
//    @JsonProperty("26")
//    public String _26;
//    @JsonProperty("27")
//    public String _27;
//    @JsonProperty("28")
//    public String _28;
//    @JsonProperty("29")
//    public String _29;
//    @JsonProperty("30")
//    public String _30;
//    @JsonProperty("31")
//    public String _31;
//    @JsonProperty("32")
//    public String _32;
//    @JsonProperty("33")
//    public String _33;
//    @JsonProperty("34")
//    public String _34;
//    @JsonProperty("35")
//    public String _35;
//    @JsonProperty("36")
//    public String _36;
//    @JsonProperty("37")
//    public String _37;
//    @JsonProperty("38")
//    public String _38;
//    @JsonProperty("39")
//    public String _39;
//    @JsonProperty("40")
//    public String _40;
//    @JsonProperty("41")
//    public String _41;
//    @JsonProperty("42")
//    public String _42;
//    @JsonProperty("43")
//    public String _43;
//    @JsonProperty("44")
//    public String _44;
//    @JsonProperty("45")
//    public String _45;
//    @JsonProperty("46")
//    public String _46;
//    @JsonProperty("47")
//    public String _47;
//    @JsonProperty("48")
//    public String _48;
//    @JsonProperty("49")
//    public String _49;
//    @JsonProperty("50")
//    public String _50;
//    @JsonProperty("51")
//    public String _51;
//    @JsonProperty("52")
//    public String _52;
//    @JsonProperty("53")
//    public String _53;
//    @JsonProperty("54")
//    public String _54;
//    @JsonProperty("55")
//    public String _55;
//    @JsonProperty("56")
//    public String _56;
//    @JsonProperty("57")
//    public String _57;
//    @JsonProperty("58")
//    public String _58;
//    @JsonProperty("59")
//    public String _59;
//    @JsonProperty("60")
//    public String _60;
//    @JsonProperty("61")
//    public String _61;
//    @JsonProperty("62")
//    public String _62;
//    @JsonProperty("63")
//    public String _63;
//    @JsonProperty("64")
//    public String _64;
//    @JsonProperty("65")
//    public String _65;
//    @JsonProperty("66")
//    public String _66;
//    @JsonProperty("67")
//    public String _67;
//    @JsonProperty("68")
//    public String _68;
//    @JsonProperty("69")
//    public String _69;
//    @JsonProperty("70")
//    public String _70;
//    @JsonProperty("71")
//    public String _71;
//    @JsonProperty("72")
//    public String _72;
//    @JsonProperty("73")
//    public String _73;
//    @JsonProperty("74")
//    public String _74;
//    @JsonProperty("75")
//    public String _75;
//    @JsonProperty("76")
//    public String _76;
//    @JsonProperty("77")
//    public String _77;
//    @JsonProperty("78")
//    public String _78;
//    @JsonProperty("79")
//    public String _79;
//    @JsonProperty("80")
//    public String _80;
//    @JsonProperty("81")
//    public String _81;
//    @JsonProperty("82")
//    public String _82;
//    @JsonProperty("83")
//    public String _83;
//    @JsonProperty("84")
//    public String _84;
//    @JsonProperty("85")
//    public String _85;
//    @JsonProperty("86")
//    public String _86;
//    @JsonProperty("87")
//    public String _87;
//    @JsonProperty("88")
//    public String _88;
//    @JsonProperty("89")
//    public String _89;
//    @JsonProperty("90")
//    public String _90;
//    @JsonProperty("91")
//    public String _91;
//    @JsonProperty("92")
//    public String _92;
//    @JsonProperty("93")
//    public String _93;
//    @JsonProperty("94")
//    public String _94;
//}
//
//public class CI {
//    @JsonProperty("0")
//    public List<double> _0;
//    @JsonProperty("1")
//    public List<double> _1;
//    @JsonProperty("2")
//    public List<double> _2;
//    @JsonProperty("3")
//    public List<double> _3;
//    @JsonProperty("4")
//    public List<double> _4;
//    @JsonProperty("5")
//    public List<double> _5;
//    @JsonProperty("6")
//    public List<double> _6;
//    @JsonProperty("7")
//    public List<double> _7;
//    @JsonProperty("8")
//    public List<double> _8;
//    @JsonProperty("9")
//    public List<double> _9;
//    @JsonProperty("10")
//    public List<double> _10;
//    @JsonProperty("11")
//    public List<double> _11;
//    @JsonProperty("12")
//    public List<double> _12;
//    @JsonProperty("13")
//    public List<double> _13;
//    @JsonProperty("14")
//    public List<double> _14;
//    @JsonProperty("15")
//    public List<double> _15;
//    @JsonProperty("16")
//    public List<double> _16;
//    @JsonProperty("17")
//    public List<double> _17;
//    @JsonProperty("18")
//    public List<double> _18;
//    @JsonProperty("19")
//    public List<double> _19;
//    @JsonProperty("20")
//    public List<double> _20;
//    @JsonProperty("21")
//    public List<double> _21;
//    @JsonProperty("22")
//    public List<double> _22;
//    @JsonProperty("23")
//    public List<double> _23;
//    @JsonProperty("24")
//    public List<double> _24;
//    @JsonProperty("25")
//    public List<double> _25;
//    @JsonProperty("26")
//    public List<double> _26;
//    @JsonProperty("27")
//    public List<double> _27;
//    @JsonProperty("28")
//    public List<double> _28;
//    @JsonProperty("29")
//    public List<double> _29;
//    @JsonProperty("30")
//    public List<double> _30;
//    @JsonProperty("31")
//    public List<double> _31;
//    @JsonProperty("32")
//    public List<double> _32;
//    @JsonProperty("33")
//    public List<double> _33;
//    @JsonProperty("34")
//    public List<double> _34;
//    @JsonProperty("35")
//    public List<double> _35;
//    @JsonProperty("36")
//    public List<double> _36;
//    @JsonProperty("37")
//    public List<double> _37;
//    @JsonProperty("38")
//    public List<double> _38;
//    @JsonProperty("39")
//    public List<double> _39;
//    @JsonProperty("40")
//    public List<double> _40;
//    @JsonProperty("41")
//    public List<double> _41;
//    @JsonProperty("42")
//    public List<double> _42;
//    @JsonProperty("43")
//    public List<double> _43;
//    @JsonProperty("44")
//    public List<double> _44;
//    @JsonProperty("45")
//    public List<double> _45;
//    @JsonProperty("46")
//    public List<double> _46;
//    @JsonProperty("47")
//    public List<double> _47;
//    @JsonProperty("48")
//    public List<double> _48;
//    @JsonProperty("49")
//    public List<double> _49;
//    @JsonProperty("50")
//    public List<double> _50;
//    @JsonProperty("51")
//    public List<double> _51;
//    @JsonProperty("52")
//    public List<double> _52;
//    @JsonProperty("53")
//    public List<double> _53;
//    @JsonProperty("54")
//    public List<double> _54;
//    @JsonProperty("55")
//    public List<double> _55;
//    @JsonProperty("56")
//    public List<double> _56;
//    @JsonProperty("57")
//    public List<double> _57;
//    @JsonProperty("58")
//    public List<double> _58;
//    @JsonProperty("59")
//    public List<double> _59;
//    @JsonProperty("60")
//    public List<double> _60;
//    @JsonProperty("61")
//    public List<double> _61;
//    @JsonProperty("62")
//    public List<double> _62;
//    @JsonProperty("63")
//    public List<double> _63;
//    @JsonProperty("64")
//    public List<double> _64;
//    @JsonProperty("65")
//    public List<double> _65;
//    @JsonProperty("66")
//    public List<double> _66;
//    @JsonProperty("67")
//    public List<double> _67;
//    @JsonProperty("68")
//    public List<double> _68;
//    @JsonProperty("69")
//    public List<double> _69;
//    @JsonProperty("70")
//    public List<double> _70;
//    @JsonProperty("71")
//    public List<double> _71;
//    @JsonProperty("72")
//    public List<double> _72;
//    @JsonProperty("73")
//    public List<double> _73;
//    @JsonProperty("74")
//    public List<double> _74;
//    @JsonProperty("75")
//    public List<double> _75;
//    @JsonProperty("76")
//    public List<double> _76;
//    @JsonProperty("77")
//    public List<double> _77;
//    @JsonProperty("78")
//    public List<double> _78;
//    @JsonProperty("79")
//    public List<double> _79;
//    @JsonProperty("80")
//    public List<double> _80;
//    @JsonProperty("81")
//    public List<double> _81;
//    @JsonProperty("82")
//    public List<double> _82;
//    @JsonProperty("83")
//    public List<double> _83;
//    @JsonProperty("84")
//    public List<double> _84;
//    @JsonProperty("85")
//    public List<double> _85;
//    @JsonProperty("86")
//    public List<double> _86;
//    @JsonProperty("87")
//    public List<double> _87;
//    @JsonProperty("88")
//    public List<double> _88;
//    @JsonProperty("89")
//    public List<double> _89;
//    @JsonProperty("90")
//    public List<double> _90;
//    @JsonProperty("91")
//    public List<double> _91;
//    @JsonProperty("92")
//    public List<double> _92;
//    @JsonProperty("93")
//    public List<double> _93;
//    @JsonProperty("94")
//    public List<double> _94;
//}
//
//public class MAX {
//    @JsonProperty("0")
//    public double _0;
//    @JsonProperty("1")
//    public double _1;
//    @JsonProperty("2")
//    public double _2;
//    @JsonProperty("3")
//    public double _3;
//    @JsonProperty("4")
//    public double _4;
//    @JsonProperty("5")
//    public double _5;
//    @JsonProperty("6")
//    public double _6;
//    @JsonProperty("7")
//    public double _7;
//    @JsonProperty("8")
//    public double _8;
//    @JsonProperty("9")
//    public double _9;
//    @JsonProperty("10")
//    public double _10;
//    @JsonProperty("11")
//    public double _11;
//    @JsonProperty("12")
//    public double _12;
//    @JsonProperty("13")
//    public double _13;
//    @JsonProperty("14")
//    public double _14;
//    @JsonProperty("15")
//    public double _15;
//    @JsonProperty("16")
//    public double _16;
//    @JsonProperty("17")
//    public double _17;
//    @JsonProperty("18")
//    public double _18;
//    @JsonProperty("19")
//    public double _19;
//    @JsonProperty("20")
//    public double _20;
//    @JsonProperty("21")
//    public double _21;
//    @JsonProperty("22")
//    public double _22;
//    @JsonProperty("23")
//    public double _23;
//    @JsonProperty("24")
//    public double _24;
//    @JsonProperty("25")
//    public double _25;
//    @JsonProperty("26")
//    public double _26;
//    @JsonProperty("27")
//    public double _27;
//    @JsonProperty("28")
//    public double _28;
//    @JsonProperty("29")
//    public double _29;
//    @JsonProperty("30")
//    public double _30;
//    @JsonProperty("31")
//    public double _31;
//    @JsonProperty("32")
//    public double _32;
//    @JsonProperty("33")
//    public double _33;
//    @JsonProperty("34")
//    public double _34;
//    @JsonProperty("35")
//    public double _35;
//    @JsonProperty("36")
//    public double _36;
//    @JsonProperty("37")
//    public double _37;
//    @JsonProperty("38")
//    public double _38;
//    @JsonProperty("39")
//    public double _39;
//    @JsonProperty("40")
//    public double _40;
//    @JsonProperty("41")
//    public double _41;
//    @JsonProperty("42")
//    public double _42;
//    @JsonProperty("43")
//    public double _43;
//    @JsonProperty("44")
//    public double _44;
//    @JsonProperty("45")
//    public double _45;
//    @JsonProperty("46")
//    public double _46;
//    @JsonProperty("47")
//    public double _47;
//    @JsonProperty("48")
//    public double _48;
//    @JsonProperty("49")
//    public double _49;
//    @JsonProperty("50")
//    public double _50;
//    @JsonProperty("51")
//    public double _51;
//    @JsonProperty("52")
//    public double _52;
//    @JsonProperty("53")
//    public double _53;
//    @JsonProperty("54")
//    public double _54;
//    @JsonProperty("55")
//    public double _55;
//    @JsonProperty("56")
//    public double _56;
//    @JsonProperty("57")
//    public double _57;
//    @JsonProperty("58")
//    public double _58;
//    @JsonProperty("59")
//    public double _59;
//    @JsonProperty("60")
//    public double _60;
//    @JsonProperty("61")
//    public double _61;
//    @JsonProperty("62")
//    public double _62;
//    @JsonProperty("63")
//    public double _63;
//    @JsonProperty("64")
//    public double _64;
//    @JsonProperty("65")
//    public double _65;
//    @JsonProperty("66")
//    public double _66;
//    @JsonProperty("67")
//    public double _67;
//    @JsonProperty("68")
//    public double _68;
//    @JsonProperty("69")
//    public double _69;
//    @JsonProperty("70")
//    public double _70;
//    @JsonProperty("71")
//    public double _71;
//    @JsonProperty("72")
//    public double _72;
//    @JsonProperty("73")
//    public double _73;
//    @JsonProperty("74")
//    public double _74;
//    @JsonProperty("75")
//    public double _75;
//    @JsonProperty("76")
//    public double _76;
//    @JsonProperty("77")
//    public double _77;
//    @JsonProperty("78")
//    public double _78;
//    @JsonProperty("79")
//    public double _79;
//    @JsonProperty("80")
//    public double _80;
//    @JsonProperty("81")
//    public double _81;
//    @JsonProperty("82")
//    public double _82;
//    @JsonProperty("83")
//    public double _83;
//    @JsonProperty("84")
//    public double _84;
//    @JsonProperty("85")
//    public double _85;
//    @JsonProperty("86")
//    public double _86;
//    @JsonProperty("87")
//    public double _87;
//    @JsonProperty("88")
//    public double _88;
//    @JsonProperty("89")
//    public double _89;
//    @JsonProperty("90")
//    public double _90;
//    @JsonProperty("91")
//    public double _91;
//    @JsonProperty("92")
//    public double _92;
//    @JsonProperty("93")
//    public double _93;
//    @JsonProperty("94")
//    public double _94;
//}
//
//public class MIN {
//    @JsonProperty("0")
//    public double _0;
//    @JsonProperty("1")
//    public double _1;
//    @JsonProperty("2")
//    public double _2;
//    @JsonProperty("3")
//    public double _3;
//    @JsonProperty("4")
//    public double _4;
//    @JsonProperty("5")
//    public double _5;
//    @JsonProperty("6")
//    public double _6;
//    @JsonProperty("7")
//    public double _7;
//    @JsonProperty("8")
//    public double _8;
//    @JsonProperty("9")
//    public double _9;
//    @JsonProperty("10")
//    public double _10;
//    @JsonProperty("11")
//    public double _11;
//    @JsonProperty("12")
//    public double _12;
//    @JsonProperty("13")
//    public double _13;
//    @JsonProperty("14")
//    public double _14;
//    @JsonProperty("15")
//    public double _15;
//    @JsonProperty("16")
//    public double _16;
//    @JsonProperty("17")
//    public double _17;
//    @JsonProperty("18")
//    public double _18;
//    @JsonProperty("19")
//    public double _19;
//    @JsonProperty("20")
//    public double _20;
//    @JsonProperty("21")
//    public double _21;
//    @JsonProperty("22")
//    public double _22;
//    @JsonProperty("23")
//    public double _23;
//    @JsonProperty("24")
//    public double _24;
//    @JsonProperty("25")
//    public double _25;
//    @JsonProperty("26")
//    public double _26;
//    @JsonProperty("27")
//    public double _27;
//    @JsonProperty("28")
//    public double _28;
//    @JsonProperty("29")
//    public double _29;
//    @JsonProperty("30")
//    public double _30;
//    @JsonProperty("31")
//    public double _31;
//    @JsonProperty("32")
//    public double _32;
//    @JsonProperty("33")
//    public double _33;
//    @JsonProperty("34")
//    public double _34;
//    @JsonProperty("35")
//    public double _35;
//    @JsonProperty("36")
//    public double _36;
//    @JsonProperty("37")
//    public double _37;
//    @JsonProperty("38")
//    public double _38;
//    @JsonProperty("39")
//    public double _39;
//    @JsonProperty("40")
//    public double _40;
//    @JsonProperty("41")
//    public double _41;
//    @JsonProperty("42")
//    public double _42;
//    @JsonProperty("43")
//    public double _43;
//    @JsonProperty("44")
//    public double _44;
//    @JsonProperty("45")
//    public double _45;
//    @JsonProperty("46")
//    public double _46;
//    @JsonProperty("47")
//    public double _47;
//    @JsonProperty("48")
//    public double _48;
//    @JsonProperty("49")
//    public double _49;
//    @JsonProperty("50")
//    public double _50;
//    @JsonProperty("51")
//    public double _51;
//    @JsonProperty("52")
//    public double _52;
//    @JsonProperty("53")
//    public double _53;
//    @JsonProperty("54")
//    public double _54;
//    @JsonProperty("55")
//    public double _55;
//    @JsonProperty("56")
//    public double _56;
//    @JsonProperty("57")
//    public double _57;
//    @JsonProperty("58")
//    public double _58;
//    @JsonProperty("59")
//    public double _59;
//    @JsonProperty("60")
//    public double _60;
//    @JsonProperty("61")
//    public double _61;
//    @JsonProperty("62")
//    public double _62;
//    @JsonProperty("63")
//    public double _63;
//    @JsonProperty("64")
//    public double _64;
//    @JsonProperty("65")
//    public double _65;
//    @JsonProperty("66")
//    public double _66;
//    @JsonProperty("67")
//    public double _67;
//    @JsonProperty("68")
//    public double _68;
//    @JsonProperty("69")
//    public double _69;
//    @JsonProperty("70")
//    public double _70;
//    @JsonProperty("71")
//    public double _71;
//    @JsonProperty("72")
//    public double _72;
//    @JsonProperty("73")
//    public double _73;
//    @JsonProperty("74")
//    public double _74;
//    @JsonProperty("75")
//    public double _75;
//    @JsonProperty("76")
//    public double _76;
//    @JsonProperty("77")
//    public double _77;
//    @JsonProperty("78")
//    public double _78;
//    @JsonProperty("79")
//    public double _79;
//    @JsonProperty("80")
//    public double _80;
//    @JsonProperty("81")
//    public double _81;
//    @JsonProperty("82")
//    public double _82;
//    @JsonProperty("83")
//    public double _83;
//    @JsonProperty("84")
//    public double _84;
//    @JsonProperty("85")
//    public double _85;
//    @JsonProperty("86")
//    public double _86;
//    @JsonProperty("87")
//    public double _87;
//    @JsonProperty("88")
//    public double _88;
//    @JsonProperty("89")
//    public double _89;
//    @JsonProperty("90")
//    public double _90;
//    @JsonProperty("91")
//    public double _91;
//    @JsonProperty("92")
//    public double _92;
//    @JsonProperty("93")
//    public double _93;
//    @JsonProperty("94")
//    public double _94;
//}
//
//public class AVG {
//    @JsonProperty("0")
//    public double _0;
//    @JsonProperty("1")
//    public double _1;
//    @JsonProperty("2")
//    public double _2;
//    @JsonProperty("3")
//    public double _3;
//    @JsonProperty("4")
//    public double _4;
//    @JsonProperty("5")
//    public double _5;
//    @JsonProperty("6")
//    public double _6;
//    @JsonProperty("7")
//    public double _7;
//    @JsonProperty("8")
//    public double _8;
//    @JsonProperty("9")
//    public double _9;
//    @JsonProperty("10")
//    public double _10;
//    @JsonProperty("11")
//    public double _11;
//    @JsonProperty("12")
//    public double _12;
//    @JsonProperty("13")
//    public double _13;
//    @JsonProperty("14")
//    public double _14;
//    @JsonProperty("15")
//    public double _15;
//    @JsonProperty("16")
//    public double _16;
//    @JsonProperty("17")
//    public double _17;
//    @JsonProperty("18")
//    public double _18;
//    @JsonProperty("19")
//    public double _19;
//    @JsonProperty("20")
//    public double _20;
//    @JsonProperty("21")
//    public double _21;
//    @JsonProperty("22")
//    public double _22;
//    @JsonProperty("23")
//    public double _23;
//    @JsonProperty("24")
//    public double _24;
//    @JsonProperty("25")
//    public double _25;
//    @JsonProperty("26")
//    public double _26;
//    @JsonProperty("27")
//    public double _27;
//    @JsonProperty("28")
//    public double _28;
//    @JsonProperty("29")
//    public double _29;
//    @JsonProperty("30")
//    public double _30;
//    @JsonProperty("31")
//    public double _31;
//    @JsonProperty("32")
//    public double _32;
//    @JsonProperty("33")
//    public double _33;
//    @JsonProperty("34")
//    public double _34;
//    @JsonProperty("35")
//    public double _35;
//    @JsonProperty("36")
//    public double _36;
//    @JsonProperty("37")
//    public double _37;
//    @JsonProperty("38")
//    public double _38;
//    @JsonProperty("39")
//    public double _39;
//    @JsonProperty("40")
//    public double _40;
//    @JsonProperty("41")
//    public double _41;
//    @JsonProperty("42")
//    public double _42;
//    @JsonProperty("43")
//    public double _43;
//    @JsonProperty("44")
//    public double _44;
//    @JsonProperty("45")
//    public double _45;
//    @JsonProperty("46")
//    public double _46;
//    @JsonProperty("47")
//    public double _47;
//    @JsonProperty("48")
//    public double _48;
//    @JsonProperty("49")
//    public double _49;
//    @JsonProperty("50")
//    public double _50;
//    @JsonProperty("51")
//    public double _51;
//    @JsonProperty("52")
//    public double _52;
//    @JsonProperty("53")
//    public double _53;
//    @JsonProperty("54")
//    public double _54;
//    @JsonProperty("55")
//    public double _55;
//    @JsonProperty("56")
//    public double _56;
//    @JsonProperty("57")
//    public double _57;
//    @JsonProperty("58")
//    public double _58;
//    @JsonProperty("59")
//    public double _59;
//    @JsonProperty("60")
//    public double _60;
//    @JsonProperty("61")
//    public double _61;
//    @JsonProperty("62")
//    public double _62;
//    @JsonProperty("63")
//    public double _63;
//    @JsonProperty("64")
//    public double _64;
//    @JsonProperty("65")
//    public double _65;
//    @JsonProperty("66")
//    public double _66;
//    @JsonProperty("67")
//    public double _67;
//    @JsonProperty("68")
//    public double _68;
//    @JsonProperty("69")
//    public double _69;
//    @JsonProperty("70")
//    public double _70;
//    @JsonProperty("71")
//    public double _71;
//    @JsonProperty("72")
//    public double _72;
//    @JsonProperty("73")
//    public double _73;
//    @JsonProperty("74")
//    public double _74;
//    @JsonProperty("75")
//    public double _75;
//    @JsonProperty("76")
//    public double _76;
//    @JsonProperty("77")
//    public double _77;
//    @JsonProperty("78")
//    public double _78;
//    @JsonProperty("79")
//    public double _79;
//    @JsonProperty("80")
//    public double _80;
//    @JsonProperty("81")
//    public double _81;
//    @JsonProperty("82")
//    public double _82;
//    @JsonProperty("83")
//    public double _83;
//    @JsonProperty("84")
//    public double _84;
//    @JsonProperty("85")
//    public double _85;
//    @JsonProperty("86")
//    public double _86;
//    @JsonProperty("87")
//    public double _87;
//    @JsonProperty("88")
//    public double _88;
//    @JsonProperty("89")
//    public double _89;
//    @JsonProperty("90")
//    public double _90;
//    @JsonProperty("91")
//    public double _91;
//    @JsonProperty("92")
//    public double _92;
//    @JsonProperty("93")
//    public double _93;
//    @JsonProperty("94")
//    public double _94;
//}
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobResult {
    public MultiValueMap<String, String> sample;
    public MultiValueMap<String, String> SMILE;
    public MultiValueMap<String, List<Double>> CI;
    public MultiValueMap<String, Double> MAX;
    public MultiValueMap<String, Double> MIN;
    public MultiValueMap<String, Double> AVG;
}

