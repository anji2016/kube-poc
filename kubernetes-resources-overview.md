# Kubernetes Resources Overview

This document provides an overview of various Kubernetes resources, including their purposes and example YAML configurations. Understanding these resources is essential for managing and deploying applications in a Kubernetes cluster.

Resource Types and YAML Examples
### 1. Pod
Purpose:Represents a single instance of a running process in your cluster. It may contain one or more containers.

YAML Example:
```yaml
apiVersion: v1
kind: Pod
metadata:
  name: example-pod
spec:
  containers:
  - name: example-container
    image: nginx
    ports:
    - containerPort: 80
```

### 2. Service
**Purpose:** Exposes a set of Pods to a network, providing a stable IP and DNS name.
YAML Example:
```yaml
apiVersion: v1
kind: Service
metadata:
  name: example-service
spec:
  selector:
    app: example
  ports:
    - protocol: TCP
      port: 80
      targetPort: 80
  type: ClusterIP
```

### 3. Deployment
Purpose: Manages the deployment and scaling of a set of Pods, ensuring that the desired number of replicas are running.
YAML Example:
```yaml
apiVersion: apps/v1
kind: Deployment
metadata:
  name: example-deployment
spec:
  replicas: 3
  selector:
    matchLabels:
      app: example
  template:
    metadata:
      labels:
        app: example
    spec:
      containers:
      - name: example-container
        image: nginx
        ports:
        - containerPort: 80
```

### 4. ReplicaSet
Purpose: Ensures a specified number of pod replicas are running. Usually managed by Deployments.

YAML Example:
```yaml
apiVersion: apps/v1
kind: ReplicaSet
metadata:
  name: example-replicaset
spec:
  replicas: 3
  selector:
    matchLabels:
      app: example
  template:
    metadata:
      labels:
        app: example
    spec:
      containers:
      - name: example-container
        image: nginx
        ports:
        - containerPort: 80
```

### 5. StatefulSet
Purpose: Manages stateful applications, providing unique identities and maintaining ordering of Pods.

YAML Example:
```yaml
apiVersion: apps/v1
kind: StatefulSet
metadata:
  name: example-statefulset
spec:
  serviceName: "example"
  replicas: 3
  selector:
    matchLabels:
      app: example
  template:
    metadata:
      labels:
        app: example
    spec:
      containers:
      - name: example-container
        image: nginx
        ports:
        - containerPort: 80
```

### 6. DaemonSet
Purpose: Ensures that a copy of a Pod runs on all or specific nodes in the cluster.

YAML Example:
```yaml
apiVersion: apps/v1
kind: DaemonSet
metadata:
  name: example-daemonset
spec:
  selector:
    matchLabels:
      app: example
  template:
    metadata:
      labels:
        app: example
    spec:
      containers:
      - name: example-container
        image: nginx
        ports:
        - containerPort: 80
```

### 7. Job
Purpose: Creates one or more Pods and ensures that a specified number of them successfully terminate.

YAML Example:
```yaml
apiVersion: batch/v1
kind: Job
metadata:
  name: example-job
spec:
  template:
    spec:
      containers:
      - name: example-container
        image: busybox
        command: ["sh", "-c", "echo Hello Kubernetes! && sleep 30"]
      restartPolicy: OnFailure
```

### 8. CronJob
Purpose: Schedules Jobs to run at specified times or intervals, similar to cron jobs in Unix/Linux.

YAML Example:
```yaml
apiVersion: batch/v1
kind: CronJob
metadata:
  name: example-cronjob
spec:
  schedule: "*/5 * * * *"
  jobTemplate:
    spec:
      template:
        spec:
          containers:
          - name: example-container
            image: busybox
            command: ["sh", "-c", "echo Hello Kubernetes!"]
          restartPolicy: OnFailure
```

### 9. ConfigMap
Purpose: Stores non-sensitive configuration data as key-value pairs.

YAML Example:
```yaml
apiVersion: v1
kind: ConfigMap
metadata:
  name: example-configmap
data:
  config.key: config.value
```

### 10. Secret
Purpose: Stores sensitive information such as passwords or tokens.

YAML Example:
```yaml
apiVersion: v1
kind: Secret
metadata:
  name: example-secret
type: Opaque
data:
  password: cGFzc3dvcmQ=  # base64 encoded value of 'password'
```

### 11. PersistentVolume (PV)
Purpose: Describes a piece of storage that has been provisioned in the cluster.

YAML Example:
```yaml
apiVersion: v1
kind: PersistentVolume
metadata:
  name: example-pv
spec:
  capacity:
    storage: 1Gi
  accessModes:
    - ReadWriteOnce
  hostPath:
    path: /mnt/data
```

### 12. PersistentVolumeClaim (PVC)
Purpose: Requests storage resources and binds to a PersistentVolume.

YAML Example:
```yaml
apiVersion: v1
kind: PersistentVolumeClaim
metadata:
  name: example-pvc
spec:
  accessModes:
    - ReadWriteOnce
  resources:
    requests:
      storage: 1Gi
```

### 13. Ingress
Purpose: Manages external access to Services, typically HTTP(S).

YAML Example:
```yaml
apiVersion: networking.k8s.io/v1
kind: Ingress
metadata:
  name: example-ingress
spec:
  rules:
  - host: example.com
    http:
      paths:
      - path: /
        pathType: Prefix
        backend:
          service:
            name: example-service
            port:
              number: 80
```

### 14. NetworkPolicy
Purpose: Defines rules for network traffic between Pods.

YAML Example:
```yaml
apiVersion: networking.k8s.io/v1
kind: NetworkPolicy
metadata:
  name: example-networkpolicy
spec:
  podSelector:
    matchLabels:
      app: example
  policyTypes:
  - Ingress
  ingress:
  - from:
    - podSelector:
        matchLabels:
          app: allowed-app
```

### 15. Namespace
Purpose: Provides a mechanism to divide cluster resources between multiple users or teams.

YAML Example:
```yaml
apiVersion: v1
kind: Namespace
metadata:
  name: example-namespace
```

### 16. ServiceAccount
Purpose: Provides an identity for Pods to communicate with the Kubernetes API.

YAML Example:
```yaml
apiVersion: v1
kind: ServiceAccount
metadata:
  name: example-serviceaccount
```

### 17. Role and ClusterRole
Purpose: Defines permissions for accessing Kubernetes resources within a namespace (Role) or across the cluster (ClusterRole).

Role YAML Example:
```yaml
apiVersion: rbac.authorization.k8s.io/v1
kind: Role
metadata:
  name: example-role
rules:
- apiGroups: [""]
  resources: ["pods"]
  verbs: ["get", "list", "watch"]
```

ClusterRole YAML Example:
```yaml
apiVersion: rbac.authorization.k8s.io/v1
kind: ClusterRole
metadata:
  name: example-clusterrole
rules:
- apiGroups: [""]
  resources: ["nodes"]
  verbs: ["get", "list", "watch"]
```

### 18. RoleBinding and ClusterRoleBinding
Purpose: Binds Roles and ClusterRoles to specific users, groups, or ServiceAccounts.

RoleBinding YAML Example:
```yaml
apiVersion: rbac.authorization.k8s.io/v1
kind: RoleBinding
metadata:
  name: example-rolebinding
subjects:
- kind: ServiceAccount
  name: example-serviceaccount
  namespace: default
roleRef:
  kind: Role
  name: example-role
  apiGroup: rbac.authorization.k8s.io
```

ClusterRoleBinding YAML Example:
```yaml
apiVersion: rbac.authorization.k8s.io/v1
kind: ClusterRoleBinding
metadata:
  name: example-clusterrolebinding
subjects:
- kind: ServiceAccount
  name: example-serviceaccount
  namespace: default
roleRef:
  kind: ClusterRole
  name: example-clusterrole
  apiGroup: rbac.authorization.k8s.io
```

### 19. HorizontalPodAutoscaler (HPA)
Purpose: Automatically scales the number of pod replicas based on observed metrics.

YAML Example:
```yaml
apiVersion: autoscaling/v1
kind: HorizontalPodAutoscaler
metadata:
  name: example-hpa
spec:
  scaleTargetRef:
    apiVersion: apps/v1
    kind: Deployment
```
   
