docker build . -t travel:elastic-search
docker run -p 9200:9200 -e "http.host=0.0.0.0" -e "transport.host=127.0.0.1" --name travel:elastic-search travel:elastic-search
