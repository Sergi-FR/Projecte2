<?php

function con(){
    
    //Connexio a la BD
    $connexio = new mysqli("localhost", "root", "1234", "projecte2");

    //Comprovasio de la connexio
    if($connexio->connect_errno){
        die ("No s'ha pogut fer la connexió");
    }

    return $connexio;

}

function act_reg(){

    $sql = "SELECT A.ID_Act, Descipció, Data, Data_reserva
            from reserva R join activitats A on A.ID_Act = R.ID_Act
            where DNI='".$_SESSION['DNI']."'";
    $result = con()->query($sql);

    return $result;
}

function cur_reg(){

    $sql = "SELECT C.ID_cursa, Modalitat, Data, DNI
            from inscriure I join curses C on C.ID_cursa = I.ID_cursa
            where DNI='".$_SESSION['DNI']."'";
    $result = con()->query($sql);

    return $result;
}
function visualitzarInfoActCol() {

    $sql="SELECT A.ID_Act as Num_Act, S.ID_Sala as Num_Sala, Durada,Hora_i, Hora_Fi, Aforament, Nom as Monitor, S.Descripció as Sala_Desc, A.Descipció as Act, Color
    from  activitats A,té T,sales S, monitors M, col·lectives C
    where A.ID_Act=T.ID_Act and  
    T.ID_Sala=S.ID_Sala and 
    M.ID_Sala=S.ID_Sala and
    C.ID_Act=A.ID_Act";

    $result=con()->query($sql);

    return $result;

}

function visualitzarInfoActInv() {

    $sql="SELECT A.ID_Act as Num_Act, S.ID_Sala as Num_Sala, Durada,Hora_i, Hora_Fi, Aforament, Nom as Monitor, S.Descripció as Sala_Desc, A.Descipció as Act, Color
    from  activitats A,té T,sales S, monitors M, individuals I
    where A.ID_Act=T.ID_Act and  
    T.ID_Sala=S.ID_Sala and 
    M.ID_Sala=S.ID_Sala and
    I.ID_Act=A.ID_Act";

    $result=con()->query($sql);

    return $result;

}

function act_insc() {
    if(!empty($_POST['ins'])) {
        $sql="SELECT inserta_reserva('".$_SESSION['DNI']."', ".$_POST["id_act"].") as msg";
    
        $result=con()->query($sql);
    
        return $result;
    } elseif(!empty($_POST['des'])) {
        $sql="SELECT delete_reserva('".$_SESSION['DNI']."', ".$_POST["id_act"].") as msg";
    
        $result=con()->query($sql);
    
        return $result;
        
    }
}

function perfil(){
    $comercial = $_SESSION['Comunicacio'];

    if(!empty($_POST['comer'])){
        $comercial = $_POST['comer'];
    }

    if(!empty($_POST['contra'])){
        $sql = "UPDATE clients C, usuari U
                set tel = ".$_POST['Telefon'].", Correu_e = '".$_POST['correu']."', Contrasenya =  MD5('".$_POST['contra']."'), Comunicació_comercial = ".$comercial."
                where C.DNI = '".$_SESSION['DNI']."'";
                echo "prova1";
    } else {
        $sql = "UPDATE clients C, usuari U
                set tel = ".$_POST['Telefon'].", Correu_e = '".$_POST['correu']."', Comunicació_comercial = ".$comercial."
                where C.DNI = '".$_SESSION['DNI']."'";
                echo "prova2";
    }

    $_SESSION['usuari'] = $_POST['usuari'];
    $_SESSION['Tele'] = $_POST['Telefon'];
    $_SESSION['Correu'] = $_POST['correu'];
    $_SESSION['Comunicacio'] = $comercial;

    $result = con()->query($sql);
}



?>