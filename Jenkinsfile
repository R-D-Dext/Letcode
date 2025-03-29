pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/yourrepo.git'
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