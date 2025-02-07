def call() {
sh ''' 
mvn clean deploy \
sonar:sonar \
-DbuildNumber=${BUILD_NUMBER}  \
    -Drelease-repository.url=http://10.0.0.130:8081/repository/maven-releases/  \
    -Dsnapshot.repository.url=http://10.0.0.130:8081/repository/maven-snapshots/ \
    -Dsonar.token=squ_62694a7551bf44e025ceb3f4d99960724d657806
    '''
}
