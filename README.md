# Spring in-depth
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

## Beans Lifecycle

### Three phases of bean lifecycle

- Initialization
- Use
- Destruction

### Initialization phase

- Begins with creation of ApplicationContext.
- Further it can be broken into 2 phases
  - **BeanFactory** initialization phase.
  - **Bean** initialization and instantiation.

In a nutshell, the phase goes like this:
- First the bean definitions are loaded in and post loading processors are called. These happen at the BeanFactory level.
- Now,for each bean,
    - Instantiate bean
    - Call setters
    - Bean post-processor (pre-init)
    - initializer
    - post-initializer (post-init)

At the end of this phase, there are only references inside bean factory
but no objects have yet been creted.

#### BeanFactoryPostProcessor
This is the first extension point that we can use. Sample use cases include
loading property sources. Doc: [BeanFactoryPostProcessor](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/factory/config/BeanFactoryPostProcessor.html)

This impacts at the level of Bean Factory instantiation.

#### Types of initializations
- Java Configuration
- XML
- Component Scanning and autoconfiguration


### Lifecycle Methods
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
