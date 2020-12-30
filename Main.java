package com.bsherwin;
import java.util.Scanner;


public class Main {
    private static int assetsN; // Currently held cash/assest
    private static float interestA; //expected interest annually on current held assets
    private static String returnsQM; //Investments returned Q or M
    private static short contributeQM; // Contributions each Q or M
    private static float inflationA;
    private static float dividendG;
    private static int result;
    private static byte invqm;

    public static void Calculator(int assetsN, byte invqm, float interestA, float inflationA, float dividendG, short contributeQM) {

        interestA /= 100;
        inflationA /= 100;
        dividendG /= 100;
        interestA /= invqm;
        while (assetsN < 1000000) {
            for (int i = 0; i < invqm; i++) {
                assetsN += assetsN * (inflationA / invqm);
                assetsN += contributeQM;
                assetsN += assetsN * interestA;

            }
            interestA *= dividendG + 1;
            result += 1;
        }
    }


    public static void main(String[] args) {
        Scanner AssetsN = new Scanner(System.in);
        Scanner InterestA = new Scanner(System.in);
        Scanner ReturnsMQ = new Scanner(System.in);
        Scanner ContributeQM = new Scanner(System.in);
        Scanner InflationA = new Scanner(System.in);
        Scanner DividendG = new Scanner(System.in);


        System.out.println("How much do you currently hold in cash/assets?");
        assetsN = AssetsN.nextInt();
        System.out.println("Expected annual percentage on currently held assets? (Whole number)");
        interestA = InterestA.nextShort();
        System.out.println("Investment returns are Quarterly or Monthly?");
        returnsQM = ReturnsMQ.nextLine();
        if ((returnsQM.equals("m")) || (returnsQM.equals("Monthly")) || (returnsQM.equals("M")) || (returnsQM.equals("monthly"))) {
            invqm = 12;
        } else if ((returnsQM.equals("q")) || (returnsQM.equals("Q")) || (returnsQM.equals("quarterly")) || (returnsQM.equals("Quarterly"))) {
            invqm = 4;

        } else {
            System.out.println("Investment returns are Quarterly or Monthly?");
            returnsQM = ReturnsMQ.nextLine();
        }
        System.out.println(returnsQM + " contributions made yourself?");
        contributeQM = ContributeQM.nextShort();
        System.out.println("Expected inflation in stocks yearly? (% as a whole number)");
        inflationA = InflationA.nextByte();
        System.out.println("Expected dividend rate growth per year?");
        dividendG = DividendG.nextByte();

        Calculator(assetsN, invqm, interestA, inflationA, dividendG, contributeQM);


        System.out.println("It will take you " + result + " year(s) to be a million dollar man!");



    }


}



