Feature: Carrito de compras
  Como cliente de la tienda
  Quiero agregar productos al carrito
  Para poder comprarlos posteriormente

  # Este flujo es crítico para el negocio, ya que cualquier fallo en el carrito
  # puede impedir la intención de compra del usuario y afectar directamente las ventas.

  @AgregarProducto @NivelRiesgoCritico
  Scenario: Agregar un producto al carrito
    Given que el usuario visualiza un producto
    When agrega el producto al carrito
    Then el sistema debe reflejar el producto en el carrito de compras