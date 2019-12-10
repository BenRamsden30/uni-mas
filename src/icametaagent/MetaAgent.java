/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icametaagent;

import icamessages.Message;
import java.util.*;

/**
 *
 * @author v8036651
 */
public abstract class MetaAgent implements Runnable{

    protected final String name;

    /**
     * Constructor
     */
    MetaAgent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    public abstract void sendMessage(Message m);
    public abstract Message receiveMessage();
}
