/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s2.lang.n1151117.formula.money;

import csheets.core.Value;

/**
 * Interface to identify types of Money
 *
 * @author Barros
 */
public interface Money {

    /**
     * Returns the amount of money in a Value type object converted to the
     * intended currency
     *
     * @param convertTo the currency to convert
     * @return the value with the amount converted
     */
    public Value amountInValue(String convertTo);
}
