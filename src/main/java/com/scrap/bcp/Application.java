package com.scrap.bcp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.client.RestTemplate;

/**
 * Application.
 *
 * @author Luis Alonso Ballena Garcia
 */
// @SpringBootApplication
public class Application {


    public static void main(String args[]) {

        int list[] = new int[]{1, 21, 8, 13, 6, 15, 7, 15};
        int impar[] = new int[list.length];
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list.length; j++) {
                if (list[i] < list[j]) {
                    int aux = list[i];
                    list[i] = list[j];
                    list[j] = aux;
                }
            }
        }

        for(int i=0; i<impar.length; i++){
            if(list[i] % 2 != 0){
                System.out.println(list[i]);
            }
        }

    }

    /*
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    // practice case - should be in other class (@Configuration in wherever module)
    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:i18n/messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @Bean
    public LocalValidatorFactoryBean getValidatorFactory(MessageSource messageSource) {
        LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
        localValidatorFactoryBean.getValidationPropertyMap().put("hibernate.validator.fail_fast", "true");
        localValidatorFactoryBean.setValidationMessageSource(messageSource);
        return localValidatorFactoryBean;
    }*/

}
