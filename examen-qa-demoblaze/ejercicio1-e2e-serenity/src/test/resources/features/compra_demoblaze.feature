# language: es
@e2e
Característica: Compra de productos en Demoblaze
  Como cliente de Demoblaze
  Quiero comprar productos desde el carrito
  Para recibir la confirmación de mi pedido

  Antecedentes:
    Dado que Gilsoin abre la tienda Demoblaze

  @compra @smoke
  Esquema del escenario: Flujo de compra con dos productos - <caso>
    Cuando agrega al carrito los productos "<producto1>" y "<producto2>"
    Y visualiza el carrito de compras con 2 productos
    Entonces el carrito muestra los productos "<producto1>" y "<producto2>"
    Cuando completa el formulario de compra con los datos del comprador "<caso>"
    Y finaliza la compra
    Entonces la compra se confirma con el mensaje "Thank you for your purchase!"

    Ejemplos:
      | caso    | producto1         | producto2        |
      | compra1 | Samsung galaxy s6 | Nokia lumia 1520 |
      | compra2 | Nexus 6           | Sony xperia z5   |