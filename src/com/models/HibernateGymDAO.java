package com.models;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import java.util.List;

public class HibernateGymDAO implements models.IGymDAO
{
    private static HibernateGymDAO ourInstance = new HibernateGymDAO();
    private SessionFactory sessionFactory;


    public static HibernateGymDAO getInstance() {
        if (ourInstance == null) {
            ourInstance = new HibernateGymDAO();
        }
        return ourInstance;
    }

    private HibernateGymDAO() {
    }


    @Override
    public void getAllUsers(RequestListener listener)
    {
        sessionFactory = new AnnotationConfiguration().
                configure().buildSessionFactory();

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
        sessionFactory.close();

    }

    @Override
    public void getUserbyId(int queryId, RequestListener listener)
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

    }

    @Override
    public void getUsersByName(String name, RequestListener listener)
    {
        sessionFactory = new AnnotationConfiguration().
                configure().buildSessionFactory();

        Session session = sessionFactory.openSession();


    }

    @Override
    public void getUserByWeight(int weight, String keyWord, RequestListener listener)
    {

    }

    @Override
    public void getUserByHeight(int height, String keyWord, RequestListener listener)
    {

    }

    @Override
    public void addNewUser(User user)
    {
        sessionFactory = new AnnotationConfiguration().
                configure().buildSessionFactory();

        Session session = sessionFactory.openSession();

        session.beginTransaction();

        session.save(user);

        session.getTransaction().commit();

        session.close();

        sessionFactory.close();


    }

    @Override
    public void deleteUser(String userName)
    {
        sessionFactory = new AnnotationConfiguration().
                configure().buildSessionFactory();

        Session session = sessionFactory.openSession();

        session.beginTransaction();

        getUsersByName(userName, new RequestListener()
        {
            @Override
            public void onComplete(Object o)
            {


            }

            @Override
            public void onError(String errorMsg) {

            }
        });



    }

    @Override
    public void getActivityById(int id, RequestListener listener)
    {

    }

    @Override
    public void getActivitiesByName(String name, RequestListener listener)
    {

    }

    @Override
    public void getActivitiesBySets(boolean hasSets, RequestListener listener)
    {

    }

    public void addNewActivity(Activity activity)
    {
        sessionFactory = new AnnotationConfiguration().
                configure().buildSessionFactory();

        Session session = sessionFactory.openSession();

        session.beginTransaction();

        session.save(activity);

        session.getTransaction().commit();

        session.close();

        sessionFactory.close();
    }
}

//TODO Fill blanks Methods