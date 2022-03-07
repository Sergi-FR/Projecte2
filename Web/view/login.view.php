<?php

include '../php/funcions.php';

session_start();

if(!empty($_POST['usuari']) && !empty($_POST['contra'])){

    $usuari = "Usuari='".$_POST['usuari']."' ";
    $contra = "Contrasenya=MD5('".$_POST['contra']."') ";

    //Consulta
    $sql = "SELECT C.DNI as DNI_Client, Nom, Cognom, Data_naixement, Tel, Correu_e, Sexe, Condicio_Fisica, Comunicació_comercial, Usuari
    from clients C,usuari U
    where C.DNI=U.DNI and
    $usuari and $contra";

    $result = con()->query($sql);

    $message = '';

    if($result->num_rows > 0){
        while($row = $result->fetch_assoc()){
            $_SESSION['usuari'] = $row['Usuari'];
            $_SESSION['DNI'] = $row['DNI_Client'];
            $_SESSION['Nom'] = $row['Nom'];
            $_SESSION['Cognom'] = $row['Cognom'];
            $_SESSION['Data'] = $row['Data_naixement'];
            $_SESSION['Tele'] = $row['Tel'];
            $_SESSION['Correu'] = $row['Correu_e'];
            $_SESSION['Sexe'] = $row['Sexe'];
            $_SESSION['Condicio'] = $row['Condicio_Fisica'];
            $_SESSION['Comunicacio'] = $row['Comunicació_comercial'];
            
        }
        header("Location: menu.view.php");
    } else {
        $message = 'L\'usuari o contrasenya son incorectes';
    }
}

?>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <link rel="stylesheet" href="../css/login.css">

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