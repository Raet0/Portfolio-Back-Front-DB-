## 1. Logo de la Carrera y del Proyecto

Ejemplo:


<div align="center">
  <img src="https://www.ups.edu.ec/documents/20121/77326/Isotipo+Original.png/48fb2ada-b4e7-09df-b45a-884cda62cc9b?version=1.0&t=1620746533255&imagePreview=1"
       width="100" alt="UPS Logo">
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/spring/spring-original.svg"
       width="100" alt="Spring Boot Logo">
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/angular/angular-original.svg"
       width="100" alt="Angular Logo">
</div>


---

## 2. Autores

**Rafael Prieto**
📧 pprietos@est.ups.edu.ec

💻 Github: [Raet0](https://github.com/Raet0)

**Adrian Lazo**
📧 blazoc@est.ups.edu.ec

💻 Github: [scomygod](https://github.com/scomygod)

---

Repositorio principal:

* https://github.com/Raet0/Portfolio-Back-Front-DB-.git

---

## 3. Tecnologias Utilizadas

Badges:

![Angular](https://img.shields.io/badge/Angular-20.3-red)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4.2-brightgreen)
![Java](https://img.shields.io/badge/Java-21-orange)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-DB-blue)
![JWT](https://img.shields.io/badge/JWT-Auth-black)
![Tailwind CSS](https://img.shields.io/badge/TailwindCSS-4.x-38bdf8)
![DaisyUI](https://img.shields.io/badge/DaisyUI-UI-ff69b4)
![Cloudinary](https://img.shields.io/badge/Cloudinary-Images-0f6bdc)
![Docker](https://img.shields.io/badge/Docker-Container-2496ed)

### Angular + Spring Boot + PostgreSQL

* Angular 20 para el frontend (standalone components, rutas y guards)
* Spring Boot 3 para el backend REST
* PostgreSQL como base de datos (Spring Data JPA)
* Seguridad con Spring Security + JWT
* Autenticacion con Google (OAuth) en el backend y boton Google en frontend
* Cloudinary para carga de imagenes (perfil y proyectos)
* Tailwind CSS + DaisyUI para UI

### Herramientas de soporte

* OpenAPI/Swagger UI para documentacion
* OpenPDF y Apache POI para reportes PDF y Excel
* Dockerfile en backend y frontend

---

## 4. Descripcion del Proyecto

El Portafolio Administrativo es una plataforma web para gestionar perfiles de programadores, proyectos y solicitudes de asesorias. Los administradores gestionan usuarios y generan reportes; los programadores administran su perfil, proyectos y disponibilidad, y aprueban o rechazan asesorias; los usuarios solicitan asesorias y consultan su estado. El frontend consume una API REST protegida con JWT.

### Descripcion tecnica del backend y su integracion

* Backend en Spring Boot 3.4.2 con Java 21 y Gradle.
* Persistencia con Spring Data JPA sobre PostgreSQL.
* Seguridad con Spring Security + JWT (Bearer token en `Authorization`).
* Autenticacion Google (endpoint `/api/auth/google`).
* Reportes PDF (OpenPDF) y Excel (Apache POI).
* Swagger/OpenAPI disponible en `/swagger-ui.html`.
* CORS configurable con `app.cors.allowed-origins`.
* Integracion con frontend Angular via `API_BASE_URL`.

### Documentacion de endpoints REST

#### Autenticacion

* `POST /api/auth/login` - login con email y password.
* `POST /api/auth/register-admin` - registrar primer admin (solo una vez).
* `POST /api/auth/google` - login con Google (idToken).

#### Usuarios (perfil)

* `GET /api/users/me` - perfil del usuario autenticado.
* `PUT /api/users/me` - actualizar perfil del usuario autenticado.

#### Administracion (solo ADMIN)

* `POST /api/admin/users` - crear usuario.
* `GET /api/admin/users?page=&size=` - listar usuarios.
* `PUT /api/admin/users/{id}` - editar usuario.
* `DELETE /api/admin/users/{id}` - eliminar usuario.

#### Reportes (solo ADMIN)

* `GET /api/reports/advisories?from=&to=&status=` - resumen de asesorias.
* `GET /api/reports/projects` - resumen de proyectos activos.
* `GET /api/reports/advisories/pdf` - PDF de asesorias.
* `GET /api/reports/projects/excel` - Excel de proyectos.

#### Programador (solo PROGRAMMER)

* `GET /api/programmer/me` - perfil del programador.
* `PUT /api/programmer/profile` - actualizar perfil del programador.
* `POST /api/programmer/projects` - crear proyecto.
* `GET /api/programmer/projects` - listar proyectos propios.
* `PUT /api/programmer/projects/{id}` - editar proyecto.
* `DELETE /api/programmer/projects/{id}` - eliminar proyecto.
* `POST /api/programmer/availability` - agregar disponibilidad.
* `GET /api/programmer/availability` - listar disponibilidad.
* `DELETE /api/programmer/availability/{id}` - eliminar disponibilidad.
* `GET /api/programmer/advisories` - listar asesorias recibidas.
* `PATCH /api/programmer/advisories/{id}` - actualizar estado/response.
* `GET /api/programmer/advisories/requester` - asesorias del usuario autenticado.

#### Publico

* `GET /api/programmers?page=&size=` - listar programadores.
* `GET /api/programmers/{id}` - detalle de programador.
* `GET /api/programmers/{id}/projects` - proyectos publicos.
* `GET /api/programmers/{id}/availability` - disponibilidad publica.
* `POST /api/advisories` - crear asesoria.
* `GET /api/advisories?email=` - listar asesorias por email.

---

## 5. Roles y Funcionalidades

### Administrador

* Crear, editar y eliminar usuarios
* Listar usuarios con paginacion
* Reportes de asesorias (PDF) y proyectos (Excel)
* Filtros por fechas y estado de asesorias

### Programador

* Gestion de perfil (especialidad, descripcion, habilidades, redes sociales, foto)
* Gestion de proyectos (CRUD)
* Gestion de disponibilidad (CRUD)
* Aprobacion o rechazo de asesorias y respuesta

### Usuario General

* Solicitar asesorias a programadores
* Ver disponibilidad y perfiles publicos
* Consultar estado de sus solicitudes
* Editar perfil basico (nombre, foto, bio)

---

## 6. Modulos y Pantallas del Sistema

* Landing: pagina principal del portafolio
* Profiles: lista publica de programadores
* Perfil publico de programador: detalle, proyectos y disponibilidad
* Login: acceso con credenciales o Google
* Register: crear primer administrador
* Admin Dashboard: gestion de usuarios y reportes
* Panel de Programador: perfil, proyectos, disponibilidad y asesorias
* Panel de Usuario: agenda de asesorias y estado de solicitudes
* Perfil de usuario: edicion de datos basicos y foto
* Notificaciones: avisos basados en estado de asesorias

---

## 7. Flujos Principales del Usuario

* Inicio de sesion con email/password o Google. El backend emite JWT y el frontend lo guarda en `localStorage`.
* El usuario selecciona un programador, revisa disponibilidad y crea una asesoria. La solicitud se guarda en PostgreSQL.
* El programador revisa asesorias pendientes y cambia su estado a APROBADA o RECHAZADA.
* El usuario ve el estado en su panel y en la pantalla de notificaciones.
* Las imagenes de perfil/proyecto se suben a Cloudinary y se guarda la URL en la base de datos.

Nota: No se utiliza Firebase en este proyecto.

---

## Guia de usuario para administradores y programadores

### Administradores

1. Iniciar sesion mediante un POST directamente.
2. Entrar a `Admin Dashboard`.
3. Crear usuarios indicando nombre, email, password y rol.
4. Editar o eliminar usuarios desde la lista.
5. Generar reportes y descargar PDF/Excel.

### Programadores

1. Iniciar sesion en `/login`.
2. Entrar al `Panel de Programador`.
3. Completar perfil, habilidades, redes y foto.
4. Crear y actualizar proyectos.
5. Definir disponibilidad semanal.
6. Revisar asesorias pendientes y aprobar/rechazar.

---

## 8. Fragmentos Tecnicos Importantes

**JWT en frontend (headers de autorizacion)**

```ts
getAuthHeaders(): HttpHeaders {
  const token = this.currentUserSignal()?.token;
  return token ? new HttpHeaders({ Authorization: `Bearer ${token}` }) : new HttpHeaders();
}
```

**Upload de imagenes a Cloudinary**

```ts
const formData = new FormData();
formData.append('file', file);
formData.append('upload_preset', environment.cloudinaryUploadPreset);

await fetch(`https://api.cloudinary.com/v1_1/${environment.cloudinaryCloudName}/image/upload`, {
  method: 'POST',
  body: formData,
});
```

**Seguridad en backend (JWT + rutas publicas)**

```java
.requestMatchers("/api/auth/**").permitAll()
.requestMatchers("/api/programmers/**").permitAll()
.requestMatchers("/api/advisories/**").permitAll()
.anyRequest().authenticated();
```

**Descarga de reportes (PDF/Excel) desde frontend**

```ts
return this.http.get(`${API_BASE_URL}/api/reports/advisories/pdf`, {
  headers: this.auth.getAuthHeaders(),
  params,
  responseType: 'blob',
});
```

---

## 9. Conclusiones

* Se implemento un sistema completo de portafolios con roles claros y reportes administrativos.
* Se integraron autenticacion JWT, Google OAuth y carga de imagenes en la nube.
* Como mejora futura, se puede ampliar el modulo de notificaciones con un endpoint dedicado para respuestas y lectura.

El proyecto permitió desarrollar una aplicación web completa que integra un frontend en Angular y un backend en Spring Boot, aplicando una arquitectura basada en roles, controladores REST y seguridad mediante JWT. La separación entre funcionalidades públicas, privadas y administrativas facilita el control de accesos y la organización del sistema.

Se implementaron flujos funcionales como la gestión de perfiles, proyectos, disponibilidad y asesorías, además de la generación de reportes, mostrando un enfoque práctico orientado a un escenario real. Como mejora futura, se puede reforzar la validación en el backend, mejora de UI/UX orientado al usuario, consolidando aún más la robustez del sistema.
