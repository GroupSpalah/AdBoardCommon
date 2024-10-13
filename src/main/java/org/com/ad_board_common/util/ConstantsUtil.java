package org.com.ad_board_common.util;

public class ConstantsUtil {

    public static final String PRICE = "price";
    public static final String PRICE_FROM = "price_from";
    public static final String PRICE_TO = "price_to";
    public static final String HEADING = "heading";
    public static final String AUTHOR = "author";
    public static final String WORD = "word";
    public static final String CONTENT = "content";
    public static final String SUBJECT = "subject";
    public static final String NAME = "name";
    public static final String PHONES = "phones";
    public static final String ADDRESS_ID = "address_id";
    public static final String EMAIL = "email";
    public static final String FIRST_NAME = "first_name";
    public static final String LAST_NAME = "last_name";
    public static final String HEADING_ID = "heading_id";
    public static final String HEADING_ID2 = "headingId";
    public static final String HEADING_IDS = "heading_ids";
    public static final String AD_ID = "ad_id";
    public static final String AUTHOR_ID = "author_id";
    public static final String FK_AD_AUTHOR = "FK_Ad_Author";
    public static final String FK_MAD_AUTHOR = "FK_Mad_Author";
    public static final String FK_AD_HEADING = "FK_Ad_Heading";
    public static final String FK_MAD_HEADING = "FK_Mad_Heading";
    public static final String PUBLICATION_DATE = "publication_date";
    public static final String UNIT_NAME = "test-dmytro";
    public static String UPDATE_HEADING = "UPDATE Heading h SET h.name = :name" +
            "WHERE l.id = :heading_id";

    public static String UPDATE_AD =
            "UPDATE Ad a SET a.name = :name, a.publicationDate = :publication_date, a.content = :content, " +
                    "a.price = :price, a.heading = :FK_Ad_Heading, a.author = :FK_Ad_Author " +
                    "WHERE a.id = :ad_id";

    public static String UPDATE_AUTHOR =
            "UPDATE Author a SET a.firstName = :first_name, a.lastName = :last_name, a.phones = :FK_Phone_Author, " +
                    "a.address = :address, a.email = :email" +
                    "WHERE a.id = :author_id";
    public static final String DELETE_AD = "DELETE FROM Ad a " +
            "WHERE a.id = :ad_id";

    public static final String DELETE_ADDRESS = "DELETE FROM Address a" +
            " WHERE a.id = :address_id";

    public static final String DELETE_AUTHOR = "DELETE FROM Author a " +
            "WHERE a.id = :author_id";

    public static final String DELETE_ADS_BY_AUTHOR = "DELETE FROM Ad a " +
            "WHERE a.author.id = :FK_Ad_Author";//через точку можно углубляться в сущность

    public static final String DELETE_MADS_BY_AUTHOR = "DELETE FROM MatchingAd ma " +
            "WHERE ma.author.id = :FK_Mad_Author";

    public static final String DELETE_ADS_BY_HEADING = "DELETE FROM Ad a " +
            "WHERE a.heading.id = :FK_Ad_Heading";

    public static final String DELETE_INACTIVE_ADS = "DELETE FROM Ad a " +
            "WHERE a.isActive = false";

    public static final String DELETE_MADS_BY_HEADING = "DELETE FROM MatchingAd ma " +
            "WHERE ma.heading.id = :FK_Mad_Heading";

    public static final String SELECT_ADS_BY_PUBLICATION_DATE = "FROM Ad a " +
            "JOIN FETCH a.heading h " +
            "JOIN FETCH a.author au " +
            "JOIN FETCH au.phones " +
            "WHERE a.publicationDate = :publication_date";//можно сделать через DTO?

    public static final String SELECT_ADS_BY_HEADINGS = "FROM Ad a " +
            "JOIN FETCH a.heading h " +
            "JOIN FETCH a.author au " +
            "JOIN FETCH au.phones " +
            "WHERE h.id IN :heading_ids";

    public static final String SELECT_ADS_BY_AUTHOR_ID = "FROM Ad a " +
            "JOIN FETCH a.heading h " +
            "JOIN FETCH a.author au " +
            "JOIN FETCH au.phones " +
            "WHERE a.author.id IN :FK_Ad_Author";

    public static final String SELECT_ADS_BY_BY_KEYWORD = "FROM Ad a " +
            "JOIN FETCH a.heading h " +
            "JOIN FETCH a.author au " +
            "JOIN FETCH au.phones " +
            "WHERE a.content " +
            "LIKE CONCAT('%', :word, '%')";

    public static final String CONCAT = "LIKE CONCAT('%', :word, '%')";

    public static final String DELETE_AD_BY_HEADING = "DELETE FROM Ad a " +
            "WHERE a.heading = :FK_Ad_Heading";

    public static final String DELETE_HEADING = "DELETE FROM Heading h " +
            "WHERE h.id = :heading_id";

    public static final String SELECT_MADS_BY_PARAMS =
            "SELECT ma FROM MatchingAd ma " +
                    "WHERE (ma.heading IS NULL OR ma.heading.id = :headingId) " +
                    "AND (ma.priceFrom IS NULL OR ma.priceFrom <= :price)" +
                    "AND (ma.priceTo IS NULL OR ma.priceTo >= :price)" +
                    "AND (ma.subject IS NULL OR :content LIKE CONCAT('%', ma.subject, '%'))";

}
