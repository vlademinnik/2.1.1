package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.persistence.NoResultException;
import java.sql.SQLException;


public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

//      userService.add(new User("Сайтама", "Сайтамыч", "saitama@mail.ru"));
//      userService.add(new User("Киану", "Ривз", "rivz@mail.ru"));
//      userService.add(new User("Иосиф", "Сталин", "iostalin@mail.ru"));
//      userService.add(new User("Александр", "Пушкин", "pushkin@mail.ru"));
        User onePach = new User("Сайтама", "Сайтамыч", "saitama@mail.ru");
        User twoMatric = new User("Киану", "Ривз", "rivz@mail.ru");
        User voshd = new User("Иосиф", "Сталин", "iostalin@mail.ru");
        User poet = new User("Александр", "Пушкин", "pushkin@mail.ru");

        Car car1 = new Car("Land Cruser", 300);
        Car car2 = new Car("BMW", 7);
        Car car3 = new Car("Победа М", 20);
        Car car4 = new Car("Лошадь", 1);

        userService.add(onePach.setCar(car1).setUser(onePach));
        userService.add(twoMatric.setCar(car2).setUser(twoMatric));
        userService.add(voshd.setCar(car3).setUser(voshd));
        userService.add(poet.setCar(car4).setUser(poet));

        for (User user : userService.listUsers()) {
            System.out.println(user + " " + user.getCar());
        }
        System.out.println(userService.getByCar("BMW", 7)); //выборка по тачке


        try {
            User no = userService.getByCar("Audi", 8);
        } catch (NoResultException e) {
            System.out.println("User-а нет с таким авто");
        }
//        userService.dropUsersTable();
//        for (User user : users) {
//            System.out.println("Id = " + user.getId());
//            System.out.println("First Name = " + user.getFirstName());
//            System.out.println("Last Name = " + user.getLastName());
//            System.out.println("Email = " + user.getEmail());
//            System.out.println();
//        }

        context.close();
    }
}
