/**
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *
 * <b>Requirement</b><p>
 * Statement:<p>
 * Cleansheets should now support multiple macros.
 * Each macro should have a name and should be associated with an workbook (and also persist with the workbook). 
 * The grammar of the macros should also have a mechanism to support the invocation of macros. 
 * It only should be possible to invoke macros of the same workbook. 
 * Special attention should be devoted to recursion (i.e., avoiding infinite recursion).
 * 
 * <b>Analysis</b><p>
 * <img src="multipleMacro_SSD" alt="image"><p>
 *
 * <b>Design</b><p>
 * <img src="multipleMacro_SD" alt="image"><p>
 * <b>Tests</b><p>
 * 
 * <b>Test1:</b> 
 * Macro cant enter an infinte cycle
 * 
 *
 */
package lapr4.red.s2.lang.n1140412.multipleMacro;
