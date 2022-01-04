package com.ugam.core.models.impl;

import com.day.cq.search.PredicateGroup;
import com.day.cq.search.Query;
import com.day.cq.search.QueryBuilder;
import com.day.cq.search.result.Hit;
import com.day.cq.search.result.SearchResult;
import com.ugam.core.models.Users;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import junitx.util.PrivateAccessor;
import org.apache.sling.testing.mock.sling.ResourceResolverType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.jcr.RepositoryException;
import javax.jcr.Session;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@ExtendWith({AemContextExtension.class, MockitoExtension.class})
class UserImplTest {
    private final AemContext aemContext = new AemContext(ResourceResolverType.JCR_MOCK);


    @BeforeEach
    void setUp() {
        aemContext.addModelsForClasses(Users.class);
        aemContext.load().json("/usernames.json","/content");
    }

    @Test
    void getUsernames() throws RepositoryException, NoSuchFieldException {
        Users users = aemContext.request().adaptTo(Users.class);
        final List<Hit> results = new ArrayList<>();
        Hit UserResult1 = mock(Hit.class);
        Mockito.when(UserResult1.getProperties()).thenReturn(aemContext.currentResource("/content/users/ugam").getValueMap());
        results.add(UserResult1);
        SearchResult SearchResult = mock(SearchResult.class);
        Query userQuery = mock(Query.class);
        QueryBuilder queryBuilder = mock(QueryBuilder.class);
        PrivateAccessor.setField(users, "queryBuilder", queryBuilder);
        Mockito.when(queryBuilder.createQuery(Mockito.any(PredicateGroup.class), Mockito.any(Session.class))).thenReturn(userQuery);
        Mockito.when(userQuery.getResult()).thenReturn(SearchResult);
        Mockito.when(SearchResult.getHits()).thenReturn(results);
        assertEquals(""+"\r\nugam",users.getUsernames());
    }
}