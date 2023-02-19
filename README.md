# spring-in-depth
This repo focuses on learning spring framework in depth.

## Bean Scopes
### Singleton 
- Created once in the IOC container.
- Stored and managed by container

### Prototype
- New instance everytime its referenced.
- Definition is stored in IOC container.
- This means spring releases handled once its created. 
- When the reference goes out of scope the instance is available for garbage collection.

### Session
- Applies to web environments only.
- One instance per user session.
- Definition is stored in IOC container.
- The instance is not stored in IOC container.
- When the session goes out of scope. The bean is available for garbage collection.

### Request
- Applies to web environments only. 
- One instance per request.
- The instance is not stored in IOC container. 
- Once request is done the instance in available for garbage collection.

## Lifecycle Methods
1. @PostContruct
   - This method must return void and must not accept any parameters.
   - Spring calls this method after the instance is created and after setting up properties.
   - Sample use cases may include filling up caches etc. Sample code snippet is below:
```aidl
@PostConstruct
public void postConstruct() {
    //...initializations here 
}
```
2. @PreDestroy
   - Called before the instance is destroyed.
   - This method must return void and must not accept any parameters.
   - Sample use cases may include clearing up additional resources, saving current state to some DB etc.
   - Sample code snippet is below:
```aidl
@PreDestroy
public void destroy(){
    // ... do something
}
```