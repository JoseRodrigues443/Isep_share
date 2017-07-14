/*
 * Copyright (c) 2005 Einar Pehrson <einar@pehrson.nu>.
 *
 * This file is part of
 * CleanSheets - a spreadsheet application for the Java platform.
 *
 * CleanSheets is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * CleanSheets is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with CleanSheets; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */
package csheets.core.formula.util;

import csheets.core.Cell;
import java.util.SortedSet;
import java.util.TreeSet;

import csheets.core.formula.Expression;
import csheets.core.formula.Reference;
import lapr4.gray.s1.lang.n3456789.formula.NaryOperation;
import lapr4.red.s2.lang.n1141114.globalVariables.lang.GlobalVariableReferenceSearch;
import lapr4.red.s2.lang.n1141114.temporaryVariables.compiler.lang.TemporaryVariableReferenceSearch;

/**
 * An expression visitor that collects the references from an expression.
 *
 * @author Einar Pehrson
 */
public class ReferenceFetcher extends AbstractExpressionVisitor {

    /**
     * The references that have been fetched
     */
    private SortedSet<Reference> references;

    /* EDITED BY José Barros - 1151117@isep.ipp.pt */
    private Cell delegate = null;

    /**
     * Creates a new reference fetcher.
     */
    public ReferenceFetcher() {
    }

    /* EDITED BY José Barros - 1151117@isep.ipp.pt */
    /**
     * Traverses the given expression and returns the references that were
     * found.
     *
     * @param expression the expression from which to fetch references
     * @return the references that have been fetched
     */
    public SortedSet<Reference> getReferences(Expression expression, Cell cell) {
        references = new TreeSet<Reference>();
        delegate = cell;
        expression.accept(this);
        return references;
    }

    /* EDITED BY José Barros - 1151117@isep.ipp.pt */
    /**
     * Adds the reference to the set.
     *
     * @param reference the reference to visit
     */
    public Object visitReference(Reference reference) {
        if (!reference.getCells().contains(delegate)) {
            references.add(reference);
        }
        return reference;
    }

    @Override
    public Object visitNaryOperation(NaryOperation operation) {
        Expression[] operands = operation.getOperands();

        for (Expression expr : operands) {
            expr.accept(this);
        }
        return operation;
    }

    @Override
    public Object vistiVariableReference(TemporaryVariableReferenceSearch tempVariable) {
        return tempVariable;
    }

    @Override
    public Object visitGlobalVariableReference(GlobalVariableReferenceSearch globalVariable) {
        return globalVariable;
    }
}
