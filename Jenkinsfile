pipeline{
    agent any
    stages{
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
        stage ('Sonar Alalise'){
            enviroment{
               scannerHome = tool 'SONAR_SCANNER' 
            }
            steps{
                withSonarQubeEnv('SONAR_LOCAL'){
                    bat "${scannerHome}/bin/sonar-scanner -e -Dsonar.projectKey=DeployBack -Dsonar.host.url=http://localhost:9001 -Dsonar.login=sqp_420644930ab2e967da07aed565046451e405060d -Dsonar.java.binaries=target -Dsonar.coverage.exclusions=**/.mvn/**,**/src/test/**,**/model/**,**Aplication.java "
                }
            }
        }
    }
}

