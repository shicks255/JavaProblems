package ProjectEuler;

public class Euler17
{
    public static void main(String[] args)
    {
        int count = 0;

        //System.out.println(numberRun(355));

        for (int i = 1; i < 1001; i++)
        {
            System.out.println(numberRun(i));
            String returned = numberRun(i).toString();
            count += returned.length();
        }
        System.out.println(count);

    }

    public static StringBuilder numberRun(int x)
    {
        String[] firstTen = new String[10];
        String[] decimalNumbers = new String[10];
        String[] hundredNumbers = new String[10];
        firstTen[0] = "";
        firstTen[1] = "one";
        firstTen[2] = "two";
        firstTen[3] = "three";
        firstTen[4] = "four";
        firstTen[5] = "five";
        firstTen[6] = "six";
        firstTen[7] = "seven";
        firstTen[8] = "eight";
        firstTen[9] = "nine";
        decimalNumbers[0] = "";
        decimalNumbers[1] = "";
        decimalNumbers[2] = "twenty";
        decimalNumbers[3] = "thirty";
        decimalNumbers[4] = "forty";
        decimalNumbers[5] = "fifty";
        decimalNumbers[6] = "sixty";
        decimalNumbers[7] = "seventy";
        decimalNumbers[8] = "eighty";
        decimalNumbers[9] = "ninety";
        hundredNumbers[0] = "";
        hundredNumbers[1] = "onehundred";
        hundredNumbers[2] = "twohundred";
        hundredNumbers[3] = "threehundred";
        hundredNumbers[4] = "fourhundred";
        hundredNumbers[5] = "fivehundred";
        hundredNumbers[6] = "sixhundred";
        hundredNumbers[7] = "sevenhundred";
        hundredNumbers[8] = "eighthundred";
        hundredNumbers[9] = "ninehundred";

        String numb = "" + x;

        //System.out.println(numb + numb.length());

        StringBuilder ret = new StringBuilder();

        if (numb.length() == 1)//numb is number as a string
        {
            ret.append(firstTen[x]);
        }

        else if (numb.length() == 2)//numb is number as a string
        {
            String firstDig = numb.substring(0,1);
            String secDig = numb.substring(1,2);

            Integer parsed1 = Integer.parseInt(firstDig);
            Integer parsed2 = Integer.parseInt(secDig);

            if (parsed1 == 1)
            {
                if  (parsed2 == 0 || parsed2 == 1 || parsed2 == 2 || parsed2 == 3 || parsed2 == 4 || parsed2 == 5 || parsed2 == 6 || parsed2 == 7 || parsed2 == 8 || parsed2 == 9)
                {
                    switch (parsed2)
                    {
                        case 0: ret.append("ten");
                            break;
                        case 1: ret.append("eleven");
                            break;
                        case 2: ret.append("twelve");
                            break;
                        case 3: ret.append("thirteen");
                            break;
                        case 4: ret.append("fourteen");
                            break;
                        case 5: ret.append("fifteen");
                            break;
                        case 6: ret.append("sixteen");
                            break;
                        case 7: ret.append("seventeen");
                            break;
                        case 8: ret.append("eighteen");
                            break;
                        case 9: ret.append("nineteen");
                            break;
                    }
                }
            }
            else
            {
                ret.append(decimalNumbers[parsed1]);
                ret.append(firstTen[parsed2]);
            }
        }

        else if (numb.length() == 3)//numb is number as a string
        {
            String firstDig = numb.substring(0,1);
            String secDig = numb.substring(1,2);
            String thirdDig = numb.substring(2,3);

            Integer parsed1 = Integer.parseInt(firstDig);
            Integer parsed2 = Integer.parseInt(secDig);
            Integer parsed3 = Integer.parseInt(thirdDig);



            if (parsed2 == 0 && parsed3 == 0)
            {
                ret.append(hundredNumbers[parsed1]);
                ret.append(decimalNumbers[parsed2]);
                ret.append(firstTen[parsed3]);
            }
            else
            {
                if (parsed2 == 1)
                {
                    switch (parsed3)
                    {
                        case 0: ret.append(hundredNumbers[parsed1] + "andten");
                            break;
                        case 1: ret.append(hundredNumbers[parsed1] + "andeleven");
                            break;
                        case 2: ret.append(hundredNumbers[parsed1] + "andtwelve");
                            break;
                        case 3: ret.append(hundredNumbers[parsed1] + "andthirteen");
                            break;
                        case 4: ret.append(hundredNumbers[parsed1] + "andfourteen");
                            break;
                        case 5: ret.append(hundredNumbers[parsed1] + "andfifteen");
                            break;
                        case 6: ret.append(hundredNumbers[parsed1] + "andsixteen");
                            break;
                        case 7: ret.append(hundredNumbers[parsed1] + "andseventeen");
                            break;
                        case 8: ret.append(hundredNumbers[parsed1] + "andeighteen");
                            break;
                        case 9: ret.append(hundredNumbers[parsed1] + "andnineteen");
                            break;
                    }
                }
                else
                {
                    ret.append(hundredNumbers[parsed1]);
                    ret.append("and");
                    ret.append(decimalNumbers[parsed2]);
                    ret.append(firstTen[parsed3]);
                }
            }
        }

        else if (numb.length() == 4)
        {
            ret.append("onethousand");
        }

        return ret;

    }

}