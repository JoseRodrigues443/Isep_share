<?xml version="1.0" encoding="UTF-8"?>
<!-- Removing and preserving whitespace --> 
<xsl:stylesheet version="1.0"
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

  <xsl:strip-space elements="news" />
  <xsl:preserve-space elements="text" />

  <xsl:template match="/">
    <xsl:copy-of select="." />
  </xsl:template>
</xsl:stylesheet>
