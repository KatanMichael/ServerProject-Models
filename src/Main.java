import com.models.HibernateGymDAO;
import com.models.RequestListener;
import com.models.User;

import java.util.List;

public class Main
{
    public static void main(String[] args) {

        HibernateGymDAO gymDAO = HibernateGymDAO.getInstance();



        gymDAO.getAllUsers(new RequestListener() {
            @Override
            public void onComplete(Object o)
            {
                List users = (List) o;

                System.out.println("Size: "+users.size());

                for (int i = 0; i <users.size() ; i++)
                {
                    System.out.println(users.get(i));
                }

            }

            @Override
            public void onError(String errorMsg)
            {
                System.out.println(errorMsg);
            }
        });

        System.out.println();

        gymDAO.getUserbyId(4, new RequestListener()
        {
            @Override
            public void onComplete(Object o)
            {
                User tempUser = (User) o;

                System.out.println(tempUser);
            }

            @Override
            public void onError(String errorMsg)
            {

            }
        });

        System.out.println();

        gymDAO.getUsersByName("Daniel", new RequestListener()
        {
            @Override
            public void onComplete(Object o)
            {
                List users = (List) o;

                for (int i = 0; i < users.size() ; i++)
                {
                    System.out.println(users.get(i));

                }
            }

            @Override
            public void onError(String errorMsg)
            {
                System.out.println(errorMsg);
            }
        });


       //gymDAO.deleteUser("Michael");
    }


}

//TODO Add Exception Class