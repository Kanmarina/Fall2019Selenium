package officeHours;

import java.util.ArrayList;
import java.util.Iterator;

public class SeleniumOH1 {
    public static void main(String[] args) {

        //Create arrayList of String - iterate over it

        ArrayList<String>keyToSearch = new ArrayList<>();
        keyToSearch.add("fruits");
        keyToSearch.add("veggies");
        keyToSearch.add("berries");
        Iterator iterator =keyToSearch.iterator();
        //iterator() - return Iterator type which we can use with all iterator methods

        while (iterator.hasNext()){
            System.out.println(iterator.next());

        }
        //print before modification and //add * to each string and print again

        Iterator iterator1 = keyToSearch.iterator();
        while ((iterator1.hasNext())){
            System.out.println(iterator1.next());
            System.out.println(("*"+iterator1.next()));
        }
    }

}
