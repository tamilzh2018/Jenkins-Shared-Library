def call(String repositoryId, String credentialsId) {
    echo "nexusDeploy: repositoryId=${repositoryId}, credentialsId=${credentialsId}"
    withCredentials([usernamePassword(credentialsId: 'Nexus-Credentials', usernameVariable: 'NEXUS_USERNAME', passwordVariable: 'NEXUS_PASSWORD'), string(credentialsId: credentialsId, variable: 'NEXUS_REPO_URL')]) {
        echo "Deploying to Nexus repository: ${NEXUS_REPO_URL}"
        sh """
         mvn deploy -DskipTests -Dmaven.wagon.http.ssl.insecure=true -Dmaven.wagon.http.ssl.allowall=true \
        -DaltDeploymentRepository=${repositoryId}::default::${NEXUS_REPO_URL} \
        -Dusername=${NEXUS_USERNAME} \
        -Dpassword=${NEXUS_PASSWORD}
        """
    }
}
