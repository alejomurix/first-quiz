Basados en OWASP Top 10, enumero las indicaciones para tener en cuenta en la seguridad del sistema: 

A1 – Para evitar fallos en control de acceso, implementar en la API: 
•	Control de sesiones por tokens.
•	Tiempos de vida de sesiones.
•	Control de acceso basado en roles, ya que contamos con usuarios administrativos, atención al cliente y de ventas.
•	Evitar al máximo la exposición de identificadores en URL.
•	Monitorización de la aplicación.

A2 – Evitar fallas criptográficas.
•	Todas las contraseñas deben estar cifradas, incluyendo la de acceso a base de datos, mediante el uso de librerías de algoritmos actuales y seguros.
•	Almacenamiento en Secrets Manager de la configuración de acceso a la base de datos.
•	Verificación de protocolos actuales y seguros en los contenedores de kubernetes.

A3 – Evitar inyecciones SQL.
•	A nivel de código, si se usa consultas SQL planos a base de datos implementar dichas consultas con parámetros, si es usa ORM implementar un constructor de consultas para no usar SQL directamente.
•	A nivel de front-end validar fuertemente cada campo para que evite caracteres especiales, con longitud establecida y sea homogéneo al tipo de dato que recibe cada campo.

A4 – Verificación del diseño, teniendo en cuenta que el sistema ya está implementado, procedo a realizar verificaciones en el diseño y operación en búsqueda de fallas que expongan vulnerabilidades y sus respectivas correcciones en el software o componentes del mismo.
•	Evaluación de arquitectura en seguridad y sus pruebas.
•	Gestión de incidentes y operativos. 

A7 – Fallas de identificación y autenticación.
•	Implementación de verificación multifactor en los clientes web y móvil.
•	Auditoria de credenciales de usuarios débiles que puedan ser vulneradas o de fácil reconocimiento.
•	Validación en el servidor se sesiones duplicadas, impedir que las sesiones se dupliquen, sean únicas por usuario.
•	Establecer funcionalidad de recuperación de credenciales, mediante verificación multifactor.


A8 – Fallas de Integridad de software y datos. 
Implementaciones en los siguientes ámbitos:
•	Verificar la confiabilidad de los repositorios de las dependencias de las aplicaciones, web, móvil y API, sino cumplen o son dudosas buscar su cambio o actualización. 
•	Control de acceso a los Pipelines o ubicar los mismos en entornos aislados.
•	Implementación de revisión de cambios en el código y en artefactos. 


A9 – Fallas de monitoreo y registro de seguridad
Para evitar estas fallas se implementa:
•	Monitoreo, registro y alertas por SMS, email u otro medio, a los inicios de sesión fallidos en 3 oportunidades consecutivas; a los inicios de sesión exitosos de un mismo usuario en un lapso no mayor a 10 min. Monitoreo, registro y alertas por SMS a las fallas por autorización.
•	Registro en logs de los siguientes eventos:
o	Fallas de validación de entrada, o posibles intentos de inyección en la API.
o	Fallas en la gestión de las sesiones.
o	Errores en las aplicaciones o eventos del sistema.
•	De preferencias los logs deben ser almacenados en una ubicación distinta al servidor de aplicaciones.
•	La información de los log deberán tener el siguiente formato
o	Fecha y hora
o	Identificación del host de donde proviene el evento, IP, URL y método HTTP.
o	Identificación del usuario o equipo.
o	Descripción del evento 

A10 – Falsificación de solicitudes del lado del servidor (SSRF)
Para evita falsificación en las solicitudes implementaría lo siguiente:
•	Validación de los esquemas URL HTTPS, denegando otros diferentes, ftp, dict, etc.
•	Deshabilitar redireccionamiento HTTP.
•	Validación de datos de entrada en los clientes web y móvil. 
