import org.eclipse.paho.client.mqttv3.*;
//he hecho este ejercicio con ayuda de chatgpt, no he entendido bien la programacion mqtt, aun usando los
//ejemplos del repositorio de psp no funcionaba bien, asi que he usado el codigo de chatgpt para entenderlo
//veré a ver si estos días lo comprendo mejor para las siguientes prácticas y lo hago por mi misma.

public class MQTTManager {
    private MqttClient client;

    public MQTTManager(String broker, String clientId) throws MqttException {
        this.client = new MqttClient(broker, clientId);
        connect();
    }

    public void connect() throws MqttException {
        MqttConnectOptions options = new MqttConnectOptions();
        options.setCleanSession(true);

        client.connect(options);

        // Set up callback for message arrival
        client.setCallback(new MqttCallback() {
            @Override
            public void connectionLost(Throwable cause) {
                System.out.println("Connection lost: " + cause.getMessage());
            }

            @Override
            public void messageArrived(String topic, MqttMessage message) throws Exception {
                // Handle the received message
                handleReceivedMessage(topic, message);
            }

            @Override
            public void deliveryComplete(IMqttDeliveryToken token) {
                // Not used in this example
            }
        });
    }

    public void subscribe(String topic) throws MqttException {
        client.subscribe(topic);
    }

    public void publish(String topic, String message) throws MqttException {
        client.publish(topic, new MqttMessage(message.getBytes()));
    }

    private void handleReceivedMessage(String topic, MqttMessage message) {
        // Save the received message to a file
        String fileName = topic.replace("/", "_") + ".txt"; // Use topic name for file
        FileHandler.saveToFile(fileName, message.toString());
    }

    public void disconnect() throws MqttException {
        client.disconnect();
    }
}
