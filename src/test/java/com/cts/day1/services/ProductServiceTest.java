package com.cts.day1.services;

import com.cts.day1.dao.ProductRepository;
import com.cts.day1.model.Product;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static com.googlecode.totallylazy.matchers.NumberMatcher.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

public class ProductServiceTest {


    @InjectMocks
    private ProductServiceImple service;

    @Mock
    private ProductRepository productRepository;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void thatGetAllProducts() {

        List<Product> mockData = new ArrayList<>();
        mockData.add(new Product(1l, "demo"));
        when(productRepository.findAll()).thenReturn(mockData);

        List<Product> results = service.readAllProducts();
        assertThat(results.size(), is(mockData.size()));

    }

}