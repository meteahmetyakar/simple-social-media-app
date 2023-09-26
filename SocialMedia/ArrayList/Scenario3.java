package SocialMedia.ArrayList;

import java.util.ArrayList;

/**
 * third testcases
 * @author meteahmetyakar
 *
 */
public class Scenario3 {
    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();


        Account gizemsungu = new Account(1,"gizemsungu","08081998","İstanbul");
        Account sibelgulmez = new Account(1,"sibelgulmez","08081998","İstanbul");
        Account gokhankaya = new Account(1,"gokhankaya","08081998","İstanbul");

        ArrayList<Account> accounts = new ArrayList<>();
        accounts.add(gizemsungu);
        accounts.add(sibelgulmez);
        accounts.add(gokhankaya);

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

        gokhankaya.addLike(sibelgulmez.getPosts().get(0));
        //gokhankaya.addComment(sibelgulmez.getPosts().get(1), "I think so too");

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

        for(Post post : sibelgulmez.getPosts())
            gizemsungu.addLike(post);

        gizemsungu.viewPosts(sibelgulmez);
        gizemsungu.viewInteractions(sibelgulmez);

        System.out.println("SCENARIO 3");
        System.out.println("------------------------------");

        gizemsungu.login(accounts);
        gizemsungu.block(sibelgulmez);
        gizemsungu.logout();

        sibelgulmez.login(accounts);
        sibelgulmez.viewProfile(gizemsungu);
        sibelgulmez.viewPosts(gizemsungu);
        sibelgulmez.sendMessage(gizemsungu, "forgive me");


        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println(totalTime);

    }
}
