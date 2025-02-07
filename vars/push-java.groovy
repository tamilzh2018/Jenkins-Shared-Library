def call(){
    curl -X POST -u "admin:admin" "http://localhost:9000/api/projects/create?name=MyProject&project=MyProject"
}