﻿<?xml version="1.0" encoding="UTF-8"?>
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
          <ul>
            <li><a href="index_menu.php"><img src="" alt="logo"/></a>

            </li>
            <li>
              <ul class="menu">
                <li><a href="Act.php">Activitats Diaries</a></li>
                <li><a href="Act_reg.php">Reguistres Activitats</a></li>
                <li><a href="curses.xml">Curses</a></li>
                <li><a href="Curses_reg.php">Participacio Curses</a></li>
              </ul>
            </li>
            <li id="user"><img src="../img/logo.png" alt="img sessio"/>
              <ul>
                <li><a href="#">Perfil</a></li>
                <li><a href="../php/tancar.php">Tancar Sessio</a></li>
              </ul>
            </li>
          </ul>
        </div>

        <div class="main">

          <h1>Curses:</h1>
          <div class="curses">
            <xsl:for-each select="curses/cursa">
              <div class="cursa">
                <h3><xsl:value-of select="nom"/></h3>
                <img src="../img/{img}" alt="img de cursa" width="100%"/>
                <h4><xsl:value-of select="modalitat"/></h4>
                <h4>A <xsl:value-of select="localitat"/> el <xsl:value-of select="data"/></h4>
                <h4><xsl:value-of select="durada"/></h4>
                <input type="button" value="Inscriu-te" id="boto"/>
              </div>
            </xsl:for-each>

          </div>

        </div>

        <div class="footer">

          <a href="">contacte</a>

        </div>

        <script src="js/funcions_curses.js"></script>
        
      </body>
    </html>
  </xsl:template>
</xsl:stylesheet>
