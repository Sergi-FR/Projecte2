<?php

include "../php/funcions.php";

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

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;700;800&display=swap" rel="stylesheet">

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<link rel="stylesheet" href="../css/estils-perfil.css">

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
                            <a href="#">Perfil</a>
                            <a href="../php/tancar.php">Tancar Sessio</a>
                        </div>
                    </li>
                </ul>
            </nav>
        </div>

        <div class="titular">
            <h1>Historial d'Activitats</h1>
        </div>

    </div>     
</header>

<main>
    <table>
        <tr>
            <th>ID Act</th>
            <th>Act</th>
            <th>Data Act</th>
            <th>Data Reserva</th>
        </tr>
        <?php
        $result = act_reg();
        while($row = $result->fetch_assoc()){
        ?>
        <tr>
            <td><?php echo $row["ID_Act"]; ?></td>
            <td><?php echo $row["Descipció"]; ?></td>
            <td><?php echo $row["Data"]; ?></td>
            <td><?php echo $row["Data_reserva"]; ?></td>
        </tr>
        <?php
        }
        ?>
    </table>
</main>

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

