/*import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;

import java.util.Scanner;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class EnvioDeMensajeMQTT {

    public void main(String[] args) {

        String publisherId = UUID.randomUUID().toString();

        IMqttClient publisher = null;

        try {
            publisher = new MqttClient("tcp://localhost:1883", publisherId);
        } catch (MqttException e) {
            throw new RuntimeException(e);
        }

        MqttConnectOptions options = new MqttConnectOptions();
        options.setAutomaticReconnect(true);
        options.setCleanSession(true);
        options.setConnectionTimeout(60);

        try {
            publisher.connect(options);
        } catch (MqttException e) {
            throw new RuntimeException(e);
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Introducir mensaje: ");
        String message = scanner.nextLine();
        System.out.println("Introducir topic: ");
        String topic = scanner.nextLine();

        try {
            ExecutorService executorService = Executors.newFixedThreadPool(5);
            Future<Boolean> result = executorService.submit(new AlumnoMQTT(publisher, message, topic));
            if (result.get()) {
                System.out.printf("MQTT message sended");
            } else {
                System.out.printf("MQTT message NOT sended");
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        try {
            publisher.disconnect();
            publisher.close();
        } catch (MqttException e) {
            throw new RuntimeException(e);
        }
    }

}*/