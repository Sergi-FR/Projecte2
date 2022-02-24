<?php

    session_start();
    $user = $_SESSION['usuari'];

?>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>GYM</title>
    <link rel="stylesheet" href="../css/estils.css">
</head>

<body>
<div class="header">
          <ul>
            <li><a href="index_menu.view.php"><img src="" alt="logo"></a>

            </li>
            <li>
              <ul class="menu">
                <li><a href="Act.view.php">Activitats Diaries</a></li>
                <li><a href="Act_reg.view.php">Reguistres Activitats</a></li>
                <li><a href="../curses.xml">Curses</a></li>
                <li><a href="Curses_reg.view.php">Participacio Curses</a></li>
              </ul>
            </li>
            <li class="user">
                <img src="../img/perfil.png" alt="img sessio" calss="dorpbtn">
                <div class="drop">
                    <a href="#">Perfil</a>
                    <a href="../php/tancar.php">Tancar Sessio</a>
                </div>
            </li>
          </ul>
        </div>

    <div class="main">

        <h2>info gimnas</h2>
        <p><?php
          echo $user;
        ?></p>

    </div>

    <div class="footer">

        <a href="">contacte</a>

    </div>

</body>

</html>