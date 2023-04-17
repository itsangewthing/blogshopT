package com.example.blogshopT.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.example.blogshopT.entity.Product;
import com.example.blogshopT.entity.ProductCategory;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer  {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
      
        RepositoryRestConfigurer.super.configureRepositoryRestConfiguration(config, cors);
        
        HttpMethod[] theUnsupportedActions =  {HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE};

        //disables HTTP Methods for Product: PUT, POST and DELETE
        config.getExposureConfiguration()
                .forDomainType(Product.class)
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions));
   
                //disables HTTP Methods for Product Category: PUT, POST and DELETE
        config.getExposureConfiguration()
                .forDomainType(ProductCategory.class)
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions));

     }
}
