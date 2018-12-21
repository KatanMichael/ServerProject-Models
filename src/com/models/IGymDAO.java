package com.models;

import com.models.Activity;
import com.models.RequestListener;
import com.models.User;

public interface IGymDAO {
    //Users
    void getAllUsers(RequestListener listener);

    void getUserById(int queryId, RequestListener listener);

    void getUsersByName(String name, RequestListener listener);

    void getUserByWeight(double weight, RequestListener listener);

    void getUserByHeight(double height, RequestListener listener);

    void addNewUser(User user);

    void deleteUser(String userName);

    /*
    Keywords are "equal", "above", "below"
     */

    //Activities
    void getActivityById(int id, RequestListener listener);

    void getActivitiesByName(String name, RequestListener listener);

    void getActivitiesBySets(boolean hasSets, RequestListener listener);

    void addNewActivity(Activity activity);

    void deleteActivity(String activityName);

}


