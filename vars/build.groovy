def call() {
  echo "build the code"
  sh """
  mvn clean install
  """
}
