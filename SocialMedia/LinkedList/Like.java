package SocialMedia.LinkedList;

/**
 * the class of like, it holds like informations
 * @author meteahmetyakar
 *
 */
public class Like extends Interaction {

    /**
     * constructor of like
     * @param interactionId
     * unique interaction id
     * @param accountId
     * account which interact with post
     * @param postId
     * post of interaction
     */
    public Like(int interactionId, Account accountId, Post postId) {
        super(interactionId, accountId, postId);
    }

    /**
     * empty no parameter constructor
     */
    public Like() {
    }
}
