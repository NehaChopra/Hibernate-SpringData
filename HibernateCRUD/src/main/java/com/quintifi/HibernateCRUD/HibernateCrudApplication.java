package com.quintifi.HibernateCRUD;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * Spring Boot Data enables JPA repository support by default. CrudRepository provides generic CRUD operation on a repository 
 * for a specific type. CrudRepository is a Spring data interface and to use it we need to create our interface by extending 
 * CrudRepository. Spring provides CrudRepository implementation class automatically at runtime. It contains methods such as 
 * save, findById, delete, count etc. Spring boot automatically detects our repository if the package of that repository interface 
 * is the same or sub-package of the class annotated with @SpringBootApplication.
 * Spring Boot provides default database configurations when it scans Spring Data JPA in classpath. Spring boot uses 
 * spring-boot-starter-data-jpa starter to configure spring JPA. For data source we need to configure data source properties 
 * starting with spring.datasource.* in application.properties. In Spring Boot 2.0 release, default database pooling technology 
 * has been switched from Tomcat Pool to HikariCP. Spring boot prefers HikariCP on first place then Tomcat pooling and then 
 * Commons DBCP2 on the basis of availability. Here on this page we will create a Spring Boot Rest web Service for CRUD operation. 
 * 
 * 
 * CrudRepository is an interface and extends Spring data Repository interface. CrudRepository provides generic CRUD 
 * operation on a repository for a specific type. It has generic methods for CRUD operation. To use CrudRepository we
 *  have to create our interface and extend CrudRepository. We need not to implement our interface, its implementation will be 
 *  created automatically at runtime. 
 *  
 *  CrudRepository has subinterface as PagingAndSortingRepository that provide additional methods to retrieve entities using 
 *  the pagination and sorting abstraction.
 *  
 *  
 */

/*
 * 
 * Steps to Use CrudRepository
 * 
 * 	1 Create an Interface extending CrudRepository
 * 2 Auto-Detection of JPA Repository
 * 		 if the package of that interface is the same or sub-package of the class annotated with @SpringBootApplication and if not then we need to use @EnableJpaRepositories annotation with @SpringBootApplication
 * 		 if we choose a package for our repository that is neither same package nor sub-package of the package of the class annotated with @SpringBootApplication, then Spring boot will not be able to detect repository classes by default. In this case we need to use @EnableJpaRepositories annotation with @SpringBootApplication.	 
 * 		 If we want to configure specific classes then we need to use basePackageClasses attribute of the @EnableJpaRepositories annotation.
 * 
 * 
 * 
 * 
 * Custom Repository Methods
 * CrudRepository provides methods for generic CRUD operation and if we want to add custom methods in our interface that has extended 
 * CrudRepository, we can add in following ways
 * a. We can start our query method names with find...By, read...By, query...By, count...By, and get...By. Before By we can add expression 
 * such as Distinct . After By we need to add property names of our entity. 
 * b. To get data on the basis of more than one property we can concatenate property names using And and Or while creating method names. 
 * c. If we want to use completely custom name for our method, we can use @Query annotation to write query. 
 * 
 * 
 * @Transactional with CrudRepository
 * CRUD methods of CrudRepository are transactional by default. They are annotated with @Transactional annotation with default settings 
 * in implementation class at runtime. For reading operation readOnly flag is set to true. To override default transactional settings of 
 * any CrudRepository methods we need to override that method in our interface and annotate with @Transactional using required configurations
 * 
 * 
 */
@SpringBootApplication
public class HibernateCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateCrudApplication.class, args);
	}

}
