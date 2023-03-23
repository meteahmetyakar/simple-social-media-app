package SocialMedia;
/**
 * the class of Post, it holds post, post's contents, likes, comment, etc
 * @author meteahmetyakar
 *
 */
public class Post {
    /**
     * unique post Id
     */
    private int postId;

    /**
     * account which shared the post
     */
    private Account accountId;

    /**
     * interaction limit any post can have
     */
    private final int interactionLimit = 100;

    /**
     * the likes the post has
     */
    private Like[] likes;

    /**
     * like index, it uses for reach elements of likes array
     */
    private int likeIdx;

    /**
     * the comments the post has
     */
    private Comment[] comments;

    /**
     * like index, it uses for reach elements of likes array
     */
    private int commentIdx;

    /**
     * content of post
     */
    private String content;

    /**
     * returns like index
     * @return
     * likeIdx;
     */
    public int getLikeIdx() {
        return likeIdx;
    }

    /**
     * returns comment index
     * @return
     * commentIdx
     */
    public int getCommentIdx() {
        return commentIdx;
    }

    /**
     * returns post
     * @return
     * post
     */
    public int getPostId() {
        return postId;
    }

    /**
     * returns account
     * @return
     * account
     */
    public Account getAccountId() {
        return accountId;
    }

    /**
     * returns content of post
     * @return
     * content
     */
    public String getContent() {
        return content;
    }

    /**
     * returns interaction limit of post
     * @return
     * interactionLimit
     */
    public int getInteractionLimit() {
        return interactionLimit;
    }

    /**
     * returns array of likes post have
     * @return
     * array of likes
     */
    public Like[] getLikes() {
        return likes;
    }

    /**
     * returns array of comment post have
     * @return
     * array of comment
     */
    public Comment[] getComments() {
        return comments;
    }

    /**
     * it like post with given information of like
     * @param like
     * a Like object it have information about like, accountId, interactionId, etc
     */
    public void likePost(Like like)
    {
        if(likeIdx < interactionLimit)
            likes[likeIdx++] = like;
        else
            System.out.println("reached like limit");
    }

    /**
     * it comment to post with given comment
     * @param comment
     * a Comment object, it have information about comment as content
     */
    public void commentPost(Comment comment)
    {
        if(commentIdx < interactionLimit)
            comments[commentIdx++] = comment;
        else
            System.out.println("reached comment limit");
    }

    /**
     * Post constructor
     * @param postId
     * unique postId
     * @param accountId
     * account of post
     * @param content
     * content of post
     */
    public Post(int postId, Account accountId, String content) {
        this.postId = postId;
        this.accountId = accountId;
        this.content = content;

        likes = new Like[interactionLimit];
        comments = new Comment[interactionLimit];

        likeIdx = 0;
        commentIdx = 0;

    }

    /**
     *empty no parameter constuctor
     */
    public Post() {
    }

}
