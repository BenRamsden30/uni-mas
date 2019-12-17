/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icamonitors;

import icamessages.Message;
import java.util.Observable;

/**
 *
 * @author v8036651
 */
public class CMDMonitor extends Monitor
{
    /**
     * A name of the agent must be passed as it says which agent the monitor is on,
     * this is to compare the intended recipient and the actual,
     * requires a message to be passed for the output.
     * @param name 
     */
    public CMDMonitor(String name) 
    {
        super(name);
    }
    
    /**
     * Method to output to the command line showing the name of the sender, the
     * name of the recipient, the actual recipient, the message type and the
     * message details when a message is received.
     */
    @Override
    public void ReceivedMessage (Message message)
    {
        System.out.println("+==========================================+");
        System.out.println("|This message was sent from:               |");
        System.out.println("|" + message.getSender());
        System.out.println("|This message was received by:             |");
        System.out.println("|" + agentName);
        System.out.println("|This message was meant to be received by: |");
        System.out.println("|" + message.getRecipient());
        System.out.println("|This message type is:                     |");
        System.out.println("|" + message.getMessageType());
        System.out.println("|The contents of the message is:           |");
        System.out.println("|" + message.getMessageDetails());
        System.out.println("+==========================================+");
    }
    
    /**
     * Method to output to the command line showing the name of the sender, the
     * name of the intended sender, the intended recipient, the message type and the
     * message details when a message is sent.
     */
    @Override
    public void SentMessage (Message message)
    {
        System.out.println("+==========================================+");
        System.out.println("|This message was sent from:               |");
        System.out.println("|" + agentName);
        System.out.println("|This message is meant to be sent from:    |");
        System.out.println("|" + message.getSender());
        System.out.println("|This message is meant to be received by:  |");
        System.out.println("|" + message.getRecipient());
        System.out.println("|This message type is:                     |");
        System.out.println("|" + message.getMessageType());
        System.out.println("|The contents of the message is:           |");
        System.out.println("|" + message.getMessageDetails());
        System.out.println("+==========================================+");
    }

    /**
     * Update method which shows the sender and recipient then the agent it is attached to.
     * @param o
     * @param message 
     */
    @Override
    public void update(Observable o, Object message) 
    {
        this.ReceivedMessage((Message)message);
    }
}

//1234567890
//1234567890
//1234567890
//1234567890
//1234
//PrintF length 44