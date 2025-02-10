# Log in to Nexus Docker registry
docker login 10.0.0.130:8083 -u admin -p admin@123
# Tag the Docker image with the dynamic version
docker tag specific-service-repo:$IMAGE_VERSION 10.0.0.130:8083/repository/docker-reg/specific-service-repo:$IMAGE_VERSION
#Push the image to nexus docker repo
docker push 10.0.0.130:8083/repository/docker-reg/specific-service-repo:$IMAGE_VERSION
