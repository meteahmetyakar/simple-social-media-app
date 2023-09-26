package SocialMedia.LDLinkedList;

/**
 * the class of comment, it holds comment informations
 * @author meteahmetyakar
 *
 */
public class Comment extends Interaction {

    /**
     * content of comment
     */
    private String content;

    /**
     * returns content
     * @return
     * content of comment
     */
    public String getContent() {
        return content;
    }

    /**
     * constructor of comment
     * @param interactionId
     * unique interaction id
     * @param accountId
     * account which interact with post
     * @param postId
     * post of interaction
     * @param content
     * content of post
     */
    public void delete()
    {
        getPostId().deleteComment(this);
    }

    public Comment(int interactionId, Account accountId, Post postId, String content) {
        super(interactionId, accountId, postId);
        this.content = content;
    }

    /**
     * empty no parameter constructor
     */
    public Comment() {
    }
}
