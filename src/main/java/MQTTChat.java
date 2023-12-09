import org.eclipse.paho.client.mqttv3.MqttException;

import java.util.Scanner;

public class MQTTChat {
    public static void main(String[] args) {
        try {
            String broker = "tcp://localhost:1883";
            String clientId = "MessengerApp";
            String generalTopic = "/chat/todos";

            MQTTManager mqttManager = new MQTTManager(broker, clientId);
            mqttManager.subscribe(generalTopic);

            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("Ingrese un comando ('send' o 'chat'):");
                String command = scanner.next();

                if (command.equals("send")) {
                    System.out.println("Ingrese el destinatario y el mensaje (ej. 'todos Hola a todos'):");
                    String recipient = scanner.next();
                    String message = scanner.nextLine().trim();
                    String topic = "/chat/" + recipient;

                    mqttManager.publish(topic, message);
                } else if (command.equals("chat")) {
                    System.out.println("Ingrese el destinatario (ej. 'todos' o 'juan'):");
                    String recipient = scanner.next();
                    String fileName = recipient.equals("todos") ? "/chat/todos.txt" : "/chat/" + recipient + ".txt";

                    String chatContent = FileHandler.readFromFile(fileName);
                    System.out.println("Chat con " + recipient + ":\n" + chatContent);
                } else {
                    System.out.println("Comando no reconocido. Inténtelo de nuevo.");
                }
            }
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }
}
