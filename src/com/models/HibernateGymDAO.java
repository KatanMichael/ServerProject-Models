package com.models;

public class HibernateGymDAO implements IGymDAO
{
    private static HibernateGymDAO ourInstance = new HibernateGymDAO();

    public static HibernateGymDAO getInstance() {
        if (ourInstance == null) {
            ourInstance = new HibernateGymDAO();
        }
        return ourInstance;
    }

    private HibernateGymDAO() {
    }

    @Override
    public void getUserbyId(int id, RequestListener listener)
    {

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
}

//TODO Fill blanks Methods