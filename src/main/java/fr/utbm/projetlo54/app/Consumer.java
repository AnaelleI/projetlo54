/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.projetlo54.app;

import java.util.Properties;
import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.transport.nio.SelectorManager.Listener;
import org.apache.log4j.BasicConfigurator;

public class Consumer {

// URL by default
private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;
 
//SUbject is the name of the topic
private static String subject = "Coucou";
private static String endWhile = "no";

public static void main(String[] args) throws NamingException,JMSException {
    
        
        BasicConfigurator.configure();

        // Creatng the connection
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
        Connection connection = connectionFactory.createConnection();
        //Set the ID of the subscriber
        connection.setClientID("1");
        connection.start();
        // Creating session for seding messages
        Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        // Creating the topic if not existing
        Topic topic = session.createTopic("Coucou"); 
        //Creation of a durable subscriber
        TopicSubscriber consumer = session.createDurableSubscriber(topic,"AppliJava");  
        // Waiting for the message

        endWhile="no";
        while(endWhile.equals("no")){
        Message message = consumer.receive();
        if (message instanceof TextMessage) {

            TextMessage textMessage = (TextMessage) message;
            System.out.println("Received message '" + textMessage.getText()+ "'");
            if(textMessage.getText().equals("close connection")){
                endWhile="true";
            }
        }
        }
        connection.close();
        
        
    }
}

