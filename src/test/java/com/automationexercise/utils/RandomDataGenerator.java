package com.automationexercise.utils;

import net.datafaker.Faker;

import java.util.Locale;

/**
 * Clase encargada de la generación de datos aleatorios para
 * pruebas automatizadas de formularios de registro.
 */
public class RandomDataGenerator {

    private static final Faker faker = new Faker(new Locale("es"));
    private static String passwordAlmacenado;

    /**
     * Genera un número de cédula aleatorio (8 a 10 dígitos).
     */
    public static String generateID() {
        return faker.number().digits(10);
    }

    /**
     * Genera un nombre aleatorio.
     */
    public static String generarFirstName() {
        return faker.name().firstName();
    }

    /**
     * Genera un apellido aleatorio.
     */
    public static String generateLastName() {
        return faker.name().lastName();
    }

    /**
     * Genera un numero de telefono aleatorio.
     */
    public static String generatePhoneNumber() {
        return faker.phoneNumber().phoneNumber();
    }

    /**
     * Genera un correo electrónico con formato válido.
     */
    public static String generateEmail() {
        return faker.internet().emailAddress();
    }

    /**
     * Genera una contraseña segura y la almacena temporalmente
     * para permitir la validación del campo 'confirmación'.
     */
    public static String generatePassword() {
        passwordAlmacenado = faker.internet().password(8, 12, true, true, true);
        return passwordAlmacenado;
    }
}