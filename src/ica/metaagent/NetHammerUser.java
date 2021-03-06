package ica.metaagent;

import ica.messages.Message;
import ica.messages.MessageType;
import java.util.ArrayList;

/**
 *
 * @author v8073331
 */
public class NetHammerUser extends MetaAgent {

    public Portal connection;

    private ArrayList<Long> times;

    /**
     * Constructor for a user, Draws from the super class of MetaAgent.
     *
     * @param name the name of the user agent
     * @param portal the link to the portal which the agent should be connected
     * to
     * @author v8036651
     */
    public NetHammerUser(String name, Portal portal) {
        super(name);
        connection = portal;
        times = new ArrayList<>();
    }

    /**
     * This function is used to display incoming message. Since user agent
     * should not forward any messages, if the recipient is invalid, an error
     * message is sent back to the sender, and the message is discarded.
     *
     * @param agent the source of the message which is being received.
     * @param msg the message to be processed.
     * @author v8073331
     */
    @Override
    public void messageHandler(MetaAgent agent, Message msg) {
        if (msg.getRecipient().equals(this.name) && msg.getMessageType().equals(MessageType.USER_MSG)) {
            times.add(System.currentTimeMillis() - Long.decode(msg.getMessageDetails()));
        } else {
            System.out.println("Error: " + msg.getMessageDetails());
        }
    }

    /**
     * Returns the Average time that it took NetHammer to submit all messages in
     * milliseconds.
     *
     * @return average time for all messages in milliseconds
     */
    public long getAverageTime() {
        int all = 0;
        for (Long l : times) {
            all += l;
        }
        return (!times.isEmpty()) ? all / times.size() : 0;
    }

    /**
     * Returns the Minimum time that it took NetHammer to submit all messages in
     * milliseconds.
     *
     * @return minimum time for fastest message in milliseconds.
     */
    public long getMinTime() {
        long lowest = Long.MAX_VALUE;
        for (Long l : times) {
            if (l < lowest) {
                lowest = l;
            }
        }
        return lowest;
    }

    /**
     * Returns the Maximum time that it took NetHammer to submit the slowest
     * message in milliseconds.
     *
     * @return maximum time for slowest message in milliseconds.
     */
    public long getMaxTime() {
        long longest = Long.MIN_VALUE;
        for (Long l : times) {
            if (l > longest) {
                longest = l;
            }
        }
        return longest;
    }
}
