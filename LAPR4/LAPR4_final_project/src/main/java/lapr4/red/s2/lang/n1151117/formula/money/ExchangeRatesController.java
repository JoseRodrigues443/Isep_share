/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s2.lang.n1151117.formula.money;

/**
 * Controller to get the current rates and update, case necessary
 *
 * @author Barros
 */
public class ExchangeRatesController {

    public ExchangeRatesController() {

    }

    public void changeEuroDollarRate(double rate) {
        ExchangeRate.updateEuroDollarRate(rate);
    }

    public void changeEuroPoundRate(double rate) {
        ExchangeRate.updateEuroPoundRate(rate);
    }

    public void changeDollarPoundRate(double rate) {
        ExchangeRate.updateDollarPoundRate(rate);
    }

    public void changeDollarEuroRate(double rate) {
        ExchangeRate.updateDollarEuroRate(rate);
    }

    public void changePoundEuroRate(double rate) {
        ExchangeRate.updatePoundEuroRate(rate);
    }

    public void changePoundDollarRate(double rate) {
        ExchangeRate.updatePoundDollarRate(rate);
    }

    public double euroDollarRate() {
        return ExchangeRate.euroDollarRate();
    }

    public double euroPoundRate() {
        return ExchangeRate.euroPoundRate();
    }

    public double dollarEuroRate() {
        return ExchangeRate.dollarEuroRate();
    }

    public double dollarPoundRate() {
        return ExchangeRate.dollarPoundRate();
    }

    public double poundEuroRate() {
        return ExchangeRate.poundEuroRate();
    }

    public double poundDollarRate() {
        return ExchangeRate.poundDollarRate();
    }
}
