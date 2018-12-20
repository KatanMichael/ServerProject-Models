import com.models.HibernateGymDAO;
import com.models.RequestListener;

public class Main
{
    public static void main(String[] args)
    {

        HibernateGymDAO dao = HibernateGymDAO.getInstance();

        dao.getUserbyId(123, new RequestListener()
        {
            @Override
            public void onComplete(Object o)
            {

            }

            @Override
            public void onError(String errorMsg)
            {

            }
        });

    }

}
