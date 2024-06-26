package temporal;

import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;
import temporal.model.OrderInfo;

// Child Workflow Interface
@WorkflowInterface
public interface ChildWorkflow {
  @WorkflowMethod
  void sendNotification(OrderInfo orderInfo);
}
