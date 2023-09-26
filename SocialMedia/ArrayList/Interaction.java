package SocialMedia.ArrayList;

/**
 * the class holds interaction information
 * @author meteahmetyakar
 *
 */
public class Interaction {

    /**
     * unique interaction id
     */
    private int interactionId;

    /**
     * account which interact with post
     */
    private Account accountId;

    /**
     * post of interaction
     */
    private Post postId;

    /**
     * returns interactionId
     * @return
     * interactionId
     */
    public int getInteractionId() {
        return interactionId;
    }

    /**
     * returns account which interact with post
     * @return
     * account
     */
    public Account getAccountId() {
        return accountId;
    }

    /**
     * returns post with interacted
     * @return
     * post
     */
    public Post getPostId() {
        return postId;
    }

    /**
     * constructor of interaction
     * @param interactionId
     * unique interaction id
     * @param accountId
     * account which interact with post
     * @param postId
     * post of interaction
     */
    public Interaction(int interactionId, Account accountId, Post postId) {
        this.interactionId = interactionId;
        this.accountId = accountId;
        this.postId = postId;
    }

    /**
     * empty no parameter constructor
     */
    public Interaction() {
    }
}
