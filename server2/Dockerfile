FROM openjdk:11-jdk-slim
COPY target/server2.jar /opt/server2.jar

ENTRYPOINT ["java",  "-Xms1024m", "-Xmx2048m", "-XX:MetaspaceSize=128m", \
            "-XX:+UseG1GC", "-XX:ParallelGCThreads=10", "-XX:ConcGCThreads=5", \
            "-XX:InitiatingHeapOccupancyPercent=70", "-XX:MaxGCPauseMillis=20", \
            "-XX:InitiatingHeapOccupancyPercent=35", "-XX:G1HeapRegionSize=16M", \
            "-XX:MinMetaspaceFreeRatio=50", "-XX:MaxMetaspaceFreeRatio=80",  \
            "-XX:+UnlockExperimentalVMOptions","-jar","/opt/server2.jar"]


EXPOSE 2021
