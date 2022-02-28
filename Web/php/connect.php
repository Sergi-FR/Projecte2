<?php

    //Connexio a la BD
    $connexio = new mysqli("localhost", "root", "root", "projecte2");

    //Comprovasio de la connexio
    if($connexio->connect_errno) die ("No s'ha pogut fer la connexió");


?>