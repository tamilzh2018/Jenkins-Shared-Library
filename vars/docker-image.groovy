def call() {
    sh '''
    #download the jar file from nexus
    curl -u admin:admin@123 -O http://10.0.0.130:8083/repository/docker-reg/com/myproject/app/specific-service-repo/$JAR_VERSION/ \
    specific-service-repo-$JAR_VERSION.jar
    #build the docker image
    docker build --build-arg JAR_FILE=specific-service-repo-$JAR_VERSION.jar -t specific-service-repo:$IMAGE_VERSION .
    #docker repo login
    docker login 10.0.0.130:8083 -u admin -p admin@123
    #Tagging Docker image...
    docker tag specific-service-repo:$IMAGE_VERSION \
    10.0.0.130:8083/repository/docker-reg/specific-service-repo:$IMAGE_VERSION
    #push the docker image to nexus
    docker push 10.0.0.130:8083/repository/docker-reg/specific-service-repo:$IMAGE_VERSION
    '''
    }