<?php

    session_start();
    $usuari = $_POST['usuari'];
    $_SESSION['usuari'] = $usuari;

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
    <h2>Benvingut <?php echo $usuari ?> </h2>

    <a href="tancar.php"> Tancar sessió </a>
</body>
</html>