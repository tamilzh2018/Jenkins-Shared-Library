def call(String sonarProjectKey) {
    withSonarQubeEnv('SonarQube') {
        sh "mvn clean verify sonar:sonar -Dsonar.projectKey=${sonarProjectKey} -Dsonar.host.url=${env.SONAR_HOST_URL} -Dsonar.login=${env.SONAR_TOKEN}"
    }
}

