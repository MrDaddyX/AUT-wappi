#language: es
#Author: carlosjuliopiraguaperez@gmail.com
@pedido-de-productos
Característica: Verificar pedido de productos
  Como Analista de calidad deseo verificar el correcto funcionamiento del aplicativo web de
  wappi en su modulo de pedido de productos

  Antecedentes:
    Dado que el analista accede al aplicativo web

  @pedido-de-productos-resumen
  Escenario: Como analista de calidad deseo validar el resumen del pedido
    Cuando hace un pedido del producto '1' y 'valida el resumen'
    Entonces podra ver que 'los datos son correctos'

  @pedido-de-productos-completo
  Escenario: Como analista de calidad deseo validar el correcto funcionamiento del pedido en el modulo mis pedidos
    Cuando hace un pedido del producto '1' y 'lo completa exitosamente'
    Entonces podra ver que 'los datos en mis pedidos son correctos'

  @pedido-de-productos-cupon
  Escenario: Como analista de calidad deseo validar el correcto funcionamiento del cupon con caracteristica de solo 2 usos
    Cuando hace un pedido de 3 productos con el cupon de bienvenida
    Entonces podra ver que 'al momento de hacer el 3er pedido saldra el mensaje de error informando que el cupon no esta disponible'