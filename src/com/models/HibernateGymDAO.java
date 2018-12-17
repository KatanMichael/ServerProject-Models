package com.models;

import com.models.Activity;
import com.models.RequestListener;
import com.models.User;
import org.hibernate.Criteria;
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
    public void getUserbyId(int id, RequestListener listener)
    {
        sessionFactory =  new AnnotationConfiguration().
                configure().buildSessionFactory();

        Session session = sessionFactory.openSession();

        session.beginTransaction();

        final List list = session.createQuery("from User u where u.id = id").list();

        if(list.size() == 0)
        {
            listener.onError("No User Found");
        }else
        {
            listener.onComplete(list.get(0));
        }

    }

    @Override
    public void getUsersByName(String name, RequestListener listener)
    {

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