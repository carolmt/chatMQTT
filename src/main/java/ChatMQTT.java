/*import org.eclipse.paho.client.mqttv3.*;

import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static java.lang.Thread.sleep;
/*Habrá dos topics específicos para cada pareja de estudiantes para enviar mensajes privados. En cada topic un estudiante publicará y el otro leerá. Funcionará como
 una conversación entre dos usuarios de Whatsapp o Telegram.
El topic /chat/david/juan para los mensajes que envía David a Juan.
El topic /chat/juan/david para los mensajes que envía Juan a David.
Los dos topics forman un chat entre dos usuarios.

El programa principal realizará lo siguiente ininterrumpidamente:
Tras la recepción de cada mensaje lo guardará en un fichero que será el chat. Cada chat en un fichero diferente. Haz uso de callbacks.
Pedirá por consola un comando de los dos posibles:
Enviar un mensaje. Enviará un mensaje por el topic correspondiente.send todos hola a todos.send juan hola Juan
Ver un chat, abrirá el fichero correspondiente y mostrará todo el chat(mensajes enviados y recibidos).chat todos.chat juan*/
/*public class ChatMQTT {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String topicGeneral = "/chat/todos";

        String mqttClientId = UUID.randomUUID().toString();
        IMqttClient alumno = null;

        try {
            alumno = new MqttClient("tcp://localhost:1883", mqttClientId);
        } catch (MqttException e) {
            throw new RuntimeException(e);
        }

        MqttConnectOptions options = new MqttConnectOptions();
        options.setAutomaticReconnect(true);
        options.setCleanSession(true);
        options.setConnectionTimeout(60);

        try {
            alumno.connect(options);
        } catch (MqttException e) {
            throw new RuntimeException(e);
        }

        alumno.setCallback(new MqttCallback() {

            public void messageArrived(String topic, MqttMessage message) throws Exception {
                System.out.println("\nMensaje recivido" +
                        "\n\tHora:    " + LocalDateTime.now() +
                        "\n\tTopic:   " + topic +
                        "\n\tMensaje: " + new String(message.getPayload()) +
                        "\n\tQoS:     " + message.getQos() + "\n");
            }

            public void connectionLost(Throwable cause) {
                System.out.println("Connection to Solace broker lost!" + cause.getMessage());
            }

            public void deliveryComplete(IMqttDeliveryToken token) {
            }

        });

        try {
            alumno.subscribe(topic, 0);
        } catch (MqttException e) {
            throw new RuntimeException(e);
        }
    }

}*/
