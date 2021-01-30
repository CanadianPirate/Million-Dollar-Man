package com.bsherwin;

import java.util.Scanner;

public class Main {
    private static int result;
    private static byte invqm;
    private static String question;

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
        // Currently held cash/assest
        int assetsN = AssetsN.nextInt();
        System.out.println("Expected annual percentage on currently held assets? (Whole number)");
        //expected interest annually on current held assets
        float interestA = InterestA.nextShort();
        System.out.println("Investment returns are Quarterly or Monthly?");
        //Investments returned Q or M
        String returnsQM = ReturnsMQ.nextLine();
        if ((returnsQM.equals("m")) || (returnsQM.equals("Monthly")) || (returnsQM.equals("M")) || (returnsQM.equals("monthly"))) {
            invqm = 12;
            question = "Monthly";
        } else if ((returnsQM.equals("q")) || (returnsQM.equals("Q")) || (returnsQM.equals("quarterly")) || (returnsQM.equals("Quarterly"))) {
            invqm = 4;
            question = "Quarterly";
        } else {
            System.out.println("Investment returns are Quarterly or Monthly?");
        }
        System.out.println(question + " contributions made yourself?");
        // Contributions each Q or M
        short contributeQM = ContributeQM.nextShort();
        System.out.println("Expected inflation in stocks yearly? (% as a whole number)");
        float inflationA = InflationA.nextByte();
        System.out.println("Expected dividend rate growth per year?");
        float dividendG = DividendG.nextByte();
        Calculator(assetsN, invqm, interestA, inflationA, dividendG, contributeQM);
        System.out.println("It will take you " + result + " year(s) to be a million dollar man!");
    }
}



