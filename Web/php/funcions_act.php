<?php

function con() {

    //Connexio a la BD
    $connexio = new mysqli("localhost", "root", "root", "projecte2");

    //Comprovasio de la connexio
    if($connexio->connect_errno) die ("No s'ha pogut fer la connexió");

    return $connexio;
}

function visualitzarInfoActCol() {

    $sql="SELECT A.ID_Act as Num_Act, S.ID_Sala as Num_Sala, Durada,Hora_i, Hora_Fi, Aforament, Nom as Monitor,Descripció as Sala_Desc
    from  activitats A,té T,sales S, monitors M, reserva R, col·lectives C
    where R.ID_Act=A.ID_Act and
    A.ID_Act=T.ID_Act and  
    T.ID_Sala=S.ID_Sala and 
    M.ID_Sala=S.ID_Sala and
    C.ID_Act=A.ID_Act";

    $result=con()->query($sql);

    return $result;

}

function visualitzarInfoActInv() {

    $sql="SELECT A.ID_Act as Num_Act, S.ID_Sala as Num_Sala, Durada,Hora_i, Hora_Fi, Aforament, Nom as Monitor,Descripció as Sala_Desc
    from  activitats A,té T,sales S, monitors M, reserva R, individuals I
    where R.ID_Act=A.ID_Act and
    A.ID_Act=T.ID_Act and  
    T.ID_Sala=S.ID_Sala and 
    M.ID_Sala=S.ID_Sala and
    I.ID_Act=A.ID_Act";

    $result=con()->query($sql);

    return $result;

}


?>