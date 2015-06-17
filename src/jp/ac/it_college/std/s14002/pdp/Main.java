package jp.ac.it_college.std.s14002.pdp;

import jp.ac.it_college.std.s14002.pdp.adapter.Print;
import jp.ac.it_college.std.s14002.pdp.adapter.Print2;
import jp.ac.it_college.std.s14002.pdp.adapter.PrintBanner;
import jp.ac.it_college.std.s14002.pdp.adapter.PrintBanner2;
import jp.ac.it_college.std.s14002.pdp.bridge.CountDisplay;
import jp.ac.it_college.std.s14002.pdp.bridge.Display;
import jp.ac.it_college.std.s14002.pdp.bridge.StringDisplayImpl;
import jp.ac.it_college.std.s14002.pdp.builder.Director;
import jp.ac.it_college.std.s14002.pdp.builder.HTMLBuilder;
import jp.ac.it_college.std.s14002.pdp.composite.Directory;
import jp.ac.it_college.std.s14002.pdp.composite.File;
import jp.ac.it_college.std.s14002.pdp.composite.FileTreatmentException;
import jp.ac.it_college.std.s14002.pdp.factory.framework.Product;
import jp.ac.it_college.std.s14002.pdp.factory.singleton.Singleton;
import jp.ac.it_college.std.s14002.pdp.iterator.Book;
import jp.ac.it_college.std.s14002.pdp.iterator.BookShelf;
import jp.ac.it_college.std.s14002.pdp.prototype.MessageBox;
import jp.ac.it_college.std.s14002.pdp.prototype.UnderlinePen;
import jp.ac.it_college.std.s14002.pdp.prototype.framework.Manager;
import jp.ac.it_college.std.s14002.pdp.strategy.Hand;
import jp.ac.it_college.std.s14002.pdp.strategy.Player;
import jp.ac.it_college.std.s14002.pdp.strategy.ProbStrategy;
import jp.ac.it_college.std.s14002.pdp.strategy.WinningStrategy;
import jp.ac.it_college.std.s14002.pdp.template.AbstractDisplay;
import jp.ac.it_college.std.s14002.pdp.template.CharDisplay;
import jp.ac.it_college.std.s14002.pdp.template.StringDisplay;
import jp.ac.it_college.std.s14002.pdp.factory.framework.Factory;
import jp.ac.it_college.std.s14002.pdp.factory.idcard.IDCardFactory;
import jp.ac.it_college.std.s14002.pdp.iterator.Iterator;
import jp.ac.it_college.std.s14002.pdp.af.factory.Link;
import jp.ac.it_college.std.s14002.pdp.af.factory.Page;
import jp.ac.it_college.std.s14002.pdp.af.factory.Tray;



import java.util.*;

/**
 * Created by s14002 on 15/06/02.
 */
public class Main {
    public static void main(String[] args) {
        // IteratorMain();
        // adapterMain();
        // adapterMain2();
        // arrayListTest1();
        // arrayListTest2();
        // listTest();
        // linkedListTest1();
        // queueTest1();
        // queueTest2();
        // stackTest();
        // hashSetTest1();
        // hashMapTest();
        // practice1_1();
        // templateTest();
        // factoryMain();
        // SingletonMain();
        // builderMain(new String[] {"html"});
        // abstractMain();
        // bridgeMain();
        // strategyMain();
        // compositeMain();
        // jp.ac.it_college.std.s14002.pdp.decorator.Main.main(args);
        // jp.ac.it_college.std.s14002.pdp.visitor.Main.main(args);
         jp.ac.it_college.std.s14002.pdp.responsibility.Main.main(args);
        // jp.ac.it_college.std.s14002.pdp.facade.Main.main(args);
        // jp.ac.it_college.std.s14002.pdp.mediator.Main.main(args);
        //jp.ac.it_college.std.s14002.pdp.observer.Main.main(args);
    }

    public static void compositeMain() {
        try {
            System.out.println("Making root entries...");
            Directory rootdir = new Directory("root");
            Directory bindir = new Directory("bin");
            Directory tmpdir = new Directory("tmp");
            Directory usrdir = new Directory("usr");
            rootdir.add(bindir);
            rootdir.add(tmpdir);
            rootdir.add(usrdir);
            bindir.add(new File("vi", 10000));
            bindir.add(new File("latex", 20000));
            rootdir.printList();

            System.out.println("");
            System.out.println("Making user entries...");
            Directory yuki = new Directory("yuki");
            Directory hanako = new Directory("Hanako");
            Directory torura = new Directory("tomura");
            usrdir.add(yuki);
            usrdir.add(hanako);
            usrdir.add(torura);
            yuki.add(new File("diary.html", 100));
            yuki.add(new File("Composite.java", 200));
            hanako.add(new File("memo.tex", 300));
            torura.add(new File("game.doc", 400));
            torura.add(new File("junk.mail", 500));
            rootdir.printList();
        } catch (FileTreatmentException e) {
            e.printStackTrace();
        }
    }

    public static void strategyMain(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java Main randomseed1 randomseed2");
            System.out.println("Example: java Main 314 15");
            System.exit(0);
        }
        int seed1 = Integer.parseInt(args[0]);
        int seed2 = Integer.parseInt(args[1]);
        Player player1 = new Player("Taro", new WinningStrategy(seed1));
        Player player2 = new Player("Hana", new ProbStrategy(seed2));
        for (int i = 0; i <10000; i++) {
            Hand nextHand1 = player1.nextHand();
            Hand nextHand2 = player2.nextHand();
            if (nextHand1.isStrongerThan(nextHand2)) {
                System.out.println("Winner:" + player1);
                player1.win();
                player2.lose();
            } else if (nextHand2.isStrongerThan(nextHand1)) {
                System.out.println("Winner:" + player2);
                player1.lose();
                player2.win();
            } else {
                System.out.println("Even...");
                player1.even();
                player2.even();
            }
        }
        System.out.println("Total result:");
        System.out.println(player1.toString());
        System.out.println(player2.toString());
    }

    public static void abstractMain(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Main class.name.of.ConcreteFactory");
            System.out.println("Example 1: java Main listfactory.ListFactory");
            System.out.println("Example 2: java Main tablefactory.TableFactory");
            System.exit(0);
        }
        jp.ac.it_college.std.s14002.pdp.af.factory.Factory factory
                = jp.ac.it_college.std.s14002.pdp.af.factory.Factory.getFactory(args[0]);

        Link asahi = factory.createLink("朝日新聞", "http://www.asahi.com/");
        Link yomiumi = factory.createLink("読売新聞", "http://www.yomiuri.co.jp/");

        Link us_yahoo = factory.createLink("Yahoo!", "http://www.yahoo.com/");
        Link jp_yahoo = factory.createLink("Yahoo!Japan", "http://www.yahoo.co.jp/");
        Link excite = factory.createLink("Excite", "http://www.excite.com");
        Link google = factory.createLink("Google", "http://www.google.com");

        Tray traynews = factory.createTray("新聞");
        traynews.add(asahi);
        traynews.add(yomiumi);

        Tray trayyahoo = factory.createTray("Yahoo!");
        trayyahoo.add(us_yahoo);
        trayyahoo.add(jp_yahoo);

        Tray traysearch = factory.createTray("サーチエンジン");
        traysearch.add(trayyahoo);
        traysearch.add(excite);
        traysearch.add(google);

        Page page = factory.createPage("LinkPage", "結城浩");
        page.add(traynews);
        page.add(traysearch);
        page.output();
    }

    public static void builderMain(String[] args) {
        if (args.length != 1) {
            Builderusage();
            System.exit(0);
        }
        switch (args[0]) {
            case "plain": {
                jp.ac.it_college.std.s14002.pdp.builder.TextBuilder textbuilder = new jp.ac.it_college.std.s14002.pdp.builder.TextBuilder();
                Director director = new Director(textbuilder);
                director.construct();
                String result = textbuilder.getResult();
                System.out.println(result);
                break;
            }
            case "html": {
                HTMLBuilder htmlbuilder = new HTMLBuilder();
                Director director = new Director(htmlbuilder);
                director.construct();
                String filename = htmlbuilder.getResult();
                System.out.println(filename + "が作成されました");
                break;
            }
            default:
                Builderusage();
                System.exit(0);
        }
    }

    public static void bridgeMain() {
        Display d1 = new Display(new StringDisplayImpl("Hello, Japan"));
        Display d2 = new CountDisplay(new StringDisplayImpl("Hello, World"));
        CountDisplay d3 = new CountDisplay(new StringDisplayImpl("Hello, Universe"));
        d1.display();
        d2.display();
        d3.display();
        d3.multiDisplay(5);
    }

    public static void Builderusage() {
        System.out.println("Usage: java Main plain プレーンテキストで文書作成");
        System.out.println("Usage: java Main html HTMLファイルで文書作成");
    }

    public static void IteratorMain() {
        BookShelf bookShelf = new BookShelf(4);
        bookShelf.appendBook(new Book("Around the World in 80 Days"));
        bookShelf.appendBook(new Book("Bible"));
        bookShelf.appendBook(new Book("Cinderella"));
        bookShelf.appendBook(new Book("Daddy-Long-Legs"));
        Iterator it = bookShelf.iterator();

        while (it.hasNext()) {
            Book book = (Book)it.next();
            System.out.println(book.getName());
        }
    }

    public static void practice1_1() {
        BookShelf bookShelf = new BookShelf(4);
        bookShelf.appendBook(new Book("Around the World in 80 Days"));
        bookShelf.appendBook(new Book("Bible"));
        bookShelf.appendBook(new Book("Cinderella"));
        bookShelf.appendBook(new Book("Daddy-Long-Legs"));
        Iterator it = bookShelf.iterator();

        while (it.hasNext()) {
            Book book = (Book)it.next();
            System.out.println(book.getName());
        }
    }

    public static void iteratorMain() {

    }

    public static void adapterMain() {
        Print p = new PrintBanner("Hello");
        p.printWeak();
        p.printStrong();
    }

    public static void adapterMain2() {
        Print2 p = new PrintBanner2("Hello");
        p.printWeak();
        p.printStrong();
    }

    public static void templateTest() {
        AbstractDisplay d1 = new CharDisplay('H');
        AbstractDisplay d2 = new StringDisplay("Hello,world");
        AbstractDisplay d3 = new StringDisplay("こんにちわ。");
        d1.display();
        d2.display();
        d3.display();
    }

    public static void factoryMain() {
        Factory factory = new IDCardFactory();
        Product card1 = factory.create("結城浩");
        Product card2 = factory.create("とむら");
        Product card3 = factory.create("佐藤花子");
        card1.use();
        card2.use();
        card3.use();
    }

    public static void SingletonMain() {
        System.out.println("Start.");
        Singleton obj1 = Singleton.getInstance();
        Singleton obj2 = Singleton.getInstance();
        if (obj1 == obj2) {
            System.out.println("obj1とobj2は同じインスタンスです。");
        } else {
            System.out.println("obj1とobj2は同じインスタンスではありません");
        }
        System.out.println("End.");
    }

    public static void PrototypeMain() {
        Manager manager = new Manager();
        UnderlinePen upen = new UnderlinePen('~');
        MessageBox mbox = new MessageBox('*');
        MessageBox sbox = new MessageBox('/');
        manager.register("strong message", upen);
        manager.register("warning box", mbox);
        manager.register("slash box", sbox);

        jp.ac.it_college.std.s14002.pdp.prototype.framework.Product p1 = manager.create("strong message");
        p1.use("Hello, world.");
        jp.ac.it_college.std.s14002.pdp.prototype.framework.Product p2 = manager.create("warning box");
        p1.use("Hello, world.");
        jp.ac.it_college.std.s14002.pdp.prototype.framework.Product p3 = manager.create("slash box");
        p1.use("Hello, world.");


    }

    public static void arrayListTest1() {
        ArrayList<String> list = new ArrayList<>();
        list.add("Alice");
        list.add("Bob");
        list.add("Chris");

        list.add("Dianna");
        list.add("Elmo");

        for (String name : list) {
            System.out.println(name);
        }
    }

    public static void arrayListTest2() {
        ArrayList<String> list = new ArrayList<>();

        list.add("Alice");
        list.add("Bob");
        list.add("Chris");
        list.add("Diana");
        list.add("Eliza");

        System.out.println("削除のまえ");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + ":" + list.get(i));
        }
        System.out.println();

        list.remove("Alice");
        list.remove("Bob");
        list.remove("Eliza");

        System.out.println("削除のあと");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + ":" + list.get(i));
        }
        System.out.println();

        if (list.contains("Alice")) {
            System.out.println("listにAliceは含まれています。");
        } else {
            System.out.println("listにAliceは含まれていません。    ");
        }
    }

    public static void listTest() {
        List<String> list = new ArrayList<>();

        list.add("Alice");
        list.add("Bob");
        list.add("Chris");
        list.add("Bob");
        list.add("Eliza");

        System.out.println("最初の要素  = " + list.get(0));
        System.out.println("最後の要素  = " + list.get(list.size() - 1));

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        System.out.println("最初に出てくるBobの添字 = " + list.indexOf("Bob"));
        System.out.println("最後に出てくるBobの添字 = " + list.lastIndexOf("Bob"));
    }

    public static void linkedListTest1() {
        LinkedList<String> list = new LinkedList<>();

        list.add("Bob");
        list.add("Chris");
        list.add("Diana");
        list.add("Eliza");

        System.out.println(list);
        list.addFirst("Alice");
        System.out.println(list);
    }

    public static void queueTest1() {
        Queue<String> queue = new LinkedList<>();

        queue.offer("Arice");
        System.out.println("offer後のqueue = " + queue);
        queue.offer("Bob");
        System.out.println("offer後のqueue = " + queue);
        queue.offer("Chris");
        System.out.println("offer後のqueue = " + queue);
        queue.offer("Bob");
        System.out.println("offer後のqueue = " + queue);

        while (queue.peek() != null) {
            String name = queue.poll();
            System.out.println("pollの戻り値 = " + name);
            System.out.println("poll後のqueue = " + queue);
        }
    }

    public static void queueTest2() {
        Queue<String> queue = new LinkedList<>();

        queue.offer("Arice");
        System.out.println("offer後のqueue = " + queue);
        queue.offer("Bob");
        System.out.println("offer後のqueue = " + queue);
        queue.offer("Chris");
        System.out.println("offer後のqueue = " + queue);
        queue.offer("Bob");
        System.out.println("offer後のqueue = " + queue);

        while (true) {
            String name = queue.element();
            System.out.println("elementの戻り値 = " + name);

            name = queue.remove();
            System.out.println("removeの戻り値 = " + name);
            System.out.println("remove後のqueue = " + queue);
        }
    }

    public static void stackTest() {
        Deque<String> stack = new LinkedList<>();

        stack.addFirst("Arice");
        System.out.println("addFirst後のstack = " + stack);
        stack.addFirst("Bob");
        System.out.println("addFirst後のstack = " + stack);
        stack.addFirst("Chris");
        System.out.println("addFirst後のstack = " + stack);
        stack.addFirst("Diana");
        System.out.println("addFirst後のstack = " + stack);
        stack.addFirst("Eliza");
        System.out.println("addFirst後のstack = " + stack);

        while (true) {
            String name = stack.getFirst();
            System.out.println("getFirstの戻り値 = " + name);

            name = stack.removeFirst();
            System.out.println("removeFirstの戻り値 = " + name);
            System.out.println("removeFirst後のstack = " + stack);
        }
    }

    public static void hashSetTest1() {
        Set<String> set = new HashSet<>();

        set.add("Alice");
        set.add("Bob");
        set.add("Chris");
        set.add("Diana");
        set.add("Eliza");

        for (String name : set) {
            System.out.println(name);
        }
        if (set.contains("Alice")) {
            System.out.println("setにAliceは含まれています。");
        } else {
            System.out.println("setはAliceに含まれていません。");
        }
    }

    public static void hashMapTest() {
        Map<String,Integer> map = new HashMap<>();

        map.put("Alice", 100);
        map.put("Bob", 57);
        map.put("Chris", 85);
        map.put("Diana", 85) ;
        map.put("Eliza", 92);

        for (Map.Entry<String,Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }
        System.out.println();

        for (String name : map.keySet()) {
            System.out.println(name);
        }
        System.out.println();

        for (int value : map.values()) {
            System.out.println(value);
        }
        System.out.println();

        for (String name : map.keySet()) {
            System.out.println(name + " => " + map.get(name));
        }
        System.out.println();

        System.out.println("Bobの値 = " + map.get("Bob"));

        System.out.println("Fredの値 = " + map.get("Fred"));
    }
}

