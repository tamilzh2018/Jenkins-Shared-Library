def call() {
sh ''' 
clean deploy \
sonar:sonar \
-DbuildNumber=${BUILD_NUMBER}  \
    -Drelease-repository.url=http://10.0.0.130:8081/repository/maven-releases/  \
    -Dsnapshot.repository.url=http://10.0.0.130:8081/repository/maven-snapshots/
    '''
}