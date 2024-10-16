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
                    
                    bat "${scannerHome}/bin/sonar-scanner -e -Dsonar.projectKey=DeployBack -Dsonar.host.url=http://192.168.0.13:9001 -Dsonar.login=sqa_2353e6bc3e5221269827ef36280ee508acc59548 -Dsonar.java.binaries=target -Dsonar.coverage.exclusions=**/.mvn/**,**/src/test/**,**/model/**,**Aplication.java"
                }
            }
        }
    }
}

