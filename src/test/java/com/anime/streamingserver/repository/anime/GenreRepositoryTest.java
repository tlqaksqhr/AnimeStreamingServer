package com.anime.streamingserver.repository.anime;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@SpringBootTest
@Transactional
public class GenreRepositoryTest {

    @Autowired
    GenreRepository genreRepository;

    @PersistenceContext
    EntityManager em;
}
