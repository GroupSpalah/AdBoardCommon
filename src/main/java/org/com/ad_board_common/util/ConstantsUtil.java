package org.com.ad_board_common.util;

public class ConstantsUtil {

    public static final String PRICE = "price";
    public static final String HEADING = "heading";
    public static final String AUTHOR = "author";
    public static final String CONTENT = "content";
    public static final String NAME = "name";
    public static final String PHONES = "phones";
    public static final String ADDRESS = "address";
    public static final String EMAIL = "email";
    public static final String FIRST_NAME = "first_name";
    public static final String LAST_NAME = "last_name";
    public static final String HEADING_ID = "heading_id";
    public static final String AD_ID = "ad_id";
    public static final String AUTHOR_ID = "author_id";
    public static final String FK_AD_AUTHOR = "FK_ad_author";
    public static final String FK_AD_HEADING = "FK_ad_heading";
    public static final String PUBLICATION_DATE = "publication_date";
    public static final String UNIT_NAME = "test-dmytro";
    public static String UPDATE_HEADING = "UPDATE Heading h SET h.name = :name" +
            "WHERE l.id = :heading_id";

    public static String UPDATE_AD =
            "UPDATE Ad a SET a.name = :name, a.publicationDate = :publication_date, a.content = :content, " +
                    "a.price = :price, a.heading = :FK_ad_heading, a.author = :FK_ad_author " +
                    "WHERE a.id = :ad_id";

    public static String UPDATE_AUTHOR =
            "UPDATE Author a SET a.firstName = :first_name, a.lastName = :last_name, a.phones = :FK_author_phone, " +
                    "a.address = :address, a.email = :email" +
                    "WHERE a.id = :author_id";
    public static final String DELETE_AD = "DELETE FROM Ad a " +
            "WHERE a.id = :ad_id";

    public static final String DELETE_AUTHOR = "DELETE FROM Author a " +
            "WHERE a.id = :author_id";

    public static final String DELETE_AD_BY_AUTHOR = "DELETE FROM Ad a " +
            "WHERE a.author = :FK_ad_author";

    public static final String DELETE_AD_BY_HEADING = "DELETE FROM Ad a " +
            "WHERE a.heading = :FK_ad_heading";

    public static final String DELETE_HEADING = "DELETE FROM Heading h " +
            "WHERE h.id = :heading_id";

}
