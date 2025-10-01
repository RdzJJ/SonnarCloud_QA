# SonnarCloud_QA

Proyecto de ejemplo para integrar con SonarCloud.

Requisitos para integrar con SonarCloud:

- Crear un proyecto en SonarCloud bajo la organización `rdzijj`.
 - Crear un proyecto en SonarCloud bajo la organización `rdzjj`.
- Añadir el secret `SONAR_TOKEN` en GitHub (Settings → Secrets) con el token de SonarCloud.
- El workflow en `.github/workflows/build.yml` ejecuta Maven y envía el análisis a SonarCloud.

Cómo probar localmente:

1. Desde la carpeta raíz del repositorio ejecutar:

	cd sonar-taller; mvn verify

Nota: Asegúrate de crear el proyecto en SonarCloud con el Project Key exacto `RdzJJ_SonnarCloud_QA` y Organization `rdzjj`.

2. Asegurarse de que el reporte JaCoCo se genere en `target/site/jacoco/jacoco.xml`.
