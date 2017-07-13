<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/Catalogo">
		<html>
			<head>
				<title/>
			</head>
			<body>
				<h1 align="center">Listagem de plantas</h1>
				<table align="center" border="1">
					<tr>
						<th/>
						<th>Nome</th>
						<th>Preco</th>
						<th>Disponibilidade</th>
					</tr>
					<xsl:apply-templates select="Planta">
						<xsl:sort select="NomeComum"/>
					</xsl:apply-templates>
				</table>
			</body>
		</html>
	</xsl:template>
	<xsl:template match="Planta">
		<tr>
			<th>
				<xsl:value-of select="position()"/>
			</th>
			<td>
				<xsl:value-of select="NomeComum"/>
			</td>
			<td style="text-align:center">
				<xsl:value-of select="Preco"/>
			</td>
			<td style="text-align:center">
				<xsl:value-of select="Disponibilidade"/>
			</td>
		</tr>
	</xsl:template>
</xsl:stylesheet>
