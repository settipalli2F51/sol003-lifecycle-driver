package com.accantosystems.stratoss.vnfmdriver.model.alm;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY, content = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(description = "Details returned when an async lifecycle execution request is accepted")
public class ExecutionAsyncResponse {

    @ApiModelProperty(value = "Request ID")
    private String requestId;
    @ApiModelProperty(value = "Status")
    private ExecutionStatus status;
    @ApiModelProperty(value = "Failure Details")
    private FailureDetails failureDetails;
    @ApiModelProperty(value = "Outputs")
    private Map<String, String> outputs = new HashMap<>();
    @ApiModelProperty(value = "Associated Resource Instance Topology")
    private final Map<String, InternalResourceInstance> associatedTopology = new HashMap<>();
    @ApiModelProperty(value = "Timestamp")
    private Long timestamp;

    public ExecutionAsyncResponse() {}

    public ExecutionAsyncResponse(String requestId, ExecutionStatus status, FailureDetails failureDetails,
                                  Map<String, String> outputs, Map<String, InternalResourceInstance> associatedTopology) {
        this.requestId = requestId;
        this.status = status;
        this.failureDetails = failureDetails;
        if (outputs != null) {
            this.outputs.putAll(outputs);
        }
        if (associatedTopology != null) {
            this.associatedTopology.putAll(associatedTopology);
        }
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getRequestId() {
        return requestId;
    }

    public ExecutionStatus getStatus() {
        return status;
    }

    public void setStatus(ExecutionStatus status) {
        this.status = status;
    }

    public FailureDetails getFailureDetails() {
        return failureDetails;
    }

    public void setFailureDetails(FailureDetails failureDetails) {
        this.failureDetails = failureDetails;
    }

    public Map<String, String> getOutputs() {
        return outputs;
    }

    public void setOutputs(Map<String, String> outputs) {
        this.outputs.putAll(outputs);
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public Map<String, InternalResourceInstance> getAssociatedTopology() {
        return associatedTopology;
    }

    public Long getTimestamp() { return timestamp; }

    public void setTimestamp(Long timestamp) { this.timestamp = timestamp; }

    @Override
    public String toString() {
        return "ExecutionAsyncResponse{" +
                "requestId='" + requestId + '\'' +
                ", status=" + status +
                ", failureDetails=" + failureDetails +
                ", associatedTopology=" + associatedTopology +
                // don't print outputs (because they may contain private keys)
                ", timestamp=" + timestamp +
                '}';
    }
}