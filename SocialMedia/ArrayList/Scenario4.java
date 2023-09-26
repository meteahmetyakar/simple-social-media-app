package SocialMedia.ArrayList;

import java.util.ArrayList;

public class Scenario4 {
    public static void main(String[] args)
    {

        long startTime = System.currentTimeMillis();


        Account gizemsungu = new Account(1, "gizemsungu", "08081998", "İstanbul");
        Account sibelgulmez = new Account(2, "sibelgulmez", "08081998", "İstanbul");
        Account gokhankaya = new Account(3, "gokhankaya", "08081998", "İstanbul");
        Account meteyakar = new Account(4, "meteyakar", "08081998", "İstanbul");
        Account stevejobs = new Account(5, "stevejobs", "08081998", "İstanbul");
        Account yusufyilan = new Account(6, "yusufyilan", "08081998", "İstanbul");
        Account naimserbes = new Account(7, "naimserbes", "08081998", "İstanbul");
        Account memo123 = new Account(8, "memo123", "08081998", "İstanbul");
        Account bluu = new Account(9, "bluu", "08081998", "İstanbul");
        Account halitkoca = new Account(10, "halitkoca", "08081998", "İstanbul");

        ArrayList<Account> accounts = new ArrayList<>();
        accounts.add(gizemsungu);
        accounts.add(sibelgulmez);
        accounts.add(gokhankaya);
        accounts.add(meteyakar);
        accounts.add(stevejobs);
        accounts.add(yusufyilan);
        accounts.add(naimserbes);
        accounts.add(memo123);
        accounts.add(bluu);
        accounts.add(halitkoca);

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

        Comment comment = new Comment(0,gokhankaya,sibelgulmez.getPosts().get(1),"I think so tpp");
        gokhankaya.addComment(sibelgulmez.getPosts().get(1), comment);
        gokhankaya.viewInteractions(sibelgulmez);
        gokhankaya.uncomment(comment);
        Comment comment2 = new Comment(0,gokhankaya,sibelgulmez.getPosts().get(1),"why do we need to delete to change comments in this app? anyway i agree with you");
        gokhankaya.addComment(sibelgulmez.getPosts().get(1), comment2);
        gokhankaya.viewPosts(sibelgulmez);
        gokhankaya.viewInteractions(sibelgulmez);

        gokhankaya.addLike(sibelgulmez.getPosts().get(1));
        gokhankaya.logout();

        gizemsungu.login(accounts);
        gizemsungu.addLike(sibelgulmez.getPosts().get(1));
        gizemsungu.logout();



        gokhankaya.login(accounts);
        gokhankaya.viewInteractions(sibelgulmez);
        gokhankaya.unlike(sibelgulmez.getPosts().get(1));
        gokhankaya.viewInteractions(sibelgulmez);
        gokhankaya.logout();


        sibelgulmez.login(accounts);
        sibelgulmez.block(gokhankaya);
        sibelgulmez.viewProfile(sibelgulmez);
        sibelgulmez.viewPosts(sibelgulmez);
        sibelgulmez.viewInteractions(sibelgulmez);
        sibelgulmez.logout();

        gokhankaya.login(accounts);
        gokhankaya.viewProfile(sibelgulmez);
        gokhankaya.viewPosts(sibelgulmez);
        gokhankaya.viewInteractions(sibelgulmez);
        gokhankaya.logout();

        sibelgulmez.login(accounts);
        sibelgulmez.unblock(gokhankaya);
        sibelgulmez.logout();

        gokhankaya.login(accounts);
        gokhankaya.viewInteractions(sibelgulmez);
        gokhankaya.follow(sibelgulmez);
        gokhankaya.viewProfile(sibelgulmez);
        gokhankaya.unfollow(sibelgulmez);
        gokhankaya.viewProfile(sibelgulmez);

        gokhankaya.viewHistory();
        gokhankaya.logout();


        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println(totalTime);

    }


}
