/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.core.formula.compiler;

import static org.antlr.runtime.BaseRecognizer.DEFAULT_TOKEN_CHANNEL;
import static org.antlr.runtime.BaseRecognizer.HIDDEN;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.EarlyExitException;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.MismatchedSetException;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;

/**
 *
 * @author Catarina Sousa 1150767
 */
@SuppressWarnings({"all", "warnings", "unchecked"})
public class MacroFormulaLexer extends Lexer {
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
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public MacroFormulaLexer() {} 
    public MacroFormulaLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public MacroFormulaLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "csheets\\core\\formula\\compiler\\MacroFormula.g"; }

    // $ANTLR start "LETTER"
    public final void mLETTER() throws RecognitionException {
        try {
            // csheets\\core\\formula\\compiler\\MacroFormula.g:118:16: ( ( 'a' .. 'z' | 'A' .. 'Z' ) )
            // csheets\\core\\formula\\compiler\\MacroFormula.g:
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LETTER"

    // $ANTLR start "FUNCTION"
    public final void mFUNCTION() throws RecognitionException {
        try {
            int _type = FUNCTION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // csheets\\core\\formula\\compiler\\MacroFormula.g:120:10: ( ( LETTER )+ )
            // csheets\\core\\formula\\compiler\\MacroFormula.g:121:4: ( LETTER )+
            {
            // csheets\\core\\formula\\compiler\\MacroFormula.g:121:4: ( LETTER )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                switch ( input.LA(1) ) {
                case 'A':
                case 'B':
                case 'C':
                case 'D':
                case 'E':
                case 'F':
                case 'G':
                case 'H':
                case 'I':
                case 'J':
                case 'K':
                case 'L':
                case 'M':
                case 'N':
                case 'O':
                case 'P':
                case 'Q':
                case 'R':
                case 'S':
                case 'T':
                case 'U':
                case 'V':
                case 'W':
                case 'X':
                case 'Y':
                case 'Z':
                case 'a':
                case 'b':
                case 'c':
                case 'd':
                case 'e':
                case 'f':
                case 'g':
                case 'h':
                case 'i':
                case 'j':
                case 'k':
                case 'l':
                case 'm':
                case 'n':
                case 'o':
                case 'p':
                case 'q':
                case 'r':
                case 's':
                case 't':
                case 'u':
                case 'v':
                case 'w':
                case 'x':
                case 'y':
                case 'z':
                    {
                    alt1=1;
                    }
                    break;

                }

                switch (alt1) {
            	case 1 :
            	    // csheets\\core\\formula\\compiler\\MacroFormula.g:
            	    {
            	    if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FUNCTION"

    // $ANTLR start "CELL_REF"
    public final void mCELL_REF() throws RecognitionException {
        try {
            int _type = CELL_REF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // csheets\\core\\formula\\compiler\\MacroFormula.g:126:2: ( ( ABS )? LETTER ( LETTER )? ( ABS )? ( DIGIT )+ )
            // csheets\\core\\formula\\compiler\\MacroFormula.g:127:3: ( ABS )? LETTER ( LETTER )? ( ABS )? ( DIGIT )+
            {
            // csheets\\core\\formula\\compiler\\MacroFormula.g:127:3: ( ABS )?
            int alt2=2;
            switch ( input.LA(1) ) {
                case '$':
                    {
                    alt2=1;
                    }
                    break;
            }

            switch (alt2) {
                case 1 :
                    // csheets\\core\\formula\\compiler\\MacroFormula.g:
                    {
                    if ( input.LA(1)=='$' ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;

            }


            mLETTER(); 


            // csheets\\core\\formula\\compiler\\MacroFormula.g:127:19: ( LETTER )?
            int alt3=2;
            switch ( input.LA(1) ) {
                case 'A':
                case 'B':
                case 'C':
                case 'D':
                case 'E':
                case 'F':
                case 'G':
                case 'H':
                case 'I':
                case 'J':
                case 'K':
                case 'L':
                case 'M':
                case 'N':
                case 'O':
                case 'P':
                case 'Q':
                case 'R':
                case 'S':
                case 'T':
                case 'U':
                case 'V':
                case 'W':
                case 'X':
                case 'Y':
                case 'Z':
                case 'a':
                case 'b':
                case 'c':
                case 'd':
                case 'e':
                case 'f':
                case 'g':
                case 'h':
                case 'i':
                case 'j':
                case 'k':
                case 'l':
                case 'm':
                case 'n':
                case 'o':
                case 'p':
                case 'q':
                case 'r':
                case 's':
                case 't':
                case 'u':
                case 'v':
                case 'w':
                case 'x':
                case 'y':
                case 'z':
                    {
                    alt3=1;
                    }
                    break;
            }

            switch (alt3) {
                case 1 :
                    // csheets\\core\\formula\\compiler\\MacroFormula.g:
                    {
                    if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;

            }


            // csheets\\core\\formula\\compiler\\MacroFormula.g:128:3: ( ABS )?
            int alt4=2;
            switch ( input.LA(1) ) {
                case '$':
                    {
                    alt4=1;
                    }
                    break;
            }

            switch (alt4) {
                case 1 :
                    // csheets\\core\\formula\\compiler\\MacroFormula.g:
                    {
                    if ( input.LA(1)=='$' ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;

            }


            // csheets\\core\\formula\\compiler\\MacroFormula.g:128:12: ( DIGIT )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                switch ( input.LA(1) ) {
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    {
                    alt5=1;
                    }
                    break;

                }

                switch (alt5) {
            	case 1 :
            	    // csheets\\core\\formula\\compiler\\MacroFormula.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CELL_REF"

    // $ANTLR start "STRING"
    public final void mSTRING() throws RecognitionException {
        try {
            int _type = STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // csheets\\core\\formula\\compiler\\MacroFormula.g:133:8: ( QUOT ( options {greedy=false; } : . )* QUOT )
            // csheets\\core\\formula\\compiler\\MacroFormula.g:133:10: QUOT ( options {greedy=false; } : . )* QUOT
            {
            mQUOT(); 


            // csheets\\core\\formula\\compiler\\MacroFormula.g:134:3: ( options {greedy=false; } : . )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0=='\"') ) {
                    alt6=2;
                }
                else if ( ((LA6_0 >= '\u0000' && LA6_0 <= '!')||(LA6_0 >= '#' && LA6_0 <= '\uFFFF')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // csheets\\core\\formula\\compiler\\MacroFormula.g:134:28: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            mQUOT(); 


             setText(getText().substring(1, getText().length()-1)); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STRING"

    // $ANTLR start "QUOT"
    public final void mQUOT() throws RecognitionException {
        try {
            int _type = QUOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // csheets\\core\\formula\\compiler\\MacroFormula.g:138:5: ( '\"' )
            // csheets\\core\\formula\\compiler\\MacroFormula.g:138:7: '\"'
            {
            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "QUOT"

    // $ANTLR start "NUMBER"
    public final void mNUMBER() throws RecognitionException {
        try {
            int _type = NUMBER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // csheets\\core\\formula\\compiler\\MacroFormula.g:142:7: ( ( DIGIT )+ ( COMMA ( DIGIT )+ )? )
            // csheets\\core\\formula\\compiler\\MacroFormula.g:142:9: ( DIGIT )+ ( COMMA ( DIGIT )+ )?
            {
            // csheets\\core\\formula\\compiler\\MacroFormula.g:142:9: ( DIGIT )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                switch ( input.LA(1) ) {
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    {
                    alt7=1;
                    }
                    break;

                }

                switch (alt7) {
            	case 1 :
            	    // csheets\\core\\formula\\compiler\\MacroFormula.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);


            // csheets\\core\\formula\\compiler\\MacroFormula.g:142:20: ( COMMA ( DIGIT )+ )?
            int alt9=2;
            switch ( input.LA(1) ) {
                case ',':
                    {
                    alt9=1;
                    }
                    break;
            }

            switch (alt9) {
                case 1 :
                    // csheets\\core\\formula\\compiler\\MacroFormula.g:142:22: COMMA ( DIGIT )+
                    {
                    mCOMMA(); 


                    // csheets\\core\\formula\\compiler\\MacroFormula.g:142:28: ( DIGIT )+
                    int cnt8=0;
                    loop8:
                    do {
                        int alt8=2;
                        switch ( input.LA(1) ) {
                        case '0':
                        case '1':
                        case '2':
                        case '3':
                        case '4':
                        case '5':
                        case '6':
                        case '7':
                        case '8':
                        case '9':
                            {
                            alt8=1;
                            }
                            break;

                        }

                        switch (alt8) {
                    	case 1 :
                    	    // csheets\\core\\formula\\compiler\\MacroFormula.g:
                    	    {
                    	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt8 >= 1 ) break loop8;
                                EarlyExitException eee =
                                    new EarlyExitException(8, input);
                                throw eee;
                        }
                        cnt8++;
                    } while (true);


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NUMBER"

    // $ANTLR start "TEMPVAR"
    public final void mTEMPVAR() throws RecognitionException {
        try {
            int _type = TEMPVAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // csheets\\core\\formula\\compiler\\MacroFormula.g:145:8: ( UNDERSCORE LETTER ( LETTER | DIGIT )* )
            // csheets\\core\\formula\\compiler\\MacroFormula.g:145:10: UNDERSCORE LETTER ( LETTER | DIGIT )*
            {
            mUNDERSCORE(); 


            mLETTER(); 


            // csheets\\core\\formula\\compiler\\MacroFormula.g:145:28: ( LETTER | DIGIT )*
            loop10:
            do {
                int alt10=2;
                switch ( input.LA(1) ) {
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                case 'A':
                case 'B':
                case 'C':
                case 'D':
                case 'E':
                case 'F':
                case 'G':
                case 'H':
                case 'I':
                case 'J':
                case 'K':
                case 'L':
                case 'M':
                case 'N':
                case 'O':
                case 'P':
                case 'Q':
                case 'R':
                case 'S':
                case 'T':
                case 'U':
                case 'V':
                case 'W':
                case 'X':
                case 'Y':
                case 'Z':
                case 'a':
                case 'b':
                case 'c':
                case 'd':
                case 'e':
                case 'f':
                case 'g':
                case 'h':
                case 'i':
                case 'j':
                case 'k':
                case 'l':
                case 'm':
                case 'n':
                case 'o':
                case 'p':
                case 'q':
                case 'r':
                case 's':
                case 't':
                case 'u':
                case 'v':
                case 'w':
                case 'x':
                case 'y':
                case 'z':
                    {
                    alt10=1;
                    }
                    break;

                }

                switch (alt10) {
            	case 1 :
            	    // csheets\\core\\formula\\compiler\\MacroFormula.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "TEMPVAR"

    // $ANTLR start "DIGIT"
    public final void mDIGIT() throws RecognitionException {
        try {
            // csheets\\core\\formula\\compiler\\MacroFormula.g:149:7: ( '0' .. '9' )
            // csheets\\core\\formula\\compiler\\MacroFormula.g:
            {
            if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DIGIT"

    // $ANTLR start "EQ"
    public final void mEQ() throws RecognitionException {
        try {
            int _type = EQ;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // csheets\\core\\formula\\compiler\\MacroFormula.g:151:5: ( '=' )
            // csheets\\core\\formula\\compiler\\MacroFormula.g:151:7: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "EQ"

    // $ANTLR start "NEQ"
    public final void mNEQ() throws RecognitionException {
        try {
            int _type = NEQ;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // csheets\\core\\formula\\compiler\\MacroFormula.g:152:6: ( '<>' )
            // csheets\\core\\formula\\compiler\\MacroFormula.g:152:8: '<>'
            {
            match("<>"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NEQ"

    // $ANTLR start "LTEQ"
    public final void mLTEQ() throws RecognitionException {
        try {
            int _type = LTEQ;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // csheets\\core\\formula\\compiler\\MacroFormula.g:153:6: ( '<=' )
            // csheets\\core\\formula\\compiler\\MacroFormula.g:153:8: '<='
            {
            match("<="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LTEQ"

    // $ANTLR start "GTEQ"
    public final void mGTEQ() throws RecognitionException {
        try {
            int _type = GTEQ;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // csheets\\core\\formula\\compiler\\MacroFormula.g:154:6: ( '>=' )
            // csheets\\core\\formula\\compiler\\MacroFormula.g:154:8: '>='
            {
            match(">="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "GTEQ"

    // $ANTLR start "GT"
    public final void mGT() throws RecognitionException {
        try {
            int _type = GT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // csheets\\core\\formula\\compiler\\MacroFormula.g:155:5: ( '>' )
            // csheets\\core\\formula\\compiler\\MacroFormula.g:155:7: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "GT"

    // $ANTLR start "LT"
    public final void mLT() throws RecognitionException {
        try {
            int _type = LT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // csheets\\core\\formula\\compiler\\MacroFormula.g:156:5: ( '<' )
            // csheets\\core\\formula\\compiler\\MacroFormula.g:156:7: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LT"

    // $ANTLR start "ASSG"
    public final void mASSG() throws RecognitionException {
        try {
            int _type = ASSG;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // csheets\\core\\formula\\compiler\\MacroFormula.g:159:6: ( ':=' )
            // csheets\\core\\formula\\compiler\\MacroFormula.g:159:7: ':='
            {
            match(":="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ASSG"

    // $ANTLR start "AMP"
    public final void mAMP() throws RecognitionException {
        try {
            int _type = AMP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // csheets\\core\\formula\\compiler\\MacroFormula.g:162:6: ( '&' )
            // csheets\\core\\formula\\compiler\\MacroFormula.g:162:8: '&'
            {
            match('&'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "AMP"

    // $ANTLR start "PLUS"
    public final void mPLUS() throws RecognitionException {
        try {
            int _type = PLUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // csheets\\core\\formula\\compiler\\MacroFormula.g:165:6: ( '+' )
            // csheets\\core\\formula\\compiler\\MacroFormula.g:165:8: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PLUS"

    // $ANTLR start "MINUS"
    public final void mMINUS() throws RecognitionException {
        try {
            int _type = MINUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // csheets\\core\\formula\\compiler\\MacroFormula.g:166:7: ( '-' )
            // csheets\\core\\formula\\compiler\\MacroFormula.g:166:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "MINUS"

    // $ANTLR start "MULTI"
    public final void mMULTI() throws RecognitionException {
        try {
            int _type = MULTI;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // csheets\\core\\formula\\compiler\\MacroFormula.g:167:7: ( '*' )
            // csheets\\core\\formula\\compiler\\MacroFormula.g:167:9: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "MULTI"

    // $ANTLR start "DIV"
    public final void mDIV() throws RecognitionException {
        try {
            int _type = DIV;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // csheets\\core\\formula\\compiler\\MacroFormula.g:168:6: ( '/' )
            // csheets\\core\\formula\\compiler\\MacroFormula.g:168:8: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DIV"

    // $ANTLR start "POWER"
    public final void mPOWER() throws RecognitionException {
        try {
            int _type = POWER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // csheets\\core\\formula\\compiler\\MacroFormula.g:169:7: ( '^' )
            // csheets\\core\\formula\\compiler\\MacroFormula.g:169:9: '^'
            {
            match('^'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "POWER"

    // $ANTLR start "PERCENT"
    public final void mPERCENT() throws RecognitionException {
        try {
            int _type = PERCENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // csheets\\core\\formula\\compiler\\MacroFormula.g:170:9: ( '%' )
            // csheets\\core\\formula\\compiler\\MacroFormula.g:170:11: '%'
            {
            match('%'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PERCENT"

    // $ANTLR start "ABS"
    public final void mABS() throws RecognitionException {
        try {
            // csheets\\core\\formula\\compiler\\MacroFormula.g:173:14: ( '$' )
            // csheets\\core\\formula\\compiler\\MacroFormula.g:173:16: '$'
            {
            match('$'); 

            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ABS"

    // $ANTLR start "EXCL"
    public final void mEXCL() throws RecognitionException {
        try {
            // csheets\\core\\formula\\compiler\\MacroFormula.g:174:14: ( '!' )
            // csheets\\core\\formula\\compiler\\MacroFormula.g:174:17: '!'
            {
            match('!'); 

            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "EXCL"

    // $ANTLR start "COLON"
    public final void mCOLON() throws RecognitionException {
        try {
            int _type = COLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // csheets\\core\\formula\\compiler\\MacroFormula.g:175:7: ( ':' )
            // csheets\\core\\formula\\compiler\\MacroFormula.g:175:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COLON"

    // $ANTLR start "UNDERSCORE"
    public final void mUNDERSCORE() throws RecognitionException {
        try {
            int _type = UNDERSCORE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // csheets\\core\\formula\\compiler\\MacroFormula.g:176:12: ( '_' )
            // csheets\\core\\formula\\compiler\\MacroFormula.g:176:14: '_'
            {
            match('_'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "UNDERSCORE"

    // $ANTLR start "COMMA"
    public final void mCOMMA() throws RecognitionException {
        try {
            int _type = COMMA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // csheets\\core\\formula\\compiler\\MacroFormula.g:179:7: ( ',' )
            // csheets\\core\\formula\\compiler\\MacroFormula.g:179:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COMMA"

    // $ANTLR start "SEMI"
    public final void mSEMI() throws RecognitionException {
        try {
            int _type = SEMI;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // csheets\\core\\formula\\compiler\\MacroFormula.g:180:6: ( ';' )
            // csheets\\core\\formula\\compiler\\MacroFormula.g:180:8: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SEMI"

    // $ANTLR start "LPAR"
    public final void mLPAR() throws RecognitionException {
        try {
            int _type = LPAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // csheets\\core\\formula\\compiler\\MacroFormula.g:181:6: ( '(' )
            // csheets\\core\\formula\\compiler\\MacroFormula.g:181:8: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LPAR"

    // $ANTLR start "RPAR"
    public final void mRPAR() throws RecognitionException {
        try {
            int _type = RPAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // csheets\\core\\formula\\compiler\\MacroFormula.g:182:6: ( ')' )
            // csheets\\core\\formula\\compiler\\MacroFormula.g:182:8: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "RPAR"

    // $ANTLR start "LCURL"
    public final void mLCURL() throws RecognitionException {
        try {
            int _type = LCURL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // csheets\\core\\formula\\compiler\\MacroFormula.g:183:7: ( '{' )
            // csheets\\core\\formula\\compiler\\MacroFormula.g:183:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LCURL"

    // $ANTLR start "RCURL"
    public final void mRCURL() throws RecognitionException {
        try {
            int _type = RCURL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // csheets\\core\\formula\\compiler\\MacroFormula.g:184:7: ( '}' )
            // csheets\\core\\formula\\compiler\\MacroFormula.g:184:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "RCURL"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // csheets\\core\\formula\\compiler\\MacroFormula.g:187:3: ( ( ' ' | '\\r' '\\n' | '\\n' | '\\t' ) )
            // csheets\\core\\formula\\compiler\\MacroFormula.g:187:5: ( ' ' | '\\r' '\\n' | '\\n' | '\\t' )
            {
            // csheets\\core\\formula\\compiler\\MacroFormula.g:187:5: ( ' ' | '\\r' '\\n' | '\\n' | '\\t' )
            int alt11=4;
            switch ( input.LA(1) ) {
            case ' ':
                {
                alt11=1;
                }
                break;
            case '\r':
                {
                alt11=2;
                }
                break;
            case '\n':
                {
                alt11=3;
                }
                break;
            case '\t':
                {
                alt11=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;

            }

            switch (alt11) {
                case 1 :
                    // csheets\\core\\formula\\compiler\\MacroFormula.g:187:7: ' '
                    {
                    match(' '); 

                    }
                    break;
                case 2 :
                    // csheets\\core\\formula\\compiler\\MacroFormula.g:188:4: '\\r' '\\n'
                    {
                    match('\r'); 

                    match('\n'); 

                    }
                    break;
                case 3 :
                    // csheets\\core\\formula\\compiler\\MacroFormula.g:189:4: '\\n'
                    {
                    match('\n'); 

                    }
                    break;
                case 4 :
                    // csheets\\core\\formula\\compiler\\MacroFormula.g:190:4: '\\t'
                    {
                    match('\t'); 

                    }
                    break;

            }


            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WS"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // csheets\\core\\formula\\compiler\\MacroFormula.g:195:9: ( SEMI ( LETTER | NUMBER | WS )* )
            // csheets\\core\\formula\\compiler\\MacroFormula.g:195:11: SEMI ( LETTER | NUMBER | WS )*
            {
            mSEMI(); 


            // csheets\\core\\formula\\compiler\\MacroFormula.g:195:16: ( LETTER | NUMBER | WS )*
            loop12:
            do {
                int alt12=4;
                switch ( input.LA(1) ) {
                case 'A':
                case 'B':
                case 'C':
                case 'D':
                case 'E':
                case 'F':
                case 'G':
                case 'H':
                case 'I':
                case 'J':
                case 'K':
                case 'L':
                case 'M':
                case 'N':
                case 'O':
                case 'P':
                case 'Q':
                case 'R':
                case 'S':
                case 'T':
                case 'U':
                case 'V':
                case 'W':
                case 'X':
                case 'Y':
                case 'Z':
                case 'a':
                case 'b':
                case 'c':
                case 'd':
                case 'e':
                case 'f':
                case 'g':
                case 'h':
                case 'i':
                case 'j':
                case 'k':
                case 'l':
                case 'm':
                case 'n':
                case 'o':
                case 'p':
                case 'q':
                case 'r':
                case 's':
                case 't':
                case 'u':
                case 'v':
                case 'w':
                case 'x':
                case 'y':
                case 'z':
                    {
                    alt12=1;
                    }
                    break;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    {
                    alt12=2;
                    }
                    break;
                case '\t':
                case '\n':
                case '\r':
                case ' ':
                    {
                    alt12=3;
                    }
                    break;

                }

                switch (alt12) {
            	case 1 :
            	    // csheets\\core\\formula\\compiler\\MacroFormula.g:195:17: LETTER
            	    {
            	    mLETTER(); 


            	    }
            	    break;
            	case 2 :
            	    // csheets\\core\\formula\\compiler\\MacroFormula.g:195:24: NUMBER
            	    {
            	    mNUMBER(); 


            	    }
            	    break;
            	case 3 :
            	    // csheets\\core\\formula\\compiler\\MacroFormula.g:195:31: WS
            	    {
            	    mWS(); 


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COMMENT"
    @Override
    public void mTokens() throws RecognitionException {
        // csheets\\core\\formula\\compiler\\MacroFormula.g:1:8: ( FUNCTION | CELL_REF | STRING | QUOT | NUMBER | TEMPVAR | EQ | NEQ | LTEQ | GTEQ | GT | LT | ASSG | AMP | PLUS | MINUS | MULTI | DIV | POWER | PERCENT | COLON | UNDERSCORE | COMMA | SEMI | LPAR | RPAR | LCURL | RCURL | WS | COMMENT )
        int alt13=30;
        switch ( input.LA(1) ) {
        case 'A':
        case 'B':
        case 'C':
        case 'D':
        case 'E':
        case 'F':
        case 'G':
        case 'H':
        case 'I':
        case 'J':
        case 'K':
        case 'L':
        case 'M':
        case 'N':
        case 'O':
        case 'P':
        case 'Q':
        case 'R':
        case 'S':
        case 'T':
        case 'U':
        case 'V':
        case 'W':
        case 'X':
        case 'Y':
        case 'Z':
        case 'a':
        case 'b':
        case 'c':
        case 'd':
        case 'e':
        case 'f':
        case 'g':
        case 'h':
        case 'i':
        case 'j':
        case 'k':
        case 'l':
        case 'm':
        case 'n':
        case 'o':
        case 'p':
        case 'q':
        case 'r':
        case 's':
        case 't':
        case 'u':
        case 'v':
        case 'w':
        case 'x':
        case 'y':
        case 'z':
            {
            switch ( input.LA(2) ) {
            case 'A':
            case 'B':
            case 'C':
            case 'D':
            case 'E':
            case 'F':
            case 'G':
            case 'H':
            case 'I':
            case 'J':
            case 'K':
            case 'L':
            case 'M':
            case 'N':
            case 'O':
            case 'P':
            case 'Q':
            case 'R':
            case 'S':
            case 'T':
            case 'U':
            case 'V':
            case 'W':
            case 'X':
            case 'Y':
            case 'Z':
            case 'a':
            case 'b':
            case 'c':
            case 'd':
            case 'e':
            case 'f':
            case 'g':
            case 'h':
            case 'i':
            case 'j':
            case 'k':
            case 'l':
            case 'm':
            case 'n':
            case 'o':
            case 'p':
            case 'q':
            case 'r':
            case 's':
            case 't':
            case 'u':
            case 'v':
            case 'w':
            case 'x':
            case 'y':
            case 'z':
                {
                switch ( input.LA(3) ) {
                case '$':
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    {
                    alt13=2;
                    }
                    break;
                default:
                    alt13=1;
                }

                }
                break;
            case '$':
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                {
                alt13=2;
                }
                break;
            default:
                alt13=1;
            }

            }
            break;
        case '$':
            {
            alt13=2;
            }
            break;
        case '\"':
            {
            int LA13_3 = input.LA(2);

            if ( ((LA13_3 >= '\u0000' && LA13_3 <= '\uFFFF')) ) {
                alt13=3;
            }
            else {
                alt13=4;
            }
            }
            break;
        case '0':
        case '1':
        case '2':
        case '3':
        case '4':
        case '5':
        case '6':
        case '7':
        case '8':
        case '9':
            {
            alt13=5;
            }
            break;
        case '_':
            {
            switch ( input.LA(2) ) {
            case 'A':
            case 'B':
            case 'C':
            case 'D':
            case 'E':
            case 'F':
            case 'G':
            case 'H':
            case 'I':
            case 'J':
            case 'K':
            case 'L':
            case 'M':
            case 'N':
            case 'O':
            case 'P':
            case 'Q':
            case 'R':
            case 'S':
            case 'T':
            case 'U':
            case 'V':
            case 'W':
            case 'X':
            case 'Y':
            case 'Z':
            case 'a':
            case 'b':
            case 'c':
            case 'd':
            case 'e':
            case 'f':
            case 'g':
            case 'h':
            case 'i':
            case 'j':
            case 'k':
            case 'l':
            case 'm':
            case 'n':
            case 'o':
            case 'p':
            case 'q':
            case 'r':
            case 's':
            case 't':
            case 'u':
            case 'v':
            case 'w':
            case 'x':
            case 'y':
            case 'z':
                {
                alt13=6;
                }
                break;
            default:
                alt13=22;
            }

            }
            break;
        case '=':
            {
            alt13=7;
            }
            break;
        case '<':
            {
            switch ( input.LA(2) ) {
            case '>':
                {
                alt13=8;
                }
                break;
            case '=':
                {
                alt13=9;
                }
                break;
            default:
                alt13=12;
            }

            }
            break;
        case '>':
            {
            switch ( input.LA(2) ) {
            case '=':
                {
                alt13=10;
                }
                break;
            default:
                alt13=11;
            }

            }
            break;
        case ':':
            {
            switch ( input.LA(2) ) {
            case '=':
                {
                alt13=13;
                }
                break;
            default:
                alt13=21;
            }

            }
            break;
        case '&':
            {
            alt13=14;
            }
            break;
        case '+':
            {
            alt13=15;
            }
            break;
        case '-':
            {
            alt13=16;
            }
            break;
        case '*':
            {
            alt13=17;
            }
            break;
        case '/':
            {
            alt13=18;
            }
            break;
        case '^':
            {
            alt13=19;
            }
            break;
        case '%':
            {
            alt13=20;
            }
            break;
        case ',':
            {
            alt13=23;
            }
            break;
        case ';':
            {
            switch ( input.LA(2) ) {
            case '\t':
            case '\n':
            case '\r':
            case ' ':
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
            case 'A':
            case 'B':
            case 'C':
            case 'D':
            case 'E':
            case 'F':
            case 'G':
            case 'H':
            case 'I':
            case 'J':
            case 'K':
            case 'L':
            case 'M':
            case 'N':
            case 'O':
            case 'P':
            case 'Q':
            case 'R':
            case 'S':
            case 'T':
            case 'U':
            case 'V':
            case 'W':
            case 'X':
            case 'Y':
            case 'Z':
            case 'a':
            case 'b':
            case 'c':
            case 'd':
            case 'e':
            case 'f':
            case 'g':
            case 'h':
            case 'i':
            case 'j':
            case 'k':
            case 'l':
            case 'm':
            case 'n':
            case 'o':
            case 'p':
            case 'q':
            case 'r':
            case 's':
            case 't':
            case 'u':
            case 'v':
            case 'w':
            case 'x':
            case 'y':
            case 'z':
                {
                alt13=30;
                }
                break;
            default:
                alt13=24;
            }

            }
            break;
        case '(':
            {
            alt13=25;
            }
            break;
        case ')':
            {
            alt13=26;
            }
            break;
        case '{':
            {
            alt13=27;
            }
            break;
        case '}':
            {
            alt13=28;
            }
            break;
        case '\t':
        case '\n':
        case '\r':
        case ' ':
            {
            alt13=29;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("", 13, 0, input);

            throw nvae;

        }

        switch (alt13) {
            case 1 :
                // csheets\\core\\formula\\compiler\\MacroFormula.g:1:10: FUNCTION
                {
                mFUNCTION(); 


                }
                break;
            case 2 :
                // csheets\\core\\formula\\compiler\\MacroFormula.g:1:19: CELL_REF
                {
                mCELL_REF(); 


                }
                break;
            case 3 :
                // csheets\\core\\formula\\compiler\\MacroFormula.g:1:28: STRING
                {
                mSTRING(); 


                }
                break;
            case 4 :
                // csheets\\core\\formula\\compiler\\MacroFormula.g:1:35: QUOT
                {
                mQUOT(); 


                }
                break;
            case 5 :
                // csheets\\core\\formula\\compiler\\MacroFormula.g:1:40: NUMBER
                {
                mNUMBER(); 


                }
                break;
            case 6 :
                // csheets\\core\\formula\\compiler\\MacroFormula.g:1:47: TEMPVAR
                {
                mTEMPVAR(); 


                }
                break;
            case 7 :
                // csheets\\core\\formula\\compiler\\MacroFormula.g:1:55: EQ
                {
                mEQ(); 


                }
                break;
            case 8 :
                // csheets\\core\\formula\\compiler\\MacroFormula.g:1:58: NEQ
                {
                mNEQ(); 


                }
                break;
            case 9 :
                // csheets\\core\\formula\\compiler\\MacroFormula.g:1:62: LTEQ
                {
                mLTEQ(); 


                }
                break;
            case 10 :
                // csheets\\core\\formula\\compiler\\MacroFormula.g:1:67: GTEQ
                {
                mGTEQ(); 


                }
                break;
            case 11 :
                // csheets\\core\\formula\\compiler\\MacroFormula.g:1:72: GT
                {
                mGT(); 


                }
                break;
            case 12 :
                // csheets\\core\\formula\\compiler\\MacroFormula.g:1:75: LT
                {
                mLT(); 


                }
                break;
            case 13 :
                // csheets\\core\\formula\\compiler\\MacroFormula.g:1:78: ASSG
                {
                mASSG(); 


                }
                break;
            case 14 :
                // csheets\\core\\formula\\compiler\\MacroFormula.g:1:83: AMP
                {
                mAMP(); 


                }
                break;
            case 15 :
                // csheets\\core\\formula\\compiler\\MacroFormula.g:1:87: PLUS
                {
                mPLUS(); 


                }
                break;
            case 16 :
                // csheets\\core\\formula\\compiler\\MacroFormula.g:1:92: MINUS
                {
                mMINUS(); 


                }
                break;
            case 17 :
                // csheets\\core\\formula\\compiler\\MacroFormula.g:1:98: MULTI
                {
                mMULTI(); 


                }
                break;
            case 18 :
                // csheets\\core\\formula\\compiler\\MacroFormula.g:1:104: DIV
                {
                mDIV(); 


                }
                break;
            case 19 :
                // csheets\\core\\formula\\compiler\\MacroFormula.g:1:108: POWER
                {
                mPOWER(); 


                }
                break;
            case 20 :
                // csheets\\core\\formula\\compiler\\MacroFormula.g:1:114: PERCENT
                {
                mPERCENT(); 


                }
                break;
            case 21 :
                // csheets\\core\\formula\\compiler\\MacroFormula.g:1:122: COLON
                {
                mCOLON(); 


                }
                break;
            case 22 :
                // csheets\\core\\formula\\compiler\\MacroFormula.g:1:128: UNDERSCORE
                {
                mUNDERSCORE(); 


                }
                break;
            case 23 :
                // csheets\\core\\formula\\compiler\\MacroFormula.g:1:139: COMMA
                {
                mCOMMA(); 


                }
                break;
            case 24 :
                // csheets\\core\\formula\\compiler\\MacroFormula.g:1:145: SEMI
                {
                mSEMI(); 


                }
                break;
            case 25 :
                // csheets\\core\\formula\\compiler\\MacroFormula.g:1:150: LPAR
                {
                mLPAR(); 


                }
                break;
            case 26 :
                // csheets\\core\\formula\\compiler\\MacroFormula.g:1:155: RPAR
                {
                mRPAR(); 


                }
                break;
            case 27 :
                // csheets\\core\\formula\\compiler\\MacroFormula.g:1:160: LCURL
                {
                mLCURL(); 


                }
                break;
            case 28 :
                // csheets\\core\\formula\\compiler\\MacroFormula.g:1:166: RCURL
                {
                mRCURL(); 


                }
                break;
            case 29 :
                // csheets\\core\\formula\\compiler\\MacroFormula.g:1:172: WS
                {
                mWS(); 


                }
                break;
            case 30 :
                // csheets\\core\\formula\\compiler\\MacroFormula.g:1:175: COMMENT
                {
                mCOMMENT(); 


                }
                break;

        }

    }
}
