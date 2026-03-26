Feature: Compra de productos
  Como cliente de la tienda
  Quiero comprar productos desde el carrito
  Para completar una transacción exitosa

  # Este flujo es crítico para el negocio, ya que fallas en el proceso de compra
  # pueden generar pérdida de ventas y afectar la experiencia del usuario.

  @ComprarProducto @NivelRiesgoCritico
  Scenario: Realizar compra de un producto
    Given que el usuario tiene productos en el carrito
    And se encuentra logueado en la plataforma
    When procede a realizar la compra
    Then el sistema debe confirmar que la compra fue exitosa