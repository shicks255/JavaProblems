//https://www.codewars.com/kata/catalog/train/java

//You are given a small extract of a catalog:
//
//s = "<prod><name>drill</name><prx>99</prx><qty>5</qty></prod>
//
//<prod><name>hammer</name><prx>10</prx><qty>50</qty></prod>
//
//<prod><name>screwdriver</name><prx>5</prx><qty>51</qty></prod>
//
//<prod><name>table saw</name><prx>1099.99</prx><qty>5</qty></prod>
//
//<prod><name>saw</name><prx>9</prx><qty>10</qty></prod>
//
//        ...
//        (prx stands for price, qty for quantity) and an article i.e "saw".
//
//        The function catalog(s, "saw") returns the line(s) corresponding to the article with $ before the prices:
//
//        "table saw > prx: $1099.99 qty: 5\nsaw > prx: $9 qty: 10\n..."

package CodeWars.catalog;

public class Catalog
{

    static String s =
            "<prod><name>drill</name><prx>99</prx><qty>5</qty></prod>\n\n" +
                    "<prod><name>hammer</name><prx>10</prx><qty>50</qty></prod>\n\n" +
                    "<prod><name>screwdriver</name><prx>5</prx><qty>51</qty></prod>\n\n" +
                    "<prod><name>table saw</name><prx>1099.99</prx><qty>5</qty></prod>\n\n" +
                    "<prod><name>saw</name><prx>9</prx><qty>10</qty></prod>\n\n" +
                    "<prod><name>chair</name><prx>100</prx><qty>20</qty></prod>\n\n" +
                    "<prod><name>fan</name><prx>50</prx><qty>8</qty></prod>\n\n" +
                    "<prod><name>wire</name><prx>10.8</prx><qty>15</qty></prod>\n\n" +
                    "<prod><name>battery</name><prx>150</prx><qty>12</qty></prod>\n\n" +
                    "<prod><name>pallet</name><prx>10</prx><qty>50</qty></prod>\n\n" +
                    "<prod><name>wheel</name><prx>8.80</prx><qty>32</qty></prod>\n\n" +
                    "<prod><name>extractor</name><prx>105</prx><qty>17</qty></prod>\n\n" +
                    "<prod><name>bumper</name><prx>150</prx><qty>3</qty></prod>\n\n" +
                    "<prod><name>ladder</name><prx>112</prx><qty>12</qty></prod>\n\n" +
                    "<prod><name>hoist</name><prx>13.80</prx><qty>32</qty></prod>\n\n" +
                    "<prod><name>platform</name><prx>65</prx><qty>21</qty></prod>\n\n" +
                    "<prod><name>car wheel</name><prx>505</prx><qty>7</qty></prod>\n\n" +
                    "<prod><name>bicycle wheel</name><prx>150</prx><qty>11</qty></prod>\n\n" +
                    "<prod><name>big hammer</name><prx>18</prx><qty>12</qty></prod>\n\n" +
                    "<prod><name>saw for metal</name><prx>13.80</prx><qty>32</qty></prod>\n\n" +
                    "<prod><name>wood pallet</name><prx>65</prx><qty>21</qty></prod>\n\n" +
                    "<prod><name>circular fan</name><prx>80</prx><qty>8</qty></prod>\n\n" +
                    "<prod><name>exhaust fan</name><prx>62</prx><qty>8</qty></prod>\n\n" +
                    "<prod><name>cattle prod</name><prx>990</prx><qty>2</qty></prod>\n\n" +
                    "<prod><name>window fan</name><prx>62</prx><qty>8</qty></prod>";


    public static void main(String[] args)
    {
        System.out.println(catalog(s, "prod"));
        System.out.println("\r\n\r\n" + catalog(s, "saw"));
        System.out.println("\r\n\r\n" + catalog(s, "ladder"));
        System.out.println("\r\n\r\n" + catalog(s, "fan"));
    }

    public static String catalog(String s, String article)
    {
        StringBuilder answer = new StringBuilder();

        String[] entries = s.split("\n\n");

        boolean foundAMatch = false;
        for (String entry : entries)
        {
            if (entry.contains(article))
            {
                foundAMatch = true;
                String name = entry.substring(entry.indexOf("<name>") + 6, entry.indexOf("</name"));
                if (name.contains(article))
                {
                    String price = entry.substring(entry.indexOf("<prx>") + 5, entry.indexOf("</prx"));
                    String quantity = entry.substring(entry.indexOf("<qty>") + 5, entry.indexOf("</qty"));

                    if (answer.length() > 0)
                        answer.append("\n");
                    answer.append(name).append(" > ").append("prx: $").append(price).append(" qty: ").append(quantity);
                }
            }
        }

        if (!foundAMatch)
            answer.append("Nothing");

        return answer.toString();
    }
}
