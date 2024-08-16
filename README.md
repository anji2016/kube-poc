### Spring Cloud Kubernetes requires access to the Kubernetes API in order to be able to retrieve a list of addresses for pods running for a single service. If you use Kubernetes, you should just execute the following command:

This command grants the default service account in the default namespace full administrative access to the entire Kubernetes cluster. This means that any Pod or other resource using this service account will have the highest level of permissions, which includes the ability to view, create, modify, and delete any resource in any namespace.

  ```kubectl create clusterrolebinding admin --clusterrole=cluster-admin --serviceaccount=default:default```
  https://stackoverflow.com/questions/56919985/service-discover-using-spring-cloud-kubernetes?rq=3

### Execute below command in data-service folder
   ```docker build -t <data-service-name> .```

### Once the build completes, verify the image by executing below command
  ```docker images```

### Execute below command to create kubernetes deployment for a data-service
  ```kubectl apply -f deployment.yaml```

### Execute below command to verify kubernetes deployment for a data-service
  ```kubectl get deployments```

### Execute below command to verify kubernetes pod for a data-service
  ```kubectl get pods```

### Execute below command to see logs of a pod
  ```kubectl logs <pod-name>```

### Execute below command to create kubernetes service for a data-service
  ```kubectl apply -f service.yaml```

### Execute below command to verify kubernetes service for a data-service
  ```kubectl get services```

### Open browser and hit below url, to verify if a data-service is accessible by replacing the exposed port and relevant path
  ```http://localhost:8081/alphadataservice/hello```

### Execute below command to delete kubernetes service for a data-service
  ```kubectl delete service <data-service-name>```

### Execute below command to delete kubernetes deployment for a data-service
  ```kubectl delete deployment <data-service-name>```

### Spring Cloud Kubernetes Dependency
         <!-- https://mvnrepository.com/artifact/org.springframework.cloud/spring-cloud-starter-kubernetes-client-all -->

		<dependency>

			<groupId>org.springframework.cloud</groupId>

			<artifactId>spring-cloud-starter-kubernetes-client-all</artifactId>

		</dependency>
