Опис
Для коретного запуску програми потрібно:
У файлі application.properties поміняти логін і пароль до бази даних та назву бази даних
spring.datasource.username=username
spring.datasource.password=password
При необхіності змінити порт та назву бази даних
spring.datasource.url=jdbc:postgresql://localhost:5433/university

Для відправлення пвідомлень через електронну пошту потрібно 
У пакеті mail клас SendEmail потрбно вказати електронну адресу та пароль із якої будуть відправлятись повідомлення
String username = "username";
String password = "password";
Повідомлення можуть не відправлятись якщо не встановлений дозвіл на використання сторонніми програмами


для створення ролей користувачів можна перейти використати посилання 
localhost:8080/api/open/createroles 
Створення 3 користувачів 
localhost:8080/api/open/createuser
За бажанням можна заповнити базу тестовими диними вручну крім коритувачів оскільки паролі шифруються 
