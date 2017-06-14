
function displayRecensioni(data) {
    var r = document.getElementById("todo");

    while (r.firstChild)r.removeChild(r.firstChild);
    
        if (data.length>0) {
        var myObject = JSON.parse(data);
      
            var table = document.createElement("TABLE");
           // table.className="col-md-7 col-sm-7";
            
            var tr = document.createElement("TR");
            
            var col_Id = document.createElement("TH");
            col_Id.className="col-lg-1";
            col_Id.textContent="id_rec";
            
            var col_user = document.createElement("TH");
            col_user.className="col-lg-1";
            col_user.textContent="utente";
            
            var col_date = document.createElement("TH");
            col_date.className="col-lg-1";
            col_date.textContent="data";
            
            var col_title = document.createElement("TH");
            col_title.className="col-lg-1";
            col_title.textContent="titolo";
            
            var col_text = document.createElement("TH");
            col_text.className="col-lg-1";
            col_text.textContent="testo";
            
            var col_titlegame = document.createElement("TH");
            col_titlegame.className="col-lg-1";
            col_titlegame.textContent="title game";
            
            var col_accept = document.createElement("TH");
            col_accept.className="col-lg-1";
            col_accept.textContent=" ";
            
            var col_decline = document.createElement("TH");
            col_decline.className="col-lg-1";
            col_decline.textContent=" ";
            
            
            table.appendChild(tr);
            tr.appendChild(col_Id);
            tr.appendChild(col_user);
            tr.appendChild(col_date);
            tr.appendChild(col_title);
            tr.appendChild(col_text);
            tr.appendChild(col_titlegame);
            tr.appendChild(col_accept);
            tr.appendChild(col_decline);
            
          
            for(i=0; i<myObject.length;++i) {
                  var item = myObject[i];
                  
                  
                var th1 = document.createElement("td");
                th1.textContent = item.id_recensione;
                
                 var th2 = document.createElement("TD");
                th2.textContent = item.username;
                
                 var th3 = document.createElement("TD");
                th3.textContent = item.dataInserimentoRecensione;
                
                 var th4 = document.createElement("TD");
                th4.textContent = item.titoloRecensione;
                
                 var th5 = document.createElement("TD");
                th5.textContent = item.testo;
                
                 var th10 = document.createElement("TD");
                th10.textContent = item.titologiocorec;
                
                 var th6 = document.createElement("button");
               
                th6.type="button";
                th6.value=item.id_recensione;
                th6.className="bg-primary";
                th6.textContent="accept";
                th6.onclick= function () {
                                            approvaRecensione(this.value);
                                            };
                
                
                var th7 = document.createElement("button");
                th7.onclick= function () {
                                            cancellaRecensione(this.value);
                                            };
               
                th7.value=item.id_recensione;
                th7.type="button";
                th7.className="bg-primary";
                th7.textContent="decline";
                
                
                var th8 = document.createElement("td");
                th8.appendChild(th6);
                var th9 = document.createElement("td");
                th9.appendChild(th7);
                var trb = document.createElement("tr");
                trb.appendChild(th1);
                trb.appendChild(th2);
                trb.appendChild(th3);
                trb.appendChild(th4);
                trb.appendChild(th5);
                trb.appendChild(th10);
                trb.appendChild(th8);
                trb.appendChild(th9);

            table.appendChild(trb);
            }
        r.appendChild(table);
    }else
    alert("vuotoo");
}



function approvaRecensione(id_rec){
    
    var req = createRequest();
    req.open("GET","/ERAMOProject/BackOffice?action=rec&id=" + id_rec,false);
    req.send(null);
    
    if ( req.readyState === 4 && req.status=== 200) {
        
            var jsondata = req.responseText;
      alert(jsondata + "ok approvata");
            displayRecensioni(jsondata);
            
    } else {
        //in caso di errore...
        //if there has been an error...
        alert("Data transfer error");
       return new Array();
   
}
}




function showRec() {
    alert("show rec") ;
    var data = getRecensioni();
    alert("data") ;
    displayRecensioni(data);
    alert("display rec") ;
   // setTimeout(update,2000);
}




function getRecensioni(){
    var req = createRequest();
    req.open("GET","/ERAMOProject/BackOffice?action=rec",false);
    req.send(null);

    if ( req.readyState === 4 && req.status === 200) {
        
            var jsondata = req.responseText;
      
            return jsondata;
    } else {
        //in caso di errore...
        //if there has been an error...
        alert("Data transfer error");
       return new Array();
    }
}


    function createRequest() {
       
            var ACTIVEXIDs=["MSXML2.XmlHttp.6.0","MSXML2.XmlHttp.3.0"];
            if (typeof XMLHttpRequest !== "undefined") {
                return new XMLHttpRequest();
            } else if (typeof ActiveXObject !== "undefined") {
                for (var i=0; i < ACTIVEXIDs.length; i++) {
                    try {
                        return new ActiveXObject(ACTIVEXIDs[i]);
                    } catch (oError) {
                    //l'oggetto richiesto non esiste: proviamo il successivo
                    //the requested object does not exist: try the next one
                    }
                }
                alert("XMLHttpRequest could not be created");
            } else {
                alert("XMLHttpRequest could not be created");
            }
            return null;
}    




/*trofei*/


function getTrofei(){
        var req = createRequest();
        req.open("GET","/ERAMOProject/BackOffice?action=trofei",false);
        
        req.send(null);

        if ( req.readyState === 4 && req.status === 200) {
        
            var jsondataTrofei = req.responseText;
            return jsondataTrofei;
        } else {
            alert("Data transfer error");
            return new Array();
        }
    
}
function showTrofei(){
    var datatrofei = getTrofei();
    displayTrofei(datatrofei);
}






function displayTrofei(data) {
    var r = document.getElementById("todo");

    while (r.firstChild)r.removeChild(r.firstChild);
    
        if (data.length>0) {
        var myObject = JSON.parse(data);
      
            var table = document.createElement("TABLE");
            
            
            var tr = document.createElement("TR");
            
            var col_id_trofeo = document.createElement("TH");
            col_id_trofeo.className="col-lg-2";
            col_id_trofeo.textContent="id_trofeo";
            
            var col_id_imm = document.createElement("TH");
            col_id_imm.className="col-lg-2";
            col_id_imm.textContent="id_immagine";
            
            var col_Id = document.createElement("TH");
            col_Id.className="col-lg-2";
            col_Id.textContent="nome";
            
            var col_date = document.createElement("TH");
            col_date.className="col-lg-2";
            col_date.textContent="immagine";
            
            var col_title = document.createElement("TH");
            col_title.className="col-lg-2";
            col_title.textContent="titolo";
            
            var col_select = document.createElement("TH");
            col_select.className="col-lg-2";
            col_select.textContent=" seleziona ";
            
            
            table.appendChild(tr);
             tr.appendChild(col_id_trofeo);
            tr.appendChild(col_id_imm);
            tr.appendChild(col_Id);
            tr.appendChild(col_date);
            tr.appendChild(col_title);
            tr.appendChild(col_select);
            
            
          
            for(i=0; i<myObject.length;++i) {
                  var item = myObject[i];
                  
                 var th0 = document.createElement("TD");
                th0.textContent = item.id_trofeo;
                  
                var th1 = document.createElement("TD");
                th1.textContent = item.immagine.id_immagine;
                
                var th2 = document.createElement("td");
                th2.textContent = item.nome;
                              
                var th3 = document.createElement("TD");
                 
                var imm = document.createElement("img");
                imm.src = item.immagine.path;
                imm.className="col-md-8 col-lg-8 img-circle img-responsive";
                
                 var th4 = document.createElement("TD");
                th4.textContent = item.immagine.titolo;
                
                
                var th6 = document.createElement("button");
               
                th6.type="button";
                th6.value=item.id_trofeo;
                th6.className="bg-primary";
                th6.textContent="select";
                th6.onclick=function(){showTrofeo(this.value);};
                
                
                
                var th8 = document.createElement("td");
                th8.appendChild(th6);
                th3.appendChild(imm);
                
                
                var trb = document.createElement("tr");
                trb.appendChild(th0);
                trb.appendChild(th1);
                trb.appendChild(th2);
                trb.appendChild(th3);
                trb.appendChild(th4);
                trb.appendChild(th8);

            table.appendChild(trb);
            }
        r.appendChild(table);
    }else
    alert("vuotoo");
}


function showTrofeo(id){
    
    var  trofeo = getTrofeo(id);
    displayTrofeo(trofeo);
}
function getTrofeo(idtr){
    var req = createRequest();
    
    req.open("GET","/ERAMOProject/BackOffice?action=trofei&id=" + idtr,false);
    req.send(null);

        if ( req.readyState === 4 && req.status === 200) {
        
            var jsondataTrofei = req.responseText;
            
            return jsondataTrofei;
        } else {
            alert("Data transfer error");
            return new Array();
        }
}
function displayTrofeo(data){
    
    var r = document.getElementById("todo");
    while (r.firstChild)r.removeChild(r.firstChild);
        r.className="col-md-3 col-lg-3 ";
        if (data.length>0) {
        var myObject = JSON.parse(data);
       var item = myObject;
            var table = document.createElement("TABLE");
            table.className="table table-user-information";
        var tr0 = document.createElement("TR");
            var td00 = document.createElement("td");
                td00.textContent="id_trofeo";
            var td01 = document.createElement("td");
                td01.textContent=item.id_trofeo;
           
           
           
       
        var tr1 = document.createElement("TR");
            var td10 = document.createElement("td");
                td10.textContent="id_immagine";
            var td11 = document.createElement("td");
                td11.textContent=item.immagine.id_immagine;
        /*continua*/        
        
        var tr2 = document.createElement("TR");
            var td20 = document.createElement("td");
                td20.textContent="nome";
            var td21 = document.createElement("td");
                td21.textContent=item.nome;
                
        var tr3 = document.createElement("TR");
            var td30 = document.createElement("td");
                td30.textContent="immagine";
            var td31 = document.createElement("td");
               
        
            var td31imm = document.createElement("img");
                td31imm.src=item.immagine.path;
                td31imm.className="col-md-8 col-lg-8 img-circle img-responsive";  
        var tr4 = document.createElement("TR");
            var td40 = document.createElement("td");
                td40.textContent="titolo";
            var td41 = document.createElement("td");
                td41.textContent=item.immagine.titolo;
        
            
        
        
            td31.appendChild(td31imm);
            tr0.appendChild(td00);
            tr0.appendChild(td01);
            tr1.appendChild(td10);
            tr1.appendChild(td11);   
            tr2.appendChild(td20);
            tr2.appendChild(td21);
            tr3.appendChild(td30);
            tr3.appendChild(td31);
            tr4.appendChild(td40);
            tr4.appendChild(td41);
            table.appendChild(tr0);
            table.appendChild(tr1);
            table.appendChild(tr2);
            table.appendChild(tr3);
            table.appendChild(tr4);
 
        r.appendChild(table);
        
            
            
         
           
    }else
    alert("vuotoo");

}

function deleteTrofei(){
    
     var datatrofei = getTrofei();
     displayDeleteTrofei(datatrofei);
    
}



function displayDeleteTrofei(data) {
    var r = document.getElementById("todo");

    while (r.firstChild)r.removeChild(r.firstChild);
    
        if (data.length>0) {
        var myObject = JSON.parse(data);
      
            var table = document.createElement("TABLE");
            
            
            var tr = document.createElement("TR");
            
            var col_id_trofeo = document.createElement("TH");
            col_id_trofeo.className="col-lg-2";
            col_id_trofeo.textContent="id_trofeo";
            
            var col_id_imm = document.createElement("TH");
            col_id_imm.className="col-lg-2";
            col_id_imm.textContent="id_immagine";
            
            var col_Id = document.createElement("TH");
            col_Id.className="col-lg-2";
            col_Id.textContent="nome";
            
            var col_date = document.createElement("TH");
            col_date.className="col-lg-2";
            col_date.textContent="immagine";
            
            var col_title = document.createElement("TH");
            col_title.className="col-lg-2";
            col_title.textContent="titolo";
            
            var col_select = document.createElement("TH");
            col_select.className="col-lg-2";
            col_select.textContent=" cancella ";
            
            
            table.appendChild(tr);
             tr.appendChild(col_id_trofeo);
            tr.appendChild(col_id_imm);
            tr.appendChild(col_Id);
            tr.appendChild(col_date);
            tr.appendChild(col_title);
            tr.appendChild(col_select);
            
            
          
            for(i=0; i<myObject.length;++i) {
                  var item = myObject[i];
                  
                 var th0 = document.createElement("TD");
                th0.textContent = item.id_trofeo;
                  
                var th1 = document.createElement("TD");
                th1.textContent = item.immagine.id_immagine;
                
                var th2 = document.createElement("td");
                th2.textContent = item.nome;
                              
                var th3 = document.createElement("TD");
                 
                var imm = document.createElement("img");
                imm.src = item.immagine.path;
                imm.className="col-md-8 col-lg-8 img-circle img-responsive";
                
                var th4 = document.createElement("TD");
                th4.textContent = item.immagine.titolo;
                
                
                var th6 = document.createElement("button");
               
                th6.type="button";
                th6.value=item.id_trofeo;
                th6.className="bg-primary";
                th6.textContent="delete";
                th6.onclick=function(){deleteTrofeo(this.value);};
                
                
                
                var th8 = document.createElement("td");
                th8.appendChild(th6);
                th3.appendChild(imm);
                
                
                var trb = document.createElement("tr");
                trb.appendChild(th0);
                trb.appendChild(th1);
                trb.appendChild(th2);
                trb.appendChild(th3);
                trb.appendChild(th4);
                trb.appendChild(th8);

            table.appendChild(trb);
            }
        r.appendChild(table);
    }else
    alert("vuotoo");
}
function deleteTrofeo(idtr){
    
    var req = createRequest();
    var url = "/ERAMOProject/BackOffice?action=deletetrofeo"+"&n=" + idtr ;
    
    
    alert(url);
    req.open("GET",url,false);
    
    req.send(null);

        if ( req.readyState === 4 && req.status === 200) {
        
            var jsondataTrofei = req.responseText;
           
            return jsondataTrofei;
        } else {
            alert("Data transfer error");
            return new Array();
        }
    
}

    function invio(nomegioco){
        alert(nomegioco);
      //  var req = createRequest();
           
        req.open("GET","/ERAMOProject/Classifica?title=" + nomegioco , false);
        
        req.send(null);

    if ( req.readyState === 4 && req.status=== 200) {
            var jsondata = req.responseText;
            alert(jsondata );
    } else {
        alert("Data transfer error");
        return new Array();
   }
}