# Prueba Técnica - Vermont Solutions

## Observaciones y Decisiones de Diseño

### Uso de Base de Datos H2
- **Elección de Base de Datos:** Se optó por una base de datos H2 en memoria para simplificar el proceso de desarrollo y pruebas. Esta elección permite una configuración y un despliegue rápidos, ideales para el contexto de una prueba técnica.

### Gestión de Autenticación
- **Ambigüedad en el Ejercicio 1:** 
  - **Problema:** El enunciado presentaba ambigüedad en la inicialización de la base de datos sin contraseñas.
  - **Solución:** Se añadió un campo 'password' al modelo de usuario para facilitar la verificación de credenciales en el endpoint `/api/login` POST.
  - **Resultado:** Esta implementación se alinea con los requisitos de autenticación descritos y garantiza una gestión de usuarios eficaz.

### Gestión de Tokens
- **Implementación de TokenManager:**
  - **Decisión:** Se implementó una solución simplificada para la gestión de tokens, utilizando una clase `TokenManager`, y evitando el uso de Spring Security.
  - **Justificación:** Dada la escala del proyecto, la integración completa de Spring Security fue considerada excesiva.

### Pruebas de Integración con POSTMAN
- **Flujo de Autenticación:**
  - **Método:** Uso de POSTMAN para enviar el token JWT como un header de autorización.
  - **Endpoints Probados:** `/api/login` para la obtención del token, seguido por `/api/users` para la autorización y acceso a los datos.

### Manejo de Archivos en el Ejercicio 2
- **Desarrollo de FileController:**
  - **Funcionalidad:** Asignación de timestamps únicos a los archivos subidos para evitar duplicidad.
  - **Servicio Asíncrono:** Uso de `AsyncFileService` para asegurar una gestión eficiente y cumplir con los requisitos de procesamiento asíncrono.

