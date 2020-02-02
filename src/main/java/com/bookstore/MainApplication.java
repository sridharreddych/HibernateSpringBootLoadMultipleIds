package com.bookstore;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.bookstore.service.BookstoreService;

@SpringBootApplication
public class MainApplication {

    private final BookstoreService bookstoreService;

    public MainApplication(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {

            System.out.println("\n\nFetch by multiple IDs via @Query:");
            bookstoreService.fetchByMultipleIdsIn();

            System.out.println("\n\nFetch by multiple IDs via MultipleIdsRepository.byMultipleIds:");
            bookstoreService.fetchByMultipleIds();

            System.out.println("\n\nFetch by multiple IDs via MultipleIdsRepository.fetchInBatchesByMultipleIds:");
            bookstoreService.fetchInBatchesByMultipleIds();

            System.out.println("\n\nFetch by multiple IDs via MultipleIdsRepository.fetchBySessionCheckMultipleIds:");
            bookstoreService.fetchBySessionCheckMultipleIds();

            System.out.println("\n\nFetch by multiple IDs via MultipleIdsRepository.fetchInBatchesBySessionCheckMultipleIds:");
            bookstoreService.fetchInBatchesBySessionCheckMultipleIds();
        };
    }
}
/*
 * 
 * 
 * 
 * How To Load Multiple Entities By Id

Description: This is a SpringBoot application that loads multiple entities by id via a @Query based on the IN operator and via the Hibernate 5 MultiIdentifierLoadAccess interface.

Key points:

for using the IN operator in a @Query simply add the query in the proper repository
for using Hibernate 5 MultiIdentifierLoadAccess in Spring Data style provide the proper implementation
among its advantages, the MultiIdentifierLoadAccess implementation allows us to load entities by multiple ids in batches and by inspecting or not the current Persistent Context (by default, the Persistent Context is not inspected to see if the entities are already loaded or not)

 * 
 * 
 * 
 * 
 * 
 */
