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
                    results: [[path: 'target/allure-results']]
                ])
            }
        }
        stage('Notify Team') {
            steps {
                emailext subject: 'Test Execution Report',
                         body: 'Tests completed. Check the Jenkins dashboard for details.',
                         recipientProviders: [[$class: 'DevelopersRecipientProvider']]
            }
        }

    }
}
