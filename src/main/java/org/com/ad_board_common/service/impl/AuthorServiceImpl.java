package org.com.ad_board_common.service.impl;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.com.ad_board_common.dao.AuthorDao;
import org.com.ad_board_common.dao.impl.AuthorDaoImpl;
import org.com.ad_board_common.domain.Author;
import org.com.ad_board_common.domain.Heading;
import org.com.ad_board_common.service.AuthorService;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)

public class AuthorServiceImpl implements AuthorService<Author> {

    AuthorDao<Author> AUTHOR_DAO = new AuthorDaoImpl();

    @Override
    public void createAuthor(Author author) {
        AUTHOR_DAO.createAuthor(author);
    }

    @Override
    public void updateAuthor(Author author) {
        AUTHOR_DAO.updateAuthor(author);
    }

    @Override
    public Author getAuthorById(int id) {
        return AUTHOR_DAO.getAuthorById(id);
    }

    @Override
    public void deleteAuthor(Author author) {
        AUTHOR_DAO.deleteAuthor(author);
    }
}
