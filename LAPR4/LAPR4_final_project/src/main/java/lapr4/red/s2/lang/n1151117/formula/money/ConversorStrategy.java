/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s2.lang.n1151117.formula.money;

import csheets.core.Value;

/**
 *
 * @author Barros
 */
public interface ConversorStrategy {

    /**
     * Converts the amount of money to euros
     *
     * @return the amount of money in euros
     */
    public double convertToEuro();

    /**
     * Converts the amount of money to dollars
     *
     * @return the amount of money in dollars
     */
    public double convertToDollar();

    /**
     * Converts the amount of money to pounds
     *
     * @return the amount of money in pounds
     */
    public double convertToPound();

}
