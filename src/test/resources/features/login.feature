@ModuloLogin
Feature: Inicio de sesión del cliente
  Como cliente registrado de la tienda
  Quiero iniciar sesión en la plataforma con mis credenciales
  Para acceder a mi cuenta de forma segura o recibir un mensaje si hay errores con el intento de acceso

 # Nota: Este flujo es crítico para el negocio, ya que fallas en el inicio de sesión
  # pueden generar pérdida de ventas y afectar la experiencia del usuario.

  @LoginCredencialesCorrectas @NivelRiesgoCritico
  Scenario: Iniciar sesión con credenciales correctas
    Given que el usuario ingresa al sitio web de Bon Bonite
    And se registra en la plataforma
    When cierra sesion
    And vuelve a iniciar sesion
    Then  el sistema debe mostrar un mensaje de bienvenida

  @LoginCredencialesIncorrectas @NivelRiesgoCritico
  Scenario: Intentar iniciar sesión con credenciales inválidas
    Given que el usuario ingresa al sitio web de Bon Bonite
    When el usuario ingresa credenciales incorrectas
    Then el sistema debe mostrar un mensaje de error de autenticación
    |Nombre de usuario o contraseña inválidos. Recuperar contraseña|