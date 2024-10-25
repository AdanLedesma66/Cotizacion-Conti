node {
    def WORKSPACE = "C:\\ProgramData\\Jenkins\\.jenkins\\workspace\\cotip-test"
    def dockerImageTag = "cotip-test${env.BUILD_NUMBER}"

    try {
        stage('Clone Repo') {
            git url: 'https://github.com/AdanLedesma66/Cotizacion-Conti.git',
                credentialsId: '67478233-aeb5-4566-8ebd-a87c0494d7dd',
                branch: 'main'
        }

        stage('Build docker') {
            dockerImage = docker.build("cotip-test:${env.BUILD_NUMBER}")
        }

        stage('Deploy docker') {
            echo "Docker Image Tag Name: ${dockerImageTag}"

            bat "docker stop cotip-test || exit 0"
            bat "docker rm cotip-test || exit 0"
            bat "docker run --name cotip-test -d -p 8081:8081 cotip-test:${env.BUILD_NUMBER}"
        }
    } catch(e) {
        throw e
    }
}
