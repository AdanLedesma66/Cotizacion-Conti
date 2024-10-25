pipeline {
    agent any

    stages {
        stage('Checkout SCM') {
            steps {
                git url: 'https://github.com/AdanLedesma66/Cotizacion-Conti.git',
                    branch: 'main',
                    credentialsId: '67478233-aeb5-4566-8ebd-a87c0494d7dd'
            }
        }

        stage('Build') {
            steps {
                echo "Building the project"
                sh 'mvn clean install'
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    dockerImage = docker.build("cotip-test:${env.BUILD_NUMBER}")
                }
            }
        }

        stage('Deploy Docker') {
            steps {
                script {
                    echo "Deploying Docker Image"

                    bat "docker stop cotip-test || exit 0"
                    bat "docker rm cotip-test || exit 0"
                    bat "docker run --name cotip-test -d -p 8081:8081 cotip-test:${env.BUILD_NUMBER}"
                }
            }
        }
    }

    post {
        always {
            echo 'Pipeline Finished'
        }
    }
}
