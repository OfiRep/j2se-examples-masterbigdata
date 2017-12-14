pipeline {
    agent any
    
  stages {
    stage('Clean Workspace') {
        steps {
            cleanWs()
        }
    }
    
    stage('Say Hello') {
        steps {
            echo 'Hello From Pipeline!'
        }
    }
  }
}
