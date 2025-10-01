# 🔍 SonarCloud Quality Analysis Workshop

<div align="center">

![SonarCloud](https://sonarcloud.io/images/project_badges/sonarcloud-white.svg)

[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=RdzJJ_SonnarCloud_QA&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=RdzJJ_SonnarCloud_QA)
[![Reliability Rating](https://sonarcloud.io/api/project_badges/measure?project=RdzJJ_SonnarCloud_QA&metric=reliability_rating)](https://sonarcloud.io/summary/new_code?id=RdzJJ_SonnarCloud_QA)
[![Security Rating](https://sonarcloud.io/api/project_badges/measure?project=RdzJJ_SonnarCloud_QA&metric=security_rating)](https://sonarcloud.io/summary/new_code?id=RdzJJ_SonnarCloud_QA)

</div>

## 🎯 Objetivo del Taller

Este repositorio es un laboratorio práctico diseñado para explorar y comprender las capacidades de análisis de calidad de código que ofrece SonarCloud. A través de ejemplos intencionalmente creados, demostramos los cinco tipos principales de hallazgos que SonarCloud puede detectar:

1. 🐛 **New Issues**: Problemas recién introducidos en el código
2. 🔧 **Maintainability**: Issues relacionados con la mantenibilidad del código
3. 📑 **Duplications**: Código duplicado que puede ser refactorizado
4. 🎯 **Coverage**: Áreas del código sin cobertura de pruebas
5. ⚡ **Reliability**: Problemas que pueden causar fallos en producción

## 👥 Equipo

| Integrantes |
|-------------|
| Juan Felipe Joaqui |
| Julian Andres Rodriguez |
| Carlos Danilo Velez |

## 🛠️ Estructura del Proyecto

```
sonar-taller/
├── src/
│   ├── main/java/
│   │   └── com/example/sonar/
│   │       ├── NewIssueExample.java       # Ejemplos de nuevos issues
│   │       └── QualityIssuesExample.java  # Ejemplos de otros problemas
│   └── test/java/
│       └── com/example/sonar/
│           ├── NewIssueExampleTest.java
│           └── QualityIssuesExampleTest.java
└── pom.xml
```

## 🔍 Propósito de cada clase

- `NewIssueExample.java`: Demuestra cómo SonarCloud detecta nuevos problemas introducidos
- `QualityIssuesExample.java`: Contiene ejemplos de:
  - Métodos largos y complejos (Maintainability)
  - Código duplicado (Duplications)
  - Código propenso a errores (Reliability)
  - Métodos sin pruebas suficientes (Coverage)

## 🚀 Configuración y Uso

### Requisitos previos:

1. Crear un proyecto en SonarCloud bajo la organización `rdzjj`
2. Añadir el secret `SONAR_TOKEN` en GitHub (Settings → Secrets)
3. Verificar que el Project Key sea `RdzJJ_SonnarCloud_QA`

### Ejecutar análisis localmente:

```bash
cd sonar-taller
mvn verify
```

El reporte de cobertura se generará en `target/site/jacoco/jacoco.xml`

## 🎓 Valor Educativo

Este repositorio sirve como:
- Ejemplo práctico de análisis de calidad de código
- Guía de mejores prácticas de desarrollo
- Demostración de la importancia de las herramientas de análisis estático
- Recurso educativo para comprender problemas comunes de código

## 🔗 Enlaces Útiles

- [Documentación de SonarCloud](https://docs.sonarcloud.io/)
- [Clean Code Principles](https://www.oreilly.com/library/view/clean-code-a/9780136083238/)
- [Java Best Practices](https://www.oracle.com/java/technologies/javase/codeconventions-contents.html)

