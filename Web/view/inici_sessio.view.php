<?php

    //Connexio a la BD
    $connexio = new mysqli("localhost", "root", "costa2021", "projecte2");

    //Comprovasio de la connexio
    if($connexio->connect_errno){
        die ("No s'ha pogut fer la connexió");
    } else {
        session_start();

        if(!empty($_POST['usuari']) && !empty($_POST['contra'])){

            $usuari = $_POST['usuari'];

            //Consulta
            $sql = "SELECT Usuari, Contrasenya from Usuari where Usuari = $usuari;" ;
            $result = $connexio->query($sql);

            $message = '';
            
            if(count($result) > 0 && password_verify($_POST['contra'], $result['contrasenya'])){
                $_SESSION['usuari'] = $result['Usuari'];
                header("Location: index_menu.view.php");
            } else {
                $error = 'L\'usuari o contrasenya son incorectes';
            }
        }
    }
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>GYM</title>
</head>
<body>
    <h1>Inici Sessio</h1>

    <?php if(!empty($message)): ?>
        <p> <?= $message ?> </p>
    <?php endif; ?>

    <form action="inici_sessio.view.php" method="post">

        <input type="text" name="usuari" id="usuari" placeholder= "nom d'usuari">
        <input type="password" name="contra" id="contra" placeholder= "Contraseña">
        <input type="submit" value="Login">

    </form>
</body>
</html>