/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.projetlo54.entity;

import javax.jms.*;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import org.apache.log4j.BasicConfigurator;

public class Producer {

    private static String envoi="";
    private ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_BROKER_URL);
    private Connection connection = connectionFactory.createConnection();
    private Session session;
    private Destination destination;
    
    
    public Producer(String topic) throws JMSException, NamingException {
        this.connection.start();
        this.session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        this.destination = session.createQueue(topic);
    }
     
    public void setEnvoi(String msg){
        this.envoi=msg;
    }
    
    public String getEnvoi(){
        return this.envoi;
    }
    
    public void sendToTopic(String txt)throws JMSException, NamingException{
        
    try {

        MessageProducer producer = session.createProducer(destination);

        TextMessage message = session.createTextMessage(txt);

        producer.send(message);
        System.out.println("Sent message '" + message.getText() + "'");
        if(message.getText().equals("close connection")){
            connection.close();
        }
    }catch(Exception e){
        e.printStackTrace();
    }
    
    
    
 }
    //Exemple of use : send "hello" to the topic "coucou"
    //public static void main(String[] args) throws JMSException, NamingException{
    //    Producer p = new Producer("coucou");
    //   p.sendToTopic("hello");
    //}
}
