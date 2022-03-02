<?php

  include '../php/funcions_act.php';
  session_start();
  $user = $_SESSION['usuari'];
    
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <link rel="stylesheet" href="../css/act_ins.css">

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;700;800&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">


</head>
<body>
  <header>
    <div class="contenedor">
      <div class="menu">
        <img src="../img/logo.png" alt="Logo">
          <nav>
            <ul>
              <li><a href="Act.view.php">Activitats Diaries</a></li>
              <li><a href="Act_reg.view.php">Reguistres Activitats</a></li>
              <li><a href="../xml/curses.xml">Curses</a></li>
              <li><a href="Curses_reg.view.php">Participacio Curses</a></li>
              <li class="user">
                <img src="../img/perfil.png" alt="img sessio" calss="dorpbtn">
                <div class="drop">
                  <a href="perfil.view.php">Perfil</a>
                  <a href="../php/tancar.php">Tancar Sessio</a>
                </div>
              </li>
          </ul>
        </nav>
      </div>

      <div class="titular">
        <h1>Activitats del Dia</h1>
      </div>

    </div>     
  </header>



    <div class="Sub-titulo">
        <h3>Activitats Col·lectives</h3>
    </div>
    
    <section id="tarjetas">
      <div class="contenedor">
          <div class="contenedor-tarjetas">
            <ul>
              <?php $result= visualitzarInfoActCol();
              while($row = $result->fetch_assoc()){
              ?>
                <li>
                  <div class="tarjeta">
                    <div class="img_Act">
                      <img src="../img/galeria1.jpg" alt="Activitat">
                      <input type="button" value="Insciure">
                    </div>
                    <div class ="info_Act">
                      <p><span>Num. Activitat:</span><?php echo $row['Num_Act'] ?></p>
                      <p><span>Num. Sala:</span><?php echo $row['Num_Sala'] ?></p>
                      <p><span>Durada de L'activitat:</span><?php echo $row['Durada'] ?></p>
                      <p><span>Hora Inici:</span><?php echo $row['Hora_i'] ?></p>
                      <p><span>Hora Fi:</span><?php echo $row['Hora_Fi'] ?></p>
                      <p><span>Aforament:</span><?php echo $row['Aforament'] ?></p>
                      <p><span>Monitor:</span><?php echo $row['Monitor'] ?></p>
                      <p><span></span><?php echo $row['Sala_Desc'] ?></p>
                    </div>
                  </div>
                </li>
              <?php } ?>
            </ul>
          </div>
        </div>
      </div>
    </section>

    <div class="Sub-titulo">
        <h3>Activitats Individuals</h3>
    </div>

    <section id="tarjetas">
      <div class="contenedor">
          <div class="contenedor-tarjetas">
            <ul>
              <?php $result= visualitzarInfoActInv();
              while($row = $result->fetch_assoc()){
              ?>
                <li>
                  <div class="tarjeta">
                    <div class="img_Act">
                      <img src="../img/galeria1.jpg" alt="Activitat">
                      <input type="button" onclick="loadDoc()" value="Insciure">
                    </div>
                    <div class ="info_Act">
                      <p><span>Num. Activitat: </span><?php echo $row['Num_Act'] ?></p>
                      <p><span>Num. Sala: </span><?php echo $row['Num_Sala'] ?></p>
                      <p><span>Durada de L'activitat: </span><?php echo $row['Durada'] ?></p>
                      <p><span>Hora Inici: </span><?php echo $row['Hora_i'] ?></p>
                      <p><span>Hora Fi: </span><?php echo $row['Hora_Fi'] ?></p>
                      <p><span>Aforament: </span><?php echo $row['Aforament'] ?></p>
                      <p><span>Monitor: </span><?php echo $row['Monitor'] ?></p>
                      <p><span></span><?php echo $row['Sala_Desc'] ?></p>
                    </div>
                  </div>
                </li>
              <?php } ?>
            </ul>
          </div>
        </div>
      </div>
    </section>


  <footer>
    <section id="contactar">
      <div class="contenedor">

          <h2>Contactans</h2>

          <div class="info">
            <p>(+34) 973 53 62 72</p>
             <p>info@gmail.com</p>
          </div>

      </div>
    </section>
  </footer>   
</body>
</html>