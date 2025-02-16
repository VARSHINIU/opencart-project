pipeline {
    agent any

    stages {
        stage('Checkout Code') {
            steps {
                git 'https://github.com/your-repo.git'
            }
        }
        stage('Build & Test') {
            steps {
                sh 'mvn clean test'
            }
        }
        stage('Generate Report') {
            steps {
                allure([
                    results: [[path: 'allure-reports']]
                ])
            }
        }
    }
}
