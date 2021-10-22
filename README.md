# Construction Equipment Rental Software

> Web Application using Spring Boot with multiple modules

### Table of contents

- [General info](#general-info)
- [Screenshots](#screenshots)
- [Tools and Technologies](#technologies)
- [Setup](#setup)
- [Features](#features)
- [Status](#status)
- [Contact](#contact)

### General info

Internal system for renting construction equipment. The application is divided into two parts. The first one available for the administrator. Allows  to manage users, catalogs, construction sites, orders, and liabilities. The second part is available to users. Allows ordering construction equipment (has a shopping cart features), checking the order status and all liabilities for the given construction site. 							     The application is secured with the Spring Web Security.

### Screenshots

![login](https://user-images.githubusercontent.com/50141193/57782077-c42b9380-772b-11e9-9136-a91181732276.jpg)

![admin](https://user-images.githubusercontent.com/50141193/57782207-0fde3d00-772c-11e9-8528-99c79df116c3.jpg)

![user-form](https://user-images.githubusercontent.com/50141193/57783940-55e8d000-772f-11e9-8d93-62f7058aa72b.jpg)

![users](https://user-images.githubusercontent.com/50141193/57784078-98121180-772f-11e9-86f0-ab63b22d403e.jpg)

![cart](https://user-images.githubusercontent.com/50141193/57784168-c132a200-772f-11e9-817a-30665efdfd21.jpg)

![Orders](https://user-images.githubusercontent.com/50141193/57784228-dc9dad00-772f-11e9-967e-fc7863141030.jpg)

### Tools and Technologies

- **Java 8**
- **Spring Boot** - version 2.2.0
- **Spring Web MVC** - version 5.1.5.RELEASE
- **Spring Security** - version 5.1.4 RELEASE
- **Spring Data JPA** - version 2.2.0 
- **Hibernate** - version 5.4.0 Finale
- **Spring Validation** - version 2.0.1 RELEASE
- **Database engine** : Microsoft SQL 2016
- **Application Servicer** : Apache Tomcat Server
- **Maven**
- **Java Server Page**
- **JSTL**
- **HTML 5 and CSS 3**

### Setup

### Features

1. **Administrator :**

   - Add new user 
   - Search all users or one user
   - Edit User (modifying a user details)
   - Edit Security for user (change password, role etc.)
   - Add new construction site
   - Search and edit construction sites
   - Checking stock list for a given construction site
   - Add  items to catalog and edit items
   - Checking orders and change order status
   - Checking orders history
   - Checking all liabilities for a given construction site

2. **User** :

   - Ordering construction equipment (like a shopping cart)
   - Search all construction sites
   - Checking all orders for construction site where the user is assigned
   - Checking all liabilities for construction site where the user is assigned

3. **Security :**

   - Login system
   - Role system

4. **Validation :**

   - Server-side validation (Spring Validation)

   

### Status:

**Application status :** BETA 

### Contact:

Email : RainbowForestGit@gmail.com
