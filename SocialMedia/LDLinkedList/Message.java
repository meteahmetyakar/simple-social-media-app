package SocialMedia.LDLinkedList;

/**
 * the class of message, it holds message informations
 * @author meteahmetyakar
 *
 */
public class Message {

    /**
     * unique message id
     */
    private int messageId;

    /**
     * message sender
     */
    private Account senderId;

    /**
     * message receiver
     */
    private Account receiveId;

    /**
     * content of message
     */
    private String content;

    /**
     * returns message Id
     * @return
     * messageId
     */
    public int getMessageId() {
        return messageId;
    }

    /**
     * returns sender account
     * @return
     * account
     */
    public Account getSenderId() {
        return senderId;
    }

    /**
     * returns receiver account
     * @return
     * receiver
     */
    public Account getReceiveId() {
        return receiveId;
    }

    /**
     * returns content
     * @return
     * content
     */
    public String getContent() {
        return content;
    }

    /**
     * constructor of message
     * @param messageId
     * unique message id
     * @param senderId
     * message sender
     * @param receiveId
     * message receiver
     * @param content
     * content of message
     */
    public Message(int messageId, Account senderId, Account receiveId, String content) {
        this.messageId = messageId;
        this.senderId = senderId;
        this.receiveId = receiveId;
        this.content = content;
    }

    /**
     * empty no parameter constructor
     */
    public Message() {
    }


}
