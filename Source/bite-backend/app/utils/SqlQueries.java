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
    }

    public String getQuery(String queryRef, String... strs){
        String query = queries.get(queryRef);
        String s = String.format(query,strs);
        return s;
    }
}
