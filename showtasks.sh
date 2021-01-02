
if ./runcrud.sh; then
  sleep 2
  open http://localhost:8080/crud/v1/task/getTasks
else
  echo "Something went wrong"
fi