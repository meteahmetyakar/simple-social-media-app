package SocialMedia;
/**
 * second testcases
 * @author meteahmetyakar
 *
 */
public class Scenario2 {
    public static void main(String[] args) {
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


        System.out.println("SCENARIO 2");
        System.out.println("------------------------------");

        gizemsungu.login(accounts);
        gizemsungu.addPost("good morning");
        gizemsungu.addPost("I love read homeworks");
        gizemsungu.logout();

        sibelgulmez.login(accounts);
        sibelgulmez.viewProfile(gizemsungu);
        sibelgulmez.addLike(gizemsungu.getPosts()[0]);
        sibelgulmez.logout();

        gokhankaya.login(accounts);
        gokhankaya.viewProfile(gizemsungu);
        gokhankaya.addComment(gizemsungu.getPosts()[1], "Nice!");
        gokhankaya.sendMessage(gizemsungu, "Hello!");
        gokhankaya.logout();

        gizemsungu.login(accounts);
        gizemsungu.viewProfile(gizemsungu);
        gizemsungu.checkInbox();
        gizemsungu.viewInbox();


        System.out.println("---- Above here I added extra testcases about login, follow and logout ----\n");

        gokhankaya.login(accounts);
        sibelgulmez.login(accounts);
        gizemsungu.login(accounts);

        gokhankaya.follow(gokhankaya);
        gokhankaya.follow(sibelgulmez);
        gizemsungu.logout();

    }
}
