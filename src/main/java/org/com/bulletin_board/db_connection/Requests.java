package org.com.bulletin_board.db_connection;

import lombok.Value;

@Value
public class Requests {
    public static String FACTORY_NAME = "bulletin_board";
    public static String SET_ID = "user_id";


    public static String GET_BY_ID = "SELECT a FROM Ad a WHERE a.id = :user_id";


}
