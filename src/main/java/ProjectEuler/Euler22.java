package ProjectEuler;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.io.*;

public class Euler22
{
    public static void main(String[] args)
    {
        List<String> names = new ArrayList<String>();

        try (BufferedReader br = new BufferedReader(new FileReader("names.txt")))
        {
            String line;
            while ((line = br.readLine()) != null)//splitting the names and putting into array
            {
                String[] na = line.split(",");
                System.out.println(na);
                for (String n : na)
                {
                    names.add(n); //arraylist called names has all names
                }
            }

            Collections.sort(names); //sort the names alphabetically
            int listCount = 1;  //position in the list
            int runningTotal = 0; //running total of everything

            for (String nam : names) //run through each name in names, taking out quotes, making lowercase, and passing it into returnValue method
            {
                nam = nam.replace("\"", ""); //remove quotes
                nam = nam.toLowerCase(); //make lower case, which the switch statement requires
                int val = returnValue(nam);
                runningTotal += (val * listCount);
                System.out.println(nam + "," + listCount + "," + val + "," + runningTotal);
                listCount++;
            }
        }
        catch (IOException e)
        {
            System.out.println(e);
        }
    }
    public static int returnValue(String x)
    {
        int numberValue = 0;
        for (int i = 0; i < x.length(); i++)
        {
            String sub = x.substring(i,i+1);
            numberValue += charValue(sub);
        }

        return numberValue;
    }

    public static int charValue(String y)//calculate the value of each a letter
    {
        int value = 0;
        switch (y)
        {
            case "a":  value = 1;
                break;
            case "b":  value = 2;
                break;
            case "c":  value = 3;
                break;
            case "d":  value = 4;
                break;
            case "e":  value = 5;
                break;
            case "f":  value = 6;
                break;
            case "g":  value = 7;
                break;
            case "h":  value = 8;
                break;
            case "i":  value = 9;
                break;
            case "j":  value = 10;
                break;
            case "k":  value = 11;
                break;
            case "l":  value = 12;
                break;
            case "m":  value = 13;
                break;
            case "n":  value = 14;
                break;
            case "o":  value = 15;
                break;
            case "p":  value = 16;
                break;
            case "q":  value = 17;
                break;
            case "r":  value = 18;
                break;
            case "s":  value = 19;
                break;
            case "t":  value = 20;
                break;
            case "u":  value = 21;
                break;
            case "v":  value = 22;
                break;
            case "w":  value = 23;
                break;
            case "x":  value = 24;
                break;
            case "y":  value = 25;
                break;
            case "z":  value = 26;
                break;
        }
        return value;
    }
}