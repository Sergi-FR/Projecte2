// let numBotons = document.getElementsByClassName("boto");

// for(var i=0; i<numBotons.length ;i++ ){

//     numBotons[i].addEventListener('click', ()=>{

//     console.log("Inscripcío realitzada: " + i);

//     })

// }



function inscriu(idboto){

    console.log("id: " + idboto)

    let nom;

    var xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            myFunction(this);
        }
    };

    xhttp.open("GET", "curses.xml", true);
    xhttp.send();

    function myFunction(xml){
        var xmlDoc = xml.responseXML;
        nom = xmlDoc.getElementsByTagName("nom")[0].childNodes[0].nodeValue;
    }

    console.log(idboto + " " + nom)
}