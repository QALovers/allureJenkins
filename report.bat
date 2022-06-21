call mvn clean test
call xcopy allure-report\history allure-results\history /E /Y
call allure generate --clean
call allure open