pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/R-D-Dext/Letcode'
            }
        }
        stage('Run Tests') {
            steps {
                sh 'mvn clean test'
            }
        }
        stage('Generate Allure Report') {
            steps {
                sh 'mvn allure:report'
            }
        }
    }
}