<?php

    session_start();

?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h1>Formulari de Loguin</h1>

    <form action="contingut.php" method="post">

        <input type="text" name="usuari" id="usuari" placeholder= "nom d'usuari">
        <input type="submit" value="Login">

    </form>

    <!-- <a href="contingut.php"> Inici sessió </a> -->
</body>
</html>