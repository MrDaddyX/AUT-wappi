#language: es
#Author: carlosjuliopiraguaperez@gmail.com
@actualizar-informacion
Característica: Verificar la actualizacion de informacion
  Como Analista de calidad deseo verificar el correcto funcionamiento del aplicativo web de
  wappi en su modulo de actualizar informacion

  Antecedentes:
    Dado que el analista accede al aplicativo web

  @actualizar-informacion-exitosa
  Escenario: Como analista de calidad deseo validar el modulo de actualizar informacion de manera exitosa
    Cuando desea hacer el actualizado de informacion 'de manera correcta'
    Entonces podra ver 'el mensaje Tu información se guardó correctamente'

  @actualizar-informacion-campos-inicializados
  Escenario: Como analista de calidad deseo validar que al ingresar al modulo de actualizar informacion este tenga campos inicializados
    Cuando desea hacer el actualizado de informacion 'para validar los datos inicializados'
    Entonces podra ver 'que los campos estan inicializados correctamente'

  @actualizar-informacion-campos-obligatorios
  Escenario: Como analista de calidad deseo validar que en el modulo de actualizar informacion todos los campos sean obligatorios para actualizar informacion
    Cuando desea hacer el actualizado de informacion 'validando que los campos sean obligatorios'
    Entonces podra ver 'los mensajes de error de los campos obligatorios'