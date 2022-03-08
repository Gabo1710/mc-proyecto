# PROYECTO BOT INGENIERÍA DE SOFTWARE

*AUTORES*:

	-Miranda Velarde Flavio Gabriel
	-Moya Vargas Mauro Adolfo
	-Valda Gutiérrez Moises Carlos

## Introducción

Este documento describe la necesidad del desarrollo de un bot para Consultas permisos de estudiantes de la Universidad Católica Boliviana, especificamente en el **Área de información sobre sus materias** y contactos ya que al principio del semestre existe algunos problemas de comunicacion al **Agregar a los alumnos a los grupos de whatsapp o telegram, además de problemas de confusión de horarios**, **ubicación de aulas o el saldo de las pensiones o del seguro universitario.** Además la implementación de un apartado donde los estudiantes puedan **pedir permisos en caso de que tuvieran que ausentarse de alguna materia.**

La Universidad Catolica Boliviana cuenta con sistemas informáticos como el sistema academico o NEO que proveen a los alumnos de la información necesaria para su asistencia a clases pero esta se encuentra dispersa entre estos sistemas y a la hora de buscarla puede llegar a ser tedioso o confuso, especialmente para los nuevos estudiantes
por lo cual el desarrollo de un bot que brinde ésta información podría ser una herramienta bastante util para los alumnos.

## Problemática

La Universidad Católica no cuenta con un sistema o una plataforma que contenga toda al información previamente mencionada, entonces los alumnos necesitan conocer:

1. El link al grupo de Whatsapp, telegram o Videollamadas.
2. El horario del actual semestre.
3. El aula de una materia en específico.
4. Saldo de pensiones o seguro.
5. Pedir permisos via bot y notificar si se aprueba o no.

El desarrollo puede llegar a tener en cuenta los siguientes problemas:

- A veces los docventes pueden llegar a no subir ningún link de la materia.
- Los horarios y ubicación de aulas puede llegar a cambiar de forma espontánea.
- Se requiere una notificación en caso de permiso y la imagen del respectivo justificativo.
- Se requiere una advertencia en caso de que un permiso sea solicitado fuera del tiempo permitido.

Valor que el proyecto aporta 

Intangible: los estudiantes tendran mas seguridad y eficacia al tener un facil acceso a su informacion

Ejemplo de Funcionamiento:

Menu

	Est: hola
	Bot: hola, selecciona una opcion:
		1. Solicitar links de la materia
		2. IInformacion sobre horario y aulas
		3. Informacions sobre saldo
		4. Solicitar permiso
	sELECCION OPCION 1
	Est: 1
	Bot: Ingrese las siglas de su materia
	Est: Sis 123
	Bot: Su docente puso el siguiente link de la materia ¨www.whatsapp.com¨	
	Bot: Que desea hacer?
		1 Volver
		2 Consultar por otra materia.




