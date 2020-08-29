package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User user1 = new User("Mike", "Tyson", "tryr@mail.vrt");
      Car car1 = new Car("Honda", 111, 1);
      user1.setCar(car1);
      userService.add(user1);

      User user2 = new User("Bob", "Boby", "efef@mail.ecre");
      Car car2 = new Car("BMW", 222, 2);
      user2.setCar(car2);
      userService.add(user2);

      User user3 = new User("Larry", "King", "hjencf@mail.com");
      Car car3 = new Car("Mazda", 333, 3);
      user3.setCar(car3);
      userService.add(user3);

      User user4 = new User("Viktor", "Mad", "ech@mail.com");
      Car car4 = new Car("Mers", 444, 4);
      user4.setCar(car4);
      userService.add(user4);


      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = " + user.getId());
         System.out.println("First Name = " + user.getFirstName());
         System.out.println("Last Name = " + user.getLastName());
         System.out.println("Email = " + user.getEmail());
         System.out.println("Car = " + user.getCar());
         System.out.println();
      }

//      User user = userService.getUserOnCar(444, 4);
      System.out.println(userService.getUserOnCar(444, 4).toString());

      context.close();
   }
}
