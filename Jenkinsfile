pipeline{
    agent any
    stages{
        /**
        stage ('Build Backend'){
            steps{
                bat 'mvn clean package -DskipTests=true'
            }
        }
        stage ('Unit Tests'){
            steps{
                bat 'mvn test'
            }
        }
        **/
        stage ('Sonar Analise'){
            environment {
               scannerHome = tool 'SONAR_SCANNER' 
            }
            steps{
                withSonarQubeEnv(credentialsId: 'SonarToken', installationName: 'SONAR_LOCAL'){
                    bat '''mvn clean verify sonar:sonar -Dsonar.projectKey=DeployBack -Dsonar.projectName='DeployBack' -Dsonar.host.url=http://localhost:9001  -Dsonar.java.binaries=target -Dsonar.coverage.exclusions=**/.mvn/**,**/src/test/**,**/model/**,**Aplication.java''' 
                    echo 'SonarQube Analysis Completed'
                
                }
            }
        }
        stage ('Qualit Gate'){
            steps{
                sleep(20)
                timeout(time: 2, unit: 'MINUTES')
                waitForQualityGate abortPipeline: false, credentialsId: 'SonarToken'
            }
        }
    }
}

                    