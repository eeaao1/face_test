@echo
e:
cd e://code/tbsp-cmpbiz5.0
git pull
call mvn clean install -Dmaven.test.skip=true
cd E:\code\tbsp-cmpbiz5.0\tbsp-cmpbiz-deploy\target
unzip tbsp-cmpbiz-zip-dev.zip
copy E:\code\tbsp-cmpbiz5.0\tbsp-cmpbiz-deploy\target\tbsp-app\tbsp-app\tbsp-cmpbiz-5.0.2-SNAPSHOT.jar E:\ddd
rmdir /s /q tbsp-app
cd e://ddd
java -jar autoDeploy-1.0-SNAPSHOT.jar