import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/skillbox";
        String user = "root";
        String pass = "root";

        int year = 2018;

        try (Connection connection = DriverManager.getConnection(url, user, pass)) {

            String sql = """                 
                       select courses.name,
                                       
                       (select count(*) from purchaselist where purchaselist.course_name = courses.name)
                       /
                       (
                       (select month(purchaselist.subscription_date)  from purchaselist where purchaselist.course_name = courses.name order by subscription_date desc limit 1) -\s
                       (select month(purchaselist.subscription_date) from purchaselist where purchaselist.course_name = courses.name order by subscription_date limit 1) + 1
                       ) as sell_results
                                       
                       from courses
                       join purchaselist on purchaselist.course_name = courses.name
                       where year(purchaselist.subscription_date) = ?
                       group by courses.name
                    """;

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, year);

            var result = preparedStatement.executeQuery();

            while (result.next()) {
                String courseName = result.getString("name");
                var sellResults = result.getFloat("sell_Results");
                System.out.println(courseName + " - " + sellResults);
            }

        } catch (Exception ignored) {
        }
    }
}
