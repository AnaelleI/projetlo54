/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.projetlo54.entity;

import javax.jms.*;
import javax.naming.NamingException;
import org.apache.activemq.ActiveMQConnectionFactory;

import org.apache.log4j.BasicConfigurator;

public class Producer {

     private String envoi="";
    private final String url = "tcp://localhost:61616";
    
    public Producer(String topicName) throws JMSException, NamingException {

    }
     
    public void setEnvoi(String msg){
        this.envoi=msg;
    }
    
    public String getEnvoi(){
        return this.envoi;
    }
    
    public void sendToTopic(String txt)throws JMSException, NamingException{
        BasicConfigurator.configure();
        // Creatng the connection
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
        Connection connection = connectionFactory.createConnection();
        //Set the ID of the subscriber
        connection.setClientID("3");
        connection.start();
        // Creating session for seding messages
        Session sessionPending = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        // Creating the topic if not existing
        Topic topic = sessionPending.createTopic("TPLO54"); 
        //Creation of a durable subscriber

        MessageProducer producer = sessionPending.createProducer(topic);
        TextMessage message = sessionPending.createTextMessage(txt);
        producer.send(message);
        System.out.println("Sent message '" + message.getText() + "'");
        if(message.getText().equals("close connection")){
            connection.close();
        }
    
    
 }
    //Exemple of use : send "hello" to the topic "coucou"
    //public static void main(String[] args) throws JMSException, NamingException{
    //    Producer p = new Producer("coucou");
    //   p.sendToTopic("hello");
    //}
}

