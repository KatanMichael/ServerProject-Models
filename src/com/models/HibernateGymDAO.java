package com.models;

import com.sun.xml.internal.ws.api.message.ExceptionHasMessage;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import java.util.List;

public class HibernateGymDAO implements com.models.IGymDAO
{
    private static HibernateGymDAO ourInstance = new HibernateGymDAO();
    private SessionFactory sessionFactory;


    public static HibernateGymDAO getInstance() {
        if (ourInstance == null) {
            ourInstance = new HibernateGymDAO();
        }
        return ourInstance;
    }

    private HibernateGymDAO()
    {
        sessionFactory = new AnnotationConfiguration().
                configure().buildSessionFactory();

    }


    @Override
    public void getAllUsers(RequestListener listener)
    {

        Session session = sessionFactory.openSession();

        session.beginTransaction();

        List from_user;

        try {
            from_user = session.createQuery("from User ").list();
            listener.onComplete(from_user);
        }catch (HibernateException e)
        {
            listener.onError(e.getMessage());
        }



        session.close();

    }

    @Override
    public void getUserById(int queryId, RequestListener listener)
    {
        sessionFactory =  new AnnotationConfiguration().
                configure().buildSessionFactory();

        Session session = sessionFactory.openSession();

        session.beginTransaction();

        final List list = session.createQuery("from User u WHERE u.id = '"+queryId+"'").list();

        if(list.size() == 0)
        {
            listener.onError("No User Found");
        }else
        {
            System.out.println(list.size());
            listener.onComplete(list.get(0));
        }

        session.close();


    }

    @Override
    public void getUsersByName(String name, RequestListener listener)
    {
        Session session = sessionFactory.openSession();

        final List list = session.createQuery("from User u WHERE u.userName = '"+name+"'").list();

        if(list.size() == 0)
        {
            listener.onError("No User Found");

        }else
        {
            listener.onComplete(list);
        }

        session.close();


    }

    @Override
    public void getUserByWeight(double weight, RequestListener listener)
    {

        Session session = sessionFactory.openSession();

        final List list = session.createQuery("from User u WHERE u.weight = '" + weight + "' ").list();

        if(list.size() == 0)
        {
            listener.onError("No User Found");

        }else
        {
            listener.onComplete(list);
        }

        session.close();

    }

    @Override
    public void getUserByHeight(double height, RequestListener listener)
    {

        Session session = sessionFactory.openSession();

        final List list = session.createQuery("from User u WHERE u.height = '" + height + "' ").list();

        if(list.size() == 0)
        {
            listener.onError("No User Found");

        }else
        {
            listener.onComplete(list);
        }


        session.close();

    }

    @Override
    public void addNewUser(User user)
    {

        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();

        session.save(user);

        session.getTransaction().commit();



        sessionFactory.close();
        }catch (HibernateException e)
        {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
        }

        session.close();
    }

    @Override
    public void deleteUser(String userName)
    {

        Session session = sessionFactory.openSession();

        session.beginTransaction();

        getUsersByName(userName, new RequestListener()
        {
            @Override
            public void onComplete(Object o)
            {
                List userList = (List) o;

                for (int i = 0; i <userList.size() ; i++)
                {
                    session.delete(userList.get(i));
                    session.getTransaction().commit();
                }
            }

            @Override
            public void onError(String errorMsg)
            {
                System.out.println(errorMsg);
            }
        });

        session.close();


    }

    @Override
    public void getActivityById(int id, RequestListener listener)
    {

        Session session = sessionFactory.openSession();

        session.beginTransaction();

        List list = session.createQuery("from Activity a where a.id ='" + id + "'").list();

        if(list.size() == 0)
        {
            listener.onError("No Activity Found");
        }else
        {
            listener.onComplete(list.get(0));
        }

        session.close();
    }

    @Override
    public void getActivitiesByName(String name, RequestListener listener)
    {
        sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        List list = session.createQuery("from Activity a where a.name ='" + name + "'").list();

        if(list.size() == 0)
        {
            listener.onError("NO Activities Found");
        }else
        {
            listener.onComplete(list);
        }
        session.close();
    }

    @Override
    public void getActivitiesBySets(boolean hasSets, RequestListener listener)
    {
        Session session = sessionFactory.openSession();

        session.beginTransaction();


        List list = session.createQuery("from Activity a where a.hasSets ='" + hasSets + "'").list();

        if(list.size() == 0)
        {
            listener.onError("NO Activities Found");
        }else
        {
            listener.onComplete(list);
        }
        session.close();

    }
    @Override
    public void addNewActivity(Activity activity)
    {

        Session session = sessionFactory.openSession();

        session.beginTransaction();

        session.save(activity);

        session.getTransaction().commit();

        session.close();

    }

    public void deleteActivity(String activityName)
    {
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        getActivitiesByName(activityName, new RequestListener()
        {
            @Override
            public void onComplete(Object o)
            {
                List activities = (List) o;

                for (int i = 0; i <activities.size() ; i++)
                {
                    session.delete(activities.get(i));

                }

            }

            @Override
            public void onError(String errorMsg)
            {
                System.out.println(errorMsg);
            }
        });

        session.getTransaction().commit();
        session.close();

    }

}