<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  <xsl:template match="/">
    <html lang="en">
      <head>
        <meta charset="UTF-8"/>
        <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <title>GYM</title>
        <link rel="stylesheet" href="css/estils.css"/>
      </head>
      <body>
        <div class="header">
          <ul>
            <li><a href="view/index_menu.view.php"><img src="" alt="logo"/></a>

            </li>
            <li>
              <ul class="menu">
                <li><a href="Act.view.php">Activitats Diaries</a></li>
                <li><a href="Act_reg.view.php">Reguistres Activitats</a></li>
                <li><a href="curses.xml">Curses</a></li>
                <li><a href="Curses_reg.view.php">Participacio Curses</a></li>
              </ul>
            </li>
            <li class="user">
                <img src="img/perfil.png" alt="img sessio" calss="dorpbtn"/>
                <div class="drop">
                    <a href="#">Perfil</a>
                    <a href="php/tancar.php">Tancar Sessio</a>
                </div>
            </li>
          </ul>
        </div>

        <div class="main">

          <h1>Curses:</h1>
          <div class="curses">
            <xsl:for-each select="curses/cursa">
              <div class="cursa">
                <h3><xsl:value-of select="nom"/></h3>
                <img src="img/{img}" alt="img de cursa" width="100%"/>
                <h4><xsl:value-of select="modalitat"/></h4>
                <h4>A <xsl:value-of select="localitat"/> el <xsl:value-of select="data"/></h4>
                <h4><xsl:value-of select="durada"/></h4>
                <h4><xsl:value-of select="@id"/></h4>
                <input type="button" value="Inscriu-te" class="boto" id="{@id}" onclick="inscriu(id)"/>
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
