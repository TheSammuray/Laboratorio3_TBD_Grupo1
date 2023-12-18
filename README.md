INSTRUCIONES PREVIAS:

1) Se debe tener instalado mongoDB Compass como interfaz grafica de mongoDB, una vez dentro se crea una nueva base de datos con el nombre: "Sistema_Voluntarios" y dentro una nueva coleccion llamada "Voluntarios".

2) Abrimos la coleccion "Voluntarios" y dentro hacemos la importacion de los documentos que estan en el archivo "Sistema_Voluntarios.Voluntarios.json"

PARA SU USO:

1) Abrimos y ejecutamos el proyecto de Springboot

2) Abrimos postman

3) Y ahora podemos hacer uso de las 3 solicitudes disponibles:

Para obtener a todos los voluntarios:
GET http://localhost:8080/voluntarios

Para obtener el promedio de habilidades entre voluntarios:
GET http://localhost:8080/voluntarios/promedio-habilidades

Para agregar un nuevo voluntario:
POST http://localhost:8080/voluntarios
body:
{
  "nombre": "Voluntario Ejemplo",
  "latitud": 1.0,
  "longitud": 2.0,
  "habilidades": [
    {
      "codigo": "HH1",
      "descripcion": "Habilidad Ejemplo"
    }
  ]
}