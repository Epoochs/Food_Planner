package com.example.foodplanner.Model;

import java.util.Map;

public class CountryCode {
   /* private String AD;
    private String AE;
    private String AF;
    private String AG;
    private String AI;
    private String AL;
    private String AM;
    private String AO;
    private String AQ;
    private String AR;
    private String AS;
    private String AT;
    private String AU;
    private String AW;
    private String AX;
    private String AZ;
    private String BA;
    private String BB;
    private String BD;
    private String BE;
    private String BF;
    private String BG;
    private String BH;
    private String BI;
    private String BJ;
    private String BL;
    private String BM;
    private String BN;
    private String BO;
    private String BQ;
    private String BR;
    private String BS;
    private String BT;
    private String BV;
    private String BW;
    private String BY;
    private String BZ;
    private String CA;
    private String CC;
    private String CD;
    private String CF;
    private String CG;
    private String CH;
    private String CI;
    private String CK;
    private String CL;
    private String CM;
    private String CN;
    private String CO;
    private String CR;
    private String CU;
    private String CV;
    private String CW;
    private String CX;
    private String CY;
    private String CZ;
    private String DE;
    private String DJ;
    private String DK;
    private String DM;
    private String DO;
    private String DZ;
    private String EC;
    private String EE;
    private String EG;
    private String EH;
    private String ER;
    private String ES;
    private String ET;
    private String FI;
    private String FJ;
    private String FM;
    private String FO;
    private String FR;
    private String GA;
    private String GB;
    private String GD;
    private String GE;
    private String GF;
    private String GG;
    private String GH;
    private String GI;
    private String GL;
    private String GM;
    private String GN;
    private String GP;
    private String GQ;
    private String GR;
    private String GT;
    private String GU;
    private String GW;
    private String GY;
    private String HK;
    private String HM;
    private String HN;
    private String HR;
    private String HT;
    private String HU;
    private String ID;
    private String IE;
    private String IL;
    private String IM;
    private String IN;
    private String IO;
    private String IQ;
    private String IR;
    private String IS;
    private String IT;
    private String JE;
    private String JM;
    private String JO;
    private String JP;
    private String KE;
    private String KG;
    private String KH;
    private String KI;
    private String KM;
    private String KN;
    private String KP;
    private String KR;
    private String KW;
    private String KY;
    private String KZ;
    private String LA;
    private String LB;
    private String LC;
    private String LI;
    private String LK;
    private String LR;
    private String LS;
    private String LT;
    private String LU;
    private String LV;
    private String LY;
    private String MA;
    private String MC;
    private String MD;
    private String ME;
    private String MF;
    private String MG;
    private String MH;
    private String MK;
    private String ML;
    private String MM;
    private String MN;
    private String MO;
    private String MP;
    private String MQ;
    private String MR;
    private String MS;
    private String MT;
    private String MU;
    private String MV;
    private String MW;
    private String MX;
    private String MY;
    private String MZ;
    private String NA;
    private String NC;
    private String NE;
    private String NF;
    private String NG;
    private String NI;
    private String NL;
    private String NO;
    private String NP;
    private String NR;
    private String NU;
    private String NZ;
    private String OM;
    private String PA;
    private String PE;
    private String PF;
    private String PG;
    private String PH;
    private String PK;
    private String PL;
    private String PM;
    private String PN;
    private String PR;
    private String PT;
    private String PW;
    private String PY;
    private String QA;
    private String RE;
    private String RO;
    private String RS;
    private String RU;
    private String RW;
    private String SA;
    private String SB;
    private String SC;
    private String SD;
    private String SE;
    private String SG;
    private String SH;
    private String SI;
    private String SJ;
    private String SK;
    private String SL;
    private String SM;
    private String SN;
    private String SO;
    private String SR;
    private String SS;
    private String ST;
    private String SV;
    private String SX;
    private String SY;
    private String SZ;
    private String TC;
    private String TD;
    private String TF;
    private String TG;
    private String TH;
    private String TJ;
    private String TK;
    private String TL;
    private String TM;
    private String TN;
    private String TO;
    private String TR;
    private String TT;
    private String TV;
    private String TW;
    private String TZ;
    private String UA;
    private String UG;
    private String US;
    private String UY;
    private String UZ;
    private String VA;
    private String VC;
    private String VE;
    private String VG;
    private String VI;
    private String VN;
    private String VU;
    private String WF;
    private String WS;
    private String YE;
    private String YT;
    private String ZA;
    private String ZM;
    private String ZW;

        public CountryCode(String AD, String AE, String AF, String AG, String AI, String AL, String AM, String AO, String AQ, String AR, String AS, String AT, String AU, String AW, String AX, String AZ, String BA, String BB, String BD, String BE, String BF, String BG, String BH, String BI, String BJ, String BL, String BM, String BN, String BO, String BQ, String BR, String BS, String BT, String BV, String BW, String BY, String BZ, String CA, String CC, String CD, String CF, String CG, String CH, String CI, String CK, String CL, String CM, String CN, String CO, String CR, String CU, String CV, String CW, String CX, String CY, String CZ, String DE, String DJ, String DK, String DM, String DO, String DZ, String EC, String EE, String EG, String EH, String ER, String ES, String ET, String FI, String FJ, String FM, String FO, String FR, String GA, String GB, String GD, String GE, String GF, String GG, String GH, String GI, String GL, String GM, String GN, String GP, String GQ, String GR, String GT, String GU, String GW, String GY, String HK, String HM, String HN, String HR, String HT, String HU, String ID, String IE, String IL, String IM, String IN, String IO, String IQ, String IR, String IS, String IT, String JE, String JM, String JO, String JP, String KE, String KG, String KH, String KI, String KM, String KN, String KP, String KR, String KW, String KY, String KZ, String LA, String LB, String LC, String LI, String LK, String LR, String LS, String LT, String LU, String LV, String LY, String MA, String MC, String MD, String ME, String MF, String MG, String MH, String MK, String ML, String MM, String MN, String MO, String MP, String MQ, String MR, String MS, String MT, String MU, String MV, String MW, String MX, String MY, String MZ, String NA, String NC, String NE, String NF, String NG, String NI, String NL, String NO, String NP, String NR, String NU, String NZ, String OM, String PA, String PE, String PF, String PG, String PH, String PK, String PL, String PM, String PN, String PR, String PT, String PW, String PY, String QA, String RE, String RO, String RS, String RU, String RW, String SA, String SB, String SC, String SD, String SE, String SG, String SH, String SI, String SJ, String SK, String SL, String SM, String SN, String SO, String SR, String SS, String ST, String SV, String SX, String SY, String SZ, String TC, String TD, String TF, String TG, String TH, String TJ, String TK, String TL, String TM, String TN, String TO, String TR, String TT, String TV, String TW, String TZ, String UA, String UG, String US, String UY, String UZ, String VA, String VC, String VE, String VG, String VI, String VN, String VU, String WF, String WS, String YE, String YT, String ZA, String ZM, String ZW) {
                this.AD = AD;
                this.AE = AE;
                this.AF = AF;
                this.AG = AG;
                this.AI = AI;
                this.AL = AL;
                this.AM = AM;
                this.AO = AO;
                this.AQ = AQ;
                this.AR = AR;
                this.AS = AS;
                this.AT = AT;
                this.AU = AU;
                this.AW = AW;
                this.AX = AX;
                this.AZ = AZ;
                this.BA = BA;
                this.BB = BB;
                this.BD = BD;
                this.BE = BE;
                this.BF = BF;
                this.BG = BG;
                this.BH = BH;
                this.BI = BI;
                this.BJ = BJ;
                this.BL = BL;
                this.BM = BM;
                this.BN = BN;
                this.BO = BO;
                this.BQ = BQ;
                this.BR = BR;
                this.BS = BS;
                this.BT = BT;
                this.BV = BV;
                this.BW = BW;
                this.BY = BY;
                this.BZ = BZ;
                this.CA = CA;
                this.CC = CC;
                this.CD = CD;
                this.CF = CF;
                this.CG = CG;
                this.CH = CH;
                this.CI = CI;
                this.CK = CK;
                this.CL = CL;
                this.CM = CM;
                this.CN = CN;
                this.CO = CO;
                this.CR = CR;
                this.CU = CU;
                this.CV = CV;
                this.CW = CW;
                this.CX = CX;
                this.CY = CY;
                this.CZ = CZ;
                this.DE = DE;
                this.DJ = DJ;
                this.DK = DK;
                this.DM = DM;
                this.DO = DO;
                this.DZ = DZ;
                this.EC = EC;
                this.EE = EE;
                this.EG = EG;
                this.EH = EH;
                this.ER = ER;
                this.ES = ES;
                this.ET = ET;
                this.FI = FI;
                this.FJ = FJ;
                this.FM = FM;
                this.FO = FO;
                this.FR = FR;
                this.GA = GA;
                this.GB = GB;
                this.GD = GD;
                this.GE = GE;
                this.GF = GF;
                this.GG = GG;
                this.GH = GH;
                this.GI = GI;
                this.GL = GL;
                this.GM = GM;
                this.GN = GN;
                this.GP = GP;
                this.GQ = GQ;
                this.GR = GR;
                this.GT = GT;
                this.GU = GU;
                this.GW = GW;
                this.GY = GY;
                this.HK = HK;
                this.HM = HM;
                this.HN = HN;
                this.HR = HR;
                this.HT = HT;
                this.HU = HU;
                this.ID = ID;
                this.IE = IE;
                this.IL = IL;
                this.IM = IM;
                this.IN = IN;
                this.IO = IO;
                this.IQ = IQ;
                this.IR = IR;
                this.IS = IS;
                this.IT = IT;
                this.JE = JE;
                this.JM = JM;
                this.JO = JO;
                this.JP = JP;
                this.KE = KE;
                this.KG = KG;
                this.KH = KH;
                this.KI = KI;
                this.KM = KM;
                this.KN = KN;
                this.KP = KP;
                this.KR = KR;
                this.KW = KW;
                this.KY = KY;
                this.KZ = KZ;
                this.LA = LA;
                this.LB = LB;
                this.LC = LC;
                this.LI = LI;
                this.LK = LK;
                this.LR = LR;
                this.LS = LS;
                this.LT = LT;
                this.LU = LU;
                this.LV = LV;
                this.LY = LY;
                this.MA = MA;
                this.MC = MC;
                this.MD = MD;
                this.ME = ME;
                this.MF = MF;
                this.MG = MG;
                this.MH = MH;
                this.MK = MK;
                this.ML = ML;
                this.MM = MM;
                this.MN = MN;
                this.MO = MO;
                this.MP = MP;
                this.MQ = MQ;
                this.MR = MR;
                this.MS = MS;
                this.MT = MT;
                this.MU = MU;
                this.MV = MV;
                this.MW = MW;
                this.MX = MX;
                this.MY = MY;
                this.MZ = MZ;
                this.NA = NA;
                this.NC = NC;
                this.NE = NE;
                this.NF = NF;
                this.NG = NG;
                this.NI = NI;
                this.NL = NL;
                this.NO = NO;
                this.NP = NP;
                this.NR = NR;
                this.NU = NU;
                this.NZ = NZ;
                this.OM = OM;
                this.PA = PA;
                this.PE = PE;
                this.PF = PF;
                this.PG = PG;
                this.PH = PH;
                this.PK = PK;
                this.PL = PL;
                this.PM = PM;
                this.PN = PN;
                this.PR = PR;
                this.PT = PT;
                this.PW = PW;
                this.PY = PY;
                this.QA = QA;
                this.RE = RE;
                this.RO = RO;
                this.RS = RS;
                this.RU = RU;
                this.RW = RW;
                this.SA = SA;
                this.SB = SB;
                this.SC = SC;
                this.SD = SD;
                this.SE = SE;
                this.SG = SG;
                this.SH = SH;
                this.SI = SI;
                this.SJ = SJ;
                this.SK = SK;
                this.SL = SL;
                this.SM = SM;
                this.SN = SN;
                this.SO = SO;
                this.SR = SR;
                this.SS = SS;
                this.ST = ST;
                this.SV = SV;
                this.SX = SX;
                this.SY = SY;
                this.SZ = SZ;
                this.TC = TC;
                this.TD = TD;
                this.TF = TF;
                this.TG = TG;
                this.TH = TH;
                this.TJ = TJ;
                this.TK = TK;
                this.TL = TL;
                this.TM = TM;
                this.TN = TN;
                this.TO = TO;
                this.TR = TR;
                this.TT = TT;
                this.TV = TV;
                this.TW = TW;
                this.TZ = TZ;
                this.UA = UA;
                this.UG = UG;
                this.US = US;
                this.UY = UY;
                this.UZ = UZ;
                this.VA = VA;
                this.VC = VC;
                this.VE = VE;
                this.VG = VG;
                this.VI = VI;
                this.VN = VN;
                this.VU = VU;
                this.WF = WF;
                this.WS = WS;
                this.YE = YE;
                this.YT = YT;
                this.ZA = ZA;
                this.ZM = ZM;
                this.ZW = ZW;
        }
        public String getAD() {
                return AD;
        }

        public String getAE() {
                return AE;
        }

        public String getAF() {
                return AF;
        }

        public String getAG() {
                return AG;
        }

        public String getAI() {
                return AI;
        }

        public String getAL() {
                return AL;
        }

        public String getAM() {
                return AM;
        }

        public String getAO() {
                return AO;
        }

        public String getAQ() {
                return AQ;
        }

        public String getAR() {
                return AR;
        }

        public String getAS() {
                return AS;
        }

        public String getAT() {
                return AT;
        }

        public String getAU() {
                return AU;
        }

        public String getAW() {
                return AW;
        }

        public String getAX() {
                return AX;
        }

        public String getAZ() {
                return AZ;
        }

        public String getBA() {
                return BA;
        }

        public String getBB() {
                return BB;
        }

        public String getBD() {
                return BD;
        }

        public String getBE() {
                return BE;
        }

        public String getBF() {
                return BF;
        }

        public String getBG() {
                return BG;
        }

        public String getBH() {
                return BH;
        }

        public String getBI() {
                return BI;
        }

        public String getBJ() {
                return BJ;
        }

        public String getBL() {
                return BL;
        }

        public String getBM() {
                return BM;
        }

        public String getBN() {
                return BN;
        }

        public String getBO() {
                return BO;
        }

        public String getBQ() {
                return BQ;
        }

        public String getBR() {
                return BR;
        }

        public String getBS() {
                return BS;
        }

        public String getBT() {
                return BT;
        }

        public String getBV() {
                return BV;
        }

        public String getBW() {
                return BW;
        }

        public String getBY() {
                return BY;
        }

        public String getBZ() {
                return BZ;
        }

        public String getCA() {
                return CA;
        }

        public String getCC() {
                return CC;
        }

        public String getCD() {
                return CD;
        }

        public String getCF() {
                return CF;
        }

        public String getCG() {
                return CG;
        }

        public String getCH() {
                return CH;
        }

        public String getCI() {
                return CI;
        }

        public String getCK() {
                return CK;
        }

        public String getCL() {
                return CL;
        }

        public String getCM() {
                return CM;
        }

        public String getCN() {
                return CN;
        }

        public String getCO() {
                return CO;
        }

        public String getCR() {
                return CR;
        }

        public String getCU() {
                return CU;
        }

        public String getCV() {
                return CV;
        }

        public String getCW() {
                return CW;
        }

        public String getCX() {
                return CX;
        }

        public String getCY() {
                return CY;
        }

        public String getCZ() {
                return CZ;
        }

        public String getDE() {
                return DE;
        }

        public String getDJ() {
                return DJ;
        }

        public String getDK() {
                return DK;
        }

        public String getDM() {
                return DM;
        }

        public String getDO() {
                return DO;
        }

        public String getDZ() {
                return DZ;
        }

        public String getEC() {
                return EC;
        }

        public String getEE() {
                return EE;
        }

        public String getEG() {
                return EG;
        }

        public String getEH() {
                return EH;
        }

        public String getER() {
                return ER;
        }

        public String getES() {
                return ES;
        }

        public String getET() {
                return ET;
        }

        public String getFI() {
                return FI;
        }

        public String getFJ() {
                return FJ;
        }

        public String getFM() {
                return FM;
        }

        public String getFO() {
                return FO;
        }

        public String getFR() {
                return FR;
        }

        public String getGA() {
                return GA;
        }

        public String getGB() {
                return GB;
        }

        public String getGD() {
                return GD;
        }

        public String getGE() {
                return GE;
        }

        public String getGF() {
                return GF;
        }

        public String getGG() {
                return GG;
        }

        public String getGH() {
                return GH;
        }

        public String getGI() {
                return GI;
        }

        public String getGL() {
                return GL;
        }

        public String getGM() {
                return GM;
        }

        public String getGN() {
                return GN;
        }

        public String getGP() {
                return GP;
        }

        public String getGQ() {
                return GQ;
        }

        public String getGR() {
                return GR;
        }

        public String getGT() {
                return GT;
        }

        public String getGU() {
                return GU;
        }

        public String getGW() {
                return GW;
        }

        public String getGY() {
                return GY;
        }

        public String getHK() {
                return HK;
        }

        public String getHM() {
                return HM;
        }

        public String getHN() {
                return HN;
        }

        public String getHR() {
                return HR;
        }

        public String getHT() {
                return HT;
        }

        public String getHU() {
                return HU;
        }

        public String getID() {
                return ID;
        }

        public String getIE() {
                return IE;
        }

        public String getIL() {
                return IL;
        }

        public String getIM() {
                return IM;
        }

        public String getIN() {
                return IN;
        }

        public String getIO() {
                return IO;
        }

        public String getIQ() {
                return IQ;
        }

        public String getIR() {
                return IR;
        }

        public String getIS() {
                return IS;
        }

        public String getIT() {
                return IT;
        }

        public String getJE() {
                return JE;
        }

        public String getJM() {
                return JM;
        }

        public String getJO() {
                return JO;
        }

        public String getJP() {
                return JP;
        }

        public String getKE() {
                return KE;
        }

        public String getKG() {
                return KG;
        }

        public String getKH() {
                return KH;
        }

        public String getKI() {
                return KI;
        }

        public String getKM() {
                return KM;
        }

        public String getKN() {
                return KN;
        }

        public String getKP() {
                return KP;
        }

        public String getKR() {
                return KR;
        }

        public String getKW() {
                return KW;
        }

        public String getKY() {
                return KY;
        }

        public String getKZ() {
                return KZ;
        }

        public String getLA() {
                return LA;
        }

        public String getLB() {
                return LB;
        }

        public String getLC() {
                return LC;
        }

        public String getLI() {
                return LI;
        }

        public String getLK() {
                return LK;
        }

        public String getLR() {
                return LR;
        }

        public String getLS() {
                return LS;
        }

        public String getLT() {
                return LT;
        }

        public String getLU() {
                return LU;
        }

        public String getLV() {
                return LV;
        }

        public String getLY() {
                return LY;
        }

        public String getMA() {
                return MA;
        }

        public String getMC() {
                return MC;
        }

        public String getMD() {
                return MD;
        }

        public String getME() {
                return ME;
        }

        public String getMF() {
                return MF;
        }

        public String getMG() {
                return MG;
        }

        public String getMH() {
                return MH;
        }

        public String getMK() {
                return MK;
        }

        public String getML() {
                return ML;
        }

        public String getMM() {
                return MM;
        }

        public String getMN() {
                return MN;
        }

        public String getMO() {
                return MO;
        }

        public String getMP() {
                return MP;
        }

        public String getMQ() {
                return MQ;
        }

        public String getMR() {
                return MR;
        }

        public String getMS() {
                return MS;
        }

        public String getMT() {
                return MT;
        }

        public String getMU() {
                return MU;
        }

        public String getMV() {
                return MV;
        }

        public String getMW() {
                return MW;
        }

        public String getMX() {
                return MX;
        }

        public String getMY() {
                return MY;
        }

        public String getMZ() {
                return MZ;
        }

        public String getNA() {
                return NA;
        }

        public String getNC() {
                return NC;
        }

        public String getNE() {
                return NE;
        }

        public String getNF() {
                return NF;
        }

        public String getNG() {
                return NG;
        }

        public String getNI() {
                return NI;
        }

        public String getNL() {
                return NL;
        }

        public String getNO() {
                return NO;
        }

        public String getNP() {
                return NP;
        }

        public String getNR() {
                return NR;
        }

        public String getNU() {
                return NU;
        }

        public String getNZ() {
                return NZ;
        }

        public String getOM() {
                return OM;
        }

        public String getPA() {
                return PA;
        }

        public String getPE() {
                return PE;
        }

        public String getPF() {
                return PF;
        }

        public String getPG() {
                return PG;
        }

        public String getPH() {
                return PH;
        }

        public String getPK() {
                return PK;
        }

        public String getPL() {
                return PL;
        }

        public String getPM() {
                return PM;
        }

        public String getPN() {
                return PN;
        }

        public String getPR() {
                return PR;
        }

        public String getPT() {
                return PT;
        }

        public String getPW() {
                return PW;
        }

        public String getPY() {
                return PY;
        }

        public String getQA() {
                return QA;
        }

        public String getRE() {
                return RE;
        }

        public String getRO() {
                return RO;
        }

        public String getRS() {
                return RS;
        }

        public String getRU() {
                return RU;
        }

        public String getRW() {
                return RW;
        }

        public String getSA() {
                return SA;
        }

        public String getSB() {
                return SB;
        }

        public String getSC() {
                return SC;
        }

        public String getSD() {
                return SD;
        }

        public String getSE() {
                return SE;
        }

        public String getSG() {
                return SG;
        }

        public String getSH() {
                return SH;
        }

        public String getSI() {
                return SI;
        }

        public String getSJ() {
                return SJ;
        }

        public String getSK() {
                return SK;
        }

        public String getSL() {
                return SL;
        }

        public String getSM() {
                return SM;
        }

        public String getSN() {
                return SN;
        }

        public String getSO() {
                return SO;
        }

        public String getSR() {
                return SR;
        }

        public String getSS() {
                return SS;
        }

        public String getST() {
                return ST;
        }

        public String getSV() {
                return SV;
        }

        public String getSX() {
                return SX;
        }

        public String getSY() {
                return SY;
        }

        public String getSZ() {
                return SZ;
        }

        public String getTC() {
                return TC;
        }

        public String getTD() {
                return TD;
        }

        public String getTF() {
                return TF;
        }

        public String getTG() {
                return TG;
        }

        public String getTH() {
                return TH;
        }

        public String getTJ() {
                return TJ;
        }

        public String getTK() {
                return TK;
        }

        public String getTL() {
                return TL;
        }

        public String getTM() {
                return TM;
        }

        public String getTN() {
                return TN;
        }

        public String getTO() {
                return TO;
        }

        public String getTR() {
                return TR;
        }

        public String getTT() {
                return TT;
        }

        public String getTV() {
                return TV;
        }

        public String getTW() {
                return TW;
        }

        public String getTZ() {
                return TZ;
        }

        public String getUA() {
                return UA;
        }

        public String getUG() {
                return UG;
        }

        public String getUS() {
                return US;
        }

        public String getUY() {
                return UY;
        }

        public String getUZ() {
                return UZ;
        }

        public String getVA() {
                return VA;
        }

        public String getVC() {
                return VC;
        }

        public String getVE() {
                return VE;
        }

        public String getVG() {
                return VG;
        }

        public String getVI() {
                return VI;
        }

        public String getVN() {
                return VN;
        }

        public String getVU() {
                return VU;
        }

        public String getWF() {
                return WF;
        }

        public String getWS() {
                return WS;
        }

        public String getYE() {
                return YE;
        }

        public String getYT() {
                return YT;
        }

        public String getZA() {
                return ZA;
        }

        public String getZM() {
                return ZM;
        }

        public String getZW() {
                return ZW;
        }

        public void setAD(String AD) {
                this.AD = AD;
        }

        public void setAE(String AE) {
                this.AE = AE;
        }

        public void setAF(String AF) {
                this.AF = AF;
        }

        public void setAG(String AG) {
                this.AG = AG;
        }

        public void setAI(String AI) {
                this.AI = AI;
        }

        public void setAL(String AL) {
                this.AL = AL;
        }

        public void setAM(String AM) {
                this.AM = AM;
        }

        public void setAO(String AO) {
                this.AO = AO;
        }

        public void setAQ(String AQ) {
                this.AQ = AQ;
        }

        public void setAR(String AR) {
                this.AR = AR;
        }

        public void setAS(String AS) {
                this.AS = AS;
        }

        public void setAT(String AT) {
                this.AT = AT;
        }

        public void setAU(String AU) {
                this.AU = AU;
        }

        public void setAW(String AW) {
                this.AW = AW;
        }

        public void setAX(String AX) {
                this.AX = AX;
        }

        public void setAZ(String AZ) {
                this.AZ = AZ;
        }

        public void setBA(String BA) {
                this.BA = BA;
        }

        public void setBB(String BB) {
                this.BB = BB;
        }

        public void setBD(String BD) {
                this.BD = BD;
        }

        public void setBE(String BE) {
                this.BE = BE;
        }

        public void setBF(String BF) {
                this.BF = BF;
        }

        public void setBG(String BG) {
                this.BG = BG;
        }

        public void setBH(String BH) {
                this.BH = BH;
        }

        public void setBI(String BI) {
                this.BI = BI;
        }

        public void setBJ(String BJ) {
                this.BJ = BJ;
        }

        public void setBL(String BL) {
                this.BL = BL;
        }

        public void setBM(String BM) {
                this.BM = BM;
        }

        public void setBN(String BN) {
                this.BN = BN;
        }

        public void setBO(String BO) {
                this.BO = BO;
        }

        public void setBQ(String BQ) {
                this.BQ = BQ;
        }

        public void setBR(String BR) {
                this.BR = BR;
        }

        public void setBS(String BS) {
                this.BS = BS;
        }

        public void setBT(String BT) {
                this.BT = BT;
        }

        public void setBV(String BV) {
                this.BV = BV;
        }

        public void setBW(String BW) {
                this.BW = BW;
        }

        public void setBY(String BY) {
                this.BY = BY;
        }

        public void setBZ(String BZ) {
                this.BZ = BZ;
        }

        public void setCA(String CA) {
                this.CA = CA;
        }

        public void setCC(String CC) {
                this.CC = CC;
        }

        public void setCD(String CD) {
                this.CD = CD;
        }

        public void setCF(String CF) {
                this.CF = CF;
        }

        public void setCG(String CG) {
                this.CG = CG;
        }

        public void setCH(String CH) {
                this.CH = CH;
        }

        public void setCI(String CI) {
                this.CI = CI;
        }

        public void setCK(String CK) {
                this.CK = CK;
        }

        public void setCL(String CL) {
                this.CL = CL;
        }

        public void setCM(String CM) {
                this.CM = CM;
        }

        public void setCN(String CN) {
                this.CN = CN;
        }

        public void setCO(String CO) {
                this.CO = CO;
        }

        public void setCR(String CR) {
                this.CR = CR;
        }

        public void setCU(String CU) {
                this.CU = CU;
        }

        public void setCV(String CV) {
                this.CV = CV;
        }

        public void setCW(String CW) {
                this.CW = CW;
        }

        public void setCX(String CX) {
                this.CX = CX;
        }

        public void setCY(String CY) {
                this.CY = CY;
        }

        public void setCZ(String CZ) {
                this.CZ = CZ;
        }

        public void setDE(String DE) {
                this.DE = DE;
        }

        public void setDJ(String DJ) {
                this.DJ = DJ;
        }

        public void setDK(String DK) {
                this.DK = DK;
        }

        public void setDM(String DM) {
                this.DM = DM;
        }

        public void setDO(String DO) {
                this.DO = DO;
        }

        public void setDZ(String DZ) {
                this.DZ = DZ;
        }

        public void setEC(String EC) {
                this.EC = EC;
        }

        public void setEE(String EE) {
                this.EE = EE;
        }

        public void setEG(String EG) {
                this.EG = EG;
        }

        public void setEH(String EH) {
                this.EH = EH;
        }

        public void setER(String ER) {
                this.ER = ER;
        }

        public void setES(String ES) {
                this.ES = ES;
        }

        public void setET(String ET) {
                this.ET = ET;
        }

        public void setFI(String FI) {
                this.FI = FI;
        }

        public void setFJ(String FJ) {
                this.FJ = FJ;
        }

        public void setFM(String FM) {
                this.FM = FM;
        }

        public void setFO(String FO) {
                this.FO = FO;
        }

        public void setFR(String FR) {
                this.FR = FR;
        }

        public void setGA(String GA) {
                this.GA = GA;
        }

        public void setGB(String GB) {
                this.GB = GB;
        }

        public void setGD(String GD) {
                this.GD = GD;
        }

        public void setGE(String GE) {
                this.GE = GE;
        }

        public void setGF(String GF) {
                this.GF = GF;
        }

        public void setGG(String GG) {
                this.GG = GG;
        }

        public void setGH(String GH) {
                this.GH = GH;
        }

        public void setGI(String GI) {
                this.GI = GI;
        }

        public void setGL(String GL) {
                this.GL = GL;
        }

        public void setGM(String GM) {
                this.GM = GM;
        }

        public void setGN(String GN) {
                this.GN = GN;
        }

        public void setGP(String GP) {
                this.GP = GP;
        }

        public void setGQ(String GQ) {
                this.GQ = GQ;
        }

        public void setGR(String GR) {
                this.GR = GR;
        }

        public void setGT(String GT) {
                this.GT = GT;
        }

        public void setGU(String GU) {
                this.GU = GU;
        }

        public void setGW(String GW) {
                this.GW = GW;
        }

        public void setGY(String GY) {
                this.GY = GY;
        }

        public void setHK(String HK) {
                this.HK = HK;
        }

        public void setHM(String HM) {
                this.HM = HM;
        }

        public void setHN(String HN) {
                this.HN = HN;
        }

        public void setHR(String HR) {
                this.HR = HR;
        }

        public void setHT(String HT) {
                this.HT = HT;
        }

        public void setHU(String HU) {
                this.HU = HU;
        }

        public void setID(String ID) {
                this.ID = ID;
        }

        public void setIE(String IE) {
                this.IE = IE;
        }

        public void setIL(String IL) {
                this.IL = IL;
        }

        public void setIM(String IM) {
                this.IM = IM;
        }

        public void setIN(String IN) {
                this.IN = IN;
        }

        public void setIO(String IO) {
                this.IO = IO;
        }

        public void setIQ(String IQ) {
                this.IQ = IQ;
        }

        public void setIR(String IR) {
                this.IR = IR;
        }

        public void setIS(String IS) {
                this.IS = IS;
        }

        public void setIT(String IT) {
                this.IT = IT;
        }

        public void setJE(String JE) {
                this.JE = JE;
        }

        public void setJM(String JM) {
                this.JM = JM;
        }

        public void setJO(String JO) {
                this.JO = JO;
        }

        public void setJP(String JP) {
                this.JP = JP;
        }

        public void setKE(String KE) {
                this.KE = KE;
        }

        public void setKG(String KG) {
                this.KG = KG;
        }

        public void setKH(String KH) {
                this.KH = KH;
        }

        public void setKI(String KI) {
                this.KI = KI;
        }

        public void setKM(String KM) {
                this.KM = KM;
        }

        public void setKN(String KN) {
                this.KN = KN;
        }

        public void setKP(String KP) {
                this.KP = KP;
        }

        public void setKR(String KR) {
                this.KR = KR;
        }

        public void setKW(String KW) {
                this.KW = KW;
        }

        public void setKY(String KY) {
                this.KY = KY;
        }

        public void setKZ(String KZ) {
                this.KZ = KZ;
        }

        public void setLA(String LA) {
                this.LA = LA;
        }

        public void setLB(String LB) {
                this.LB = LB;
        }

        public void setLC(String LC) {
                this.LC = LC;
        }

        public void setLI(String LI) {
                this.LI = LI;
        }

        public void setLK(String LK) {
                this.LK = LK;
        }

        public void setLR(String LR) {
                this.LR = LR;
        }

        public void setLS(String LS) {
                this.LS = LS;
        }

        public void setLT(String LT) {
                this.LT = LT;
        }

        public void setLU(String LU) {
                this.LU = LU;
        }

        public void setLV(String LV) {
                this.LV = LV;
        }

        public void setLY(String LY) {
                this.LY = LY;
        }

        public void setMA(String MA) {
                this.MA = MA;
        }

        public void setMC(String MC) {
                this.MC = MC;
        }

        public void setMD(String MD) {
                this.MD = MD;
        }

        public void setME(String ME) {
                this.ME = ME;
        }

        public void setMF(String MF) {
                this.MF = MF;
        }

        public void setMG(String MG) {
                this.MG = MG;
        }

        public void setMH(String MH) {
                this.MH = MH;
        }

        public void setMK(String MK) {
                this.MK = MK;
        }

        public void setML(String ML) {
                this.ML = ML;
        }

        public void setMM(String MM) {
                this.MM = MM;
        }

        public void setMN(String MN) {
                this.MN = MN;
        }

        public void setMO(String MO) {
                this.MO = MO;
        }

        public void setMP(String MP) {
                this.MP = MP;
        }

        public void setMQ(String MQ) {
                this.MQ = MQ;
        }

        public void setMR(String MR) {
                this.MR = MR;
        }

        public void setMS(String MS) {
                this.MS = MS;
        }

        public void setMT(String MT) {
                this.MT = MT;
        }

        public void setMU(String MU) {
                this.MU = MU;
        }

        public void setMV(String MV) {
                this.MV = MV;
        }

        public void setMW(String MW) {
                this.MW = MW;
        }

        public void setMX(String MX) {
                this.MX = MX;
        }

        public void setMY(String MY) {
                this.MY = MY;
        }

        public void setMZ(String MZ) {
                this.MZ = MZ;
        }

        public void setNA(String NA) {
                this.NA = NA;
        }

        public void setNC(String NC) {
                this.NC = NC;
        }

        public void setNE(String NE) {
                this.NE = NE;
        }

        public void setNF(String NF) {
                this.NF = NF;
        }

        public void setNG(String NG) {
                this.NG = NG;
        }

        public void setNI(String NI) {
                this.NI = NI;
        }

        public void setNL(String NL) {
                this.NL = NL;
        }

        public void setNO(String NO) {
                this.NO = NO;
        }

        public void setNP(String NP) {
                this.NP = NP;
        }

        public void setNR(String NR) {
                this.NR = NR;
        }

        public void setNU(String NU) {
                this.NU = NU;
        }

        public void setNZ(String NZ) {
                this.NZ = NZ;
        }

        public void setOM(String OM) {
                this.OM = OM;
        }

        public void setPA(String PA) {
                this.PA = PA;
        }

        public void setPE(String PE) {
                this.PE = PE;
        }

        public void setPF(String PF) {
                this.PF = PF;
        }

        public void setPG(String PG) {
                this.PG = PG;
        }

        public void setPH(String PH) {
                this.PH = PH;
        }

        public void setPK(String PK) {
                this.PK = PK;
        }

        public void setPL(String PL) {
                this.PL = PL;
        }

        public void setPM(String PM) {
                this.PM = PM;
        }

        public void setPN(String PN) {
                this.PN = PN;
        }

        public void setPR(String PR) {
                this.PR = PR;
        }

        public void setPT(String PT) {
                this.PT = PT;
        }

        public void setPW(String PW) {
                this.PW = PW;
        }

        public void setPY(String PY) {
                this.PY = PY;
        }

        public void setQA(String QA) {
                this.QA = QA;
        }

        public void setRE(String RE) {
                this.RE = RE;
        }

        public void setRO(String RO) {
                this.RO = RO;
        }

        public void setRS(String RS) {
                this.RS = RS;
        }

        public void setRU(String RU) {
                this.RU = RU;
        }

        public void setRW(String RW) {
                this.RW = RW;
        }

        public void setSA(String SA) {
                this.SA = SA;
        }

        public void setSB(String SB) {
                this.SB = SB;
        }

        public void setSC(String SC) {
                this.SC = SC;
        }

        public void setSD(String SD) {
                this.SD = SD;
        }

        public void setSE(String SE) {
                this.SE = SE;
        }

        public void setSG(String SG) {
                this.SG = SG;
        }

        public void setSH(String SH) {
                this.SH = SH;
        }

        public void setSI(String SI) {
                this.SI = SI;
        }

        public void setSJ(String SJ) {
                this.SJ = SJ;
        }

        public void setSK(String SK) {
                this.SK = SK;
        }

        public void setSL(String SL) {
                this.SL = SL;
        }

        public void setSM(String SM) {
                this.SM = SM;
        }

        public void setSN(String SN) {
                this.SN = SN;
        }

        public void setSO(String SO) {
                this.SO = SO;
        }

        public void setSR(String SR) {
                this.SR = SR;
        }

        public void setSS(String SS) {
                this.SS = SS;
        }

        public void setST(String ST) {
                this.ST = ST;
        }

        public void setSV(String SV) {
                this.SV = SV;
        }

        public void setSX(String SX) {
                this.SX = SX;
        }

        public void setSY(String SY) {
                this.SY = SY;
        }

        public void setSZ(String SZ) {
                this.SZ = SZ;
        }

        public void setTC(String TC) {
                this.TC = TC;
        }

        public void setTD(String TD) {
                this.TD = TD;
        }

        public void setTF(String TF) {
                this.TF = TF;
        }

        public void setTG(String TG) {
                this.TG = TG;
        }

        public void setTH(String TH) {
                this.TH = TH;
        }

        public void setTJ(String TJ) {
                this.TJ = TJ;
        }

        public void setTK(String TK) {
                this.TK = TK;
        }

        public void setTL(String TL) {
                this.TL = TL;
        }

        public void setTM(String TM) {
                this.TM = TM;
        }

        public void setTN(String TN) {
                this.TN = TN;
        }

        public void setTO(String TO) {
                this.TO = TO;
        }

        public void setTR(String TR) {
                this.TR = TR;
        }

        public void setTT(String TT) {
                this.TT = TT;
        }

        public void setTV(String TV) {
                this.TV = TV;
        }

        public void setTW(String TW) {
                this.TW = TW;
        }

        public void setTZ(String TZ) {
                this.TZ = TZ;
        }

        public void setUA(String UA) {
                this.UA = UA;
        }

        public void setUG(String UG) {
                this.UG = UG;
        }

        public void setUS(String US) {
                this.US = US;
        }

        public void setUY(String UY) {
                this.UY = UY;
        }

        public void setUZ(String UZ) {
                this.UZ = UZ;
        }

        public void setVA(String VA) {
                this.VA = VA;
        }

        public void setVC(String VC) {
                this.VC = VC;
        }

        public void setVE(String VE) {
                this.VE = VE;
        }

        public void setVG(String VG) {
                this.VG = VG;
        }

        public void setVI(String VI) {
                this.VI = VI;
        }

        public void setVN(String VN) {
                this.VN = VN;
        }

        public void setVU(String VU) {
                this.VU = VU;
        }

        public void setWF(String WF) {
                this.WF = WF;
        }

        public void setWS(String WS) {
                this.WS = WS;
        }

        public void setYE(String YE) {
                this.YE = YE;
        }

        public void setYT(String YT) {
                this.YT = YT;
        }

        public void setZA(String ZA) {
                this.ZA = ZA;
        }

        public void setZM(String ZM) {
                this.ZM = ZM;
        }

        public void setZW(String ZW) {
                this.ZW = ZW;
        }*/

    private Map<String, String> countryCodes;

    public Map<String, String> getCountryCodes() {
        return countryCodes;
    }

    public void setCountryCodes(Map<String, String> countryCodes) {
        this.countryCodes = countryCodes;
    }

    @Override
    public String toString() {
        return "CountryCode{" +
                "countryCodes=" + countryCodes +
                '}';
    }
}
