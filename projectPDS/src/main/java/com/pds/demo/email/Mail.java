package com.pds.demo.email;

import lombok.Data;

import java.util.List;
import java.util.Map;


/**
 * @author s.ismail
 *
 */

@Data
public class Mail {

    private String from;
    private String to;
    private String subject;
    private List<Object> attachments;
    private Map<String, Object> model;

    public Mail() {

    }

    public List<Object> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Object> attachments) {
        this.attachments = attachments;
    }

    public Map<String, Object> getModel() {
        return model;
    }

    public void setModel(Map<String, Object> model) {
        this.model = model;
    }
}
