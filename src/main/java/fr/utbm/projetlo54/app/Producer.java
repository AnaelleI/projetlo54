/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.projetlo54.app;

import javax.jms.*;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import org.apache.log4j.BasicConfigurator;

public class Producer {

 public Producer(String envoi) throws JMSException, NamingException {

  

    ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_BROKER_URL);
    Connection connection = connectionFactory.createConnection();
    try {
        connection.start();
        
        Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createQueue("coucou");


        MessageProducer producer = session.createProducer(destination);

        TextMessage message = session.createTextMessage(envoi);

        producer.send(message);
        System.out.println("Sent message '" + message.getText() + "'");
    } finally {
        connection.close();
    }
 }

 public static void main(String[] args) throws JMSException {
  try {
   BasicConfigurator.configure();
   new Producer("bonjour2");
  } catch (NamingException e) {
   e.printStackTrace();
  }

 }
}