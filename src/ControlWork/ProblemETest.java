package ControlWork;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ProblemETest {
    List<User> listUserSorted = new ArrayList<>();
    List<User> listUserGood = new ArrayList<>();

    Comparator<User> comparator = new Comparator<User>() {
        @Override
        public int compare(User user1, User user2) {
            if (user1.countFavourite == user2.countFavourite) return 0;
            if (user1.countFavourite > user2.countFavourite) return 1;
            else return -1;
        }
    };

    boolean isSorted(List<User> listUserSorted) {
        for (int i = 1; i < listUserSorted.size(); i++) {
            if (listUserSorted.get(i).countFavourite < listUserSorted.get(i - 1).countFavourite) return false;
        }
        return true;
    }

    @Test
    public void testComparator() {
        for (int i = 100; i > 0; i--) {
            User user = new User(1, "???", 2000, "???");
            user.countFavourite = i;
            listUserSorted.add(user);
        }
        listUserSorted = listUserGood.stream().sorted(comparator).toList();
        assert(isSorted(listUserSorted));
    }


}
