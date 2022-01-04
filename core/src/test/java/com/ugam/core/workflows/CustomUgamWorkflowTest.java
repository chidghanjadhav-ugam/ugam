package com.ugam.core.workflows;

import com.adobe.granite.workflow.WorkflowSession;
import com.adobe.granite.workflow.exec.WorkItem;
import com.adobe.granite.workflow.exec.WorkflowData;
import com.adobe.granite.workflow.metadata.MetaDataMap;
import com.adobe.granite.workflow.WorkflowException;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import junitx.util.PrivateAccessor;
import org.apache.sling.testing.mock.sling.ResourceResolverType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith({AemContextExtension.class, MockitoExtension.class})
class CustomUgamWorkflowTest {
    AemContext aemContext = new AemContext(ResourceResolverType.JCR_MOCK);
    WorkItem workItem;
    WorkflowSession workflowSession;
    MetaDataMap metaDataMap;
    WorkflowData workflowData;
    CustomUgamWorkflow customUgamWorkflow;

    @BeforeEach
    void setUp() throws WorkflowException {
        customUgamWorkflow = aemContext.registerService(new CustomUgamWorkflow());
    }

    @Test
    void execute_activate() throws NoSuchFieldException, WorkflowException {
        WorkItem workItem = mock(WorkItem.class);
        WorkflowSession workflowSession = mock(WorkflowSession.class);
        MetaDataMap metaDataMap = mock(MetaDataMap.class);
        WorkflowData  workflowData = mock(WorkflowData.class);
        CustomUgamWorkflow customUgamWorkflow1 = mock(CustomUgamWorkflow.class);
        doNothing().when(customUgamWorkflow1).execute(workItem,workflowSession,metaDataMap);
        lenient().when(workItem.getWorkflowData()).thenReturn(workflowData);
        customUgamWorkflow1.execute(workItem,workflowSession,metaDataMap);

    }
}