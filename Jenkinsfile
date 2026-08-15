pipeline {
    agent any

    stages {
        stage('Checking out the code from GITHUB') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/muthunsuman/git-actions-aws-project.git'
            }
        }

        stage('Compile the Code') {
            steps {
                sh '/opt/maven/maven/bin/mvn clean package'
            }
        }

        stage('SonarQube Code Analysis') {
            steps {
                script {
                    withSonarQubeEnv('sonarqube-service') {
                        sh 'mvn sonar:sonar'
                    }
                }
            }
        }

        stage('Quality Gate') {
            steps {
                script {
                    timeout(time: 1, unit: 'HOURS') {
                        waitForQualityGate abortPipeline: true
                    }
                }
            }
        }
    }
}
