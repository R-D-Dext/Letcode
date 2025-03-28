pipeline {
    agent {
        docker {
            image 'maven:3.8.4-openjdk-17'  // Используем образ с Maven и JDK 17
            args '-v /tmp/.m2:/root/.m2'   // Монтируем директорию .m2 для кеша зависимостей
        }
    }
    environment {
        SELENIUM_HOST = "http://localhost:4444/wd/hub"  // Адрес Selenium Grid
    }
    stages {
        stage('Checkout Code') {
            steps {
                git 'https://github.com/R-D-Dext/Letcode'  // URL репозитория с автотестами
            }
        }
        stage('Install Dependencies') {
            steps {
                sh 'mvn clean install'  // Устанавливаем зависимости
            }
        }
        stage('Run Selenium Tests') {
            steps {
                sh 'mvn test'  // Запускаем тесты
            }
        }
        stage('Generate Allure Report') {
            steps {
                sh 'mvn allure:report'  // Генерируем отчет Allure
            }
        }
    }
    post {
        always {
            junit '**/target/test-*.xml'  // Публикуем результаты тестов (JUnit формат)
            allure includeProperties: false, results: [[path: 'target/allure-results']]  // Публикуем Allure отчет
        }
    }
}
