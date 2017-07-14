/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s2.lang.n1151117.formula.money;

/**
 * Class that will be responsible to handle the exchange rates between different
 * currencies
 *
 * @author Barros
 */
public class ExchangeRate {

    private static final double EURO_TO_DOLLAR = 1.12;
    private static final double EURO_TO_POUND = 0.88;

    private static final double DOLLAR_TO_POUND = 0.79;
    private static final double DOLLAR_TO_EURO = 0.89;

    private static final double POUND_TO_EURO = 1.14;
    private static final double POUND_TO_DOLLAR = 1.27;

    private static double rateDollarEuro = DOLLAR_TO_EURO;
    private static double rateDollarPound = DOLLAR_TO_POUND;
    private static double rateEuroPound = EURO_TO_POUND;
    private static double rateEuroDollar = EURO_TO_DOLLAR;
    private static double ratePoundDollar = POUND_TO_DOLLAR;
    private static double ratePoundEuro = POUND_TO_EURO;

    public static void updateDollarEuroRate(double rate) {
        if (rate < 0) {
            throw new IllegalStateException("Dollar to Euro rate can't be lower than 0");
        }
        rateDollarEuro = rate;
    }

    public static void updateDollarPoundRate(double rate) {
        if (rate < 0) {
            throw new IllegalStateException("Dollar to Pound rate can't be lower than 0");
        }
        rateDollarPound = rate;
    }

    public static void updatePoundEuroRate(double rate) {
        if (rate < 0) {
            throw new IllegalStateException("Pound to Euro rate can't be lower than 0");
        }
        ratePoundEuro = rate;
    }

    public static void updatePoundDollarRate(double rate) {
        if (rate < 0) {
            throw new IllegalStateException("Pound to Dollar rate can't be lower than 0");
        }
        ratePoundDollar = rate;
    }

    public static void updateEuroDollarRate(double rate) {
        if (rate < 0) {
            throw new IllegalStateException("Euro to Dollar rate can't be lower than 0");
        }
        rateEuroDollar = rate;
    }

    public static void updateEuroPoundRate(double rate) {
        if (rate < 0) {
            throw new IllegalStateException("Euro to Pound rate can't be lower than 0");
        }
        rateEuroPound = rate;
    }
    
    public static double dollarEuroRate() {
        return rateDollarEuro;
    }

    public static double dollarPoundRate() {
        return rateDollarPound;
    }

    public static double poundEuroRate() {
        return ratePoundEuro;
    }

    public static double poundDollarRate() {
        return ratePoundDollar;
    }

    public static double euroDollarRate() {
        return rateEuroDollar;
    }

    public static double euroPoundRate() {
        return rateEuroPound;
    }
}
