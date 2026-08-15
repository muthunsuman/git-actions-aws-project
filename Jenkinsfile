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

        stage('Upload to S3 Artifactory') {
            steps {
                sh 'aws s3 cp /var/lib/jenkins/workspace/cicproject/target/git-actions-aws-project-0.0.1-SNAPSHOT.war s3://jenkins-pipeline-sbucket/snapshot-artifacts/15aug.war'
            }
        }
stage('Deploy to Tomcat QA Server') {
    steps {
        sshagent(['tomcat']) {
            sh """
                scp -o StrictHostKeyChecking=no \
                /var/lib/jenkins/workspace/cicproject/target/git-actions-aws-project-0.0.1-SNAPSHOT.war \
                ubuntu@13.207.61.141:/opt/tomcat9/webapps/
            """
        }
    }
}
    }
}
