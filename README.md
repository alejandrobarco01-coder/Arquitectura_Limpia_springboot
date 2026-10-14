# Taller 6 - Clean Architecture Spring Boot

Backend Spring Boot del Taller 6. Implementa los módulos de usuarios, productos y categorías siguiendo Clean Architecture: el dominio define entidades y puertos; los casos de uso dependen de esos puertos; y la infraestructura provee datasources, adaptadores HTTP e inyección de dependencias.

## Requisitos

- JDK 21.
- No se necesita una instalación global de Gradle: se incluye el wrapper.

## Ejecución

En Windows:

```bat
gradlew.bat test
gradlew.bat bootRun
```

En macOS/Linux:

```bash
./gradlew test
./gradlew bootRun
```

La aplicación inicia en `http://localhost:8080` con el context path `/api`, definido en `src/main/resources/application.properties`.

## API

| Método | Ruta | Respuesta |
|---|---|---|
| GET | `/api/users/{countUsers}` | Lista de usuarios con `id`, `name`, `lastName`, `age`, `email`, `engineering` |
| GET | `/api/products/{countProducts}` | Lista de productos con `id`, `name`, `category`, `price` |
| GET | `/api/categories` | Catálogo fijo con `id`, `name`, `description` |

`countUsers` y `countProducts` deben ser enteros entre 1 y 1000; los valores inválidos responden HTTP 400. Las consultas correctas responden HTTP 200 y JSON.

Ejemplo de categoría:

```json
{ "id": 1, "name": "Carnes", "description": "Carnes y proteínas" }
```

El catálogo contiene Carnes, Frutas, Lacteos y Verduras, en el mismo orden y con el mismo contrato usados por Angular y Node.js.

## Swagger / OpenAPI

Con `server.servlet.context-path=/api`, las URL reales son:

- Swagger UI: `http://localhost:8080/api/swagger-ui.html` (redirige a `http://localhost:8080/api/swagger-ui/index.html`).
- Documento OpenAPI: `http://localhost:8080/api/v3/api-docs`.

## Integración con Angular

Angular usa `http://localhost:8080/api` para Spring Boot y selecciona repositorios con providers. Para alternar el backend, edita `src/environments/environment.ts` en el repositorio Angular y establece:

```ts
backend: 'node' // Node.js en http://localhost:3000/api
// o
backend: 'springboot' // Spring Boot en http://localhost:8080/api
```

No se modifican casos de uso ni páginas. Este backend permite CORS de desarrollo desde `http://localhost:4200`.

## Arquitectura

```text
src/main/java/co/edu/taller6/cleanarchitecture/
├── domain/
│   ├── model/              # Entidades y contratos JSON
│   └── repository/         # Puertos de salida
├── application/usecase/    # Casos de uso
└── infrastructure/
    ├── datasource/         # Datos en memoria
    ├── repository/         # Adaptadores de los puertos
    ├── config/AppConfig    # Raíz de composición / DI
    └── web/                # Controladores y manejo HTTP
```

## Verificación

`ApiContractTest` valida el catálogo de categorías, las propiedades que Angular requiere para usuarios y productos, y el manejo de cantidades inválidas. Ejecuta `./gradlew test` antes de entregar.

## Repositorios del taller

- Angular: https://github.com/alejandrobarco01-coder/Arquitectura_Limpia_Angular
- Node.js: https://github.com/alejandrobarco01-coder/Arquitectura_Limpia_Node
- Spring Boot: https://github.com/alejandrobarco01-coder/Arquitectura_Limpia_springboot
