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
                List tempList = (List) o;

                for (int i = 0; i < tempList.size(); i++)
                {
                    System.out.println(tempList.get(i));
                }

            }

            @Override
            public void onError(String errorMsg)
            {

            }
        });

    }


}

//TODO Add Exception Class