pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "M3"
        
        jdk "java"
    }

       stages {
        stage('Build') {
            steps {
                // Run Maven on a Linux agent.
                sh "cd Inventory-Service && mvn clean package install -DskipTests"
            }
        }

        stage('Building our image') { 
            steps { 
                script { 
                    sh "cd Inventory-Service && docker build -t ros_be ." 
                }
            } 
        }

        stage('Deploy') {
            steps {
                sh "docker run -d -p 8093:8093 ros_be"
            }
        }
    }
}
