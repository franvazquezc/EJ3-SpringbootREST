# Ejercicio Entregable N3 de Arquitecturas Web:

## Integrantes:
- Ezequiel Enrique Buzzella (ezequiel.buzzella@gmail.com).
- Javier Ignacio Agüera Martin (nacho.aguera.martin@hotmail.com).
- Sebastian Ulibarri (sebastiannahuelulibarri@gmail.com).
- Francisco Vazquez (frvazquez@alumnos.exa.unicen.edu.ar)

## Servicios:

### Dar de alta un Alumno:

**Método:** `POST`  
**Endpoint:** `/alumno`  
**Body (JSON): Alumno**

#### Ejemplo:
- **POST** http://localhost:8080/alumno
- **En Body -> raw -> JSON:**
```json
{
  "dni": 45678901,
  "lu": 200,
  "nombre": "María",
  "apellido": "Gómez",
  "edad": 21,
  "genero": "F",
  "ciudadResidencia": "Tandil"
}
```

### Matricular un alumno en una carrera:

**Método:** `POST`  
**Endpoint:** `/alumno/matricularAlumno`  
**Body (JSON): Alumno**

#### Ejemplo:
- **POST** http://localhost:8080/alumno/matricularAlumno
- **En Body -> raw -> JSON:**
```json
{
  "dniAlumno": 10719241,
  "idCarrera": 2
}
```

### Recuperar a todos los estudiantes:

**Método:** `GET`  
**Endpoint:** `/alumnos`  

#### Ejemplo:
- **GET** http://localhost:8080/alumnos

### Recuperar un alumno en base a su libreta universitaria:

**Método:** `GET`  
**Endpoint:** `/alumno/lu/{lu}`  

#### Ejemplo:
- **GET** http://localhost:8080/alumno/lu/72976

### Recuperar alumnos en base a su genero:

**Método:** `GET`  
**Endpoint:** `/alumnos/genero/{genero}`  

#### Ejemplo:
- **GET** http://localhost:8080/alumnos/genero/Male

### Recuperar carreras con estudiantes inscriptos ordenadas por cantidad de inscriptos:

**Método:** `GET`  
**Endpoint:** `/carrera/OrderByAlumnos`  

#### Ejemplo:
- **GET** http://localhost:8080/carrera/OrderByAlumnos

### Recuperar los estudiantes de una determinada carrera filtrando por ciudad de residencia:

**Método:** `GET`  
**Endpoint:** `/alumnoscarrera?id={idCarrera}&ciudad={ciudadResidencia}` 

#### Ejemplo:
- **GET** http://localhost:8080/alumnos/carrera?id=6&ciudad=Lyamino

### Reporte:

**Método:** `GET`  
**Endpoint:** `/carreras/reporte` 

#### Ejemplo:
- **GET** http://localhost:8080/carreras/reporte
