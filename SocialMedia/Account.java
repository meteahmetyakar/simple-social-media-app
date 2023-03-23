package SocialMedia;
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

    /**
     * it holds account's posts
     *
     */
    private Post[] posts;

    /**
     *it is control which post access operations
     *
     */
    private int postIdx;

    private int messageId;

    /**
     * it holds account's inbox messages
     *
     */
    private Message[] inbox;

    /**
     *it is control which inbox access operations
     *
     */
    private int inboxIdx;

    /**
     * it holds account's outbox messages
     *
     */
    private Message[] outbox;

    /**
     *it is control which inbox access operations
     *
     */
    private int outboxIdx;

    /**
     * it holds account's followings
     *
     */
    private Account[] following;
    /**
     *it controls which following access operations
     *
     */
    private int followingIdx;

    /**
     * it holds account's followers
     *
     */
    private Account[] followers;
    /**
     *it controls which follower access operations
     *
     */
    private int followerIdx;

    /**
     * it holds accounts which blocked by account
     *
     */
    private Account[] blockedAccounts;

    /**
     *it controls which blocked accounts access operations
     *
     */
    private int blockedIdx;

    /**
     * account limit that can be created
     */
    private final int accountLimit = 10;
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
     * it returns following index
     * @return followingIdx
     */
    public int getFollowingIdx() {
        return followingIdx;
    }

    /**
     * it returns follower index
     * @return followerIdx
     */
    public int getFollowerIdx() {
        return followerIdx;
    }

    /**
     * it returns following accounts
     * @return following
     */
    public Account[] getFollowing() {
        return following;
    }

    /**
     * it returns follower accounts
     * @return followers
     */
    public Account[] getFollowers() {
        return followers;
    }

    /**
     * it returns shared posts
     * @return posts
     */
    public Post[] getPosts() {
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
     * it returns post index
     * @return postIdx
     */
    public int getPostIdx() {
        return postIdx;
    }

    /**
     * it returns inbox index
     * @return inboxIdx
     */
    public int getInboxIdx() {
        return inboxIdx;
    }

    /**
     * it returns blocked index
     * @return blockedIdx
     */
    public int getBlockedIdx() {
        return blockedIdx;
    }

    /**
     * it returns blocked accounts
     * @return blockedAccounts
     */
    public Account[] getBlockedAccounts() {
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
    public void login(Account[] accounts)
    {
        boolean isAnybodyOnline = false;

        for(Account account : accounts)
            if(account.isLoggedIn)
                isAnybodyOnline = true;

        if(!isAnybodyOnline)
        {
            isLoggedIn = true;
            System.out.println(username + " logged in");
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
        System.out.println(username + " is logout");
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

        if(postIdx < postLimit)
        {
            Post post = new Post(postIdx, this, content);
            posts[postIdx] = post;
            postIdx++;

            System.out.println(this.getUsername() + " has shared a post");

        }
        else
            System.out.println("Reached post limit!");
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
            return;
        }

        boolean isAlreadyFollowed = false;

        /* it checks if is given account already followed */
        for(int idx = 0; idx<=followingIdx; idx++)
            if(following[idx].getUsername() == accountId.getUsername())
                isAlreadyFollowed = true;

        if(!isAlreadyFollowed)
        {
            if(followingIdx + 1 < accountLimit)
            {
                if(accountId.getFollowerIdx() + 1 < accountLimit)
                {
                    accountId.addFollower(this);
                    following[++followingIdx] = accountId;
                    System.out.println(this.getUsername() + " followed to " + accountId.getUsername());
                }
                else
                    System.out.println(accountId.getUsername() + " is reached follower limit");
            }
            else
                System.out.println("you are reached following limit");
        }
        else
            System.out.println("you are already following this account");

    }

    /**
     * adding a follower to given account
     * @param accountId
     * account which will follow itself
     */
    private void addFollower(Account accountId)
    {
        if(accountId.getFollowerIdx() + 1 < accountLimit)
            followers[++followerIdx] = accountId;
        else
            System.out.println(accountId.getUsername() + " is reached follower limit");

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
            return;
        }

        System.out.println();
        System.out.println("PROFILE");
        System.out.println("-------------------------------------");

        System.out.println("User ID: " + accountId.getAccountId());
        System.out.println("Username: " + accountId.getUsername());
        System.out.println("Location: " + accountId.getLocation());
        System.out.println("Birth date: " + accountId.getBirthdate());
        System.out.println(accountId.getUsername() + " is following " + (accountId.getFollowingIdx()+1) + " account (s) "
                + " and has " + (accountId.getFollowerIdx()+1) + " follower (s).");
        System.out.println();

        if(accountId.getFollowingIdx() != -1)
        {
            System.out.print(accountId.getUsername() + " is following:  ");
            for(int idx = 0; idx <= accountId.getFollowingIdx(); idx++)
                System.out.print(accountId.getFollowing()[idx].getUsername() + ", ");
        }
        else
            System.out.print("no following");

        System.out.println();

        if(accountId.getFollowerIdx() != -1)
        {
            System.out.print(accountId.getUsername() + " is follower:  ");
            for(int idx = 0; idx <= accountId.getFollowerIdx(); idx++)
                System.out.print(accountId.getFollowers()[idx].getUsername() + ", ");
        }
        else
            System.out.print("no follower");

        System.out.println();
        System.out.println();



        System.out.println(accountId.getUsername() + " has " + (accountId.getPostIdx()) + " posts.");
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
            return;
        }

        System.out.println();
        System.out.println("POSTS");
        System.out.println("---------------------------------");

        for(int idx = 0; idx < accountId.getPostIdx(); idx++)
        {
            System.out.println("(PostID: "+accountId.posts[idx].getPostId()+")  " + accountId.posts[idx].getAccountId().getUsername() + ":  " + accountId.posts[idx].getContent());
            System.out.println("---------------------------------");
        }

        System.out.println();
    }

    public void viewInteractions(Account accountId)
    {
        System.out.println();
        System.out.println("POSTS");
        System.out.println("---------------------------------");

        for(int idx = 0; idx < accountId.getPostIdx(); idx++)
        {
            System.out.println("(PostID: "+accountId.posts[idx].getPostId()+")  " + accountId.posts[idx].getAccountId().getUsername() + ":  " + accountId.posts[idx].getContent());

            if(accountId.posts[idx].getLikeIdx() == 0)
                System.out.println("The post has no likes.");
            else
            {
                System.out.print("The post was liked by the following account (s) : ");
                for(int likedIdx=0; likedIdx<accountId.posts[idx].getLikeIdx(); likedIdx++)
                    System.out.print(accountId.posts[idx].getLikes()[likedIdx].getAccountId().getUsername() + ", ");
                System.out.println();
            }

            if(accountId.posts[idx].getCommentIdx() == 0)
                System.out.println("The post has no comments.");
            else
            {
                System.out.println("The post has " + accountId.posts[idx].getCommentIdx() + " comment (s)...");
                for(int commentIdx=0; commentIdx<accountId.posts[idx].getCommentIdx(); commentIdx++)
                    System.out.print("Comment " + (commentIdx+1) + ": '" + accountId.posts[idx].getComments()[commentIdx].getAccountId().getUsername() + "' said '" + accountId.posts[idx].getComments()[commentIdx].getContent() + "'");
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
    public void sendMessage(Account receiveId, String content)
    {
        if(!isLoggedIn())
            return;

        if(!isAccessible(receiveId))
        {
            System.out.println("message could not be sent, " + this.getUsername() + " is blocked by " + receiveId.getUsername());
            return;
        }

        if(receiveId.getInboxIdx() < 100)
        {
            Message message = new Message(hashCode(), this, receiveId, content);
            receiveId.addMessageToInbox(message);
            this.addOutbox(message);
            System.out.println(this.getUsername() + " sent a message to " + receiveId.getUsername());

        }
        else
            System.out.println(receiveId.getUsername() + "'s inbox is full");
    }

    /**
     * it is add given message to inbox of current account
     * @param message
     * message which will add
     */
    private void addMessageToInbox(Message message)
    {
        if(inboxIdx < messageLimit)
            inbox[inboxIdx++] = message;
        else
            System.out.println("inbox is full");
    }

    /**
     * it is adds given message to outbox of current account
     * @param message
     * message which will add
     */
    private void addOutbox(Message message)
    {
        if(outboxIdx < messageLimit)
            outbox[outboxIdx++] = message;
        else
            System.out.println("outbox is full");
    }


    /**
     * it adds like to given post
     * @param postId
     * the id of the post to be liked
     */
    public void addLike(Post postId)
    {
        if(!isLoggedIn())
            return;

        if(postId.getLikeIdx() < postId.getInteractionLimit())
        {
            Like like = new Like(hashCode(), this, postId);
            postId.likePost(like);
            System.out.println(this.getUsername() + " liked " + postId.getAccountId().getUsername() + "'s post");
        }
        else
            System.out.println("reached like limit");
    }

    /**
     * writes the number of messages the outbox contains
     */
    public void checkOutbox()
    {
        if(!isLoggedIn())
            return;

        System.out.println("There is/are " + outboxIdx + " message (s) in the outbox");
        System.out.println();
    }

    /**
     * writes messages information the outbox contains
     */
    public void viewOutbox()
    {
        if(!isLoggedIn())
            return;

        System.out.println(username + "'s outbox");
        System.out.println("--------------------------------");
        for(int idx=0; idx<outboxIdx; idx++)
        {
            System.out.println("Message ID: " + outbox[idx].getMessageId());
            System.out.println("From: " + outbox[idx].getSenderId().getUsername());
            System.out.println("To: " + outbox[idx].getReceiveId().getUsername());
            System.out.println("Message: " + outbox[idx].getContent());

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

        System.out.println("There is/are " + inboxIdx + " message (s) in the inbox");
        System.out.println();
    }

    /**
     * writes messages information the inbox contains
     */
    public void viewInbox()
    {
        if(!isLoggedIn())
            return;

        System.out.println(username + "'s inbox");
        System.out.println("--------------------------------");
        for(int idx=0; idx<inboxIdx; idx++)
        {
            System.out.println("Message ID: " + inbox[idx].getMessageId());
            System.out.println("From: " + inbox[idx].getSenderId().getUsername());
            System.out.println("To: " + inbox[idx].getReceiveId().getUsername());
            System.out.println("Message: " + inbox[idx].getContent());

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
    public void addComment(Post postId, String content)
    {
        if(!isLoggedIn())
            return;

        if(postId.getCommentIdx() < postId.getInteractionLimit())
        {
            Comment comment = new Comment(hashCode(), this, postId, content);
            postId.commentPost(comment);
            System.out.println(this.getUsername() + " comment to " + postId.getAccountId().getUsername() + "'s post");
        }
        else
            System.out.println("reached comment limit");
    }

    /**
     * block an account from account
     * @param accountId
     * account to be blocked
     */
    public void block(Account accountId)
    {
        if(!isLoggedIn())
            return;

        if(accountId.getUsername() == this.getUsername())
        {
            System.out.println("you cannot block yourself");
            return;
        }

        boolean isBlockedBefore = false;

        /* checks given account has already blocked*/
        for(int idx=0; idx < blockedIdx; idx++)
        {
            if(blockedAccounts[idx].getUsername() == accountId.getUsername())
            {
                isBlockedBefore = true;
                break;
            }
        }

        if(!isBlockedBefore)
        {
            blockedAccounts[blockedIdx] = accountId;
            blockedIdx++;
        }
        else
            System.out.println(this.getUsername() + " has already block " + accountId.getUsername());


    }

    /**
     * checks is given account accessible, if it blocked than cannot accessible
     * @param accountId
     * account to be check
     * @return true if account accessible, otherwise false
     */
    public boolean isAccessible(Account accountId)
    {
        for(int idx=0; idx<accountId.getBlockedIdx(); idx++)
            if(accountId.getBlockedAccounts()[idx].getUsername() == this.getUsername())
                return false;

        return true;
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


        posts = new Post[postLimit];

        messageId = 0;

        inbox = new Message[messageLimit];
        inboxIdx = 0;

        outbox = new Message[messageLimit];
        outboxIdx = 0;

        following = new Account[accountLimit];
        followingIdx = -1;

        followers = new Account[accountLimit];
        followerIdx = -1;

        blockedAccounts = new Account[accountLimit];
        blockedIdx = 0;

        isLoggedIn = false;
        postIdx = 0;


        System.out.println("An account with username " + username + " has been created.");
    }

    /**
     * empty no parameter constructor
     */
    public Account() {

    }
}
