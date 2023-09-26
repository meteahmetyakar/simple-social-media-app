package SocialMedia.basicArray;
/**
 * first testcases
 * @author meteahmetyakar
 *
 */
public class Scenario1 {

    public static void main(String[] args)
    {
        long startTime = System.currentTimeMillis();


        Account gizemsungu = new Account(1,"gizemsungu","08081998","İstanbul");
        Account sibelgulmez = new Account(1,"sibelgulmez","08081998","İstanbul");
        Account gokhankaya = new Account(1,"gokhankaya","08081998","İstanbul");

        Account[] accounts = {gizemsungu,sibelgulmez,gokhankaya};

        sibelgulmez.login(accounts);

        sibelgulmez.addPost("Hello world");
        sibelgulmez.addPost("April is the most beautiful month");

        sibelgulmez.follow(gizemsungu);
        sibelgulmez.follow(gokhankaya);

        sibelgulmez.logout();

        gokhankaya.login(accounts);
        gokhankaya.viewProfile(sibelgulmez);
        gokhankaya.viewPosts(sibelgulmez);
        gokhankaya.viewInteractions(sibelgulmez);

        gokhankaya.addLike(sibelgulmez.getPosts()[0]);
        gokhankaya.addComment(sibelgulmez.getPosts()[1], "I think so too");

        gokhankaya.follow(sibelgulmez);
        gokhankaya.follow(gizemsungu);
        gokhankaya.sendMessage(gizemsungu, "I think you are the students' favorite research assistant");
        gokhankaya.logout();

        gizemsungu.login(accounts);
        gizemsungu.checkOutbox();
        gizemsungu.checkInbox();
        gizemsungu.viewInbox();
        gizemsungu.viewProfile(sibelgulmez);
        gizemsungu.viewPosts(sibelgulmez);
        gizemsungu.viewInteractions(sibelgulmez);

        for(int idx = 0; idx < sibelgulmez.getPostIdx(); idx++)
            gizemsungu.addLike(sibelgulmez.getPosts()[idx]);

        gizemsungu.viewPosts(sibelgulmez);
        gizemsungu.viewInteractions(sibelgulmez);

        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println(totalTime);

    }
}