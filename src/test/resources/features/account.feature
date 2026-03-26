@ModuloMiCuenta
Feature: Creación y actualización de cuenta del cliente
  Como cliente de la tienda
  Quiero poder crear una cuenta y actualizar mis datos personales
  Para gestionar mi información y realizar compras en línea correctamente

  # Nota: Este flujo es crítico para el negocio, ya que fallas en el registro o actualización
  # pueden generar pérdida de ventas y afectar la reputación de la empresa.

  @CrearCuenta @NivelRiesgoCritico
  Scenario: Un visitante nuevo crea su cuenta y queda registrado en el sitio
    Given que el usuario ingresa al sitio web de Bon Bonite
    When el usuario se registra con datos válidos
    Then  el sistema debe mostrar un mensaje de bienvenida

  @ModificarCuenta @NivelRiesgoCritico
  Scenario: Modificar datos del usuario registrado
    Given que el usuario ingresa al sitio web de Bon Bonite
    And se registra en la plataforma
    When actualiza su información personal
    Then el sistema debe guardar los cambios correctamente
    And se muestra el mensaje de exito
      |Datos personales actualizados correctamente|


