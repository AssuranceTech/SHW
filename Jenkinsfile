stage 'Compile'
node('master') 
{        
    checkout scm            
    def mvnHome = tool 'maven-3.3.9'        
    sh "${mvnHome}/bin/mvn clean install -DskipTests"        
    stash 'working-copy'
}
stage 'Test'
node('master') 
{        
    unstash 'working-copy'        
    def mvnHome = tool 'maven-3.3.9'        
    sh "${mvnHome}/bin/mvn test -Diterations=10"    
}
