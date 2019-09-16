### Devops

In this project I tried to explore more Devops practices like CI/CD, IaC and so on.

I'm going to focus on Microservices containerized with Docker released into AWS ECS.

###### Running on Localhost

To build and run docker image:

<code>gradlew build</code>

<code>docker build -t kotlinaws .</code>

<code>docker run -m512M --cpus 1 -it -p 8080:8080 --rm kotlinaws</code>



To maximize productivity, this solution is running CloudFormation Templates to create diffent ECS clusters.

There are 3 templates:
-  <code>ecs.yml</code> : creates the cluster and all the needed resources
-  <code>service.yml</code> : creates the task, the service and other resources needed to run the containers on the cluster.
-  <code>buildspec.yml</code> : script that tells AWS CodeBuild how to run the build. 

![picture](https://uploaddeimagens.com.br/images/002/347/945/original/templates.PNG?1568619842)

The project is using CloudFormation to create a CI/CD Pipeline with AWS Developer Tools (CodeCommit, CodeBuild, and CodePipeline)


![picture](https://uploaddeimagens.com.br/images/002/347/943/original/pipeline.PNG?1568619588)

The <code>buildspec.yml</code> tells AWS CodeBuild how to run the build. It is broken into 3 sections (pre_build, build, and post_build).

The pre_build section logs into ECR (Elastic Container Registry) and sets up some variables that will be used.

The build section runs the Gradle build, creates the docker image, and tags the image with the version which was created in the version.txt.

The post_build section pushes the images to ECR that was created.

The service_cicd.yml creates 4 resources: BuildRole, S3Artifact, CodeBuild, and CodePipeline.

The BuildRole defines the IAM role that will be used for this build.

The S3Artifact defines an S3 bucket that will hold a copy of the source.

The CodeBuild defines the build environment and where to put the artifacts. It also creates environment variables that are referenced in the buildspec.yml.

The CodePipeline is what defines the CI/CD pipeline with 3 stages: Source, Build, and Deploy.

###### Staging url

<code>Staging-ALB-16CYMJVW3P7P6-1014908581.sa-east-1.elb.amazonaws.com </code>

### Code desing

I'm following the same concepts that I showed last time, but this time I'm showing more Unit Tests following Test First Aproach.
Also, a simple and easy approach to solve the problem using StrategyPattern with anonymous functions for Enum.

Anonymous functions is one of the many advantages when working with Kotlin, this way we can save some time writing classes that with anonymus functions for enum its easy to understand, maintain and extend.
