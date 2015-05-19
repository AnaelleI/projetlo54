/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.projetlo54.app;

import javax.jms.*;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.log4j.BasicConfigurator;

public class Consumer {

// URL by default
private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;
 
//SUbject is the name of the topic
private static String subject = "coucou";


public static void main(String[] args) throws JMSException {
    
    while(true){
        BasicConfigurator.configure();

        // Creatng the connection
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
        Connection connection = connectionFactory.createConnection();
        connection.start();

        // Creating session for seding messages
        Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);

        // Getting the queue

        Destination destination = session.createQueue(subject);
        // Waiting for the message
        MessageConsumer consumer = session.createConsumer(destination);
        Message message = consumer.receive();
        if (message instanceof TextMessage) {

            TextMessage textMessage = (TextMessage) message;
            System.out.println("Received message '" + textMessage.getText()+ "'");
        }
        connection.close();
        }
    }
}

