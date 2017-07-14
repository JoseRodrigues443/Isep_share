/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s2.lang.n1140412.multipleMacro;

import csheets.core.formula.lang.Macro;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Tiago
 */
public class Macro_Handler {
    /**
     * Macro
     */
    private Macro macro;
    /**
     * Current MacroMap saved in the workbook
     */
    private Map<String, Macro> macroMap;
    /**
     * Macro_Handle constructor
     * @param macro
     * @param map 
     */
    public Macro_Handler(Macro macro, Map<String, Macro> map) {
        this.macro = macro;
        this.macroMap = map;
    }

    /**
     * Replaces the invocation of a macro with its script
     * ont the current macro
     * @return List 
     */
    public List<String> invocations() {
        List<String> lines = new ArrayList<>();
        List<String> macroScript = this.macro.getScript();

        for (int i = 0; i < macroScript.size(); i++) {
            if (macroMap.containsKey(macroScript.get(i))) {

                Macro macroInvocation = macroMap.get(macroScript.get(i));
                List<String> script = macroInvocation.getScript();

                for (int j = 0; j < script.size(); j++) {
                    lines.add(script.get(j));
                }

            } else {
                lines.add((macroScript.get(i)));
            }
        }
        boolean noMoreInvocations = false;
        while (noMoreInvocations != true) {
            for (int i = 0; i < lines.size(); i++) {
                if (macroMap.containsKey(lines.get(i))) {
                    System.out.println(macroScript.size());
                    
                    Macro macroInvocation = macroMap.get(lines.get(i));
                    List<String> script = macroInvocation.getScript();
                    lines.remove(i);
                    int idx=i;
                    for (int j = 0; j < script.size(); j++) {
                        lines.add(idx,script.get(j));
                        idx++;
                    }
                }
            }
            for (int i = 0; i < lines.size(); i++) {
                if (!macroMap.containsKey(lines.get(i))) {
                    noMoreInvocations = true;
                }
            }
        }

        return lines;
    }
}
