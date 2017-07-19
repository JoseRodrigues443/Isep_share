<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>
    <xsl:param name="origem" select="'OPO'"/>
    <xsl:template match="/">
        <html>
            <head>

            </head>
            <body>
                <p>Viagens ate 50€ com origem em <xsl:value-of select="$origem"/> </p>

                <table>
                    <tr  style="bold">
                        <th>destino</th>
                        <th>duracao</th>
                        <th>custo</th>
                    </tr>

                    <xsl:apply-templates select="//viagens/viagem[@origem = $origem][./custo &lt; 50]">
                        <xsl:sort select="/duracao" order="descending"/>
                    </xsl:apply-templates>

                    <tr style="bold">
                        <th>Totais</th>
                        <th>-</th>
                        <th><xsl:value-of select="sum(//viagens/viagem[@origem = $origem]/custo[. &lt; 50])"/></th>

                    </tr>

                </table>

            </body>


        </html>
    </xsl:template>

    <xsl:template match="viagem">
        <xsl:variable name="des" select="@destino"/>

        <tr>
            <th><xsl:value-of select="//aeroporto/designacao[../iata = $des]"/></th>
            <th><xsl:value-of select="./duracao"/></th>
            <th>€<xsl:value-of select="./custo"/></th>

        </tr>


    </xsl:template>


</xsl:stylesheet>