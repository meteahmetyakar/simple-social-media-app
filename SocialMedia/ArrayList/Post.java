package SocialMedia.ArrayList;

import java.util.ArrayList;

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
    private ArrayList<Like> likes;

    /**
     * the comments the post has
     */
    private ArrayList<Comment> comments;


    /**
     * content of post
     */
    private String content;


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
    public ArrayList<Like> getLikes() {
        return likes;
    }

    /**
     * returns array of comment post have
     * @return
     * array of comment
     */
    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void unlikePost(Account accountId)
    {
        for(Like like : likes)
        {
            if(like.getAccountId() == accountId)
            {
                likes.remove(like);
                return;
            }
        }

        System.out.println(accountId.getUsername() + " did not like the post");

    }

    /**
     * it like post with given information of like
     * @param like
     * a Like object it have information about like, accountId, interactionId, etc
     */
    public void likePost(Like like)
    {
        if(!likes.contains(like))
            likes.add(like);
    }

    public void deleteInteractionsOf(Account accountId)
    {
        unlikePost(accountId);

        for(int i=0; i< comments.size(); i++)
            if(comments.get(i).getAccountId() == accountId)
                comments.get(i).delete();
    }

    public void deleteComment(Comment commentId)
    {
        if(comments.contains(commentId))
            comments.remove(commentId);
        else
            System.out.println(commentId.getAccountId().getUsername() + "did not comment the post");

    }

    /**
     * it comment to post with given comment
     * @param comment
     * a Comment object, it have information about comment as content
     */
    public void commentPost(Comment comment)
    {
        comments.add(comment);
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

        likes = new ArrayList<>();
        comments = new ArrayList<>();
    }

    /**
     *empty no parameter constuctor
     */
    public Post() {
    }

}
