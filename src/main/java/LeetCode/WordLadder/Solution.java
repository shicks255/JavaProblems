package LeetCode.WordLadder;

import java.util.*;

public class Solution
{
    public static void main(String[] args)
    {
//        System.out.println(ladderLength2("hit", "cog", Arrays.asList(new String[]{"hot", "dot", "dog", "lot", "log", "cog"})));
//        System.out.println(ladderLength2("hit", "cog", Arrays.asList(new String[]{"hot", "dot", "dog", "lot", "log"})));
//        System.out.println(ladderLength2("joe", "pop", Arrays.asList(new String[]{"jop", "poj", "pop"})));
//        System.out.println(ladderLength2("hot", "dog", Arrays.asList(new String[]{"hot", "dog"})));
//        System.out.println(ladderLength2("hot", "dog", Arrays.asList(new String[]{"hot","cog","dog","tot","hog","hop","pot","dot"})));
//        System.out.println(ladderLength2("leet", "code", Arrays.asList(new String[]{"lest","leet","lose","code","lode","robe","lost"})));
        System.out.println(ladderLength2("game", "thee", Arrays.asList(new String[]{"frye","heat","tree","thee","game","free","hell","fame","faye"})));
//        System.out.println(ladderLength2("cet", "ism", Arrays.asList(new String[]{
//                "kid","tag","pup","ail","tun","woo","erg","luz","brr","gay","sip","kay","per","val","mes","ohs","now","boa","cet","pal","bar","die","war","hay","eco","pub","lob","rue","fry","lit","rex","jan","cot","bid","ali","pay","col","gum","ger","row","won","dan","rum","fad","tut","sag","yip","sui","ark","has","zip","fez","own","ump","dis","ads","max","jaw","out","btu","ana","gap","cry","led","abe","box","ore","pig","fie","toy","fat","cal","lie","noh","sew","ono","tam","flu","mgm","ply","awe","pry","tit","tie","yet","too","tax","jim","san","pan","map","ski","ova","wed","non","wac","nut","why","bye","lye","oct","old","fin","feb","chi","sap","owl","log","tod","dot","bow","fob","for","joe","ivy","fan","age","fax","hip","jib","mel","hus","sob","ifs","tab","ara","dab","jag","jar","arm","lot","tom","sax","tex","yum","pei","wen","wry","ire","irk","far","mew","wit","doe","gas","rte","ian","pot","ask","wag","hag","amy","nag","ron","soy","gin","don","tug","fay","vic","boo","nam","ave","buy","sop","but","orb","fen","paw","his","sub","bob","yea","oft","inn","rod","yam","pew","web","hod","hun","gyp","wei","wis","rob","gad","pie","mon","dog","bib","rub","ere","dig","era","cat","fox","bee","mod","day","apr","vie","nev","jam","pam","new","aye","ani","and","ibm","yap","can","pyx","tar","kin","fog","hum","pip","cup","dye","lyx","jog","nun","par","wan","fey","bus","oak","bad","ats","set","qom","vat","eat","pus","rev","axe","ion","six","ila","lao","mom","mas","pro","few","opt","poe","art","ash","oar","cap","lop","may","shy","rid","bat","sum","rim","fee","bmw","sky","maj","hue","thy","ava","rap","den","fla","auk","cox","ibo","hey","saw","vim","sec","ltd","you","its","tat","dew","eva","tog","ram","let","see","zit","maw","nix","ate","gig","rep","owe","ind","hog","eve","sam","zoo","any","dow","cod","bed","vet","ham","sis","hex","via","fir","nod","mao","aug","mum","hoe","bah","hal","keg","hew","zed","tow","gog","ass","dem","who","bet","gos","son","ear","spy","kit","boy","due","sen","oaf","mix","hep","fur","ada","bin","nil","mia","ewe","hit","fix","sad","rib","eye","hop","haw","wax","mid","tad","ken","wad","rye","pap","bog","gut","ito","woe","our","ado","sin","mad","ray","hon","roy","dip","hen","iva","lug","asp","hui","yak","bay","poi","yep","bun","try","lad","elm","nat","wyo","gym","dug","toe","dee","wig","sly","rip","geo","cog","pas","zen","odd","nan","lay","pod","fit","hem","joy","bum","rio","yon","dec","leg","put","sue","dim","pet","yaw","nub","bit","bur","sid","sun","oil","red","doc","moe","caw","eel","dix","cub","end","gem","off","yew","hug","pop","tub","sgt","lid","pun","ton","sol","din","yup","jab","pea","bug","gag","mil","jig","hub","low","did","tin","get","gte","sox","lei","mig","fig","lon","use","ban","flo","nov","jut","bag","mir","sty","lap","two","ins","con","ant","net","tux","ode","stu","mug","cad","nap","gun","fop","tot","sow","sal","sic","ted","wot","del","imp","cob","way","ann","tan","mci","job","wet","ism","err","him","all","pad","hah","hie","aim","ike","jed","ego","mac","baa","min","com","ill","was","cab","ago","ina","big","ilk","gal","tap","duh","ola","ran","lab","top","gob","hot","ora","tia","kip","han","met","hut","she","sac","fed","goo","tee","ell","not","act","gil","rut","ala","ape","rig","cid","god","duo","lin","aid","gel","awl","lag","elf","liz","ref","aha","fib","oho","tho","her","nor","ace","adz","fun","ned","coo","win","tao","coy","van","man","pit","guy","foe","hid","mai","sup","jay","hob","mow","jot","are","pol","arc","lax","aft","alb","len","air","pug","pox","vow","got","meg","zoe","amp","ale","bud","gee","pin","dun","pat","ten","mob"})));
    }

    public static int ladderLength2(String beingWord, String endWord, List<String> wordList)
    {
        if (!wordList.contains(endWord))
            return 0;
        int answer = 1 + doWork(beingWord, endWord, wordList, new ArrayList<>());
        return answer;
    }

    public static int doWork(String begin, String end, List<String> wordList, List<String> alreadyVisited)
    {
        if (wordDif(begin, end) == 0 || !wordList.contains(end))
            return 0;

        List<String> possibleSwaps = new ArrayList<>();
        int different = Integer.MAX_VALUE;
        for (String word : wordList)
        {
            if (!begin.equals(word) && wordDif(begin, word) <= 1)
            {
                if (!alreadyVisited.contains(word))
                {
                    int dif = wordDif(word, end);
                    if (dif < different)
                        possibleSwaps.clear();

                    if (dif <= different)
                    {
                        possibleSwaps.add(word);
                        different = dif;
                    }
                }
            }
        }

        int swapsNeeded = Integer.MAX_VALUE;
        String bestPossible = "";
        for (String possible : possibleSwaps)
        {
            if (possible.equals(end))
                return 0;

            alreadyVisited.add(possible);
            int x = doWork(possible, end, wordList, alreadyVisited);
            alreadyVisited.remove(possible);
            if (x < swapsNeeded)
            {
                swapsNeeded = x;
                bestPossible = possible;
            }
        }

        alreadyVisited.add(bestPossible);
        return 1 + doWork(bestPossible, end, wordList, alreadyVisited);
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList)
    {
        List<String> alreadyVisited = new ArrayList<>();
        if (!wordList.contains(endWord))
            return 0;

        int swaps = 1;

        while (wordDif(beginWord, endWord) > 0)
        {
            int listToEnd = Integer.MAX_VALUE;

            String beginToSwap = "";

            for (String word : wordList)
            {
                if (beginWord.equals(word) || alreadyVisited.contains(word))
                    continue;
                int beginToList2 = wordDif(word, beginWord);
                int listToEnd2 = wordDif(word, endWord);

                if (beginToList2 < 2)
                {
                    if (listToEnd2 < listToEnd)
                    {
                        listToEnd = listToEnd2;
                        beginToSwap = word;
                    }
                }
            }

            if (beginToSwap.isEmpty())
                return 0;
            alreadyVisited.add(beginWord);
            beginWord = beginToSwap;
            swaps++;
        }

        return swaps;
    }

    private static int wordDif(String a, String b)
    {
        int dif = 0;
        for (int i = 0; i < a.length(); i++)
            if (a.charAt(i) != b.charAt(i))
                dif++;
        return dif;
    }
}
