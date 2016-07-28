Install java memcache client packages:
1. download java_memcached-release_2.6.6.jar from http://download.csdn.net/download/habazhu1110/7493263
2. put the jar file in certain location
3. create a pom called java-memcached-2.6.6.pom, put it in the same location
4. run mvn install as following shows:

mvn install:install-file -Dfile=location\java_memcached-release_2.6.6.jar -DpomFile=location\java-memcached-2.6.6.pom

java_memcached installed success!