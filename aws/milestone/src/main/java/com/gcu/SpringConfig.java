package com.gcu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;

import com.gcu.business.AllValidLogins;
import com.gcu.business.ProductsBusinessService;
import com.gcu.business.ProductsBusinessServiceInterface;
import com.gcu.business.SecurityServiceInterface;

@Configuration
public class SpringConfig {
    
    
    @Bean(name="productsBusinessService", initMethod="init", destroyMethod="destroy")
    @RequestScope
    public ProductsBusinessServiceInterface getProductsBusiness(){
        return new ProductsBusinessService();
    }

    @Bean(name="securityService")
    public SecurityServiceInterface getSecurityService(){
        return new AllValidLogins();
    }

    //@Bean(name=("productsDAO"))
    //public ProductDataAccessInterface getDataSource(){
      //  return new ProductDataService();
    //}
}
