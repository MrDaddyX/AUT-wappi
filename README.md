#INTRODUCCIÓN Proyecto en el cual se utilizan los patrones de automatización Screenplay, combinado con Cucumber y Serenity.

Las pruebas se corren contra la aplicación Chrome.

Detalles generales de la implementación:

Herramienta de automatización: Intellij IDEA Community Edition 2021.2.1 o superior.
Compilador: 1.8 JAVA
Patrón de diseño: Screenplay
Prerequisitos:

Tener instalado y verificar su funcionamiento:
Intellij IDEA Community Edition 2021.2.1 o superior.
Maven 3.8.2
Chrome versión  93.0.4577.82 si en su defecto tiene uno superior o inferior visitar: https://chromedriver.chromium.org/
La estructura completa del proyecto es:

questions: objectos usados para consultar acerca del estado de la aplicación.
tasks: clases que representan tareas que realiza el actor a nivel de proceso de negocio.
userinterfaces: Page Objects y Page Elements. Mapean los objetos de la interfaz de usuario.
utils: utilidades que se puedan reusar.

#PROYECTO AUT-wappi

Aplicación que sé está probando: Wappi Web
Lenguaje de programación: Java.
Frameworks: Selenium, JUnit y Serenity BDD.
Patrón de diseño: Screenplay.
Feature: Hecho en lenguaje Gherkin.
IDE: Intellij IDEA Community Edition.
Driver: ChromeDriver.exe Manejo de dependencias con Maven.

Para ejecutar la automatización se abre la consola en la raíz del proyecto, y se pone el comando:

mvn clean verify - esta ejecuta toda la automatizacion
mvn clean verify -Dcucumber.options="--tags @actualizar-informacion"  - este comando solo ejecuta el escenario de actualizar informacion
mvn clean verify -Dcucumber.options="--tags @pedido-de-productos"  - este comando solo ejecuta el escenario del pedido de productos

Ninguna de las pruebas necesita ajustar Data para su ejecucion, dado que se hicieron de tal forma que sea auto suficiente para ello.

Autor
Carlos Julio Piragua Perez - *Automatizador - [carlosjuliopiraguaperez@gmail.com]
