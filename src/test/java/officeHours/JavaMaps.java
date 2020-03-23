package officeHours;

import java.util.*;

public class JavaMaps {
    public static void main(String[] args) {


        Deque <Integer> numbers = new ArrayDeque<>();
        numbers.addFirst(20);
        numbers.addFirst(30);
        numbers.addFirst(50);

        System.out.println(numbers);

        numbers.addLast(90);
        System.out.println(numbers);

        numbers.add(33);
        System.out.println(numbers);

        Integer num = numbers.pollFirst();
        System.out.println(num);
        //peek - returns the value (similar to get)
        //poll - gives us the value and remove it from the Queue
        System.out.println(numbers.getLast()+ " peek: "+ numbers.peekLast());
        System.out.println("dequeue after peek: "+ numbers);

        /*
        What collections you are using in your project?

        Describe all different collections:
        List
        Queue
        Set
        Explain the difference between them
        Peek for each example

        From List< I use ArrayList, I ussually just need to store some values

        LinkedList if I know I will need to manipulate m date(add., remove, etc)

        Set --- HashSet - for unique value
        TreeSet - for unique sorted values

        Queue --- if I need to check FIFO (first in first out) logic in my project



         */

        /*
        MAP Interface:
        doesn't accept any duplicates keys
        HashMap - key/value, can accept null
        HashTable - synchronized/ no null values
        LinkedHashMap extends the HashMap , slower than HashMap
        TreeMap - sorted, no null values
         */
        HashMap<String,String>user1 = new HashMap<>();
        user1.put("first name",null);
        user1.put("last name","smith");
        user1.put("account number","A24241");
        user1.put("DOB","02.20.1980");
        System.out.println(user1);
        LinkedHashMap<String, String> user2 = new LinkedHashMap<>();
        user2.put("First Name", "John");
        user2.put("Last Name", null);
        user2.put("Last Name", "White");
        user2.put("Last Name", "Green");
        user2.put("Account Number", "A50564");
        user2.put("DOB", "12.02.1964");
        System.out.println(user2);
        HashMap <String, String> user3 = new HashMap<>(user1);
        user3.put("Account Number", "A50564431");
        user3.put("DOB", "12.08.1990");
        List <HashMap<String, String>> users = new ArrayList<>();
        //LinkedHashMap extends HashMap
        users.add(user1);
        users.add(user2);
        users.add(user3);
        //print account number for all users along with last name
        System.out.println("====LIST==== \n" + users);
        /*
        [{Account Number=A6345165, DOB=02.20.1980, First Name=null, Last Name=Smith},
        {First Name=John, Last Name=Green, Account Number=A50564, DOB=12.02.1964},
         {First Name=null, Account Number=A50564431, Last Name=Smith, DOB=12.08.1990}]
         */
        for (HashMap<String, String> user:
                users) {
            System.out.println("Account number: " + user.get("Account Number")
                    + " | Last Name: " + user.get("Last Name"));
        }
        int i = 1;
        for (HashMap<String, String> user:
                users) {
            System.out.println("User " + i);
            Iterator<String> keys = user.keySet().iterator();
            while (keys.hasNext()){
                String key = keys.next();
                System.out.println(key + ":" + user.get(key));
            }
            i++;
        }

    }
}
