package utils;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * Created by Daniel on 7/19/2015.
 */

/*
   Single-ton class
 */
public class SqlQueries {

    public static SqlQueries instance = null;
   // private static final String createUserQuery = "insert into user (firstName, lastName, userName, password, email, dob, gender, joinDate)" +
   //         "values (%1$s, %2$s, %3$s, %4$s, %5$s, %6$tD, %7$s, %8$tD)";

    private static final String createUserQuery = "insert into user (firstName, lastName, userName, password, email, dob, gender, joinDate)" +
            "values (?, ?, ?, ?, ?, ?, ?, ?)";

    public static SqlQueries getInstance() {
        if(instance == null) {
            instance = new SqlQueries(true);
        }
        return instance;
    }

    private  Map<String, String> queries;

    protected SqlQueries(boolean newInstance){
        queries  = new HashMap();
        queries.put("GetUser","select * from user where userId='%1$s' or email='%1$s'");
        queries.put("GetAllUsers","select * from user");
        queries.put("CreateUser", createUserQuery);
    }

    public String getQuery(String queryRef, Object... args){
        String query = queries.get(queryRef);
        String s = String.format(query,args);
        return s;
    }
}
