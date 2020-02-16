package com.mycompany.bots.Logica;

/**
 * Clase principal encargada de crear los bots
 */
public class Bot {
    private String[] respuestas;
    private String nombreBot, nombreUsuario = "";

    public Bot(String[] respuestas, String nombreBot) {
        this.respuestas = respuestas;
        this.nombreBot = nombreBot;
    }

    /**
     * Una funcion simple para iniciar la conversacion
     *
     * @return Presentacion del bot
     */
    public String encender() {
        return "Hola yo soy " + nombreBot + " un gusto saludarte\n como te llamas?";
    }

    /**
     * Funcion principal que ejercera el bot
     *
     * @param mensaje solicitud del usuario
     * @return un mensaje para continuar la platica
     */
    public String hablar(String mensaje) {
        switch (evaluar(mensaje)) {
            case 0:
                return "Hola " + nombreUsuario + " un gusto saber de ti";
            case 1:
                return charlaRan();
            case 2:
                return "Que tengas un gran día " + nombreUsuario;
            default:
                return "Lo siento no se que tratas de decir";
        }
    }

    /**
     * Funcion para generar un poco de charla random
     *
     * @return una respuesta aleatoria
     */
    private String charlaRan() {
        return respuestas[(int) (Math.random() * respuestas.length)];
    }

    /**
     * Evalua el tipo de mensaje que mando el usuario
     *
     * @param mensaje mensaje mandado por el usuario
     * @return Regresa una respuesta posible a lo que el usuario introdujo
     */
    private int evaluar(String mensaje) {
        if (mensaje.toLowerCase().contains("hola") || mensaje.toLowerCase().contains("mucho gusto") || mensaje.toLowerCase().contains("saludos")) {
            return 0;
        } else if (mensaje.toLowerCase().contains("adios") || mensaje.toLowerCase().contains("fue un gusto") || mensaje.toLowerCase().contains("hasta luego")) {
            return 2;
        } else if (mensaje.toLowerCase().contains("como estas") || mensaje.toLowerCase().contains("que dices") || mensaje.toLowerCase().contains("habla")) {
            return 1;
        } else {
            return 3;
        }
    }


    /**
     * Funcion para conocer el nombre del bot
     *
     * @return regresa el nombre del bot
     */
    public String getNombreBot() {
        return nombreBot;
    }

    /**
     * establece eñ nombre del usuario
     *
     * @param nombreUsuario nombre con el que el bot se referira al usuario
     * @return Saludo y conformacicon de nombre
     */
    public String nombrarUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
        return "mucho gusto " + nombreUsuario + " comencemos a hablar";
    }

    public String getNombreUsuario() {
        return this.nombreUsuario;
    }
}
