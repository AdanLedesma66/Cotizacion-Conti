node {
//     def WORKSPACE = "/var/lib/jenkins/workspace/cotip-test" linux
    def WORKSPACE = "C:\\ProgramData\\Jenkins\\.jenkins\\workspace\\cotip-test"
    def dockerImageTag = "cotip-test${env.BUILD_NUMBER}"

    try{
//          notifyBuild('STARTED')
         stage('Clone Repo') {
            // for display purposes
            // Get some code from a GitHub repository
            git url: 'https://github.com/AdanLedesma66/Cotizacion-Conti.git',
                credentialsId: '67478233-aeb5-4566-8ebd-a87c0494d7dd',
                branch: 'main'
         }
          stage('Build docker') {
                 dockerImage = docker.build("cotip-test:${env.BUILD_NUMBER}")
          }

          stage('Deploy docker'){
            echo "Docker Image Tag Name: ${dockerImageTag}"

            sh "docker stop cotip-test || true"
            sh "docker rm cotip-test || true"
            sh "docker run --name cotip-test -d -p 8081:8081 cotip-test:${env.BUILD_NUMBER}"
          }
    }catch(e){
//         currentBuild.result = "FAILED"
        throw e
    }finally{
//         notifyBuild(currentBuild.result)
    }
}
