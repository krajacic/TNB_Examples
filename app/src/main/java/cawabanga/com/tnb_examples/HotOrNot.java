package cawabanga.com.tnb_examples;

/**
 * Created by croatan on 5.3.2016. TNB_Examples.
 */
public class HotOrNot {

    public static final String KEY_ROWID = "_id"; // public means other class can access it static we don't wanna change Final-that never gonna change
    public static final String KEY_NAME = "persons_name";
    public static final String KEY_HOTNESS = "persons_hotness";

    private static final String DATABASE_NAME = "HotOrNotdb";
    private static final String DATABASE_TABLE = "peopleTable";
    private static final int DATABASE_VERSION = 1;

}
