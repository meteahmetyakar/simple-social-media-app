package SocialMedia.LinkedList;

import java.util.LinkedList;

/**
 * the class in which the controls of the account are provided
 * @author meteahmetyakar
 *
 */
public class Account {

    private int accountId;
    private String username;
    private String birthdate;
    private String location;

    private LinkedList<String> history;

    /**
     * it holds account's posts
     *
     */
    private LinkedList<Post> posts;

    private int messageId;

    /**
     * it holds account's inbox messages
     *
     */
    private LinkedList<Message> inbox;

    /**
     * it holds account's outbox messages
     *
     */
    private LinkedList<Message> outbox;


    /**
     * it holds account's followings
     *
     */
    private LinkedList<Account> following;


    /**
     * it holds account's followers
     *
     */
    private LinkedList<Account> followers;

    /**
     * it holds accounts which blocked by account
     *
     */
    private LinkedList<Account> blockedAccounts;


    private final int historyLimit = 100;

    /**
     * account limit that can be created
     */
    private final int accountLimit = 20;
    /**
     * message limit that can be sent
     */
    private final int messageLimit = 100;
    /**
     * post limit that can be share
     */
    private final int postLimit = 100;

    /**
     * with this, login operations are checked
     */
    private boolean isLoggedIn;


    /**
     * it returns following accounts
     * @return following
     */
    public LinkedList<Account> getFollowing() {
        return following;
    }

    /**
     * it returns follower accounts
     * @return followers
     */
    public LinkedList<Account> getFollowers() {
        return followers;
    }

    /**
     * it returns shared posts
     * @return posts
     */
    public LinkedList<Post> getPosts() {
        return posts;
    }

    /**
     * it returns accountId
     * @return accountId
     */
    public int getAccountId() {
        return accountId;
    }

    /**
     * it returns account's username
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * it returns account's birthdate;
     * @return birthdate
     */
    public String getBirthdate() {
        return birthdate;
    }

    /**
     * it returns account's location
     * @return location
     */
    public String getLocation() {
        return location;
    }


    /**
     * it returns blocked accounts
     * @return blockedAccounts
     */
    public LinkedList<Account> getBlockedAccounts() {
        return blockedAccounts;
    }

    /**
     * it is check if is current account online
     * @return true if account is online, otherwise false
     */
    private boolean isLoggedIn() {
        if(!isLoggedIn)
        {
            System.out.println(username + " is not logged in");
            System.out.println();
        }
        return isLoggedIn;
    }

    /**
     * login process an account
     * @param accounts
     * with this parameter, it checks is anybody online on it
     */
    public void login(LinkedList<Account> accounts)
    {
        boolean isAnybodyOnline = false;

        for(Account account : accounts)
            if(account.isLoggedIn)
                isAnybodyOnline = true;

        if(!isAnybodyOnline)
        {
            isLoggedIn = true;
            System.out.println(username + " logged in");
            history.add("You logged in");
        }
        else
            System.out.println("someone else is online");

        System.out.println();
    }

    /**
     * logout process an account
     */
    public void logout()
    {
        if(!isLoggedIn())
            return;

        isLoggedIn = false;
        history.add("You logout");
        System.out.println(username + " is logout");
        history.clear();
    }

    /**
     * add a post to account
     * @param content
     * content of post
     */
    public void addPost(String content)
    {
        if(!isLoggedIn())
            return;


        Post post = new Post(Math.abs(content.hashCode()), this, content);
        posts.add(post);

        System.out.println(this.getUsername() + " has shared a post");
        history.add("You shared a post (Post Id: " + post.getPostId()+ " )");

    }

    /**
     * follow given account
     * @param accountId
     * account which following by current object
     */
    public void follow(Account accountId)
    {
        if(!isLoggedIn())
            return;

        if(username == accountId.getUsername())
        {
            System.out.println("you cannot follow own");
            history.add("You tried follow own.");
            return;
        }

        boolean isAlreadyFollowed = false;

        /* it checks if is given account already followed */
        for(Account ac : following)
            if(ac.getUsername() == accountId.getUsername())
                isAlreadyFollowed = true;

        if(!isAlreadyFollowed)
        {
            accountId.addFollower(this);
            following.add(accountId);
            history.add("You followed to " + accountId.getUsername());
            System.out.println(this.getUsername() + " followed to " + accountId.getUsername());
        }
        else
        {
            history.add("you tried to follow an account you followed before");
            System.out.println("you are already following this account");
        }

    }

    /**
     * adding a follower to given account
     * @param accountId
     * account which will follow itself
     */
    private void addFollower(Account accountId)
    {
        followers.add(accountId);
    }

    public void unfollow(Account accountId)
    {
        if(following.remove(accountId))
        {
            accountId.getFollowers().remove(this);
            System.out.println("unfollowed");
            history.add("You unfollowed " + accountId.getUsername());
        }
    }

    /**
     * view profile given account
     * @param accountId
     * account which will view
     */
    public void viewProfile(Account accountId)
    {
        if(!isLoggedIn())
            return;

        if(!isAccessible(accountId))
        {
            System.out.println("Profile cannot view, " + this.getUsername() + " is blocked by " + accountId.getUsername());
            history.add("You tried to view a profile that blocked you");
            return;
        }

        history.add("You viewed " + accountId.getUsername() +"'s profile");

        System.out.println();
        System.out.println("PROFILE");
        System.out.println("-------------------------------------");

        System.out.println("User ID: " + accountId.getAccountId());
        System.out.println("Username: " + accountId.getUsername());
        System.out.println("Location: " + accountId.getLocation());
        System.out.println("Birth date: " + accountId.getBirthdate());
        System.out.println(accountId.getUsername() + " is following " + (accountId.getFollowing().size()) + " account (s) "
                + " and has " + (accountId.getFollowers().size()) + " follower (s).");
        System.out.println();

        if(!accountId.getFollowing().isEmpty())
        {
            System.out.print(accountId.getUsername() + " is following:  ");
            for(Account ac : accountId.getFollowing())
                System.out.print(ac.getUsername() + ", ");
        }
        else
            System.out.print("no following");

        System.out.println();

        if(!accountId.getFollowers().isEmpty())
        {
            System.out.print(accountId.getUsername() + " is follower:  ");
            for(Account ac : accountId.getFollowers())
                System.out.print(ac.getUsername() + ", ");
        }
        else
            System.out.print("no follower");

        System.out.println();
        System.out.println();



        System.out.println(accountId.getUsername() + " has " + (accountId.getPosts().size()) + " posts.");
        System.out.println("-------------------------------------");

    }

    /**
     * view posts given account
     * @param accountId
     * account which will view
     */
    public void viewPosts(Account accountId)
    {
        if(!isLoggedIn())
            return;

        if(!isAccessible(accountId))
        {
            System.out.println("Posts cannot view, " + this.getUsername() + " is blocked by " + accountId.getUsername());
            history.add("You tried to view posts of an account that blocked you");
            return;
        }

        history.add("You viewed " + accountId.getUsername() +"'s posts");

        System.out.println();
        System.out.println("POSTS");
        System.out.println("---------------------------------");

        for(Post post : accountId.posts)
        {
            System.out.println("(PostID: "+post.getPostId()+")  " + post.getAccountId().getUsername() + ":  " + post.getContent());
            System.out.println("---------------------------------");
        }

        System.out.println();
    }

    public void viewInteractions(Account accountId)
    {
        if(!isLoggedIn())
            return;

        if(!isAccessible(accountId))
        {
            System.out.println("Interactions cannot view, " + this.getUsername() + " is blocked by " + accountId.getUsername());
            history.add("You tried to view Interactions of an account that blocked you");
            return;
        }

        history.add("You viewed " + accountId.getUsername() + "'s interactions");

        System.out.println();
        System.out.println("POSTS");
        System.out.println("---------------------------------");

        for(Post post : accountId.getPosts())
        {
            System.out.println("(PostID: "+post.getPostId()+")  " + post.getAccountId().getUsername() + ":  " + post.getContent());

            if(post.getLikes().size() == 0)
                System.out.println("The post has no likes.");
            else
            {
                System.out.print("The post was liked by the following account (s) : ");
                for(Like like : post.getLikes())
                    System.out.print(like.getAccountId().getUsername() + ", ");
                System.out.println();
            }

            if(post.getComments().size() == 0)
                System.out.println("The post has no comments.");
            else
            {
                System.out.println("The post has " + post.getComments().size() + " comment (s)...");
                for(int commentIdx=0; commentIdx<post.getComments().size(); commentIdx++)
                    System.out.print("Comment " + (commentIdx+1) + ": '" + post.getComments().get(commentIdx).getAccountId().getUsername() + "' said '" + post.getComments().get(commentIdx).getContent() + "'");
                System.out.println();
            }
            System.out.println();
            System.out.println("---------------------------------");
        }

        System.out.println();
    }

    /**
     * sending message to receive account
     * @param receiveId
     * account to message
     * @param content
     * content of message
     */
    public void sendMessage(Account receiveId, String content) {
        if (!isLoggedIn())
            return;

        if (!isAccessible(receiveId)) {
            System.out.println("message could not be sent, " + this.getUsername() + " is blocked by " + receiveId.getUsername());
            history.add("You tried to sent a message to account that blocked you");
            return;
        }


        Message message = new Message(hashCode(), this, receiveId, content);
        receiveId.addMessageToInbox(message);
        this.addOutbox(message);
        System.out.println(this.getUsername() + " sent a message to " + receiveId.getUsername());
        history.add("You sent a message to " + receiveId.getUsername());


    }

    /**
     * it is add given message to inbox of current account
     * @param message
     * message which will add
     */
    private void addMessageToInbox(Message message)
    {
        inbox.add(message);
    }

    /**
     * it is adds given message to outbox of current account
     * @param message
     * message which will add
     */
    private void addOutbox(Message message)
    {
        outbox.add(message);
    }




    public void unlike(Post postId)
    {
        if(!isLoggedIn())
            return;

        history.add("You tried unlike " + postId.getAccountId().getUsername() + "'s post id : " + postId.getPostId());
        postId.unlikePost(this);

    }

    /**
     * it adds like to given post
     * @param postId
     * the id of the post to be liked
     */
    public void addLike(Post postId) {
        if (!isLoggedIn())
            return;

        Like like = new Like(hashCode(), this, postId);
        postId.likePost(like);
        System.out.println(this.getUsername() + " liked " + postId.getAccountId().getUsername() + "'s post");
        history.add("You likes " + postId.getAccountId().getUsername() + "'s post id : " + postId.getPostId());

    }

    /**
     * writes the number of messages the outbox contains
     */
    public void checkOutbox() {
        if (!isLoggedIn())
            return;

        history.add("You checked outbox");
        System.out.println("There is/are " + outbox.size() + " message (s) in the outbox");
        System.out.println();
    }

    /**
     * writes messages information the outbox contains
     */
    public void viewOutbox()
    {
        if(!isLoggedIn())
            return;

        history.add("You viewed outbox");
        System.out.println(username + "'s outbox");
        System.out.println("--------------------------------");
        for(int idx=0; idx<outbox.size(); idx++)
        {
            System.out.println("Message ID: " + outbox.get(idx).getMessageId());
            System.out.println("From: " + outbox.get(idx).getSenderId().getUsername());
            System.out.println("To: " + outbox.get(idx).getReceiveId().getUsername());
            System.out.println("Message: " + outbox.get(idx).getContent());

            System.out.println("\n");
        }

    }

    /**
     * writes the number of messages the inbox contains
     */
    public void checkInbox()
    {
        if(!isLoggedIn())
            return;

        history.add("You checked inbox");
        System.out.println("There is/are " + inbox.size() + " message (s) in the inbox");
        System.out.println();
    }

    /**
     * writes messages information the inbox contains
     */
    public void viewInbox()
    {
        if(!isLoggedIn())
            return;

        history.add("You viewed inbox");
        System.out.println(username + "'s inbox");
        System.out.println("--------------------------------");
        for(int idx=0; idx<inbox.size(); idx++)
        {
            System.out.println("Message ID: " + inbox.get(idx).getMessageId());
            System.out.println("From: " + inbox.get(idx).getSenderId().getUsername());
            System.out.println("To: " + inbox.get(idx).getReceiveId().getUsername());
            System.out.println("Message: " + inbox.get(idx).getContent());

            System.out.println("\n");
        }

    }

    /**
     * add comment to given post
     * @param postId
     * post to add comment
     * @param content
     * content of comment
     */
    public void addComment(Post postId, Comment comment) {
        if (!isLoggedIn())
            return;

        postId.commentPost(comment);
        System.out.println(this.getUsername() + " comment to " + postId.getAccountId().getUsername() + "'s post");
        history.add("You tried comment " + postId.getAccountId().getUsername() + "'s post id : " + postId.getPostId());
    }

    public void uncomment(Comment commentId)
    {
        if(commentId.getAccountId() != this)
        {
            System.out.println("An account can delete only own comments");

            return;
        }

        history.add("You tried delete comment (Comment Id: " + commentId.getInteractionId() + ")");
        commentId.delete();

    }

    /**
     * block an account from account
     * @param accountId
     * account to be blocked
     */
    public void block(Account accountId) {
        if (!isLoggedIn())
            return;

        if (accountId.getUsername() == this.getUsername())
        {
            System.out.println("you cannot block yourself");
            history.add("You tried block yourself");
            return;
        }

        if (!blockedAccounts.contains(accountId))
        {
            for(Post post : posts)
                post.deleteInteractionsOf(accountId);

            unfollow(accountId);
            blockedAccounts.add(accountId);
            history.add("You blocked " + accountId.getUsername());

        }
        else
        {
            history.add("You tried block to " + accountId.getUsername() + " but it has already blocked");
            System.out.println(this.getUsername() + " has already block " + accountId.getUsername());
        }


    }



    public void unblock(Account accountId)
    {
        if(!isLoggedIn())
            return;

        if(accountId.getUsername() == this.getUsername())
        {
            System.out.println("you cannot unblock yourself");
            history.add("You tried unblock yourself");
            return;
        }

        boolean isBlocked = false;

        /* checks given account has already blocked*/
        if(blockedAccounts.contains(accountId))
        {
            blockedAccounts.remove(accountId);
            System.out.println(this.getUsername() + " unblocked to " + accountId.getUsername());
            history.add("You unblocked to " + accountId.getUsername());
        }
        else
        {
            history.add("You tried unblock to " + accountId.getUsername() + " but it is not a blocked account");
            System.out.println(accountId.getUsername() + " is not a blocked account.");
        }

    }

    /**
     * checks is given account accessible, if it blocked than cannot accessible
     * @param accountId
     * account to be check
     * @return true if account accessible, otherwise false
     */
    public boolean isAccessible(Account accountId)
    {
        for(Account ac : accountId.getBlockedAccounts())
            if(ac.getUsername() == this.getUsername())
                return false;

        return true;
    }

    public void viewHistory()
    {
        System.out.println("----------------------------------");
        System.out.println("History of " + this.getUsername());
        System.out.println("----------------------------------");
        for(String str : history)
            System.out.println(str);
        System.out.println("----------------------------------");
    }

    /**
     * constructor of account
     * @param accountId
     * accountId
     * @param username
     * username
     * @param birthdate
     * birthdate of account holder
     * @param location
     * location of  account holder
     */
    public Account(int accountId, String username, String birthdate, String location) {
        this.accountId = accountId;
        this.username = username;
        this.birthdate = birthdate;
        this.location = location;


        history = new LinkedList<>();

        posts = new LinkedList<>();

        messageId = 0;

        inbox = new LinkedList<>();

        outbox = new LinkedList<>();

        following = new LinkedList<>();

        followers = new LinkedList<>();

        blockedAccounts = new LinkedList<>();

        isLoggedIn = false;


        System.out.println("An account with username " + username + " has been created.");
    }

    /**
     * empty no parameter constructor
     */
    public Account() {

    }
}
