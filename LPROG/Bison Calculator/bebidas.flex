%{
  #include"bebidas.tab.h" // header gerado pelo BISON
  extern int numErros;
%}

%%
[0-9]+\.[0-9]+			yylval.real=atoi(yytext);return MOEDA;
[a-zA-Z]+				return BEBIDA;
\,					return SEPARADOR;
.				printf("Erro lexico: simbolo desconhecido %s\n",yytext); numErros++;
\n				return 0;
<<EOF>>			return 0;

%%



/*

6) Considere um simulador de uma máquina de venda automática que dispõe de um
conjunto de produtos e aceita moedas em euros (€0.01, €0.02, €0.05, €0.10, €0.20, €0.50,
€1.00, €2.00).
O objetivo é seleccionar um produto, introduzir o respectivo valor, receber o troco (se
existir) e receber o produto. Considere os seguintes produtos: café (€0.35), pingo (€0.35), chá
(€0.35), chocolate (€0.40), copo (€0.05) e leite (€0.30).
O formato de entrada de dados deve obedecer à seguinte regra:
<produto>,<moeda1>, . . .<moedan>.
O formato de saída deve obedecer à seguinte regra:
<produto>, <moeda1>, . . .<moedan> | “dinheiro insuficiente”.
Exemplo:
Entrada - café, €0.01,


*/



