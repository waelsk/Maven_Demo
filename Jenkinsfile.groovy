pipeline {
    agent any

    stages {
 stage('clone code') {
            steps {
              git 'https://github.com/waelsk/Maven_Demo.git'
                echo 'Clone done..'
            }
        }
        stage('Build') {
            steps {
              bat label: '', script: 'mvn clean install'
                echo 'Building..'
            }
        }
         
 
         stage('Test') {
            steps {
               bat label: '', script: 'mvn test'
                echo 'Testing..'
            }
        }
        
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
      
    }
      post('send email') {
            always {
              emailext body: 'test', subject: 'C1', to: 'wael.soukeh@esprit.tn'
               echo 'success..'
            }
        }
}
