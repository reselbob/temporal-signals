# Understanding a Temporal workflow as an implementation of the Actor Model

The project demonstrates how key features of the Actor Model map onto Temporal workflows.

|NOTE|
|----|
|In order to get full benefit from using this project, it's useful to have a basic understanding of what Temporal is and how it works. [This tutorial](https://docs.temporal.io/temporal) provides a good basic introduction to the Temporal framework.|


In terms of the Actor Model, the sample project considers a [Temporal workflow](https://docs.temporal.io/workflows) to be an actor and Temporal [signals](https://docs.temporal.io/encyclopedia/application-message-passing#signals) to be custom messages sent to the actor, in this case, the Temporal Workflow, to instigate specific behavior.

The sample project contains a Temporal Workflow and constituent child workflow. Interaction with the workflow is conducted using Temoral's signal feature.

The figure below illustrates the basic structure of the demonstration application.

![workflow-actor-model-02](https://github.com/reselbob/SimpleTemporalActorModel/assets/1110569/561bca59-2c79-4481-a28d-d83717e26477)


---

# Installing the code

To execute the code, take the following steps:

The [Java Virtual Machine](https://openjdk.org/) and [Maven](https://maven.apache.org/install.html) need to be installed
on the host computer.

## (1) Confirm that Java and Maven are installed on the host machine

Confirm that Java is installed:

```bash
java --version
```

You'll get output similar to the following:

```bash
openjdk 18.0.2-ea 2022-07-19
OpenJDK Runtime Environment (build 18.0.2-ea+9-Ubuntu-222.04)
OpenJDK 64-Bit Server VM (build 18.0.2-ea+9-Ubuntu-222.04, mixed mode, sharing)
```

Confirm that Maven is installed:

```bash
mvn --version
```

```bash
Maven home: /usr/share/maven
Java version: 18.0.2, vendor: Oracle Corporation, runtime: /usr/lib/jvm/jdk-18.0.2
Default locale: en_US, platform encoding: UTF-8
OS name: "linux", version: "5.19.0-46-generic", arch: "amd64", family: "unix"
```

---

## (2) Download and install the Temporal CLI (which includes the server)

If you do not have the Temporal server installed, click the link below to go to the Temporal documentation that has the
instructions for installing the Temporal CLI.

[https://docs.temporal.io/cli/#installation](https://docs.temporal.io/cli/#installation)

The Temporal development server ships with the CLI.

---

## (3) Start the Temporal Server

Here is the command for starting the Temporal Server on a local Ubuntu machine. Execute the command in a separate
terminal
window.

```bash
temporal server start-dev
```

---

## (4) Do some maven housecleaning

Run the following command in a new terminal window to create a fresh Maven environment:

```bash
mvn clean package install
```

## (5) Start the application

In that same terminal window run:

```bash
mvn exec:java -Dexec.mainClass="temporal.App"
```

You'll see output, similar to the following:

```
[temporal.App.main()] INFO io.temporal.serviceclient.WorkflowServiceStubsImpl - Created WorkflowServiceStubs for channel: ManagedChannelOrphanWrapper{delegate=ManagedChannelImpl{logId=1, target=127.0.0.1:7233}}
[temporal.App.main()] INFO io.temporal.internal.worker.Poller - start: Poller{name=Workflow Poller taskQueue="SimpleWorkflow", namespace="default", identity=11450@bobs-mac-mini.lan}
[temporal.App.main()] INFO io.temporal.internal.worker.Poller - start: Poller{name=Activity Poller taskQueue="SimpleWorkflow", namespace="default", identity=11450@bobs-mac-mini.lan}
[temporal.App.main()] INFO temporal.App - Worker listening on task queue: SimpleWorkflow.
[workflow-method-SimpleWorkflow-01-6d168fc4-e07f-421a-b779-f64716a02ef6] INFO temporal.SimpleWorkflowImpl - Starting Workflow for SimpleWorkflow
[signal add] INFO temporal.SimpleWorkflowImpl - Adding order in Workflow: temporal.model.OrderInfo@33d03ac1
[signal update] INFO temporal.SimpleWorkflowImpl - Updating order in Workflow: temporal.model.OrderInfo@4bc159d1
[signal notifyCustomer] INFO temporal.SimpleWorkflowImpl - Notifying customer for order from parent workflow: temporal.model.OrderInfo@420dfc77
[signal exit] INFO temporal.SimpleWorkflowImpl - Exiting Workflow for SimpleWorkflow
```


