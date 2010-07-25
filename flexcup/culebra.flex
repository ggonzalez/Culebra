//
// Culebra Programming language
//
package culebra.lexical;

import culebra.syntax.*;
import culebra.lexical.Token;

%%

%public
%class Scanner
%char
%line
%column
%eofclose
%cup

// incluir aqui, si es necesario otras directivas

%{
    //LexicalErrorManager LexicalErrorManager = new LexicalErrorManager ();
    private int commentCount = 0;

    // Cadena de caracteres leida
    private StringBuffer  cadena = new StringBuffer();
    private int cadena_line = 0;
    private int cadena_column = 0;
%}

// Macros y definiciones

EOF        = \n|\r|\r\n
char        = [^\n\r]

Space         = {EOF} | [ \t\f]

Integer          = 0 | [1-9][0-9]*
WrongEntero     = 0[0-9]+
Identificator   = [:jletter:][:jletterdigit:]*
WrongId         = [0-9]+[:jletter:]+[:jletterdigit:]*

BeginComment    = "/*"
EndComment      = "*/"
BeginCppComment = "//"



// Declaración de estados
%state COMMENT
%state CPP_COMMENT
%state STRING

//%eofval{
//   return new java_cup.runtime.Symbol(sym.EOF);
//%eofval}

%eof{
%eof}

%%

////////////////////
// Comments parsing
//
<YYINITIAL> {
    <<EOF>>             {
                              return new java_cup.runtime.Symbol(sym.EOF);
                        }
    {WrongEntero}
                        {
                           LexicalError error = new LexicalError ();
                           error.setLine (yyline + 1);
                           error.setColumn (yycolumn + 1);
                           error.setText (yytext ());
                           LexicalErrorManager.lexicalError (error);
                           LexicalErrorManager.lexicalFatalError("Entero: " + yytext() + " no valido");
                        }
    {WrongId}
                        {
                           LexicalError error = new LexicalError ();
                           error.setLine (yyline + 1);
                           error.setColumn (yycolumn + 1);
                           error.setText (yytext ());
                           LexicalErrorManager.lexicalError (error);
                           LexicalErrorManager.lexicalFatalError("Identificador: " + yytext() + " no valido");
                        }


    {BeginComment}          {
                              if (commentCount != 0) {
                                LexicalError error = new LexicalError ();
                                error.setLine(yyline + 1);
                                error.setColumn(yycolumn + 1);
                                error.setText(yytext());
                                LexicalErrorManager.lexicalError(error);
                                LexicalErrorManager.lexicalFatalError("Error al procesar el comentario");
                              }
                              commentCount = 1;
                              yybegin(COMMENT);
                            }
    {EndComment}            {
                                LexicalError error = new LexicalError ();
                                error.setLine(yyline + 1);
                                error.setColumn(yycolumn + 1);
                                error.setText(yytext());
                                LexicalErrorManager.lexicalError(error);
                                LexicalErrorManager.lexicalFatalError("Fin de comentario no esperado");
                            }
	{BeginCppComment}          {
                              yybegin(CPP_COMMENT);
                            }

// KEYWORDS
	"as"				{
                            Token token = new Token (sym.AS);
                            token.setLine (yyline + 1);
                            token.setColumn (yycolumn + 1);
                            token.setLexeme (yytext ());
                            return token;
                        }
	"hooks"				{
                            Token token = new Token (sym.HOOKS);
                            token.setLine (yyline + 1);
                            token.setColumn (yycolumn + 1);
                            token.setLexeme (yytext ());
                            return token;
                        }
	"return"            {
                            Token token = new Token (sym.RETURN);
                            token.setLine (yyline + 1);
                            token.setColumn (yycolumn + 1);
                            token.setLexeme (yytext ());
                            return token;
                        }
    "flush()"            {
                            Token token = new Token (sym.FLUSH);
                            token.setLine (yyline + 1);
                            token.setColumn (yycolumn + 1);
                            token.setLexeme (yytext ());
                            return token;
                        }
						
    "delete()"            {
                            Token token = new Token (sym.DELETE);
                            token.setLine (yyline + 1);
                            token.setColumn (yycolumn + 1);
                            token.setLexeme (yytext ());
                            return token;
                        }



    "import"            {
                            Token token = new Token (sym.IMPORT);
                            token.setLine (yyline + 1);
                            token.setColumn (yycolumn + 1);
                            token.setLexeme (yytext ());
                            return token;
                        }
    "module"            {
                            Token token = new Token (sym.MODULE);
                            token.setLine (yyline + 1);
                            token.setColumn (yycolumn + 1);
                            token.setLexeme (yytext ());
                            return token;
                        }
    "case"              {
                            Token token = new Token (sym.CASE);
                            token.setLine (yyline + 1);
                            token.setColumn (yycolumn + 1);
                            token.setLexeme (yytext ());
                            return token;
                        }
    "#define"        {
                            Token token = new Token (sym.DEFINE);
                            token.setLine (yyline + 1);
                            token.setColumn (yycolumn + 1);
                            token.setLexeme (yytext ());
                            return token;
                        }
    "break"             {
                            Token token = new Token (sym.BREAK);
                            token.setLine (yyline + 1);
                            token.setColumn (yycolumn + 1);
                            token.setLexeme (yytext ());
                            return token;
                        }   

    "println"           {
                            Token token = new Token (sym.PRINTLN);
                            token.setLine (yyline + 1);
                            token.setColumn (yycolumn + 1);
                            token.setLexeme (yytext ());
                            return token;
                        }
    "print"           {
                            Token token = new Token (sym.PRINT);
                            token.setLine (yyline + 1);
                            token.setColumn (yycolumn + 1);
                            token.setLexeme (yytext ());
                            return token;
                        }
    "read"           {
                            Token token = new Token (sym.READ);
                            token.setLine (yyline + 1);
                            token.setColumn (yycolumn + 1);
                            token.setLexeme (yytext ());
                            return token;
                        }
    "switch"      {
                            Token token = new Token (sym.SWITCH);
                            token.setLine (yyline + 1);
                            token.setColumn (yycolumn + 1);
                            token.setLexeme (yytext ());
                            return token;
                        } 
   "while"          {
                         Token token = new Token (sym.WHILE);
                           token.setLine (yyline + 1);
                           token.setColumn (yycolumn + 1);
                            token.setLexeme (yytext ());
                           return token;
                      }
    "for"              {
                            Token token = new Token (sym.FOR);
                            token.setLine (yyline + 1);
                            token.setColumn (yycolumn + 1);
                            token.setLexeme (yytext ());
                            return token;
                        }
    "default"        {
                            Token token = new Token (sym.DEFAULT);
                            token.setLine (yyline + 1);
                            token.setColumn (yycolumn + 1);
                            token.setLexeme (yytext ());
                            return token;
                        }    
 //   "main"         {
 //                           Token token = new Token (sym.MAIN);
 //                           token.setLine (yyline + 1);
 //                           token.setColumn (yycolumn + 1);
 //                           token.setLexeme (yytext ());
 //                           return token;
 //                       }    

    "return"          {
                            Token token = new Token (sym.RETURN);
                            token.setLine (yyline + 1);
                            token.setColumn (yycolumn + 1);
                            token.setLexeme (yytext ());
                            return token;
                        }    
    "continue"             {
                            Token token = new Token (sym.CONTINUE);
                            token.setLine (yyline + 1);
                            token.setColumn (yycolumn + 1);
                            token.setLexeme (yytext ());
                            return token;
                        }    
    "if"                {
                            Token token = new Token (sym.IF);
                            token.setLine (yyline + 1);
                            token.setColumn (yycolumn + 1);
                            token.setLexeme (yytext ());
                            return token;
                        }        
    "else"              {
                            Token token = new Token (sym.ELSE);
                            token.setLine (yyline + 1);
                            token.setColumn (yycolumn + 1);
                            token.setLexeme (yytext ());
                            return token;
                        }    
    "struct"          {
                            Token token = new Token (sym.STRUCT);
                            token.setLine (yyline + 1);
                            token.setColumn (yycolumn + 1);
                            token.setLexeme (yytext ());
                            return token;
                        }

    "enum"           {
                            Token token = new Token (sym.ENUM);
                            token.setLine (yyline + 1);
                            token.setColumn (yycolumn + 1);
                            token.setLexeme (yytext ());
                            return token;
                        }

// TYPES
    "var"               {
                            Token token = new Token (sym.VAR);
                            token.setLine (yyline + 1);
                            token.setColumn (yycolumn + 1);
                            token.setLexeme (yytext ());
                            return token;
                        }   
     "int"            {
                            Token token = new Token (sym.INT);
                            token.setLine (yyline + 1);
                            token.setColumn (yycolumn + 1);
                            token.setLexeme (yytext ());
                            return token;
                        }   
     "string"            {
                            Token token = new Token (sym.STR);
                            token.setLine (yyline + 1);
                            token.setColumn (yycolumn + 1);
                            token.setLexeme (yytext ());
                            return token;
                        }   
     "float"            {
                            Token token = new Token (sym.FLT);
                            token.setLine (yyline + 1);
                            token.setColumn (yycolumn + 1);
                            token.setLexeme (yytext ());
                            return token;
                        }   
    "void"             {
                            Token token = new Token (sym.VOID);
                            token.setLine (yyline + 1);
                            token.setColumn (yycolumn + 1);
                            token.setLexeme (yytext ());
                            return token;
                        }    
// MODIFICATORS
    "tmp"               {
                            Token token = new Token (sym.TMP);
                            token.setLine (yyline + 1);
                            token.setColumn (yycolumn + 1);
                            token.setLexeme (yytext ());
                            return token;
                        }
// DELIMITADORES

    "("                 {
                            Token token = new Token (sym.LPAREN);
                            token.setLine (yyline + 1);
                            token.setColumn (yycolumn + 1);
                            token.setLexeme (yytext ());
                            return token;

                        }
    ")"                 {
                            Token token = new Token (sym.RPAREN);
                            token.setLine (yyline + 1);
                            token.setColumn (yycolumn + 1);
                            token.setLexeme (yytext ());
                            return token;

                        }

    "{"                 {
                            Token token = new Token (sym.LCURLY);
                            token.setLine (yyline + 1);
                            token.setColumn (yycolumn + 1);
                            token.setLexeme (yytext ());
                            return token;

                        }
    "}"                 {
                            Token token = new Token (sym.RCURLY);
                            token.setLine (yyline + 1);
                            token.setColumn (yycolumn + 1);
                            token.setLexeme (yytext ());
                            return token;

                        }
    ","                 {
                            Token token = new Token (sym.COMA);
                            token.setLine (yyline + 1);
                            token.setColumn (yycolumn + 1);
                            token.setLexeme (yytext ());
                            return token;

                        }
    ";"                 {
                            Token token = new Token (sym.SEMICOLON);
                            token.setLine (yyline + 1);
                            token.setColumn (yycolumn + 1);
                            token.setLexeme (yytext ());
                            return token;

                        }
    ":"                 {
                            Token token = new Token (sym.COLON);
                            token.setLine (yyline + 1);
                            token.setColumn (yycolumn + 1);
                            token.setLexeme (yytext ());
                            return token;

                        }
    "&"                 {
                            Token token = new Token (sym.ANDPERSAND);
                            token.setLine (yyline + 1);
                            token.setColumn (yycolumn + 1);
                            token.setLexeme (yytext ());
                            return token;

                        }


//////////////////
// OPERATORS
//
// Relational

    "<"                 {
                            Token token = new Token (sym.LESS);
                            token.setLine (yyline + 1);
                            token.setColumn (yycolumn + 1);
                            token.setLexeme (yytext ());
                            return token;
                        }
    ">"                 {
                            Token token = new Token (sym.GREAT);
                            token.setLine (yyline + 1);
                            token.setColumn (yycolumn + 1);
                            token.setLexeme (yytext ());
                            return token;
                        }
    "<="                 {
                            Token token = new Token (sym.LESSEQUAL);
                            token.setLine (yyline + 1);
                            token.setColumn (yycolumn + 1);
                            token.setLexeme (yytext ());
                            return token;
                        }
    ">="                 {
                            Token token = new Token (sym.GREATEQUAL);
                            token.setLine (yyline + 1);
                            token.setColumn (yycolumn + 1);
                            token.setLexeme (yytext ());
                            return token;
                        }
    "=="                {
                            Token token = new Token (sym.EQUAL);
                            token.setLine (yyline + 1);
                            token.setColumn (yycolumn + 1);
                           token.setLexeme (yytext ());
                            return token;
                        }

    "!="                {
                            Token token = new Token (sym.NOEQUAL);
                            token.setLine (yyline + 1);
                            token.setColumn (yycolumn + 1);
                            token.setLexeme (yytext ());
                            return token;
                        }

// Logic

    "&&"                {
                            Token token = new Token (sym.AND);
                            token.setLine (yyline + 1);
                            token.setColumn (yycolumn + 1);
                            token.setLexeme (yytext ());
                            return token;
                        }
    "||"                {
                            Token token = new Token (sym.OR);
                            token.setLine (yyline + 1);
                            token.setColumn (yycolumn + 1);
                            token.setLexeme (yytext ());
                            return token;
                        }
    "!"                 {
                            Token token = new Token (sym.NOT);
                            token.setLine (yyline + 1);
                            token.setColumn (yycolumn + 1);
                            token.setLexeme (yytext ());
                            return token;
                        }

// Especial

    "++"                {
                            Token token = new Token (sym.PLUSPLUS);
                            token.setLine (yyline + 1);
                            token.setColumn (yycolumn + 1);
                            token.setLexeme (yytext ());
                            return token;
                        }
    "--"                {
                            Token token = new Token (sym.MINUSMINUS);
                            token.setLine (yyline + 1);
                            token.setColumn (yycolumn + 1);
                           token.setLexeme (yytext ());
                            return token;
                        }

// Assignation

    "="                 {
                            Token token = new Token (sym.ASSIG);
                            token.setLine (yyline + 1);
                            token.setColumn (yycolumn + 1);
                            token.setLexeme (yytext ());
                            return token;
                        }
    "+="                {
                            Token token = new Token (sym.ADDASSIG);
                            token.setLine (yyline + 1);
                            token.setColumn (yycolumn + 1);
                            token.setLexeme (yytext ());
                            return token;
                        }
    "-="                {
                            Token token = new Token (sym.SUBSASSIG);
                            token.setLine (yyline + 1);
                            token.setColumn (yycolumn + 1);
                            token.setLexeme (yytext ());
                            return token;
                        }
// Arithmetics
    "+"                 {
                            Token token = new Token (sym.PLUS);
                            token.setLine (yyline + 1);
                            token.setColumn (yycolumn + 1);
                            token.setLexeme (yytext ());
                            return token;
                        }
    "-"                 {
                            Token token = new Token (sym.MINUS);
                            token.setLine (yyline + 1);
                            token.setColumn (yycolumn + 1);
                            token.setLexeme (yytext ());
                            return token;
                        }
    "*"                 {
                            Token token = new Token (sym.MUL);
                            token.setLine (yyline + 1);
                           token.setColumn (yycolumn + 1);
                            token.setLexeme (yytext ());
                            return token;
                        }
    "/"                 {
                            Token token = new Token (sym.DIV);
                            token.setLine (yyline + 1);
                            token.setColumn (yycolumn + 1);
                            token.setLexeme (yytext ());
                            return token;
                        }
// Access

    "@"                 {
                            Token token = new Token (sym.ITER);
                            token.setLine (yyline + 1);
                            token.setColumn (yycolumn + 1);
                            token.setLexeme (yytext ());
                            return token;
                        }

    "."                 {
                            Token token = new Token (sym.DOT);
                            token.setLine (yyline + 1);
                            token.setColumn (yycolumn + 1);
                            token.setLexeme (yytext ());
                            return token;
                        }

// REGEX
   \~                   {
                            Token token = new Token (sym.REGEX);
                            token.setLine (yyline + 1);
                            token.setColumn (yycolumn + 1);
                            token.setLexeme (yytext ());
                            return token;
                        }
// BEGIN STRING

    \"                  {
                            cadena.setLength(0);
                            cadena_line = yyline + 1;
                            cadena_column = yycolumn + 1;
                            yybegin(STRING);
                        }

// Other tokens

    {Integer}            {
                            Token token = new Token (sym.INTEGER);
                            token.setLine(yyline + 1);
                            token.setColumn(yycolumn + 1);
                            token.setLexeme(yytext());
                            return token;
                        }

    {Identificator}     {
                            Token token = new Token (sym.ID);
                            token.setLine(yyline + 1);
                            token.setColumn(yycolumn + 1);
                            token.setLexeme(yytext());
                            return token;
                        }

    {EOF}          { /* Ignorar fin de línea */ }
    {Space}           { /* Ignorar espacios en blanco */ }

    // error en caso de coincidir con ning�n patr�n

	[^]
                        {
                           LexicalError error = new LexicalError ();
                           error.setLine (yyline + 1);
                           error.setColumn (yycolumn + 1);
                           error.setText (yytext ());
                           LexicalErrorManager.lexicalError (error);
                           LexicalErrorManager.lexicalFatalError("Caracter no permitido");
                        }

}

<STRING> {
    \"                  {
                            yybegin(YYINITIAL);
                            Token token = new Token (sym.STRING);
                            token.setLine(cadena_line);
                            token.setColumn(cadena_column);
                            token.setLexeme(cadena.toString());
                            return token;
                        }

    \\\"                { cadena.append('\"'); }
    \\\\                { cadena.append("\\"); }
    \\t                 { cadena.append('\t'); }
    \\n                 { cadena.append('\n'); }
    \\r                 { cadena.append('\r'); }

        [^\n\r\"]           { cadena.append(yytext()); }

    <<EOF>>             {
                            LexicalError error = new LexicalError ();
                            error.setLine(yyline + 1);
                            error.setColumn(yycolumn + 1);
                            error.setText(yytext());
                            LexicalErrorManager.lexicalError(error);
                            LexicalErrorManager.lexicalFatalError("Cadena de caracteres no terminada");
                        }

    [^]                 {
                           LexicalError error = new LexicalError ();
                           error.setLine (yyline + 1);
                           error.setColumn (yycolumn + 1);
                           error.setText (yytext ());
                           LexicalErrorManager.lexicalError (error);
                           LexicalErrorManager.lexicalFatalError("Cadena de caracteres mal construida");
                        }
}

<COMMENT> {

    {BeginComment}      {
                          commentCount ++;
                        }

    {EndComment}        {
                          if ((--commentCount) == 0) {
                            yybegin(YYINITIAL);
                          }
                        }
    <<EOF>>             {
                            LexicalError error = new LexicalError ();
                            error.setLine(yyline + 1);
                            error.setColumn(yycolumn + 1);
                            error.setText(yytext());
                            LexicalErrorManager.lexicalError(error);
                            LexicalErrorManager.lexicalFatalError("Comentario Mal Balanceado");
                        }
    .|\n|\r\n                   { /* IGNORE */ }
}

<CPP_COMMENT> {
    [^\n\r]                  { /* IGNORE */ }
	\n|\r\n                  { yybegin(YYINITIAL); }
}


