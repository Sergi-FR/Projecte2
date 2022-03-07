<?php

include '../php/funcions.php';

session_start();

if(!empty($_POST)){
    perfil();
}
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
                <a href="menu.view.php"><img src="../img/logo.png" alt="Logo"></a>
            </div>

            <div class="login">
                <div class="formulari"> 

                    <form action="" method="post">

                        <div class="infoclient">

                            <h4>Informació Client</h4>

                            <label>DNI</label>

                            <input type="text" name="dni" id="dni" placeholder="DNI" value="<?php echo $_SESSION['DNI']?>" disabled>

                            <label>Nom</label>
                            <input type="text" name="usuari" id="usuari" placeholder="nom d'usuari" value="<?php echo $_SESSION['Nom']?>" disabled>

                            <label>Cognom</label>
                            <input type="text" name="Cognom" id="Cognom" placeholder="Cognom" value="<?php echo $_SESSION['Cognom']?>" disabled>

                            <label>Data</label>
                            <input type="text" name="Data" id="Data" placeholder="Data de naixement" value="<?php echo $_SESSION['Data']?>" disabled>

                            <label>Tel.</label>
                            <input type="text" name="Telefon" id="Telefon" placeholder="Telefon" value="<?php echo $_SESSION['Tele']?>">

                            <label>Correu Electronic</label>
                            <input type="text" name="correu" id="correu" placeholder="Correu" value="<?php echo $_SESSION['Correu']?>">     

                            <label>Genere</label>
                            <input type="text" name="sexe" id="sexe" placeholder="Sexe" value="<?php echo $_SESSION['Sexe']?>" disabled>


                        </div>

                        <div class="usuari">

                            <h4>Informació Usuari</h4>

                            <label>Nom usuari</label>
                            <input type="text" name="usuari" id="usuari" placeholder= "nom d'usuari" value="<?php echo $_SESSION['usuari']?>" disable>

                            <label>Contrasenya</label>
                            <input type="password" name="contra" id="contra" placeholder= "Contraseña" >
                            
                            <h4>Altres</h4>

                            <label>Confidició Fiscia</label>
                            <input type="text" name="cond" id="Con" value="<?php echo $_SESSION['Condicio']?>" disable>

                            <label>Comunicació Comercial</label>
                            <div class="si">
                            <input type="radio" name="comer" id="true" value="true" >
                            <label for="html">Si</label><br>
                            </div>
                            <div class="no">
                            <input type="radio" id="false" name="comer" value="false">
                            <label for="css">No</label>
                            </div>

                        </div>

                        <input type="submit" value="Actualitzar">

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