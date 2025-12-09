# gha-microservices

Proyecto de microservicios con integración continua usando GitHub Actions y Java 21.

## 📋 Descripción

Este proyecto implementa un pipeline de CI/CD automatizado para construir y empaquetar microservicios Java utilizando Gradle y GitHub Actions.

## 🚀 Pipeline CI/CD

El pipeline se ejecuta automáticamente en cada `push` al repositorio y realiza los siguientes pasos:

### 1. **Checkout del código**
```yaml
uses: actions/checkout@8e8c483db84b4bee98b60c0593521ed34d9990e8
```
- Descarga el código fuente del repositorio
- Utiliza la versión 6.0.1 de checkout

### 2. **Configuración de JDK 21**
```yaml
uses: actions/setup-java@f2beeb24e141e01a676f977032f5a29d81c9e27e
```
- Instala Java Development Kit versión 21
- Distribución: Temurin (Eclipse Adoptium)

### 3. **Permisos de ejecución**
```bash
chmod +x gradlew
```
- Otorga permisos de ejecución al wrapper de Gradle

### 4. **Construcción del proyecto**
```bash
./gradlew build
```
- Compila el código fuente
- Ejecuta las pruebas unitarias
- Genera el archivo `.jar` en `build/libs/`

### 5. **Subida del artefacto**
```yaml
uses: actions/upload-artifact@330a01c490aca151604b8cf639adc76d48f6c5d4
```
- Sube el archivo `.jar` generado como artefacto
- Nombre del artefacto: `microservice-jdk21-cicd`
- Ubicación: `build/libs/*.jar`

## 📦 Resultado

Al finalizar el pipeline, el archivo `.jar` del microservicio estará disponible en la sección de **Artifacts** de la ejecución del workflow en GitHub Actions.

## 🛠️ Tecnologías

- **Java**: 21 (Temurin)
- **Build Tool**: Gradle
- **CI/CD**: GitHub Actions
- **Runner**: Ubuntu Latest

## 📥 Descargar el JAR

1. Ve a la pestaña **Actions** en GitHub
2. Selecciona la ejecución del workflow
3. Descarga el artefacto `microservice-jdk21-cicd`
4. Extrae el archivo `.jar` del ZIP descargado
