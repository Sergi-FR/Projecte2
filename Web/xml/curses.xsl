<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  <xsl:template match="/">
    <html lang="en">
      <head>
        <meta charset="UTF-8"/>
        <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <title>GYM</title>

        <link rel="stylesheet" href="../css/xml.css"/>
        
      </head>
      <body>
        <div class="header">
          <img src="../img/logo.png" alt="logo"/>
        </div>

        <div class="main">

          <h1>Curses:</h1>

          <xsl:for-each select="curses/cursa">
          <div class="tarjeta">
              <div class="img_Act">
                <img src="../img/{img}" alt="img de cursa" width="100%"/>
                <input type="button" value="Inscriu-te" id="boto"/>
              </div>
              <div class="info_Act">
                <h3><xsl:value-of select="nom"/></h3>
                <h4><span>-Modalitat: </span><xsl:value-of select="modalitat"/></h4>
                <h4><span>-Localitat: </span><xsl:value-of select="localitat"/></h4>
                <h4><span>-Data: </span><xsl:value-of select="data"/></h4>
                <h4><span>-Durada: </span><xsl:value-of select="durada"/></h4>
              </div>
          </div>
        </xsl:for-each>


<!-- 
          <div class="tarjeta">
            <div class="img_Act">
              <img src="../img/galeria1.jpg" alt="Activitat"/>
              <input type="button" value="Insciure"/>
            </div>
            <div class ="info_Act">
              <p><span>Num. Activitat:</span>/p>
              <p><span>Num. Sala:</span></p>
              <p><span>Durada de L'activitat:</span></p>
              <p><span>Hora Inici:</span></p>
              <p><span>Hora Fi:</span></p>
              <p><span>Aforament:</span></p>
              <p><span>Monitor:</span></p>
              <p><span></span></p>
            </div> -->
        </div>

        <div class="footer">

          <a href="">contacte</a>

        </div>

        <script src="js/funcions_curses.js"></script>
        
      </body>
    </html>
  </xsl:template>
</xsl:stylesheet>
