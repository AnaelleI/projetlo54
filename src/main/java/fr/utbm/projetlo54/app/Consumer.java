/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.projetlo54.app;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.jms.*;
import javax.naming.NamingException;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.log4j.BasicConfigurator;

public class Consumer {

// URL by default
private static final String url = ActiveMQConnection.DEFAULT_BROKER_URL;
 
//SUbject is the name of the topic
private static final String subject = "TPLO54";
private static String endWhile = "no";

public static void main(String[] args) throws  IOException,NamingException,JMSException {
    
        
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
        Topic topic = session.createTopic(subject); 
        //Creation of a durable subscriber
        TopicSubscriber consumer = session.createDurableSubscriber(topic,"AppliJava");  
        //Check if the file already exists
        //If not, we create one else we append to the existing one and insert new line
        FileWriter logFile;
        File log= new File("LogFile.txt");
        if(!log.exists()){
            logFile = new FileWriter("LogFile.txt");
        }
        else logFile = new FileWriter("LogFile.txt",true);
        logFile.write(System.getProperty("line.separator"));
        
        // Waiting for the message

        endWhile="no";
        while(endWhile.equals("no")){
        Message message = consumer.receive();
        if (message instanceof TextMessage) {

            TextMessage textMessage = (TextMessage) message;
            System.out.println("Received message '" + textMessage.getText()+ "'");
            //write the message and \n in the log file
            logFile.write(textMessage.getText());
            logFile.write(System.getProperty("line.separator"));
            if(textMessage.getText().equals("close connection")){
                endWhile="true";
            }
        }
        }
        logFile.close();
        connection.close();
        
        
    }
}

