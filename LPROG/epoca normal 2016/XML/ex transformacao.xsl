<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>
    <xsl:template match="/">
        <html>
            <head>
                <title>projetos.xsl</title>

            </head>
            <body>
                <p>Projetos 3+:  <xsl:value-of select="count(/Gestao/Projetos/Projeto[count(.//Elemento) &gt; 3])"/></p>
                <table>
                    <tr>
                        <th>Nome</th>
                        <th>Projectos</th>
                    </tr>
                    <xsl:apply-templates select="//Pessoa[@id = //Elementos/*/@id]">

                        <xsl:sort select="@nome" order="ascending"/>

                    </xsl:apply-templates>
                </table>
            </body>
        </html>
    </xsl:template>
    <!-- COMPLETAR Bloco B -->

    <xsl:template match="//Pessoa"> <!-- Mostrar todas as garrafas -->
		<xsl:variable name="mid" select="@id"/>
        <tr>
            <td>
                <xsl:value-of select="@nome"/>
            </td>
            <td>
                <xsl:value-of select="count(/Gestao/Projetos/Projeto[.//Elemento/@id = $mid])"/>
            </td>

        </tr>
    </xsl:template>

</xsl:stylesheet>