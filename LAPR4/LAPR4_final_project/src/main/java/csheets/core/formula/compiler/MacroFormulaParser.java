/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.core.formula.compiler;

import org.antlr.runtime.BitSet;
import org.antlr.runtime.IntStream;
import org.antlr.runtime.MismatchedSetException;
import org.antlr.runtime.MismatchedTokenException;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.Parser;
import org.antlr.runtime.ParserRuleReturnScope;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;
import org.antlr.runtime.tree.CommonTreeAdaptor;
import org.antlr.runtime.tree.TreeAdaptor;

/**
 *
 * @author Catarina Sousa 1150767
 */
@SuppressWarnings({"all", "warnings", "unchecked"})
public class MacroFormulaParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ABS", "AMP", "ASSG", "CELL_REF", "COLON", "COMMA", "COMMENT", "DIGIT", "DIV", "EQ", "EXCL", "FUNCTION", "GT", "GTEQ", "LCURL", "LETTER", "LPAR", "LT", "LTEQ", "MINUS", "MULTI", "NEQ", "NUMBER", "PERCENT", "PLUS", "POWER", "QUOT", "RCURL", "RPAR", "SEMI", "STRING", "TEMPVAR", "UNDERSCORE", "WS"
    };

    public static final int EOF=-1;
    public static final int ABS=4;
    public static final int AMP=5;
    public static final int ASSG=6;
    public static final int CELL_REF=7;
    public static final int COLON=8;
    public static final int COMMA=9;
    public static final int COMMENT=10;
    public static final int DIGIT=11;
    public static final int DIV=12;
    public static final int EQ=13;
    public static final int EXCL=14;
    public static final int FUNCTION=15;
    public static final int GT=16;
    public static final int GTEQ=17;
    public static final int LCURL=18;
    public static final int LETTER=19;
    public static final int LPAR=20;
    public static final int LT=21;
    public static final int LTEQ=22;
    public static final int MINUS=23;
    public static final int MULTI=24;
    public static final int NEQ=25;
    public static final int NUMBER=26;
    public static final int PERCENT=27;
    public static final int PLUS=28;
    public static final int POWER=29;
    public static final int QUOT=30;
    public static final int RCURL=31;
    public static final int RPAR=32;
    public static final int SEMI=33;
    public static final int STRING=34;
    public static final int TEMPVAR=35;
    public static final int UNDERSCORE=36;
    public static final int WS=37;

    // delegates
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators

    public MacroFormulaParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public MacroFormulaParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
    }

protected TreeAdaptor adaptor = new CommonTreeAdaptor();

public void setTreeAdaptor(TreeAdaptor adaptor) {
    this.adaptor = adaptor;
}
public TreeAdaptor getTreeAdaptor() {
    return adaptor;
}
    public String[] getTokenNames() { return MacroFormulaParser.tokenNames; }
    public String getGrammarFileName() { return "csheets\\core\\formula\\compiler\\MacroFormula.g"; }


    protected void mismatch(IntStream input, int ttype, BitSet follow)throws RecognitionException{
        throw new MismatchedTokenException(ttype, input);
    }

    public Object recoverFromMismatchedSet(IntStream input, RecognitionException e, BitSet follow)throws RecognitionException {
    	throw e; 
    }
    	
    @Override
    protected Object recoverFromMismatchedToken(IntStream input, int ttype, BitSet follow) throws RecognitionException {
        throw new MismatchedTokenException(ttype, input);
    }


    public static class expression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "expression"
    // csheets\\core\\formula\\compiler\\MacroFormula.g:45:1: expression : ( COMMENT EOF !| ( EQ !)? comparison | ( EQ !)? FUNCTION ^ LCURL ! forexpression RCURL !| ( EQ !)? LCURL ! expressions RCURL !);
    public final MacroFormulaParser.expression_return expression() throws RecognitionException {
        MacroFormulaParser.expression_return retval = new MacroFormulaParser.expression_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token COMMENT1=null;
        Token EOF2=null;
        Token EQ3=null;
        Token EQ5=null;
        Token FUNCTION6=null;
        Token LCURL7=null;
        Token RCURL9=null;
        Token EQ10=null;
        Token LCURL11=null;
        Token RCURL13=null;
        MacroFormulaParser.comparison_return comparison4 =null;

        MacroFormulaParser.forexpression_return forexpression8 =null;

        MacroFormulaParser.expressions_return expressions12 =null;


        Object COMMENT1_tree=null;
        Object EOF2_tree=null;
        Object EQ3_tree=null;
        Object EQ5_tree=null;
        Object FUNCTION6_tree=null;
        Object LCURL7_tree=null;
        Object RCURL9_tree=null;
        Object EQ10_tree=null;
        Object LCURL11_tree=null;
        Object RCURL13_tree=null;

        try {
            // csheets\\core\\formula\\compiler\\MacroFormula.g:46:9: ( COMMENT EOF !| ( EQ !)? comparison | ( EQ !)? FUNCTION ^ LCURL ! forexpression RCURL !| ( EQ !)? LCURL ! expressions RCURL !)
            int alt4=4;
            switch ( input.LA(1) ) {
            case COMMENT:
                {
                alt4=1;
                }
                break;
            case EQ:
                {
                switch ( input.LA(2) ) {
                case CELL_REF:
                case LPAR:
                case MINUS:
                case NUMBER:
                case STRING:
                case TEMPVAR:
                    {
                    alt4=2;
                    }
                    break;
                case FUNCTION:
                    {
                    switch ( input.LA(3) ) {
                    case LPAR:
                        {
                        alt4=2;
                        }
                        break;
                    case LCURL:
                        {
                        alt4=3;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 4, 4, input);

                        throw nvae;

                    }

                    }
                    break;
                case LCURL:
                    {
                    alt4=4;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 2, input);

                    throw nvae;

                }

                }
                break;
            case CELL_REF:
            case LPAR:
            case MINUS:
            case NUMBER:
            case STRING:
            case TEMPVAR:
                {
                alt4=2;
                }
                break;
            case FUNCTION:
                {
                switch ( input.LA(2) ) {
                case LPAR:
                    {
                    alt4=2;
                    }
                    break;
                case LCURL:
                    {
                    alt4=3;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 4, input);

                    throw nvae;

                }

                }
                break;
            case LCURL:
                {
                alt4=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;

            }

            switch (alt4) {
                case 1 :
                    // csheets\\core\\formula\\compiler\\MacroFormula.g:46:10: COMMENT EOF !
                    {
                    root_0 = (Object)adaptor.nil();


                    COMMENT1=(Token)match(input,COMMENT,FOLLOW_COMMENT_in_expression76); 
                    COMMENT1_tree = 
                    (Object)adaptor.create(COMMENT1)
                    ;
                    adaptor.addChild(root_0, COMMENT1_tree);


                    EOF2=(Token)match(input,EOF,FOLLOW_EOF_in_expression78); 

                    }
                    break;
                case 2 :
                    // csheets\\core\\formula\\compiler\\MacroFormula.g:47:10: ( EQ !)? comparison
                    {
                    root_0 = (Object)adaptor.nil();


                    // csheets\\core\\formula\\compiler\\MacroFormula.g:47:10: ( EQ !)?
                    int alt1=2;
                    switch ( input.LA(1) ) {
                        case EQ:
                            {
                            alt1=1;
                            }
                            break;
                    }

                    switch (alt1) {
                        case 1 :
                            // csheets\\core\\formula\\compiler\\MacroFormula.g:47:11: EQ !
                            {
                            EQ3=(Token)match(input,EQ,FOLLOW_EQ_in_expression91); 

                            }
                            break;

                    }


                    pushFollow(FOLLOW_comparison_in_expression96);
                    comparison4=comparison();

                    state._fsp--;

                    adaptor.addChild(root_0, comparison4.getTree());

                    }
                    break;
                case 3 :
                    // csheets\\core\\formula\\compiler\\MacroFormula.g:48:10: ( EQ !)? FUNCTION ^ LCURL ! forexpression RCURL !
                    {
                    root_0 = (Object)adaptor.nil();


                    // csheets\\core\\formula\\compiler\\MacroFormula.g:48:10: ( EQ !)?
                    int alt2=2;
                    switch ( input.LA(1) ) {
                        case EQ:
                            {
                            alt2=1;
                            }
                            break;
                    }

                    switch (alt2) {
                        case 1 :
                            // csheets\\core\\formula\\compiler\\MacroFormula.g:48:11: EQ !
                            {
                            EQ5=(Token)match(input,EQ,FOLLOW_EQ_in_expression108); 

                            }
                            break;

                    }


                    FUNCTION6=(Token)match(input,FUNCTION,FOLLOW_FUNCTION_in_expression113); 
                    FUNCTION6_tree = 
                    (Object)adaptor.create(FUNCTION6)
                    ;
                    root_0 = (Object)adaptor.becomeRoot(FUNCTION6_tree, root_0);


                    LCURL7=(Token)match(input,LCURL,FOLLOW_LCURL_in_expression116); 

                    pushFollow(FOLLOW_forexpression_in_expression119);
                    forexpression8=forexpression();

                    state._fsp--;

                    adaptor.addChild(root_0, forexpression8.getTree());

                    RCURL9=(Token)match(input,RCURL,FOLLOW_RCURL_in_expression121); 

                    }
                    break;
                case 4 :
                    // csheets\\core\\formula\\compiler\\MacroFormula.g:49:10: ( EQ !)? LCURL ! expressions RCURL !
                    {
                    root_0 = (Object)adaptor.nil();


                    // csheets\\core\\formula\\compiler\\MacroFormula.g:49:10: ( EQ !)?
                    int alt3=2;
                    switch ( input.LA(1) ) {
                        case EQ:
                            {
                            alt3=1;
                            }
                            break;
                    }

                    switch (alt3) {
                        case 1 :
                            // csheets\\core\\formula\\compiler\\MacroFormula.g:49:11: EQ !
                            {
                            EQ10=(Token)match(input,EQ,FOLLOW_EQ_in_expression134); 

                            }
                            break;

                    }


                    LCURL11=(Token)match(input,LCURL,FOLLOW_LCURL_in_expression139); 

                    pushFollow(FOLLOW_expressions_in_expression142);
                    expressions12=expressions();

                    state._fsp--;

                    adaptor.addChild(root_0, expressions12.getTree());

                    RCURL13=(Token)match(input,RCURL,FOLLOW_RCURL_in_expression144); 

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        	catch (RecognitionException e) {
        		reportError(e);
        		throw e; 
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "expression"


    public static class expressions_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "expressions"
    // csheets\\core\\formula\\compiler\\MacroFormula.g:52:1: expressions : comparison ( SEMI ^ comparison )* ;
    public final MacroFormulaParser.expressions_return expressions() throws RecognitionException {
        MacroFormulaParser.expressions_return retval = new MacroFormulaParser.expressions_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token SEMI15=null;
        MacroFormulaParser.comparison_return comparison14 =null;

        MacroFormulaParser.comparison_return comparison16 =null;


        Object SEMI15_tree=null;

        try {
            // csheets\\core\\formula\\compiler\\MacroFormula.g:53:9: ( comparison ( SEMI ^ comparison )* )
            // csheets\\core\\formula\\compiler\\MacroFormula.g:53:10: comparison ( SEMI ^ comparison )*
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_comparison_in_expressions169);
            comparison14=comparison();

            state._fsp--;

            adaptor.addChild(root_0, comparison14.getTree());

            // csheets\\core\\formula\\compiler\\MacroFormula.g:53:21: ( SEMI ^ comparison )*
            loop5:
            do {
                int alt5=2;
                switch ( input.LA(1) ) {
                case SEMI:
                    {
                    alt5=1;
                    }
                    break;

                }

                switch (alt5) {
            	case 1 :
            	    // csheets\\core\\formula\\compiler\\MacroFormula.g:53:22: SEMI ^ comparison
            	    {
            	    SEMI15=(Token)match(input,SEMI,FOLLOW_SEMI_in_expressions172); 
            	    SEMI15_tree = 
            	    (Object)adaptor.create(SEMI15)
            	    ;
            	    root_0 = (Object)adaptor.becomeRoot(SEMI15_tree, root_0);


            	    pushFollow(FOLLOW_comparison_in_expressions175);
            	    comparison16=comparison();

            	    state._fsp--;

            	    adaptor.addChild(root_0, comparison16.getTree());

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        	catch (RecognitionException e) {
        		reportError(e);
        		throw e; 
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "expressions"


    public static class forexpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "forexpression"
    // csheets\\core\\formula\\compiler\\MacroFormula.g:56:1: forexpression : comparison ( SEMI ! comparison )* ;
    public final MacroFormulaParser.forexpression_return forexpression() throws RecognitionException {
        MacroFormulaParser.forexpression_return retval = new MacroFormulaParser.forexpression_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token SEMI18=null;
        MacroFormulaParser.comparison_return comparison17 =null;

        MacroFormulaParser.comparison_return comparison19 =null;


        Object SEMI18_tree=null;

        try {
            // csheets\\core\\formula\\compiler\\MacroFormula.g:57:9: ( comparison ( SEMI ! comparison )* )
            // csheets\\core\\formula\\compiler\\MacroFormula.g:57:10: comparison ( SEMI ! comparison )*
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_comparison_in_forexpression205);
            comparison17=comparison();

            state._fsp--;

            adaptor.addChild(root_0, comparison17.getTree());

            // csheets\\core\\formula\\compiler\\MacroFormula.g:57:21: ( SEMI ! comparison )*
            loop6:
            do {
                int alt6=2;
                switch ( input.LA(1) ) {
                case SEMI:
                    {
                    alt6=1;
                    }
                    break;

                }

                switch (alt6) {
            	case 1 :
            	    // csheets\\core\\formula\\compiler\\MacroFormula.g:57:22: SEMI ! comparison
            	    {
            	    SEMI18=(Token)match(input,SEMI,FOLLOW_SEMI_in_forexpression208); 

            	    pushFollow(FOLLOW_comparison_in_forexpression211);
            	    comparison19=comparison();

            	    state._fsp--;

            	    adaptor.addChild(root_0, comparison19.getTree());

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        	catch (RecognitionException e) {
        		reportError(e);
        		throw e; 
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "forexpression"


    public static class comparison_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "comparison"
    // csheets\\core\\formula\\compiler\\MacroFormula.g:60:1: comparison : concatenation ( ( EQ ^| NEQ ^| GT ^| LT ^| LTEQ ^| GTEQ ^| ASSG ^) concatenation )? ;
    public final MacroFormulaParser.comparison_return comparison() throws RecognitionException {
        MacroFormulaParser.comparison_return retval = new MacroFormulaParser.comparison_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token EQ21=null;
        Token NEQ22=null;
        Token GT23=null;
        Token LT24=null;
        Token LTEQ25=null;
        Token GTEQ26=null;
        Token ASSG27=null;
        MacroFormulaParser.concatenation_return concatenation20 =null;

        MacroFormulaParser.concatenation_return concatenation28 =null;


        Object EQ21_tree=null;
        Object NEQ22_tree=null;
        Object GT23_tree=null;
        Object LT24_tree=null;
        Object LTEQ25_tree=null;
        Object GTEQ26_tree=null;
        Object ASSG27_tree=null;

        try {
            // csheets\\core\\formula\\compiler\\MacroFormula.g:61:2: ( concatenation ( ( EQ ^| NEQ ^| GT ^| LT ^| LTEQ ^| GTEQ ^| ASSG ^) concatenation )? )
            // csheets\\core\\formula\\compiler\\MacroFormula.g:61:4: concatenation ( ( EQ ^| NEQ ^| GT ^| LT ^| LTEQ ^| GTEQ ^| ASSG ^) concatenation )?
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_concatenation_in_comparison241);
            concatenation20=concatenation();

            state._fsp--;

            adaptor.addChild(root_0, concatenation20.getTree());

            // csheets\\core\\formula\\compiler\\MacroFormula.g:62:3: ( ( EQ ^| NEQ ^| GT ^| LT ^| LTEQ ^| GTEQ ^| ASSG ^) concatenation )?
            int alt8=2;
            switch ( input.LA(1) ) {
                case ASSG:
                case EQ:
                case GT:
                case GTEQ:
                case LT:
                case LTEQ:
                case NEQ:
                    {
                    alt8=1;
                    }
                    break;
            }

            switch (alt8) {
                case 1 :
                    // csheets\\core\\formula\\compiler\\MacroFormula.g:62:5: ( EQ ^| NEQ ^| GT ^| LT ^| LTEQ ^| GTEQ ^| ASSG ^) concatenation
                    {
                    // csheets\\core\\formula\\compiler\\MacroFormula.g:62:5: ( EQ ^| NEQ ^| GT ^| LT ^| LTEQ ^| GTEQ ^| ASSG ^)
                    int alt7=7;
                    switch ( input.LA(1) ) {
                    case EQ:
                        {
                        alt7=1;
                        }
                        break;
                    case NEQ:
                        {
                        alt7=2;
                        }
                        break;
                    case GT:
                        {
                        alt7=3;
                        }
                        break;
                    case LT:
                        {
                        alt7=4;
                        }
                        break;
                    case LTEQ:
                        {
                        alt7=5;
                        }
                        break;
                    case GTEQ:
                        {
                        alt7=6;
                        }
                        break;
                    case ASSG:
                        {
                        alt7=7;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 7, 0, input);

                        throw nvae;

                    }

                    switch (alt7) {
                        case 1 :
                            // csheets\\core\\formula\\compiler\\MacroFormula.g:62:7: EQ ^
                            {
                            EQ21=(Token)match(input,EQ,FOLLOW_EQ_in_comparison249); 
                            EQ21_tree = 
                            (Object)adaptor.create(EQ21)
                            ;
                            root_0 = (Object)adaptor.becomeRoot(EQ21_tree, root_0);


                            }
                            break;
                        case 2 :
                            // csheets\\core\\formula\\compiler\\MacroFormula.g:62:13: NEQ ^
                            {
                            NEQ22=(Token)match(input,NEQ,FOLLOW_NEQ_in_comparison254); 
                            NEQ22_tree = 
                            (Object)adaptor.create(NEQ22)
                            ;
                            root_0 = (Object)adaptor.becomeRoot(NEQ22_tree, root_0);


                            }
                            break;
                        case 3 :
                            // csheets\\core\\formula\\compiler\\MacroFormula.g:62:20: GT ^
                            {
                            GT23=(Token)match(input,GT,FOLLOW_GT_in_comparison259); 
                            GT23_tree = 
                            (Object)adaptor.create(GT23)
                            ;
                            root_0 = (Object)adaptor.becomeRoot(GT23_tree, root_0);


                            }
                            break;
                        case 4 :
                            // csheets\\core\\formula\\compiler\\MacroFormula.g:62:26: LT ^
                            {
                            LT24=(Token)match(input,LT,FOLLOW_LT_in_comparison264); 
                            LT24_tree = 
                            (Object)adaptor.create(LT24)
                            ;
                            root_0 = (Object)adaptor.becomeRoot(LT24_tree, root_0);


                            }
                            break;
                        case 5 :
                            // csheets\\core\\formula\\compiler\\MacroFormula.g:62:32: LTEQ ^
                            {
                            LTEQ25=(Token)match(input,LTEQ,FOLLOW_LTEQ_in_comparison269); 
                            LTEQ25_tree = 
                            (Object)adaptor.create(LTEQ25)
                            ;
                            root_0 = (Object)adaptor.becomeRoot(LTEQ25_tree, root_0);


                            }
                            break;
                        case 6 :
                            // csheets\\core\\formula\\compiler\\MacroFormula.g:62:40: GTEQ ^
                            {
                            GTEQ26=(Token)match(input,GTEQ,FOLLOW_GTEQ_in_comparison274); 
                            GTEQ26_tree = 
                            (Object)adaptor.create(GTEQ26)
                            ;
                            root_0 = (Object)adaptor.becomeRoot(GTEQ26_tree, root_0);


                            }
                            break;
                        case 7 :
                            // csheets\\core\\formula\\compiler\\MacroFormula.g:62:48: ASSG ^
                            {
                            ASSG27=(Token)match(input,ASSG,FOLLOW_ASSG_in_comparison279); 
                            ASSG27_tree = 
                            (Object)adaptor.create(ASSG27)
                            ;
                            root_0 = (Object)adaptor.becomeRoot(ASSG27_tree, root_0);


                            }
                            break;

                    }


                    pushFollow(FOLLOW_concatenation_in_comparison284);
                    concatenation28=concatenation();

                    state._fsp--;

                    adaptor.addChild(root_0, concatenation28.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        	catch (RecognitionException e) {
        		reportError(e);
        		throw e; 
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "comparison"


    public static class concatenation_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "concatenation"
    // csheets\\core\\formula\\compiler\\MacroFormula.g:65:1: concatenation : arithmetic_lowest ( AMP ^ arithmetic_lowest )* ;
    public final MacroFormulaParser.concatenation_return concatenation() throws RecognitionException {
        MacroFormulaParser.concatenation_return retval = new MacroFormulaParser.concatenation_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token AMP30=null;
        MacroFormulaParser.arithmetic_lowest_return arithmetic_lowest29 =null;

        MacroFormulaParser.arithmetic_lowest_return arithmetic_lowest31 =null;


        Object AMP30_tree=null;

        try {
            // csheets\\core\\formula\\compiler\\MacroFormula.g:66:2: ( arithmetic_lowest ( AMP ^ arithmetic_lowest )* )
            // csheets\\core\\formula\\compiler\\MacroFormula.g:66:4: arithmetic_lowest ( AMP ^ arithmetic_lowest )*
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_arithmetic_lowest_in_concatenation299);
            arithmetic_lowest29=arithmetic_lowest();

            state._fsp--;

            adaptor.addChild(root_0, arithmetic_lowest29.getTree());

            // csheets\\core\\formula\\compiler\\MacroFormula.g:67:3: ( AMP ^ arithmetic_lowest )*
            loop9:
            do {
                int alt9=2;
                switch ( input.LA(1) ) {
                case AMP:
                    {
                    alt9=1;
                    }
                    break;

                }

                switch (alt9) {
            	case 1 :
            	    // csheets\\core\\formula\\compiler\\MacroFormula.g:67:5: AMP ^ arithmetic_lowest
            	    {
            	    AMP30=(Token)match(input,AMP,FOLLOW_AMP_in_concatenation305); 
            	    AMP30_tree = 
            	    (Object)adaptor.create(AMP30)
            	    ;
            	    root_0 = (Object)adaptor.becomeRoot(AMP30_tree, root_0);


            	    pushFollow(FOLLOW_arithmetic_lowest_in_concatenation308);
            	    arithmetic_lowest31=arithmetic_lowest();

            	    state._fsp--;

            	    adaptor.addChild(root_0, arithmetic_lowest31.getTree());

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        	catch (RecognitionException e) {
        		reportError(e);
        		throw e; 
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "concatenation"


    public static class arithmetic_lowest_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "arithmetic_lowest"
    // csheets\\core\\formula\\compiler\\MacroFormula.g:70:1: arithmetic_lowest : arithmetic_low ( ( PLUS ^| MINUS ^) arithmetic_low )* ;
    public final MacroFormulaParser.arithmetic_lowest_return arithmetic_lowest() throws RecognitionException {
        MacroFormulaParser.arithmetic_lowest_return retval = new MacroFormulaParser.arithmetic_lowest_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token PLUS33=null;
        Token MINUS34=null;
        MacroFormulaParser.arithmetic_low_return arithmetic_low32 =null;

        MacroFormulaParser.arithmetic_low_return arithmetic_low35 =null;


        Object PLUS33_tree=null;
        Object MINUS34_tree=null;

        try {
            // csheets\\core\\formula\\compiler\\MacroFormula.g:71:2: ( arithmetic_low ( ( PLUS ^| MINUS ^) arithmetic_low )* )
            // csheets\\core\\formula\\compiler\\MacroFormula.g:71:4: arithmetic_low ( ( PLUS ^| MINUS ^) arithmetic_low )*
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_arithmetic_low_in_arithmetic_lowest322);
            arithmetic_low32=arithmetic_low();

            state._fsp--;

            adaptor.addChild(root_0, arithmetic_low32.getTree());

            // csheets\\core\\formula\\compiler\\MacroFormula.g:72:3: ( ( PLUS ^| MINUS ^) arithmetic_low )*
            loop11:
            do {
                int alt11=2;
                switch ( input.LA(1) ) {
                case MINUS:
                case PLUS:
                    {
                    alt11=1;
                    }
                    break;

                }

                switch (alt11) {
            	case 1 :
            	    // csheets\\core\\formula\\compiler\\MacroFormula.g:72:5: ( PLUS ^| MINUS ^) arithmetic_low
            	    {
            	    // csheets\\core\\formula\\compiler\\MacroFormula.g:72:5: ( PLUS ^| MINUS ^)
            	    int alt10=2;
            	    switch ( input.LA(1) ) {
            	    case PLUS:
            	        {
            	        alt10=1;
            	        }
            	        break;
            	    case MINUS:
            	        {
            	        alt10=2;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 10, 0, input);

            	        throw nvae;

            	    }

            	    switch (alt10) {
            	        case 1 :
            	            // csheets\\core\\formula\\compiler\\MacroFormula.g:72:7: PLUS ^
            	            {
            	            PLUS33=(Token)match(input,PLUS,FOLLOW_PLUS_in_arithmetic_lowest330); 
            	            PLUS33_tree = 
            	            (Object)adaptor.create(PLUS33)
            	            ;
            	            root_0 = (Object)adaptor.becomeRoot(PLUS33_tree, root_0);


            	            }
            	            break;
            	        case 2 :
            	            // csheets\\core\\formula\\compiler\\MacroFormula.g:72:15: MINUS ^
            	            {
            	            MINUS34=(Token)match(input,MINUS,FOLLOW_MINUS_in_arithmetic_lowest335); 
            	            MINUS34_tree = 
            	            (Object)adaptor.create(MINUS34)
            	            ;
            	            root_0 = (Object)adaptor.becomeRoot(MINUS34_tree, root_0);


            	            }
            	            break;

            	    }


            	    pushFollow(FOLLOW_arithmetic_low_in_arithmetic_lowest340);
            	    arithmetic_low35=arithmetic_low();

            	    state._fsp--;

            	    adaptor.addChild(root_0, arithmetic_low35.getTree());

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        	catch (RecognitionException e) {
        		reportError(e);
        		throw e; 
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "arithmetic_lowest"


    public static class arithmetic_low_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "arithmetic_low"
    // csheets\\core\\formula\\compiler\\MacroFormula.g:75:1: arithmetic_low : arithmetic_medium ( ( MULTI ^| DIV ^) arithmetic_medium )* ;
    public final MacroFormulaParser.arithmetic_low_return arithmetic_low() throws RecognitionException {
        MacroFormulaParser.arithmetic_low_return retval = new MacroFormulaParser.arithmetic_low_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token MULTI37=null;
        Token DIV38=null;
        MacroFormulaParser.arithmetic_medium_return arithmetic_medium36 =null;

        MacroFormulaParser.arithmetic_medium_return arithmetic_medium39 =null;


        Object MULTI37_tree=null;
        Object DIV38_tree=null;

        try {
            // csheets\\core\\formula\\compiler\\MacroFormula.g:76:2: ( arithmetic_medium ( ( MULTI ^| DIV ^) arithmetic_medium )* )
            // csheets\\core\\formula\\compiler\\MacroFormula.g:76:4: arithmetic_medium ( ( MULTI ^| DIV ^) arithmetic_medium )*
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_arithmetic_medium_in_arithmetic_low354);
            arithmetic_medium36=arithmetic_medium();

            state._fsp--;

            adaptor.addChild(root_0, arithmetic_medium36.getTree());

            // csheets\\core\\formula\\compiler\\MacroFormula.g:77:3: ( ( MULTI ^| DIV ^) arithmetic_medium )*
            loop13:
            do {
                int alt13=2;
                switch ( input.LA(1) ) {
                case DIV:
                case MULTI:
                    {
                    alt13=1;
                    }
                    break;

                }

                switch (alt13) {
            	case 1 :
            	    // csheets\\core\\formula\\compiler\\MacroFormula.g:77:5: ( MULTI ^| DIV ^) arithmetic_medium
            	    {
            	    // csheets\\core\\formula\\compiler\\MacroFormula.g:77:5: ( MULTI ^| DIV ^)
            	    int alt12=2;
            	    switch ( input.LA(1) ) {
            	    case MULTI:
            	        {
            	        alt12=1;
            	        }
            	        break;
            	    case DIV:
            	        {
            	        alt12=2;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 12, 0, input);

            	        throw nvae;

            	    }

            	    switch (alt12) {
            	        case 1 :
            	            // csheets\\core\\formula\\compiler\\MacroFormula.g:77:7: MULTI ^
            	            {
            	            MULTI37=(Token)match(input,MULTI,FOLLOW_MULTI_in_arithmetic_low362); 
            	            MULTI37_tree = 
            	            (Object)adaptor.create(MULTI37)
            	            ;
            	            root_0 = (Object)adaptor.becomeRoot(MULTI37_tree, root_0);


            	            }
            	            break;
            	        case 2 :
            	            // csheets\\core\\formula\\compiler\\MacroFormula.g:77:16: DIV ^
            	            {
            	            DIV38=(Token)match(input,DIV,FOLLOW_DIV_in_arithmetic_low367); 
            	            DIV38_tree = 
            	            (Object)adaptor.create(DIV38)
            	            ;
            	            root_0 = (Object)adaptor.becomeRoot(DIV38_tree, root_0);


            	            }
            	            break;

            	    }


            	    pushFollow(FOLLOW_arithmetic_medium_in_arithmetic_low372);
            	    arithmetic_medium39=arithmetic_medium();

            	    state._fsp--;

            	    adaptor.addChild(root_0, arithmetic_medium39.getTree());

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        	catch (RecognitionException e) {
        		reportError(e);
        		throw e; 
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "arithmetic_low"


    public static class arithmetic_medium_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "arithmetic_medium"
    // csheets\\core\\formula\\compiler\\MacroFormula.g:80:1: arithmetic_medium : arithmetic_high ( POWER ^ arithmetic_high )? ;
    public final MacroFormulaParser.arithmetic_medium_return arithmetic_medium() throws RecognitionException {
        MacroFormulaParser.arithmetic_medium_return retval = new MacroFormulaParser.arithmetic_medium_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token POWER41=null;
        MacroFormulaParser.arithmetic_high_return arithmetic_high40 =null;

        MacroFormulaParser.arithmetic_high_return arithmetic_high42 =null;


        Object POWER41_tree=null;

        try {
            // csheets\\core\\formula\\compiler\\MacroFormula.g:81:2: ( arithmetic_high ( POWER ^ arithmetic_high )? )
            // csheets\\core\\formula\\compiler\\MacroFormula.g:81:4: arithmetic_high ( POWER ^ arithmetic_high )?
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_arithmetic_high_in_arithmetic_medium386);
            arithmetic_high40=arithmetic_high();

            state._fsp--;

            adaptor.addChild(root_0, arithmetic_high40.getTree());

            // csheets\\core\\formula\\compiler\\MacroFormula.g:82:3: ( POWER ^ arithmetic_high )?
            int alt14=2;
            switch ( input.LA(1) ) {
                case POWER:
                    {
                    alt14=1;
                    }
                    break;
            }

            switch (alt14) {
                case 1 :
                    // csheets\\core\\formula\\compiler\\MacroFormula.g:82:5: POWER ^ arithmetic_high
                    {
                    POWER41=(Token)match(input,POWER,FOLLOW_POWER_in_arithmetic_medium392); 
                    POWER41_tree = 
                    (Object)adaptor.create(POWER41)
                    ;
                    root_0 = (Object)adaptor.becomeRoot(POWER41_tree, root_0);


                    pushFollow(FOLLOW_arithmetic_high_in_arithmetic_medium395);
                    arithmetic_high42=arithmetic_high();

                    state._fsp--;

                    adaptor.addChild(root_0, arithmetic_high42.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        	catch (RecognitionException e) {
        		reportError(e);
        		throw e; 
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "arithmetic_medium"


    public static class arithmetic_high_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "arithmetic_high"
    // csheets\\core\\formula\\compiler\\MacroFormula.g:85:1: arithmetic_high : arithmetic_highest ( PERCENT ^)? ;
    public final MacroFormulaParser.arithmetic_high_return arithmetic_high() throws RecognitionException {
        MacroFormulaParser.arithmetic_high_return retval = new MacroFormulaParser.arithmetic_high_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token PERCENT44=null;
        MacroFormulaParser.arithmetic_highest_return arithmetic_highest43 =null;


        Object PERCENT44_tree=null;

        try {
            // csheets\\core\\formula\\compiler\\MacroFormula.g:86:2: ( arithmetic_highest ( PERCENT ^)? )
            // csheets\\core\\formula\\compiler\\MacroFormula.g:86:4: arithmetic_highest ( PERCENT ^)?
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_arithmetic_highest_in_arithmetic_high409);
            arithmetic_highest43=arithmetic_highest();

            state._fsp--;

            adaptor.addChild(root_0, arithmetic_highest43.getTree());

            // csheets\\core\\formula\\compiler\\MacroFormula.g:86:23: ( PERCENT ^)?
            int alt15=2;
            switch ( input.LA(1) ) {
                case PERCENT:
                    {
                    alt15=1;
                    }
                    break;
            }

            switch (alt15) {
                case 1 :
                    // csheets\\core\\formula\\compiler\\MacroFormula.g:86:25: PERCENT ^
                    {
                    PERCENT44=(Token)match(input,PERCENT,FOLLOW_PERCENT_in_arithmetic_high413); 
                    PERCENT44_tree = 
                    (Object)adaptor.create(PERCENT44)
                    ;
                    root_0 = (Object)adaptor.becomeRoot(PERCENT44_tree, root_0);


                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        	catch (RecognitionException e) {
        		reportError(e);
        		throw e; 
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "arithmetic_high"


    public static class arithmetic_highest_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "arithmetic_highest"
    // csheets\\core\\formula\\compiler\\MacroFormula.g:89:1: arithmetic_highest : ( MINUS ^)? atom ;
    public final MacroFormulaParser.arithmetic_highest_return arithmetic_highest() throws RecognitionException {
        MacroFormulaParser.arithmetic_highest_return retval = new MacroFormulaParser.arithmetic_highest_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token MINUS45=null;
        MacroFormulaParser.atom_return atom46 =null;


        Object MINUS45_tree=null;

        try {
            // csheets\\core\\formula\\compiler\\MacroFormula.g:90:2: ( ( MINUS ^)? atom )
            // csheets\\core\\formula\\compiler\\MacroFormula.g:90:4: ( MINUS ^)? atom
            {
            root_0 = (Object)adaptor.nil();


            // csheets\\core\\formula\\compiler\\MacroFormula.g:90:4: ( MINUS ^)?
            int alt16=2;
            switch ( input.LA(1) ) {
                case MINUS:
                    {
                    alt16=1;
                    }
                    break;
            }

            switch (alt16) {
                case 1 :
                    // csheets\\core\\formula\\compiler\\MacroFormula.g:90:6: MINUS ^
                    {
                    MINUS45=(Token)match(input,MINUS,FOLLOW_MINUS_in_arithmetic_highest430); 
                    MINUS45_tree = 
                    (Object)adaptor.create(MINUS45)
                    ;
                    root_0 = (Object)adaptor.becomeRoot(MINUS45_tree, root_0);


                    }
                    break;

            }


            pushFollow(FOLLOW_atom_in_arithmetic_highest436);
            atom46=atom();

            state._fsp--;

            adaptor.addChild(root_0, atom46.getTree());

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        	catch (RecognitionException e) {
        		reportError(e);
        		throw e; 
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "arithmetic_highest"


    public static class atom_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "atom"
    // csheets\\core\\formula\\compiler\\MacroFormula.g:93:1: atom : ( function_call | reference | literal | TEMPVAR | LPAR ! comparison RPAR !);
    public final MacroFormulaParser.atom_return atom() throws RecognitionException {
        MacroFormulaParser.atom_return retval = new MacroFormulaParser.atom_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token TEMPVAR50=null;
        Token LPAR51=null;
        Token RPAR53=null;
        MacroFormulaParser.function_call_return function_call47 =null;

        MacroFormulaParser.reference_return reference48 =null;

        MacroFormulaParser.literal_return literal49 =null;

        MacroFormulaParser.comparison_return comparison52 =null;


        Object TEMPVAR50_tree=null;
        Object LPAR51_tree=null;
        Object RPAR53_tree=null;

        try {
            // csheets\\core\\formula\\compiler\\MacroFormula.g:94:2: ( function_call | reference | literal | TEMPVAR | LPAR ! comparison RPAR !)
            int alt17=5;
            switch ( input.LA(1) ) {
            case FUNCTION:
                {
                alt17=1;
                }
                break;
            case CELL_REF:
                {
                alt17=2;
                }
                break;
            case NUMBER:
            case STRING:
                {
                alt17=3;
                }
                break;
            case TEMPVAR:
                {
                alt17=4;
                }
                break;
            case LPAR:
                {
                alt17=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;

            }

            switch (alt17) {
                case 1 :
                    // csheets\\core\\formula\\compiler\\MacroFormula.g:94:4: function_call
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_function_call_in_atom447);
                    function_call47=function_call();

                    state._fsp--;

                    adaptor.addChild(root_0, function_call47.getTree());

                    }
                    break;
                case 2 :
                    // csheets\\core\\formula\\compiler\\MacroFormula.g:95:4: reference
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_reference_in_atom452);
                    reference48=reference();

                    state._fsp--;

                    adaptor.addChild(root_0, reference48.getTree());

                    }
                    break;
                case 3 :
                    // csheets\\core\\formula\\compiler\\MacroFormula.g:96:4: literal
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_literal_in_atom457);
                    literal49=literal();

                    state._fsp--;

                    adaptor.addChild(root_0, literal49.getTree());

                    }
                    break;
                case 4 :
                    // csheets\\core\\formula\\compiler\\MacroFormula.g:97:17: TEMPVAR
                    {
                    root_0 = (Object)adaptor.nil();


                    TEMPVAR50=(Token)match(input,TEMPVAR,FOLLOW_TEMPVAR_in_atom475); 
                    TEMPVAR50_tree = 
                    (Object)adaptor.create(TEMPVAR50)
                    ;
                    adaptor.addChild(root_0, TEMPVAR50_tree);


                    }
                    break;
                case 5 :
                    // csheets\\core\\formula\\compiler\\MacroFormula.g:98:4: LPAR ! comparison RPAR !
                    {
                    root_0 = (Object)adaptor.nil();


                    LPAR51=(Token)match(input,LPAR,FOLLOW_LPAR_in_atom480); 

                    pushFollow(FOLLOW_comparison_in_atom483);
                    comparison52=comparison();

                    state._fsp--;

                    adaptor.addChild(root_0, comparison52.getTree());

                    RPAR53=(Token)match(input,RPAR,FOLLOW_RPAR_in_atom485); 

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        	catch (RecognitionException e) {
        		reportError(e);
        		throw e; 
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "atom"


    public static class function_call_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "function_call"
    // csheets\\core\\formula\\compiler\\MacroFormula.g:101:1: function_call : FUNCTION ^ LPAR ! ( comparison ( SEMI ! comparison )* )? RPAR !;
    public final MacroFormulaParser.function_call_return function_call() throws RecognitionException {
        MacroFormulaParser.function_call_return retval = new MacroFormulaParser.function_call_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token FUNCTION54=null;
        Token LPAR55=null;
        Token SEMI57=null;
        Token RPAR59=null;
        MacroFormulaParser.comparison_return comparison56 =null;

        MacroFormulaParser.comparison_return comparison58 =null;


        Object FUNCTION54_tree=null;
        Object LPAR55_tree=null;
        Object SEMI57_tree=null;
        Object RPAR59_tree=null;

        try {
            // csheets\\core\\formula\\compiler\\MacroFormula.g:102:2: ( FUNCTION ^ LPAR ! ( comparison ( SEMI ! comparison )* )? RPAR !)
            // csheets\\core\\formula\\compiler\\MacroFormula.g:102:4: FUNCTION ^ LPAR ! ( comparison ( SEMI ! comparison )* )? RPAR !
            {
            root_0 = (Object)adaptor.nil();


            FUNCTION54=(Token)match(input,FUNCTION,FOLLOW_FUNCTION_in_function_call497); 
            FUNCTION54_tree = 
            (Object)adaptor.create(FUNCTION54)
            ;
            root_0 = (Object)adaptor.becomeRoot(FUNCTION54_tree, root_0);


            LPAR55=(Token)match(input,LPAR,FOLLOW_LPAR_in_function_call500); 

            // csheets\\core\\formula\\compiler\\MacroFormula.g:103:3: ( comparison ( SEMI ! comparison )* )?
            int alt19=2;
            switch ( input.LA(1) ) {
                case CELL_REF:
                case FUNCTION:
                case LPAR:
                case MINUS:
                case NUMBER:
                case STRING:
                case TEMPVAR:
                    {
                    alt19=1;
                    }
                    break;
            }

            switch (alt19) {
                case 1 :
                    // csheets\\core\\formula\\compiler\\MacroFormula.g:103:5: comparison ( SEMI ! comparison )*
                    {
                    pushFollow(FOLLOW_comparison_in_function_call508);
                    comparison56=comparison();

                    state._fsp--;

                    adaptor.addChild(root_0, comparison56.getTree());

                    // csheets\\core\\formula\\compiler\\MacroFormula.g:103:16: ( SEMI ! comparison )*
                    loop18:
                    do {
                        int alt18=2;
                        switch ( input.LA(1) ) {
                        case SEMI:
                            {
                            alt18=1;
                            }
                            break;

                        }

                        switch (alt18) {
                    	case 1 :
                    	    // csheets\\core\\formula\\compiler\\MacroFormula.g:103:18: SEMI ! comparison
                    	    {
                    	    SEMI57=(Token)match(input,SEMI,FOLLOW_SEMI_in_function_call512); 

                    	    pushFollow(FOLLOW_comparison_in_function_call515);
                    	    comparison58=comparison();

                    	    state._fsp--;

                    	    adaptor.addChild(root_0, comparison58.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop18;
                        }
                    } while (true);


                    }
                    break;

            }


            RPAR59=(Token)match(input,RPAR,FOLLOW_RPAR_in_function_call525); 

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        	catch (RecognitionException e) {
        		reportError(e);
        		throw e; 
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "function_call"


    public static class reference_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "reference"
    // csheets\\core\\formula\\compiler\\MacroFormula.g:107:1: reference : CELL_REF ( ( COLON ^) CELL_REF )? ;
    public final MacroFormulaParser.reference_return reference() throws RecognitionException {
        MacroFormulaParser.reference_return retval = new MacroFormulaParser.reference_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token CELL_REF60=null;
        Token COLON61=null;
        Token CELL_REF62=null;

        Object CELL_REF60_tree=null;
        Object COLON61_tree=null;
        Object CELL_REF62_tree=null;

        try {
            // csheets\\core\\formula\\compiler\\MacroFormula.g:108:2: ( CELL_REF ( ( COLON ^) CELL_REF )? )
            // csheets\\core\\formula\\compiler\\MacroFormula.g:108:4: CELL_REF ( ( COLON ^) CELL_REF )?
            {
            root_0 = (Object)adaptor.nil();


            CELL_REF60=(Token)match(input,CELL_REF,FOLLOW_CELL_REF_in_reference537); 
            CELL_REF60_tree = 
            (Object)adaptor.create(CELL_REF60)
            ;
            adaptor.addChild(root_0, CELL_REF60_tree);


            // csheets\\core\\formula\\compiler\\MacroFormula.g:109:3: ( ( COLON ^) CELL_REF )?
            int alt20=2;
            switch ( input.LA(1) ) {
                case COLON:
                    {
                    alt20=1;
                    }
                    break;
            }

            switch (alt20) {
                case 1 :
                    // csheets\\core\\formula\\compiler\\MacroFormula.g:109:5: ( COLON ^) CELL_REF
                    {
                    // csheets\\core\\formula\\compiler\\MacroFormula.g:109:5: ( COLON ^)
                    // csheets\\core\\formula\\compiler\\MacroFormula.g:109:7: COLON ^
                    {
                    COLON61=(Token)match(input,COLON,FOLLOW_COLON_in_reference545); 
                    COLON61_tree = 
                    (Object)adaptor.create(COLON61)
                    ;
                    root_0 = (Object)adaptor.becomeRoot(COLON61_tree, root_0);


                    }


                    CELL_REF62=(Token)match(input,CELL_REF,FOLLOW_CELL_REF_in_reference550); 
                    CELL_REF62_tree = 
                    (Object)adaptor.create(CELL_REF62)
                    ;
                    adaptor.addChild(root_0, CELL_REF62_tree);


                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        	catch (RecognitionException e) {
        		reportError(e);
        		throw e; 
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "reference"


    public static class literal_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "literal"
    // csheets\\core\\formula\\compiler\\MacroFormula.g:112:1: literal : ( NUMBER | STRING );
    public final MacroFormulaParser.literal_return literal() throws RecognitionException {
        MacroFormulaParser.literal_return retval = new MacroFormulaParser.literal_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token set63=null;

        Object set63_tree=null;

        try {
            // csheets\\core\\formula\\compiler\\MacroFormula.g:113:2: ( NUMBER | STRING )
            // csheets\\core\\formula\\compiler\\MacroFormula.g:
            {
            root_0 = (Object)adaptor.nil();


            set63=(Token)input.LT(1);

            if ( input.LA(1)==NUMBER||input.LA(1)==STRING ) {
                input.consume();
                adaptor.addChild(root_0, 
                (Object)adaptor.create(set63)
                );
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        	catch (RecognitionException e) {
        		reportError(e);
        		throw e; 
        	}

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "literal"

    // Delegated rules


 

    public static final BitSet FOLLOW_COMMENT_in_expression76 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_expression78 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EQ_in_expression91 = new BitSet(new long[]{0x0000000C04908080L});
    public static final BitSet FOLLOW_comparison_in_expression96 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EQ_in_expression108 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_FUNCTION_in_expression113 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_LCURL_in_expression116 = new BitSet(new long[]{0x0000000C04908080L});
    public static final BitSet FOLLOW_forexpression_in_expression119 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_RCURL_in_expression121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EQ_in_expression134 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_LCURL_in_expression139 = new BitSet(new long[]{0x0000000C04908080L});
    public static final BitSet FOLLOW_expressions_in_expression142 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_RCURL_in_expression144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_comparison_in_expressions169 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_SEMI_in_expressions172 = new BitSet(new long[]{0x0000000C04908080L});
    public static final BitSet FOLLOW_comparison_in_expressions175 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_comparison_in_forexpression205 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_SEMI_in_forexpression208 = new BitSet(new long[]{0x0000000C04908080L});
    public static final BitSet FOLLOW_comparison_in_forexpression211 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_concatenation_in_comparison241 = new BitSet(new long[]{0x0000000002632042L});
    public static final BitSet FOLLOW_EQ_in_comparison249 = new BitSet(new long[]{0x0000000C04908080L});
    public static final BitSet FOLLOW_NEQ_in_comparison254 = new BitSet(new long[]{0x0000000C04908080L});
    public static final BitSet FOLLOW_GT_in_comparison259 = new BitSet(new long[]{0x0000000C04908080L});
    public static final BitSet FOLLOW_LT_in_comparison264 = new BitSet(new long[]{0x0000000C04908080L});
    public static final BitSet FOLLOW_LTEQ_in_comparison269 = new BitSet(new long[]{0x0000000C04908080L});
    public static final BitSet FOLLOW_GTEQ_in_comparison274 = new BitSet(new long[]{0x0000000C04908080L});
    public static final BitSet FOLLOW_ASSG_in_comparison279 = new BitSet(new long[]{0x0000000C04908080L});
    public static final BitSet FOLLOW_concatenation_in_comparison284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_arithmetic_lowest_in_concatenation299 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_AMP_in_concatenation305 = new BitSet(new long[]{0x0000000C04908080L});
    public static final BitSet FOLLOW_arithmetic_lowest_in_concatenation308 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_arithmetic_low_in_arithmetic_lowest322 = new BitSet(new long[]{0x0000000010800002L});
    public static final BitSet FOLLOW_PLUS_in_arithmetic_lowest330 = new BitSet(new long[]{0x0000000C04908080L});
    public static final BitSet FOLLOW_MINUS_in_arithmetic_lowest335 = new BitSet(new long[]{0x0000000C04908080L});
    public static final BitSet FOLLOW_arithmetic_low_in_arithmetic_lowest340 = new BitSet(new long[]{0x0000000010800002L});
    public static final BitSet FOLLOW_arithmetic_medium_in_arithmetic_low354 = new BitSet(new long[]{0x0000000001001002L});
    public static final BitSet FOLLOW_MULTI_in_arithmetic_low362 = new BitSet(new long[]{0x0000000C04908080L});
    public static final BitSet FOLLOW_DIV_in_arithmetic_low367 = new BitSet(new long[]{0x0000000C04908080L});
    public static final BitSet FOLLOW_arithmetic_medium_in_arithmetic_low372 = new BitSet(new long[]{0x0000000001001002L});
    public static final BitSet FOLLOW_arithmetic_high_in_arithmetic_medium386 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_POWER_in_arithmetic_medium392 = new BitSet(new long[]{0x0000000C04908080L});
    public static final BitSet FOLLOW_arithmetic_high_in_arithmetic_medium395 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_arithmetic_highest_in_arithmetic_high409 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_PERCENT_in_arithmetic_high413 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_arithmetic_highest430 = new BitSet(new long[]{0x0000000C04108080L});
    public static final BitSet FOLLOW_atom_in_arithmetic_highest436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_call_in_atom447 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_reference_in_atom452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_atom457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEMPVAR_in_atom475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAR_in_atom480 = new BitSet(new long[]{0x0000000C04908080L});
    public static final BitSet FOLLOW_comparison_in_atom483 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_RPAR_in_atom485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FUNCTION_in_function_call497 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_LPAR_in_function_call500 = new BitSet(new long[]{0x0000000D04908080L});
    public static final BitSet FOLLOW_comparison_in_function_call508 = new BitSet(new long[]{0x0000000300000000L});
    public static final BitSet FOLLOW_SEMI_in_function_call512 = new BitSet(new long[]{0x0000000C04908080L});
    public static final BitSet FOLLOW_comparison_in_function_call515 = new BitSet(new long[]{0x0000000300000000L});
    public static final BitSet FOLLOW_RPAR_in_function_call525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CELL_REF_in_reference537 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_COLON_in_reference545 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_CELL_REF_in_reference550 = new BitSet(new long[]{0x0000000000000002L});
}
