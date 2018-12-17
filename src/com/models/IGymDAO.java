package models;

import com.models.Activity;
import com.models.RequestListener;
import com.models.User;

public interface IGymDAO
{
    //Users
    public void getAllUsers(RequestListener listener);
    public void getUserbyId(int id, RequestListener listener);
    public void getUsersByName(String name, RequestListener listener);
    public void getUserByWeight(int weight, String keyWord, RequestListener listener);
    public void getUserByHeight(int height, String keyWord, RequestListener listener);

    public void addNewUser(User user);
    public void deleteUser(String userName);

    /*
    Keywords are "equal", "above", "below"
     */

    //Activities
    public void getActivityById(int id, RequestListener listener);
    public void getActivitiesByName(String name, RequestListener listener);
    public void getActivitiesBySets(boolean hasSets, RequestListener listener);

    public void addNewActivity(Activity activity);

}


