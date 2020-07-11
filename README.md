##Desafio Hotel

This project was generated with Spring Initializr version 2.3.1.

##Requirements

This project need Java version 11.

API Rest

#Hospede Service
Url: http://localhost:8090/hospedes
Method allowed: POST
Body:
	{
		"nomeHospede" : "teste",
		"documentoHospede" : "712315151",
		"telefoneHospede" : "479996-5478",	
		"hospedado" : "S"
	}

Url: http://localhost:8090/hospedes/{idHospede}
Method allowed: GET

Url: http://localhost:8090/hospedes
Method allowed: PUT
Body:
{
  "idHospede": {idHospede},
  "nomeHospede": "teste",
  "documentoHospede": "712315151",
  "telefoneHospede": "479996-5478",  
  "hospedado": "N"
}

Url: http://localhost:8090/hospedes/name-doc-phone
Method allowed: GET
Body:
{  
  "nomeHospede": "Felipe" 
}
Or
{  
  "documentoHospede": "712315151" 
}
Or
{  
  "telefoneHospede": "479996-5478" 
}


#CheckIn Service
Url: http://localhost:8090/checkin/
Method allowed: POST
Body:
{
	"idHospede" : {idHospede},
	"dataEntrada" : "2020-07-11T08:00:00",
	"dataSaida" : "2020-07-12T10:17:00",
	"veiculo" : true,
	"finalizado" : "N",
	"gastosHospede" : 100.00 
}

Url: http://localhost:8090/checkin/{idCheckin}
Method allowed: GET

Url: http://localhost:8090/checkin
Method allowed: PUT
Body:
{
  "idCheckin": {idCheckin},
  "idHospede": {idHospede},
  "dataEntrada": "2020-07-11T08:00:00",
  "dataSaida": "2020-07-12T10:17:00",
  "veiculo": true,
  "finalizado": "N",
  "gastosHospede": 100.0
}

Url: http://localhost:8090/checkin/hospedes-checkin
Method allowed: GET

  
