/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s2.lang.n1151117.formula.money;

import csheets.core.Value;
import java.math.BigDecimal;

/**
 * Represents money in Dollar currency
 *
 * @author Barros
 */
public class Dollar implements ConversorStrategy, Money {

    public BigDecimal amount;
    private static final int HUNDRED = 100;

    public Dollar(double amount) {
        if (amount < 0) {
            throw new IllegalStateException();
        }
        this.amount = new BigDecimal(amount * HUNDRED);
    }

    @Override
    public double convertToEuro() {
        return (this.amount.doubleValue() * ExchangeRate.dollarEuroRate()) / HUNDRED;
    }

    @Override
    public double convertToDollar() {
        return this.amount.doubleValue() / HUNDRED;
    }

    @Override
    public double convertToPound() {
        return (this.amount.doubleValue() * ExchangeRate.dollarPoundRate()) / HUNDRED;
    }

    @Override
    public Value amountInValue(String convertTo) {
        Value value;
        switch (convertTo) {
            case "euro":
                value = new Value(convertToEuro());
                break;
            case "dollar":
                value = new Value(convertToDollar());
                break;
            case "pound":
                value = new Value(convertToPound());
                break;
            default:
                throw new IllegalStateException();
        }
        return value;
    }

}