package com.models;

public interface IGymDAO
{
    //Users
    public void getUserbyId(int id, RequestListener listener);
    public void getUsersByName(String name,RequestListener listener);
    public void getUserByWeight(int weight, String keyWord, RequestListener listener);
    public void getUserByHeight(int height, String keyWord, RequestListener listener);

    /*
    Keywords are "equal", "above", "below"
     */


    //Activities
    public void getActivityById(int id, RequestListener listener);
    public void getActivitiesByName(String name, RequestListener listener);
    public void getActivitiesBySets(boolean hasSets, RequestListener listener);


}
