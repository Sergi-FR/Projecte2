<?php

include '../php/funcions.php';

session_start();

?>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <link rel="stylesheet" href="../css/perfil.css">

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;700;800&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">


</head>
<body>
    <header>
        <div class="contenedor">
            <div class="menu">
                <img src="../img/logo.png" alt="Logo">>
            </div>

            <div class="login">
                <div class="formulari"> 

                    <?php if(!empty($message)): ?>
                    <p> <?= $message ?> </p>
                    <?php endif; ?>

                    <form action="login.view.php" method="post">

                        <label>Nom usuari</label>
                        <input type="text" name="usuari" id="usuari" placeholder= "nom d'usuari">
                        <label>Contraseña</label>
                        <input type="password" name="contra" id="contra" placeholder= "Contraseña">
                        <label>Nom usuari</label>
                        <input type="text" name="usuari" id="usuari" placeholder= "nom d'usuari">
                        <label>Contraseña</label>
                        <input type="password" name="contra" id="contra" placeholder= "Contraseña">
                        <label>Nom usuari</label>
                        <input type="text" name="usuari" id="usuari" placeholder= "nom d'usuari">
                        <label>Contraseña</label>
                        <input type="password" name="contra" id="contra" placeholder= "Contraseña">
                        <label>Nom usuari</label>
                        <input type="text" name="usuari" id="usuari" placeholder= "nom d'usuari">
                        <label>Contraseña</label>
                        <input type="password" name="contra" id="contra" placeholder= "Contraseña">
                        <label>Nom usuari</label>
                        <input type="text" name="usuari" id="usuari" placeholder= "nom d'usuari">
                        <label>Contraseña</label>
                        <input type="password" name="contra" id="contra" placeholder= "Contraseña">
                        <label>Nom usuari</label>
                        <input type="text" name="usuari" id="usuari" placeholder= "nom d'usuari">
                        <label>Contraseña</label>
                        <input type="password" name="contra" id="contra" placeholder= "Contraseña">
                        <input type="submit" value="Login">

                    </form>
                </div>
            </div>

        </div>     
    </header>


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