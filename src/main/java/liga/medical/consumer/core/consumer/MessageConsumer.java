package liga.medical.consumer.core.consumer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class MessageConsumer {
    Logger logger = Logger.getLogger(String.valueOf(MessageConsumer.class));

    @Autowired
    AmqpTemplate template;

    @RabbitListener(queues = "daily_queue")
    public void dailyListener(String message) {
        logger.info(String.format("Daily. Message: %s", message));
    }

    @RabbitListener(queues = "alert_queue")
    public void alertListener(String message) {
        logger.info(String.format("Alert. Message: %s", message));
    }

    @RabbitListener(queues = "error_queue")
    public void errorListener(String message) {
        logger.info(String.format("Error. Message: %s", message));
    }


}