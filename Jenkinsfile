pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                git 'https://github.com/your-repo-url.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Unit Tests') {
            steps {
                sh 'mvn test -Punit-tests'
            }
        }

        stage('Integration Tests') {
            steps {
                sh 'mvn test -Pintegration-tests'
            }
        }
    }

    post {
        always {
            // Publish test results
            junit 'target/surefire-reports/*.xml'
        }
    }
}