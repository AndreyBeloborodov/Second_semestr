package ControlWork;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Path pathFileUsers = Path.of("C:\\Users\\Андрей\\IdeaProjects\\ru.kpfu.itis.java1.2\\src\\ControlWork\\DB\\Users.txt");
        Path pathFileProducts = Path.of("C:\\Users\\Андрей\\IdeaProjects\\ru.kpfu.itis.java1.2\\src\\ControlWork\\DB\\Products.txt");
        Path pathFileFavourites = Path.of("C:\\Users\\Андрей\\IdeaProjects\\ru.kpfu.itis.java1.2\\src\\ControlWork\\DB\\favourites.txt");
        Scanner scanner;

        scanner = new Scanner(pathFileUsers);
        List<User> listUsers = new ArrayList<>();
        while (scanner.hasNext()) {
            listUsers.add(new User(scanner.nextInt(), scanner.next(), scanner.nextInt(), scanner.next()));
        }

        scanner = new Scanner(pathFileProducts);
        List<Product> listProducts = new ArrayList<>();
        while (scanner.hasNext()) {
            listProducts.add(new Product(scanner.nextInt(), scanner.next(), scanner.next(), scanner.next()));
        }

        scanner = new Scanner(pathFileFavourites);
        List<Favourite> listFavourites = new ArrayList<>();
        while (scanner.hasNext()) {
            listFavourites.add(new Favourite(scanner.nextInt(), scanner.nextInt()));
        }

        problem_A(listUsers, listFavourites);
        List<User> listUsersGood = problem_B(listUsers, listFavourites, listProducts);
        problem_C();
        List<User> listUserSorted = problem_D(listUsers, listFavourites, listProducts);
    }

    public static void problem_A(List<User> listUsers, List<Favourite> listFavourite) {
        System.out.print("Введите город Х: ");
        String cityUser = (new Scanner(System.in).next());
        List<User> listUserGood = listUsers.stream().filter(x -> (x.city == cityUser)).toList();
        for (User user: listUserGood) {
            System.out.println("idUser: " + user.id + " count_favourite : " + listFavourite.stream().filter(x -> (x.idUser == user.id)).toList().size());
        }
    }

    public static List<User> problem_B(List<User> listUsers, List<Favourite> listFavourite, List<Product> listProducts) {
        List<User> listUsersGood = new ArrayList<>();
        for (User user: listUsers) {
            boolean ok = false;
            for (Favourite favourite: listFavourite) {
                if (favourite.idUser != user.id) continue;
                for (Product product : listProducts) {
                    if (product.id != favourite.idProduct) continue;
                    ok |= (product.manufacturerCity == user.city);
                    if (ok) break;
                }
                if (ok) break;
            }
            if (ok) listUsersGood.add(user);
        }

        for (User user: listUsersGood) System.out.print(user.name + " ");
        System.out.println();

        return listUsersGood;
    }

    public static void problem_C() {
        // ....
    }

    public static List<User> problem_D(List<User> listUsers, List<Favourite> listFavourite, List<Product> listProducts) {
        for (Favourite favourite: listFavourite) {
            for (User user: listUsers) {
                if (user.id == favourite.idUser) user.countFavourite++;
            }
        }

        Comparator<User> comparator = new Comparator<User>() {
            @Override
            public int compare(User user1, User user2) {
                if (user1.countFavourite == user2.countFavourite) return 0;
                if (user1.countFavourite > user2.countFavourite) return 1;
                else return -1;
            }
        };

        listUsers = listUsers.stream().sorted(comparator).toList();

        for (User user: listUsers) System.out.print(user.name + " ");
        System.out.println();

        return listUsers;
    }


}
